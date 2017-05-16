package colarinhobranco.web.news;

import colarinhobranco.http.FrontCommand;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

import colarinhobranco.dao.NewsDao;
import colarinhobranco.daoimpl.NewsDaoImpl;
import colarinhobranco.http.Dispatcher;
import colarinhobranco.model.News;
import java.util.Collection;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@MultipartConfig
public class SaveServlet extends FrontCommand {
	
	private NewsDao newsDao = new NewsDaoImpl();
	
	private SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
	private String imagesFolder; 
	
        @Override
	public void init(Map requestContextMap, Dispatcher dispatcher){
            super.init(requestContextMap, dispatcher);
            this.target = "news/show";
            this.imagesFolder = this.dispatcher.context.getInitParameter("images-folder");
	}	
	
	@Override
	public void process() throws IOException{
            
            String[] title = (String[]) map.get("title");
            String[] headlineContent = (String[]) map.get("headline-content");
            String[] content = (String[]) map.get("content");
            Collection<Part> partes = (Collection<Part>) map.get("partes");
            Part headlineImage = (Part) partes.toArray()[4];

            Date date = null;
		
            try {
                String[] aData = (String[])map.get("date");
                date = dateParser.parse(aData[0]);
            } catch (ParseException pe) {
                    this.dispatcher.response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);			
            }
             
            News news = new News(title[0], date, headlineContent[0], headlineImage.getSubmittedFileName(), content[0]);
            if (newsDao.save(news) != null) {
                saveHeadlineImage(headlineImage, news.getId());
            }

            this.dispatcher.request.setAttribute("news", news);			
				
	}
	
	private Boolean saveHeadlineImage(Part filePart, Integer newsId) throws IOException {
		
		InputStream is = null;
		OutputStream os = null;
		String fileName = null;
		
		try {
			File imageFolder = new File(imagesFolder, String.valueOf(newsId));
			imageFolder.mkdir();
			fileName = filePart.getSubmittedFileName();
                        System.out.println(fileName);
                        
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