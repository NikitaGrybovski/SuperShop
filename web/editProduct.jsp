
 <div class="row">
     <div class="col-md-3"></div>
    <div class="col-md-offset-3 col-md-6">
        <form class="form-horizontal" method="post">
            <span class="heading">Изменить продукт</span>
            <div class="form-group">
            <input type="hidden" class="form-control" name="id" value="${product.id}">
            <input type="text" class="form-control" id="editName" name="name" placeholder="Название продукта:" >
            <i class="fab fa-adn"></i>
            
            </div>
            <div class="form-group help">
            <input type="number" class="form-control" id="editPrice" name="price" placeholder="Цена продукта:">
            <i class="fa fa-id-badge"></i>
            
            </div>
            
            <div class="form-group">
                <a href="listProduct"><input type="submit" class="btn btn-default" value="Изменить"></a>
            
            </div>
        </form>
    </div>