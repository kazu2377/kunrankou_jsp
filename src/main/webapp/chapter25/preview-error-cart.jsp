<%@page contentType="text/html; charset=UTF-8" %>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>カート</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .empty-cart-container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #ffc107;
            border-radius: 10px;
            background-color: #fff3cd;
            color: #856404;
        }
    </style>
</head>
<body>

<%@include file="../header.html" %>
<%@include file="menu.jsp" %>

<div class="container">
    <div class="empty-cart-container text-center">
        <h2>カートに商品がありません</h2>
        <p>商品を選んでカートに追加してください。</p>
        <a href="../chapter25/Product.action" class="btn btn-primary mt-3">商品を見る</a>
    </div>
</div>

<%@include file="../footer.html" %>

<!-- Bootstrap JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
