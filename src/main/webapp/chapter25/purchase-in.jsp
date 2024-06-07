<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>購入画面</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .cart-container, .purchase-form-container {
            margin: 50px auto;
            max-width: 800px;
        }
    </style>
</head>
<body>

<%@include file="../header.html" %>
<%@include file="menu.jsp" %>

<div class="container cart-container">
    <p class="alert alert-info">${cart.size()}種類の商品があります。</p>
    <hr>

    <table class="table table-bordered table-hover mt-3">
        <thead class="thead-light">
            <tr>
                <th>商品ID</th>
                <th>画像</th>
                <th>商品名</th>
                <th>価格</th>
                <th>数量</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${cart}">
                <tr>
                    <td>${item.product.id}</td>
                    <td><img src="image/${item.product.id}.jpg" height="96" class="img-thumbnail"></td>
                    <td>${item.product.name}</td>
                    <td>${item.product.price}円</td>
                    <td>${item.count}個</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <hr>

    <div class="purchase-form-container">
        <form action="Purchase.action" method="post">
            <div class="form-group">
                <label for="name">お名前</label>
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="address">ご住所</label>
                <input type="text" class="form-control" id="address" name="address" required>
            </div>
            <button type="submit" class="btn btn-primary btn-block">購入を確定</button>
        </form>
    </div>
</div>

<%@include file="../footer.html" %>

<!-- Bootstrap JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
