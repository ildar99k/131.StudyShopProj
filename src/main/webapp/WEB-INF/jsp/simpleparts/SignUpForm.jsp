<%@ page contentType="text/html;charset=windows-1251" %>
<%@page pageEncoding="windows-1251"%>
<%request.setCharacterEncoding("windows-1251");%>
<div class="form">
    <form action='' method='POST' class="login-form">
        <p>E-mail</p>
        <input type="email" name="email" placeholder="example@mail.ru" required>
        <p>������</p>
        <input type="password" name="password" required>
        <p>��������� ������</p>
        <input type="password" name="replypassword" required>
        <p>���</p>
        <input type="text" name="name" required>
        <p>�������</p>
        <input type="text" name="surname" required>
        <p>�������</p>
        <input type="text" name="phone" required>
        <p>������</p>
        <input type="text" name="country" required>
        <p>�����</p>
        <input type="text" name="city" required>
        <p>�����</p>
        <input type="text" name="street" required>
        <p>���</p>
        <input type="text" name="home" required>
        <p>��������</p>
        <input type="text" name="flat">
        <p>�������� � ��������
        <input type="checkbox" name="agreeing" required>
        </p>
        <input type="submit" value="Enter">
    </form>
</div>
