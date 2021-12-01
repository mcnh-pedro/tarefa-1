<%--
    Document   : sayhello
    Created on : 08/02/2021, 23:08:15
    Author     : viter
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>sayhello.jsp</title>
    <link rel="stylesheet" type="text/css" href="app.css">
</head>
<body>
<div class="conteudo">
    <jsp:useBean id="myBean" class="hello.MessageBean"/>
    <h1>Fale assim:</h1>
    <img src="imagens/talk.jpg" style="width: 600px;" alt="conversando"/>

    <% String lang = request.getParameter("lang"); %>
    <% String tratamento = request.getParameter("tratamento"); %>

    <jsp:setProperty name="myBean" property="msg"  value="<%=lang%>"/>
    <jsp:setProperty name="myBean" property="tratamento" value="<%=tratamento%>"/>
    <h3><jsp:getProperty name="myBean" property="msg"/>, <jsp:getProperty name="myBean" property="treatment"/> <%=request.getParameter("nome")%>!</h3>

    <br/><br/><a href="#" onclick="window.history.back();">Voltar</a>
</div>
</body>
</html>







