<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.jsp"%>
<%@include file="../chapter25/menu.jsp"%>

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

<script src="../js/login.js" />
<script src="https://cdn.jsdelivr.net/npm/validator@13.9.0/validator.min.js"></script>
<%@include file="../footer.jsp"%>
