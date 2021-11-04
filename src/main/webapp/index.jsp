<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<%@ include file="/common/header.jsp" %>
<%
    Integer sum = 1+2;
    String color = "red";
%>
<h2><%=sum%></h2>
<h2>${pageContext.request.contextPath}</h2>
</body>
</html>
