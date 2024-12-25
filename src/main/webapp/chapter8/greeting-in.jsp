<%@page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet/JSP Samples</title>
</head>
<body>
    <p>お名前を入力してください。</p>
    <form id="greetingForm" action="greeting-out.jsp" method="post">
        <!-- テキスト入力フィールド -->
        <input type="text" id="userInput" name="user">
        <!-- 確定ボタン -->
        <input type="submit" id="submitButton" value="確定">
    </form>
</body>
<script src="js/validation.js"></script>

</html>
