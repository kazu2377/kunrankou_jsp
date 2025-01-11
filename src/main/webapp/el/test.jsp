<%@page contentType="text/html; charset=UTF-8"%>


<%-- ①アクションタグでBeanを使用 --%>
<jsp:useBean id="bean" class="example.SampleBean" scope="request">
	<jsp:setProperty name="bean" property="name" value="Taro" />
</jsp:useBean>
<%-- プロパティの値を取得 --%>
名前:
<jsp:getProperty name="bean" property="name" />
<%-- EL式でBeanのプロパティを取得 --%>
名前: ${bean.name}



<%-- アクション --%>
<%@ page import="example.SampleBean" %>

<%-- リクエストスコープにBeanを設定　スクリプトプレット --%>
<%
SampleBean bean = new SampleBean();
bean.setName("Taro");
request.setAttribute("bean", bean);
%>

<%-- EL式でBeanのプロパティを取得 --%>
名前: ${bean.name}
<%-- スクリプトレット内でBeanを取得し、式で出力 --%>
名前:
<%=((SampleBean) request.getAttribute("bean")).getName()%>
