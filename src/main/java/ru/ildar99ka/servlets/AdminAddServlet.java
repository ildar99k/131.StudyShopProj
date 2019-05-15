package ru.ildar99ka.servlets;

import ru.ildar99ka.DataRepository;
import ru.ildar99ka.HibernateUtil;
import ru.ildar99ka.models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static ru.ildar99ka.HibernateUtil.*;
@MultipartConfig
@WebServlet("/admin/add")
public class AdminAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/WEB-INF/jsp/adminAdd.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product=new Product();
        product.fillProduct(req);
        DataRepository.saveObject(product);
        Part image = req.getPart("photo");
        File f = new File(
                "C:\\Users\\bkmlf\\Downloads\\test\\131.StudyShopProj\\src\\main\\webapp\\static\\images\\"
                        + req.getParameter("name") + ".png" );
        if (image != null && image.getSize() > 0 && image.getInputStream() != null) {
            try (FileOutputStream fos = new FileOutputStream(f);
                 InputStream is = image.getInputStream()){
                int i = 0;
                while ((i = is.read()) != -1) {
                    fos.write(i);
                }
                fos.flush();
            }

        }
        req.getServletContext().getRequestDispatcher("/WEB-INF/jsp/adminAdd.jsp").forward(req, resp);
    }
}
