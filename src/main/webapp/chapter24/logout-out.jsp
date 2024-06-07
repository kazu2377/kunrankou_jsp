<%@page contentType="text/html; charset=UTF-8" %>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>ログアウト</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .logout-container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #28a745;
            border-radius: 10px;
            background-color: #d4edda;
            color: #155724;
        }
    </style>
</head>
<body>

<%@include file="../header.html" %>
<%@include file="../chapter25/menu.jsp" %>

<div class="container">
    <div class="logout-container text-center">
        <h2>ログアウトしました</h2>
        <p>ご利用ありがとうございました。またのご利用をお待ちしております。</p>
        <a href="../chapter24/login-in.jsp" class="btn btn-primary mt-3">ログインページに戻る</a>
    </div>
</div>

<%@include file="../footer.html" %>

<!-- Bootstrap JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
