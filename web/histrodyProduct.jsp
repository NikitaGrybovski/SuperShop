<%-- 
    Document   : histrodyProduct
    Created on : Oct 5, 2020, 10:22:20 PM
    Author     : ban31
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:forEach var="product" items="${listProduct}">
        
       
    
      <div class="product-items">
          <h3>${historyProduct.date}</h3>
          <h3>${historyProduct.product}</h3>
          <h3>${historyProduct.users}</h3>
               
      </div>
      </div>
    </c:forEach>

