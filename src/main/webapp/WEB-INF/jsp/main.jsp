<%@ page import="ru.ildar99ka.models.Product" %>
<%@ page contentType="text/html;charset=windows-1251" %>
<%@include file="layout/header.jsp"%>
<%@include file="layout/title.jsp"%>
<%@include file="layout/menu.jsp"%>
<% ArrayList<Product> products = (ArrayList) request.getAttribute("products"); %>
<div class="products">
<c:forEach items="<%=products%>" var="product">
<a href="/main/${product.category}/${product.name}">
<div class="product">
<img src="/static/images/${product.name}.png" alt="${product.name}" class="imgProd">
<div>
<p class="titleProd">${product.name}</p>
<p class="priceProd">${product.price} RUB.</p>
</div>
</div>
</a>
</c:forEach>
</div>
<%@include file="layout/footer.jsp"%>