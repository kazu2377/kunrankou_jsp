<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@include file="../header.jsp" %>
<%@include file="menu.jsp" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>購入確定</title>
    <style>
        /* 全体のラッパー */
        .wrapper {
            max-width: 1200px; /* 最大幅を設定 */
            margin: 0 auto; /* 中央寄せ */
            padding: 1rem;
        }

        /* 見出しのスタイル */
        .heading-large {
            font-size: 2rem;
            color: #0bd;
            text-align: center;
            margin-bottom: 2rem;
        }

        /* カート情報のスタイル */
        .cart-info {
            background-color: #f0f8ff;
            border: 1px solid #add8e6;
            padding: 1.5rem;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            margin-bottom: 2rem;
            text-align: center;
            font-size: 1.1rem;
            color: #333;
        }

        /* カートテーブルのスタイル */
        .cart-table {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 20px;
        }

        .cart-item {
            background-color: #fff;
            border: 1px solid #add8e6;
            border-radius: 8px;
            padding: 1rem;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            display: flex;
            flex-direction: column;
            align-items: center;
            text-align: center;
        }

        .cart-item img {
            max-width: 100%;
            height: auto;
            border-radius: 4px;
            margin-bottom: 1rem;
        }

        .cart-item h3 {
            font-size: 1.2rem;
            margin-bottom: 0.5rem;
            color: #333;
        }

        .cart-item p {
            font-size: 1rem;
            margin-bottom: 0.5rem;
            color: #555;
        }

        .cart-item .quantity {
            font-size: 1rem;
            margin-bottom: 1rem;
            color: #555;
        }

        /* 購入フォームのスタイル */
        .purchase-form {
            background-color: #f8f9fa;
            border: 1px solid #ced4da;
            padding: 2rem;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            margin-top: 2rem;
        }

        .purchase-form form {
            display: flex;
            flex-direction: column;
            max-width: 500px;
            margin: 0 auto;
        }

        .purchase-form label {
            margin-bottom: 0.5rem;
            font-weight: bold;
            color: #333;
            font-size: 1rem;
        }

        .purchase-form input[type="text"] {
            padding: 0.8rem;
            border: 1px solid #c9c2bc;
            border-radius: 4px;
            margin-bottom: 1.5rem;
            box-sizing: border-box;
            width: 100%;
        }

        /* ボタンのスタイル */
        .purchase-form input[type="submit"] {
            padding: 0.75rem;
            background-color: #28a745;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 1rem;
            transition: background-color 0.3s ease;
        }

        .purchase-form input[type="submit"]:hover {
            background-color: #218838;
        }

        /* エラーメッセージのスタイル */
        .error-message {
            color: red;
            margin-bottom: 1rem;
            font-size: 0.9rem;
            text-align: center;
        }

        /* レスポンシブデザイン */
        @media (max-width: 768px) {
            .cart-table {
                grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            }

            .cart-item h3 {
                font-size: 1.1rem;
            }

            .cart-item p,
            .cart-item .quantity {
                font-size: 0.95rem;
            }

            .purchase-form form {
                max-width: 100%;
            }
        }

        @media (max-width: 480px) {
            .heading-large {
                font-size: 1.5rem;
                margin-bottom: 1.5rem;
            }

            .cart-info {
                padding: 1rem;
                font-size: 1rem;
            }

            .cart-table {
                grid-template-columns: 1fr;
            }

            .cart-item h3 {
                font-size: 1rem;
            }

            .cart-item p,
            .cart-item .quantity {
                font-size: 0.9rem;
            }

            .purchase-form {
                padding: 1rem;
            }

            .purchase-form label {
                font-size: 0.9rem;
            }

            .purchase-form input[type="text"] {
                padding: 0.6rem;
                font-size: 0.9rem;
            }

            .purchase-form input[type="submit"] {
                padding: 0.6rem;
                font-size: 0.9rem;
            }
        }
    </style>

</head>
<body>
    <div class="wrapper">
        <h2 class="heading-large">購入確定</h2>

        <div class="cart-info">
            ${cart.size()}種類の商品があります。
        </div>

        <div class="cart-table">
            <c:forEach var="item" items="${cart}">
                <div class="cart-item">
                    <img src="image/${item.product.id}.jpg" alt="商品画像${item.product.id}">
                    <h3>商品${item.product.id}: ${item.product.name}</h3>
                    <p>価格: ${item.product.price}円</p>
                    <p class="quantity">数量: ${item.count}個</p>
                </div>
            </c:forEach>
        </div>

        <div class="purchase-form">
            <!-- エラーメッセージ表示エリア -->
            <div id="error-message" class="error-message"></div>
            <form id="purchase-form" action="Purchase.action" method="post" novalidate>
                <label for="name">お名前</label>
                <input type="text" id="name" name="name" placeholder="お名前を入力" required maxlength="15">

                <label for="address">ご住所</label>
                <input type="text" id="address" name="address" placeholder="ご住所を入力" required maxlength="30">

                <input type="submit" value="購入を確定">
            </form>
        </div>
    </div>

    <%@include file="../footer.html" %>
    <!-- Validator.js ライブラリの追加 -->
<script src="https://cdn.jsdelivr.net/npm/validator@13.9.0/validator.min.js"></script>
    <script>
        // ページ読み込み後に実行
        document.addEventListener('DOMContentLoaded', function() {
            const form = document.getElementById('purchase-form');
            const errorElement = document.getElementById('error-message');

            // フォーム送信時のイベントリスナーを登録
            form.addEventListener('submit', function(event) {
                const nameInput = form.querySelector('input[name="name"]');
                const addressInput = form.querySelector('input[name="address"]');
                const name = nameInput.value.trim();
                const address = addressInput.value.trim();

                // エラーメッセージをクリア
                errorElement.textContent = '';

                // エラーメッセージを格納する配列
                let errors = [];

                // お名前の必須チェック
                if (validator.isEmpty(name)) {
                    errors.push('お名前を入力してください。');
                } else {
                    // お名前の文字数チェック（最大15文字）
                    if (!validator.isLength(name, { max: 15 })) {
                        errors.push('お名前は15文字以内で入力してください。');
                    }
                }

                // ご住所の必須チェック
                if (validator.isEmpty(address)) {
                    errors.push('ご住所を入力してください。');
                } else {
                    // ご住所の文字数チェック（最大30文字）
                    if (!validator.isLength(address, { max: 30 })) {
                        errors.push('ご住所は30文字以内で入力してください。');
                    }
                }

                // エラーが存在する場合
                if (errors.length > 0) {
                    // エラーメッセージを表示
                    errorElement.innerHTML = errors.join('<br>');
                    event.preventDefault(); // フォーム送信を停止
                }

                // バリデーションを通過した場合はフォーム送信
                return errors.length === 0;
            });
        });
    </script>
</body>
</html>
