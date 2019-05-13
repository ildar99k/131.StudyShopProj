    <%@ page import="ru.ildar99ka.models.User" %>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
        <%@ page contentType="text/html;charset=windows-1251" %>
        <header>
        <div class="phone">
        <p class="tel">+791042019** ������</p>
        <p class="tel">+791726201** ������</p>
        </div>
        <div class="logoDiv">
        <div class="logoPic">
        <img src="<c:url value="/static/images/oakSon.png"/>" alt="logo" class="logo">
        </div>
        <div class="title">MyShop</div>
        </div>
        <div class="headerButtons">
            <%User u = (User)request.getAttribute("user");%>
        <c:set var="test" value="<%=u%>"/>
        <c:set var="myEmpty" value=""></c:set>
        <c:if test="${test != null && !test.name.equals(myEmpty)}">
            <p>
            ������������,
            ${test.name}
            ${test.surname}
            </p><br>
            <a href="/login"><button class="headerButton">�����</button></a>
        </c:if>
        <c:if test="${test == null || test.name.equals(myEmpty)}">
            <a href="/signup"><button class="headerButton">�����������</button></a>
            <a href="/login"><button class="headerButton">�����</button></a>
        </c:if>
        </div>
        </header>