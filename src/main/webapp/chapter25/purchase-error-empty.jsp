<%@page contentType="text/html; charset=UTF-8" %>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>入力エラー</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .input-error-container {
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
<%@include file="menu.jsp" %>

<div class="container">
    <div class="input-error-container text-center">
        <h2>入力エラー</h2>
        <p>名前と住所を正しく入力してください。</p>
        <a href="previous-page.jsp" class="btn btn-primary mt-3">戻る</a>
    </div>
</div>

<%@include file="../footer.html" %>

<!-- Bootstrap JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
