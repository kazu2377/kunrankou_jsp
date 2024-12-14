<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html"%>
<p>追加する商品を入力してください。</p>
<form action="insert" method="post">
	商品名<input type="text" name="name"> 価格 <input type="text" name="price"> <input type="submit" value="追加">
</form>


<p>削除する商品IDを入力してください。</p>
<form action="delete" method="post">
    商品ID<input type="text" name="id"> <input type="submit" value="削除">
</form>

<p>更新する商品の情報を入力してください。</p>
<form action="update" method="post">
    商品ID<input type="text" name="id">
    新しい商品名<input type="text" name="name">
    <input type="submit" value="更新">
</form>

<%@include file="../footer.html"%>
