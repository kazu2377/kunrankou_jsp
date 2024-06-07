<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>


<html lang="ja">
    <head>
        <meta charset="utf-8">
        <title>WCB Cafe</title>
        <meta name="description" content="ブレンドコーヒーとヘルシーなオーガニックフードを提供するカフェ">
        <link rel="icon" type="image/png" href="images/favicon.png">
        <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- CSS -->
        <link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
        <link href="https://fonts.googleapis.com/css?family=Philosopher" rel="stylesheet">

    </head>

    <body>

        <div id="home" class="big-bg">

			<%@include file="menu.jsp" %>
            <div class="home-content wrapper">
                <h2 class="page-title">We'll Make Your Day</h2>
                <p>おしゃれなカフェで癒やされてみませんか？無添加の食材で体の中からリフレッシュ。</p>
                <a class="button" href="menu_s.jsp">メニューを見る</a>
            </div><!-- /.home-content -->
        </div><!-- /#home -->
    </body>
</html>


<%@include file="../footer.html" %>
