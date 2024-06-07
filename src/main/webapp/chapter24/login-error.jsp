<%@page contentType="text/html; charset=UTF-8" %>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>ログインエラー</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .error-container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #dc3545;
            border-radius: 10px;
            background-color: #f8d7da;
            color: #721c24;
        }
    </style>
</head>
<body>

<%@include file="../header.html" %>
<%@include file="../chapter25/menu.jsp" %>

<div class="container">
    <div class="error-container">
        <h2 class="text-center">ログインエラー</h2>
        <p class="text-center">ログイン名またはパスワードが違います。</p>
        <div class="text-center">
            <a href="../chapter24/login-in.jsp" class="btn btn-primary">再試行</a>
        </div>
    </div>
</div>

<%@include file="../footer.html" %>

<!-- Bootstrap JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
