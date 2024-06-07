<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<html lang="ja">
    <head>
        <meta charset="utf-8">
        <title>WCB Cafe - MENU</title>
        <meta name="description" content="ブレンドコーヒーとヘルシーなオーガニックフードを提供するカフェ">
        <link rel="icon" type="image/png" href="images/favicon.png">
        <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- CSS -->
        <link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
        <link href="https://fonts.googleapis.com/css?family=Philosopher" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
    </head>

    <body>
        <div id="menu" class="big-bg">
			<%@include file="menu.jsp" %>


            <div class="menu-content wrapper">
                <h2 class="page-title">Menu</h2>
                <p>
                    体に優しい自然食を提供する、WCB CAFE。無添加の食材を利用したメニューが特徴です。
                    おいしいブレンドコーヒーとヘルシーなオーガニックフードで体の内側から癒やされてください。
                </p>
            </div><!-- /.menu-content -->
        </div><!-- /#menu -->

        <div class="wrapper grid">
            <div class="item">
                <img src="images/menu1.jpg" alt="">
                <p>写真キャプション写真キャプション</p>
            </div>
            <div class="item">
                <img src="images/menu2.jpg" alt="">
                <p>写真キャプション写真キャプション</p>
            </div>
            <div class="item">
                <img src="images/menu3.jpg" alt="">
                <p>写真キャプション写真キャプション</p>
            </div>
            <div class="item">
                <img src="images/menu4.jpg" alt="">
                <p>写真キャプション写真キャプション</p>
            </div>
            <div class="item">
                <img src="images/menu5.jpg" alt="">
                <p>写真キャプション写真キャプション</p>
            </div>
            <div class="item">
                <img src="images/menu6.jpg" alt="">
                <p>写真キャプション写真キャプション</p>
            </div>
            <div class="item">
                <img src="images/menu7.jpg" alt="">
                <p>写真キャプション写真キャプション</p>
            </div>
            <div class="item">
                <img src="images/menu8.jpg" alt="">
                <p>写真キャプション写真キャプション</p>
            </div>
            <div class="item">
                <img src="images/menu9.jpg" alt="">
                <p>写真キャプション写真キャプション</p>
            </div>
        </div><!-- /.grid -->

        <footer>
            <div class="wrapper">
                <p><small>&copy; 2019 Manabox</small></p>
            </div>
        </footer>
    </body>
</html>
