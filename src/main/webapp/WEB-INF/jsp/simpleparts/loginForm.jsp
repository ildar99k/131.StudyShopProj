<%@ page contentType="text/html;charset=windows-1251" %>
<%@page pageEncoding="windows-1251"%>
<div class="form">
    <form action="" class="login-form" method="post">
        <p>
            Email
        </p>
        <input type="email" placeholder="example@mail.ru" name="email" required value="<%=request.getParameter("email")==null?"":request.getParameter("email")%>">
        <p>
            Пароль
        </p>
        <input type="password" class="password-field" required name="password">
        <p>
            Запомнить меня
        </p>
        <input type="checkbox" name="save">
        <input type="submit" value="Enter">
    </form>
</div>
