        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                <%@ page import="ru.ildar99ka.models.Category" %>
                <%@ page import="java.util.List" %>
                <%@ page import="ru.ildar99ka.DataRepository" %>
                <%@ page contentType="text/html;charset=windows-1251" %>
        <%@page pageEncoding="windows-1251" %>
        <%List<Category> categories= DataRepository.getAllCategories();%>
                <div class="form">
                <form action="" method="post" enctype="multipart/form-data">
                <p>
                Название
                </p>
                <input type="text" name="name" required>
                <p>
                Цена
                </p>
                <input type="text" name="price" required>
                <P>
                Категория товара
                </P>
                <select name="category" required>
                <c:forEach items="<%=categories%>" var="category">
                        <option value="${category.name}">
                        ${category.name}
                        </option>
                </c:forEach>
                </select>
                <p>
                Производитель
                </p>
                <input type="text" name="producer" required>
                <p>
                Количество товара
                </p>
                <input name="amount" type="text" required>
                <p>
                <input type="file" accept="image/png" name="photo">
                </p>
                <p>Описание</p>
                        <p><textarea rows="5" cols="30" name="description"></textarea></p>
                <input type="submit" value="Добавить" >
                </form>
                </div>