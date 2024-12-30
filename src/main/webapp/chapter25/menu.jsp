<%@page pageEncoding="UTF-8" %>

<style>
    /* メニューコンテナ */
    .navbar {
        display: flex;
        flex-wrap: wrap;
        justify-content: center; /* 中央揃え */
        background-color: #f0f8ff; /* ソフトピンク */
        padding: 1rem;
    }

    /* メニューループ */
    .navbar a {
        color: #333; /* ダークグレー */
        padding: 0.75rem 1.5rem;
        text-decoration: none;
        text-align: center;
        font-size: 1.2rem;
        margin: 0.5rem;
        border-radius: 8px;
        transition: background-color 0.3s ease, transform 0.3s ease;
    }

    /* ホバー時の効果 */
    .navbar a:hover {
        background-color: #ffb6c1; /* ライトピンク */
        transform: scale(1.05);
    }

    /* レスポンシブデザイン */
    @media (max-width: 768px) {
        .navbar {
            flex-direction: column;
            align-items: center;
        }

        .navbar a {
            width: 100%;
            max-width: 300px;
        }
    }

    @media (max-width: 480px) {
        .navbar a {
            padding: 0.5rem 1rem;
            font-size: 1rem;
            margin: 0.3rem;
        }
    }

    /* 下線のスタイル */
    hr {
        border: none;
        border-top: 1px solid #ddd;
        margin-top: 1rem;
    }
</style>

<div class="navbar">
    <a href="../chapter25/Product.action">商品</a>
    <a href="../chapter25/cart.jsp">カート</a>
    <a href="../chapter25/Preview.action">購入</a>
    <a href="../chapter24/login-in.jsp">ログイン</a>
    <a href="../chapter24/logout-in.jsp">ログアウト</a>
</div>
<hr>
