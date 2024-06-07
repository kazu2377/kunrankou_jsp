<%@page contentType="text/html; charset=UTF-8" %>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>ウェルカムページ</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .welcome-container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #007bff;
            border-radius: 10px;
            background-color: #e9f7fe;
            color: #004085;
        }
    </style>
</head>
<body>

<%@include file="../header.html" %>
<%@include file="../chapter25/menu.jsp" %>

<div class="container">
    <div class="welcome-container text-center">
        <h2>こんにちは、${customer.login}さん</h2>
        <p>ようこそ！</p>
    </div>
</div>

<%@include file="../footer.html" %>

<!-- Bootstrap JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
