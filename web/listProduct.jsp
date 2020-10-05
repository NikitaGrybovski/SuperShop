<%-- 
    Document   : listProduct
    Created on : Oct 1, 2020, 11:37:34 PM
    Author     : ban31
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <c:forEach var="product" items="${listProduct}">
        
       
    
      <div class="product-items">
            <div class="product-lists">
                <h3>${product.name}</h3>
               <span class="prices">${product.price}</span>
                <a href="buy?id=${product.id}" class="buttons">купить</a><br>
                <a href="delete?id=${product.id}" class="buttons">удалить</a><br>
                <a href="editProduct?id=${product.id}" id="id" class="buttons">изменить</a><br>
            </div>
      </div>
    </c:forEach>
        
