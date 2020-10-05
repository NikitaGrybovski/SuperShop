<%-- 
    Document   : showFormAddProduct
    Created on : Sep 30, 2020, 8:52:36 PM
    Author     : ban31
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

        <div class="container">
 <div class="row">
     <div class="col-md-3"></div>
    <div class="col-md-offset-3 col-md-6">
        <form class="form-horizontal" action="createProduct" method="post">
            <span class="heading">Добавить продукт</span>
            <div class="form-group">
            <input type="text" class="form-control" id="inputName" name="name" placeholder="Название продукта:" >
            <i class="fab fa-adn"></i>
            
            </div>
            <div class="form-group help">
            <input type="number" class="form-control" id="inputPrice" name="price" placeholder="Цена продукта:">
            <i class="fa fa-id-badge"></i>
            
            </div>
            
            <div class="form-group">
          
            <button type="submit" class="btn btn-default">Создать</button>
            </div>
        </form>
    </div>

