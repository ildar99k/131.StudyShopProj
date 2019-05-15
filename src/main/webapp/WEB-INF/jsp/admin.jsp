<%@ page import="ru.ildar99ka.models.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<%@include file="layout/header.jsp"%>
<%@include file="layout/title.jsp"%>
<% ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("product");%>
<div class="cart">
    <div class=cartHeader>
        <h1>Admin panel</h1>
        <a href="${pageContext.request.contextPath}/admin/add"><button class="newPositionButton">Добавить товар</button></a>
    </div>
    <form method="post" class="cart">

        <c:forEach items="<%=products%>" var="product">
            <div class="cartProduct">
                <c:set var="space" value=" "></c:set>
                <c:set var="emptyspace" value=""></c:set>
                <c:set var="path" value="${product.name.replaceAll(space,emptyspace)}"/>
                <img src="<c:url value="/static/images/${path}.png"/>" alt="${product.name}" class="cartImg">
                <div class="cartProductTitle">
                    <h2>${product.name}</h2>
                    <p>${product.price} RUB.</p>
                </div>
                <input type="checkbox" name="${product.name}">
            </div>
        </c:forEach>
        <input type="submit" value="Удалить">
    </form>
</div>
<%@include file="layout/footer.jsp"%>