    <%@ page import="java.util.ArrayList" %>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
        <%@ page contentType="text/html;charset=windows-1251" language="java" %>
            <% ArrayList categoryes = (ArrayList) request.getAttribute("category"); %>
        <div class="menu">
        <div class="menuButtonDiv"><a class="menuButton" href="${pageContext.request.contextPath}/main">Главная</a></div>
        <c:forEach items="<%=categoryes%>" var="category">
            <div class="menuButtonDiv">
            <a class="menuButton" role="tab" href="/main/${category.name}">${category.name}</a>
            </div>
        </c:forEach>
        <div class="menuButtonDiv"><a class="menuButton" href="/cart"><img src="${pageContext.request.contextPath}/static/images/cart.png" alt="cart" class="cart"></a></div>
        </div>

