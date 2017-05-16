package colarinhobranco.web.util;

import colarinhobranco.http.Dispatcher;
import colarinhobranco.http.FrontCommand;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public class ImageServer extends FrontCommand {

    private String imagesFolder;

    @Override
    public void init(Map requestContextMap, Dispatcher dispatcher) {
        super.init(requestContextMap, dispatcher);
        this.target = "";
        this.imagesFolder = this.dispatcher.context.getInitParameter("images-folder");
    }

    @Override
    public void process() throws IOException {

        String[] newsId = (String[]) map.get("newsId");
        String[] imageFileName = (String[]) map.get("imageFileName");
        String strImageFileName = (String) imageFileName[0];

        if (newsId == null || imageFileName == null) {
            this.dispatcher.response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            InputStream is = null;
            OutputStream os = null;

            try {
                File imageFile = new File(imagesFolder, newsId[0] + File.separator + strImageFileName);

                if (!imageFile.exists()) {
                    this.dispatcher.response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                } else {
                    String fileExtension = strImageFileName.substring(strImageFileName.indexOf('.') + 1);
                    this.dispatcher.response.setContentType("image/" + fileExtension);

                    is = new FileInputStream(imageFile);
                    os = this.dispatcher.response.getOutputStream();

                    Integer read = 0;
                    final byte[] bytes = new byte[1024];

                    while ((read = is.read(bytes)) != -1) {
                        os.write(bytes, 0, read);
                    }

                    os.flush();
                }

            } catch (IOException e) {
                this.dispatcher.response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
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

    public void setImagesFolder(String imagesFolder) {
        this.imagesFolder = imagesFolder;
    }

}
