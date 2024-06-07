<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>商品検索</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .search-container {
            max-width: 600px;
            margin: 50px auto;
            padding: 30px;
            border: 1px solid #ddd;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .table-container {
            margin: 50px auto;
            max-width: 800px;
        }
    </style>
</head>
<body>

<%@include file="../header.html" %>
<%@include file="menu.jsp" %>


<div class="container">
    <div class="search-container">
        <p>検索キーワードを入力してください。</p>
        <form action="Product.action" method="post" class="form-inline">
            <input type="text" name="keyword" class="form-control mr-2" placeholder="キーワードを入力">
            <button type="submit" class="btn btn-primary">検索</button>
        </form>
    </div>

    <hr>

    <div class="table-container">
        <table class="table table-bordered table-hover">
            <thead class="thead-light">
                <tr>
                    <th>商品ID</th>
                    <th>画像</th>
                    <th>商品名</th>
                    <th>価格</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${list}">
                    <tr>
                        <td>${product.id}</td>
                        <td><img src="image/${product.id}.jpg" height="64" class="img-thumbnail"></td>
                        <td>${product.name}</td>
                        <td>${product.price}円</td>
                        <td><a href="CartAdd.action?id=${product.id}" class="btn btn-success btn-sm">カートに追加</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<%@include file="../footer.html" %>



<!-- Bootstrap JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
