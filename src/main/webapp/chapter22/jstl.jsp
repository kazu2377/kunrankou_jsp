<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<%
    // 現在の日時を設定
    java.util.Date now = new java.util.Date();
    request.setAttribute("now", now);
%>

<%@ page import="java.util.List, java.util.ArrayList" %>


<%
	List<String> fruitsList = new ArrayList<>();
	fruitsList.add("りんご");
	fruitsList.add("みかん");
	fruitsList.add("バナナ");
	String[] fruitsArray = fruitsList.toArray(new String[0]);
	pageContext.setAttribute("fruits", fruitsArray);
%>

${fn:join(fruits, '、')}

<%-- Javaサーブレットでリストを設定済みの場合 --%>
<p>結合されたリスト: ${fn:join(myList, ',')}</p>

<c:if test="${fn:contains('hello world', 'world')}">
    <p>含まれています。</p>
</c:if>

<c:forEach var="p" items="${list}">
	${p.id}：${p.name}：${p.price}<br>
</c:forEach>

<c:set var="price" value="1000000" />
<fmt:formatNumber value="${price}" />円

<fmt:formatNumber value="12345.6789" type="currency" />
<!-- 結果: $12,345.68 （ロケールに基づく） -->

<fmt:formatDate value="${now}" />

<%@include file="../footer.html" %>
