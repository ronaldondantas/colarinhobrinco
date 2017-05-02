package colarinhobranco.web.news;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import colarinhobranco.dao.NewsDao;
import colarinhobranco.daoimpl.NewsDaoImpl;
import colarinhobranco.model.News;

@SuppressWarnings("serial")
@WebServlet("/news/save")
@MultipartConfig
public class SaveServlet extends HttpServlet {
	
	private NewsDao newsDao = new NewsDaoImpl();
	
	private SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
	private String imagesFolder; 
	
	@Override
	public void init() throws ServletException {
		 
		setImagesFolder(getServletContext().getInitParameter("images-folder"));
		
	}	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String headlineContent = request.getParameter("headline-content");
		String content = request.getParameter("content");
		Part headlineImage = request.getPart("headline-image");
		
		Date date = null;
		
		try {
			date = dateParser.parse(request.getParameter("date"));
		} catch (ParseException pe) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);			
		}
		
		News news = new News(title, date, headlineContent, headlineImage.getSubmittedFileName(), content);
		
		if (newsDao.save(news) != null) {
			saveHeadlineImage(headlineImage, news.getId());
		}
		
		request.setAttribute("news", news);
		
		request.getRequestDispatcher("/pages/news/show.jsp").forward(request, response);
		
		request.getRequestDispatcher("/pages/news/show.jsp").forward(request, response);			
				
	}
	
	private Boolean saveHeadlineImage(Part filePart, Integer newsId) throws IOException {
		
		InputStream is = null;
		OutputStream os = null;
		String fileName = null;
		
		try {
			File imageFolder = new File(imagesFolder, String.valueOf(newsId));
			imageFolder.mkdir();
			fileName = filePart.getSubmittedFileName();
			is = filePart.getInputStream();
			os = new FileOutputStream(new File(imageFolder, fileName));
 
			Integer read = 0;
			final byte[] bytes = new byte[1024];
			
			while ((read = is.read(bytes)) != -1) {
				os.write(bytes, 0, read);
			}			
			
			return Boolean.TRUE;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return Boolean.FALSE;
		} finally {
			
			if (os != null) {
				os.close();
			}
			
			if (is != null) {
				is.close();
			} 
			
		}
		
	}
	
	public void setImagesFolder(String imagesFolder) { this.imagesFolder = imagesFolder; }

}