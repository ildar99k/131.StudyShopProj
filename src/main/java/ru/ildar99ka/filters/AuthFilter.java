package ru.ildar99ka.filters;


import ru.ildar99ka.DataRepository;
import ru.ildar99ka.models.Category;
import ru.ildar99ka.models.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebFilter("/*")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Cookie[] cookies=request.getCookies();
        HttpSession session=request.getSession();
        if (session!=null&&session.getAttribute("user")!=null){
            User user= (User) session.getAttribute("user");
            request.setAttribute("user",user);
            request.setAttribute("cart", DataRepository.getCartByEmail(user.getEmail()));
        }
        List<Category> categories= DataRepository.getAllCategories();
        request.setAttribute("category",categories);
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
