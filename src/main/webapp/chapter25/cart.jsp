<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>カート</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .cart-container {
            margin: 50px auto;
            max-width: 800px;
        }
    </style>
</head>
<body>

<%@include file="../header.html" %>
<%@include file="menu.jsp" %>

<div class="container cart-container">
    <c:choose>
        <c:when test="${cart.size() > 0}">
            <p class="alert alert-info">${cart.size()}種類の商品があります。</p>
        </c:when>
        <c:otherwise>
            <p class="alert alert-warning">カートに商品がありません。</p>
        </c:otherwise>
    </c:choose>

    <table class="table table-bordered table-hover mt-3">
        <thead class="thead-light">
            <tr>
                <th>商品ID</th>
                <th>画像</th>
                <th>商品名</th>
                <th>価格</th>
                <th>数量</th>
                <th>操作</th>
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
                    <td><a href="CartRemove.action?id=${item.product.id}" class="btn btn-danger btn-sm">カートから削除</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="../footer.html" %>

<!-- Bootstrap JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
