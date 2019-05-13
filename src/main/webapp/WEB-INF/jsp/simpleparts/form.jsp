<%@ page contentType="text/html;charset=windows-1251" %>
<%@page pageEncoding="windows-1251"%>
<%request.setCharacterEncoding("windows-1251");%>
<div class="form">
    <form action='' method='POST' class="login-form">
        <p>E-mail</p>
        <input type="email" name="email" placeholder="example@mail.ru" required>
        <p>Пароль</p>
        <input type="password" name="password" required>
        <p>Повторите пароль</p>
        <input type="password" name="replypassword" required>
        <p>Имя</p>
        <input type="text" name="name" required>
        <p>Фамилия</p>
        <input type="text" name="surname" required>
        <p>Телефон</p>
        <input type="text" name="phone" required>
        <p>Страна</p>
        <input type="text" name="country" required>
        <p>Город</p>
        <input type="text" name="city" required>
        <p>Улица</p>
        <input type="text" name="street" required>
        <p>Дом</p>
        <input type="text" name="home" required>
        <p>Квартира</p>
        <input type="text" name="flat">
        <p>Согласен с условием
        <input type="checkbox" name="agreeing" required>
        </p>
        <input type="submit" value="Enter">
    </form>
</div>
