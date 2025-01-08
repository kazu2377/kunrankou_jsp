<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.jsp"%>
<%@include file="../chapter25/menu.jsp"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
/* 全体のラッパー */
.wrapper {
	max-width: 400px; /* 最大幅を設定 */
	margin: 0 auto; /* 中央寄せ */
	padding: 1rem;
}

/* 見出しのスタイル */
.heading-large {
	font-size: 1.8rem;
	color: #0bd;
	text-align: center;
	margin-bottom: 2rem;
}

/* フォームコンテナのスタイル */
.email {
	background-color: #f0f8ff;
	border: 1px solid #add8e6;
	padding: 2rem;
	border-radius: 8px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

/* フォーム内の各項目 */
form div {
	margin-bottom: 1.5rem;
}

label {
	display: block;
	margin-bottom: 0.5rem;
	font-weight: bold;
	color: #432;
	font-size: 0.95rem;
}

input[type="text"], input[type="password"] {
	width: 100%;
	padding: 0.8rem;
	border: 1px solid #c9c2bc;
	border-radius: 4px;
	background-color: #fff;
	box-sizing: border-box;
}

/* ボタンのスタイル */
.btn {
	background-color: #0056b3;
	border: none;
	padding: 0.75rem 1.5rem;
	color: #fff;
	border-radius: 4px;
	cursor: pointer;
	font-size: 1rem;
	transition: background-color 0.3s ease;
}

.btn:hover {
	background-color: #004494;
}

/* 中央寄せ */
.align-center {
	text-align: center;
}

/* リンクのスタイル */
.small-link {
	color: #432;
	font-size: 0.75rem;
	text-decoration: none;
}

.small-link:hover {
	text-decoration: underline;
}

/* エラーメッセージのスタイル */
.error-message {
	color: red;
	margin-bottom: 1rem;
	font-size: 0.9rem;
	text-align: center;
}

/* レスポンシブデザイン */
@media ( max-width : 480px) {
	.wrapper {
		padding: 0.5rem;
	}
	.heading-large {
		font-size: 1.5rem;
		margin-bottom: 1.5rem;
	}
	.email {
		padding: 1.5rem;
	}
	.btn {
		width: 100%;
		padding: 0.75rem;
	}
}
</style>
</head>
<body>
	<div class="wrapper">
		<h2 class="heading-large">Login</h2>
		<div class="email">
			<!-- エラーメッセージ表示エリア -->
			<div id="error-message" class="error-message"></div>
			<form id="login-form" action="Login.action" method="post" novalidate>
				<div>
					<label for="login">メールアドレス</label> <input type="text" id="login" name="login" required>
				</div>
				<div>
					<label for="password">パスワード</label> <input type="password" id="password" name="password" required>
				</div>
				<div class="align-center">
					<input class="btn" type="submit" value="ログイン">
				</div>
			</form>
		</div>
	</div>
	<%@include file="../footer.jsp"%>
	<script src="https://cdn.jsdelivr.net/npm/validator@13.9.0/validator.min.js"></script>
	<script>
		// ページ読み込み後に実行
		document.addEventListener('DOMContentLoaded', function() {
			const form = document.getElementById('login-form');
			const errorElement = document.getElementById('error-message');

			// フォーム送信時のイベントリスナーを登録
			form.addEventListener('submit', function(event) {
				const emailInput = form.querySelector('input[name="login"]');
				const passwordInput = form
						.querySelector('input[name="password"]');
				const email = emailInput.value.trim();
				const password = passwordInput.value.trim();

				// エラーメッセージをクリア
				errorElement.textContent = '';

				// エラーメッセージを格納する配列
				let errors = [];

				// パスワードの必須チェック
				if (validator.isEmpty(password)) {
					errors.push('パスワードを入力してください。');
				} else {
					// パスワードの文字数チェック（1文字以上15文字以内）
					if (!validator.isLength(password, {
						min : 1,
						max : 15
					})) {
						errors.push('パスワードは15文字以内で入力してください。');
					}

					// パスワードの半角英数字チェック
					if (!validator.isAlphanumeric(password)) {
						errors.push('パスワードは半角英数字で入力してください。');
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
