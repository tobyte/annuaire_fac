<%-- 
    Document   : index
    Created on : 24 févr. 2012, 19:24:32
    Author     : Toby
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello <sec:authentication property="principal.username"/> !</h1>


        <p>Utilisateur : <sec:authentication property="principal.username"/></p>
        <p> Vous pouvez accedé au pages suivantes... :</p>
        <ul>
            <sec:authorize ifAllGranted="ROLE_USER">
                <li> <a href ="ListerUtilisateur">lister les utilisateur </a></li>
            </sec:authorize>
            <sec:authorize ifAllGranted="ROLE_ADMIN">
                <li> <a href ="AjouterUtilisateur">ajouter un utilisateur </a></li>
            </sec:authorize>
            <a href="j_spring_security_logout">Déconnexion</a>
    </body>
</html>
