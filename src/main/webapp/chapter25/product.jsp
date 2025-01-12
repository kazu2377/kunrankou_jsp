<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@include file="../header.jsp"%>
<%@include file="menu.jsp"%>
<style>
/* 既存のスタイルを保持 */
.wrapper {
    max-width: 1200px;
    margin: 0 auto;
    padding: 1rem;
}

.heading-large {
    font-size: 2rem;
    color: #0bd;
    text-align: center;
    margin-bottom: 2rem;
}

.search-form {
    display: flex;
    flex-direction: column;
    align-items: center;
    background-color: #f0f8ff;
    border: 1px solid #add8e6;
    padding: 2rem;
    border-radius: 8px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    margin-bottom: 2rem;
}

.search-form p {
    margin-bottom: 1rem;
    font-size: 1rem;
    color: #333;
}

.search-form form {
    display: flex;
    flex-direction: column;
    width: 100%;
    max-width: 500px;
}

.search-form input[type="text"] {
    width: 100%;
    padding: 0.8rem;
    border: 1px solid #c9c2bc;
    border-radius: 4px;
    margin-bottom: 1rem;
    box-sizing: border-box;
}

.search-form input[type="submit"] {
    padding: 0.75rem;
    background-color: #0056b3;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 1rem;
    transition: background-color 0.3s ease;
}

.search-form input[type="submit"]:hover {
    background-color: #004494;
}

.product-table {
    width: 100%;
    border-collapse: collapse;
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
    gap: 20px;
}

.product-card {
    background-color: #fff;
    border: 1px solid #add8e6;
    border-radius: 8px;
    padding: 1rem;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    display: flex;
    flex-direction: column;
    align-items: center;
    text-align: center;
}

.product-card img {
    max-width: 100%;
    height: auto;
    border-radius: 4px;
    margin-bottom: 1rem;
}

.product-card h3 {
    font-size: 1.2rem;
    margin-bottom: 0.5rem;
    color: #333;
}

.product-card p {
    font-size: 1rem;
    margin-bottom: 1rem;
    color: #555;
}

.product-card form {
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 100%;
}

.product-card select {
    width: 100%;
    max-width: 100px;
    padding: 0.5rem;
    margin-bottom: 0.5rem;
    border: 1px solid #c9c2bc;
    border-radius: 4px;
}

.product-card input[type="submit"] {
    padding: 0.5rem 1rem;
    background-color: #28a745;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 1rem;
    transition: background-color 0.3s ease;
}

.product-card input[type="submit"]:hover {
    background-color: #218838;
}

.error {
    color: red;
    margin-top: 5px;
}

@media (max-width: 768px) {
    .search-form form {
        max-width: 100%;
    }
    .product-table {
        grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
    }
}

@media (max-width: 480px) {
    .heading-large {
        font-size: 1.5rem;
        margin-bottom: 1.5rem;
    }
    .search-form {
        padding: 1rem;
    }
    .search-form input[type="text"],
    .search-form input[type="submit"] {
        font-size: 0.9rem;
        padding: 0.6rem;
    }
    .product-card h3 {
        font-size: 1rem;
    }
    .product-card p {
        font-size: 0.9rem;
    }
    .product-card input[type="submit"] {
        padding: 0.4rem 0.8rem;
        font-size: 0.9rem;
    }
}
</style>
<div class="wrapper">
    <h2 class="heading-large">商品検索</h2>
    <div class="search-form">
        <p>検索キーワードを入力してください。</p>
        <form id="search-form" action="Product.action" method="post" novalidate>
            <input type="text" name="keyword" placeholder="キーワードを入力" required>
            <input type="submit" value="検索">
            <p id="error-message" class="error"></p>
        </form>
    </div>
    <div class="product-table">
        <c:forEach var="product" items="${list}">
            <div class="product-card">
                <img src="image/${product.id}.jpg" alt="商品画像${product.id}">
                <h3>商品${product.id}: ${product.name}</h3>
                <p>${product.price}円</p>
                <form action="CartAdd.action" method="post">
                    <input type="hidden" name="id" value="${product.id}">
                    <label for="quantity-${product.id}">数量:</label>
                    <select name="quantity" id="quantity-${product.id}">
                        <c:forEach var="i" begin="1" end="20">
                            <option value="${i}">${i}</option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="カートに追加">
                </form>
            </div>
        </c:forEach>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/validator@13.9.0/validator.min.js"></script>
<script>
    // ページ読み込み後に実行
    document.addEventListener('DOMContentLoaded', function() {
        const form = document.getElementById('search-form');
        const errorElement = document.getElementById('error-message');

        // フォーム送信時のイベントリスナーを登録
        form.addEventListener('submit', function(event) {
            const keywordInput = form.querySelector('input[name="keyword"]');
            const keyword = keywordInput.value.trim();

            // エラーメッセージをクリア
            errorElement.textContent = '';

            // 入力必須チェック
            if (validator.isEmpty(keyword)) {
                errorElement.textContent = '検索キーワードを入力してください。';
                event.preventDefault();
                return false;
            }

            // 文字数チェック（1文字以上15文字以下）
            if (!validator.isLength(keyword, {
                min: 1,
                max: 15
            })) {
                errorElement.textContent = '検索キーワードは15文字以内で入力してください。';
                event.preventDefault();
                return false;
            }

            // バリデーションを通過した場合はフォーム送信
            return true;
        });
    });
</script>
<%@include file="../footer.html"%>
