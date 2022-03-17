/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author chinh
 */
public class UploadFile {

    public String uploadFile(HttpServletRequest request, String part, String UPLOAD_DIR) throws IOException, ServletException {
        String fileName = "";
        try {
            Part filePart = request.getPart(part);
//            fileName = (String) getFileName(filePart);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            fileName = timestamp.getTime() + getFileExtension(getFileName(filePart));
            String applicationPath = request.getServletContext().getRealPath("");
            String basePath = applicationPath + File.separator + UPLOAD_DIR + File.separator;

            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                File outputFilePath = new File(basePath + fileName);
                inputStream = filePart.getInputStream();
                outputStream = new FileOutputStream(outputFilePath);
                int read = 0;
                final byte[] bytes = new byte[1024];
                while ((read = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (ServletException e) {
            fileName = "";
        }
        return fileName;
    }

    public String getFileName(Part part) {
        final String partHeader = part.getHeader("content-disposition");
        System.out.println("*****partHeader: " + partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    public String getFileExtension(String fileName) {
        String extension = ".";

        int i = fileName.lastIndexOf(".");

        if (i > 0) {
            extension += fileName.substring(i + 1);
        }
        return extension;
    }
}
