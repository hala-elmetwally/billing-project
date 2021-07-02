package web.billing;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


/**
 *
 * @author Mayada
 */
//@WebServlet(name = "FileUploadServlet", urlPatterns = {"/fileuploadservlet"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class FilesUpload extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("filename");
        String fileName = filePart.getSubmittedFileName();
        for (Part part : request.getParts()) {
            part.write("F:\\mayada\\ITI\\Billing\\web\\CDR_uploads\\" + fileName);
        }
        //CDRParser.cdrDecoded("F:\\mayada\\ITI\\Billing\\web\\UploadsFiles\\" + fileName);
        response.sendRedirect("UploadCdr.jsp?action=redirect");
    }
}
