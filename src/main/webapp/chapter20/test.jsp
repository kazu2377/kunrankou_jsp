<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page Scope Counter Example</title>
</head>
<body>
    <h1>カウンター</h1>
    <%
        // カウンターの初期化
        Integer counter = (Integer) pageContext.getAttribute("counter");
        if (counter == null) {
            counter = 0;
        }

        // ボタンが押されたかどうかを確認
        String action = request.getParameter("action");
        if ("increment".equals(action)) {
            counter++;
        }

        // PageContextにカウンターを保存
        pageContext.setAttribute("counter", counter);
    %>

    <p>カウント: <%= counter %></p>

    <form method="post">
        <input type="hidden" name="action" value="increment"/>
        <button type="submit">カウントを増やす</button>
    </form>
</body>
</html>