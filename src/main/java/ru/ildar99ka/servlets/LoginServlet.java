package ru.ildar99ka.servlets;

import ru.ildar99ka.DataRepository;
import ru.ildar99ka.exceptions.EmailNotExistException;
import ru.ildar99ka.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies == null) {
            Arrays.stream(cookies).filter(n -> n.getName().equals("user")).forEach(n -> {
                n.setMaxAge(0);
                resp.addCookie(n);
            });
        }
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.removeAttribute("user");
        }
        req.setAttribute("user", new User());
        req.getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User user = DataRepository.getUserByEmail(req.getParameter("email"));

            if ("Admin@admin.ru".equals(req.getParameter("email")) && "Admin".equals(req.getParameter("password"))) {
                resp.sendRedirect("/admin");
                return;
            }
            if (user.getPassword().equals(req.getParameter("password"))) {
                if (req.getParameter("save") != null) {
                    Cookie savedUser = new Cookie("user", user.getEmail());
                    savedUser.setMaxAge(100000);
                    resp.addCookie(savedUser);
                }
                req.getSession().setAttribute("user", user);
                resp.sendRedirect("/main");
                return;

            }


        } catch (EmailNotExistException e) {
            req.getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
        }
        req.getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);

    }
}
