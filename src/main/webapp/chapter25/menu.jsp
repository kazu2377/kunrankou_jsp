<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ナビゲーションメニュー</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

<style>
.navbar-custom {
	margin: 20px auto;
	padding: 10px;
	border: 1px solid #ddd;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.main-nav {
	font-size: 0.9rem;
}
</style>

</head>
<body>

	<header class="page-header wrapper">
		<h1>
			<a href="../chapter25/index.jsp"><img class="logo" src="images/logo.png"
				alt="WCBカフェ ホーム"></a>
		</h1>
		<nav>
			<ul class="main-nav">

				<li><a href="../chapter25/news.jsp"><i
						class="fas fa-newspaper"></i> News</a></li>
				<li><a href="../chapter25/menu_s.jsp"><i
						class="fas fa-utensils"></i> Menu</a></li>
				<li><a href="../chapter25/contact.jsp"><i
						class="fas fa-envelope"></i> Contact</a></li>
				<li><a href="../chapter25/Product.action"><i
						class="fas fa-box"></i>購入</a></li>
				<li><a href="../chapter25/cart.jsp"><i
						class="fas fa-shopping-cart"></i> カート</a></li>
				<li><a href="../chapter25/Preview.action"><i
						class="fas fa-credit-card"></i> 決済</a></li>
				<li><a href="../chapter24/login-in.jsp"><i
						class="fas fa-sign-in-alt"></i> in</a></li>
				<li><a href="../chapter24/logout-in.jsp"><i
						class="fas fa-sign-out-alt"></i> out</a></li>


			</ul>
		</nav>
	</header>

	<hr>

	<!-- Bootstrap JS, Popper.js, and jQuery -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
