package ru.ildar99ka.servlets;

import ru.ildar99ka.DataRepository;
import ru.ildar99ka.models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("check", false);
        req.setAttribute("product", DataRepository.getAllProducts());
        req.getServletContext().getRequestDispatcher("/WEB-INF/jsp/admin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = DataRepository.getAllProducts();
        req.setAttribute("check", false);
        for (Product p : products) {
            String check = req.getParameter(p.getName());
            if (check != null) {
                DataRepository.deleteProduct(p);
                req.setAttribute("check", true);
            }
        }
        products = DataRepository.getAllProducts();
        req.setAttribute("product", products);
        resp.sendRedirect("/admin");
    }
}

