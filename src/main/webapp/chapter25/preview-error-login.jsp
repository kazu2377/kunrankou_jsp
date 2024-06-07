<%@page contentType="text/html; charset=UTF-8" %>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>ログインが必要</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .login-required-container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #17a2b8;
            border-radius: 10px;
            background-color: #d1ecf1;
            color: #0c5460;
        }
    </style>
</head>
<body>

<%@include file="../header.html" %>
<%@include file="menu.jsp" %>

<div class="container">
    <div class="login-required-container text-center">
        <h2>購入するにはログインが必要です</h2>
        <p>購入するには、以下のリンクからログインしてください。</p>
        <a href="../chapter24/login-in.jsp" class="btn btn-primary mt-3">ログイン</a>
    </div>
</div>

<%@include file="../footer.html" %>

<!-- Bootstrap JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
