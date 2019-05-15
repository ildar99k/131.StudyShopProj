package ru.ildar99ka.servlets;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.ildar99ka.DataRepository;
import ru.ildar99ka.HibernateUtil;
import ru.ildar99ka.exceptions.EmailExistingException;
import ru.ildar99ka.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies=req.getCookies();
        if(cookies==null){
            Arrays.stream(cookies).filter(n->n.getName().equals("user")).forEach(n->{n.setMaxAge(0); resp.addCookie(n);});
        }
        HttpSession session=req.getSession(false);
        if (session!=null){
            session.removeAttribute("user");
        }
        req.setAttribute("user", new User());
        req.getServletContext().getRequestDispatcher("/WEB-INF/jsp/signUp.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("windows-1251");
        resp.setCharacterEncoding("windows-1251");
        resp.setContentType("text/html");
        try {
            User user=User.createUser(req);
            DataRepository.saveObject(user);
            req.getSession().setAttribute("user",user);
            resp.sendRedirect("/main");
        } catch (EmailExistingException emailExistingException) {
            req.getServletContext().getRequestDispatcher("/WEB-INF/jsp/signUp.jsp").forward(req,resp);
        }

    }
}
