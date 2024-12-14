<%@page contentType="text/html; charset=UTF-8" %>

<%
    // "destination.jsp" へのフォワード
    RequestDispatcher dispatcher = request.getRequestDispatcher("forward.jsp");
    dispatcher.forward(request, response);
%>


<%
    // "/myServlet" (URLパスにマッピングされたServlet) へのフォワード
    RequestDispatcher dispatcher = request.getRequestDispatcher("/chapter9/forward");
    dispatcher.forward(request, response);
%>