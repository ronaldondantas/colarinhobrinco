package colarinhobranco.backup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@SuppressWarnings("serial")
@WebServlet("/image")*/
public class ImageServer extends HttpServlet {
	
	private String imagesFolder; 
	
	@Override
	public void init() throws ServletException {
		 
		setImagesFolder(getServletContext().getInitParameter("images-folder"));
		
	}

	@Override       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		String newsId = request.getParameter("newsId");
		String imageFileName = request.getParameter("imageFileName");
				
		if (newsId == null || imageFileName == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);			
		} else {
			InputStream is = null;
			OutputStream os = null;
			
			try {
				File imageFile = new File(imagesFolder, newsId + File.separator + imageFileName);
				
				if (!imageFile.exists()) {
					response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				} else {
					String fileExtension = imageFileName.substring(imageFileName.indexOf('.') + 1);
					response.setContentType("image/" + fileExtension);
					
					is =  new FileInputStream(imageFile);
					os = response.getOutputStream();
				
					Integer read = 0;
					final byte[] bytes = new byte[1024];
				
					while ((read = is.read(bytes)) != -1) {
						os.write(bytes, 0, read);
					}
				
					os.flush();
				}
				
			} catch (Exception e) {
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);			
			} finally {
				
					if (os != null) {
						os.close();
					}
					
					if (is != null) {
						is.close();
					}
				}			
			
		}
		
	}	
	
	public void setImagesFolder(String imagesFolder) { this.imagesFolder = imagesFolder; }

}