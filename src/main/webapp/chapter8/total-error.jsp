<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@page isErrorPage="true" %>

<h2>エラー情報</h2>

<%
if (exception instanceof java.lang.NumberFormatException) {
%>
    <p><strong>エラータイプ:</strong> 数値フォーマットエラー</p>
    <p><strong>詳細:</strong> 正しい数値を入力してください。</p>
<%
} else if (exception instanceof java.lang.NullPointerException) {
%>
    <p><strong>エラータイプ:</strong> ヌルポインタ例外</p>
    <p><strong>詳細:</strong> 存在しないデータにアクセスしようとしました。</p>
<%
} else if (exception instanceof java.lang.ArrayIndexOutOfBoundsException) {
%>
    <p><strong>エラータイプ:</strong> 配列インデックスエラー</p>
    <p><strong>詳細:</strong> 配列の範囲外を参照しました。</p>
<%
} else {
%>
    <p><strong>エラータイプ:</strong> 一般的なエラー</p>
    <p><strong>詳細:</strong> <%= exception.getMessage() %></p>
<%
}
%>

<h3>追加情報</h3>
<p><strong>例外クラス:</strong> <%= exception.getClass().getName() %></p>

<h3>スタックトレース:</h3>
<pre>
<% 
for (StackTraceElement element : exception.getStackTrace()) {
    out.println(element.toString());
}
%>
</pre>

<%@include file="../footer.html" %>
