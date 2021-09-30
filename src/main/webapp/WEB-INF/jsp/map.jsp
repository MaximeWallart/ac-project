<%@page import="org.springframework.web.bind.annotation.RequestParam"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page import="com.AC.ile.IleDao" %>
<%@ page import="javax.sql.DataSource" %>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="/css/inscription.css" />
<title>Creation Archipel</title>
</head>
<body>
   <div class="user">
    
    <sql:setDataSource var = "snapshot"
         url = "jdbc:postgresql://postgresql-maxime-wallart.alwaysdata.net:5432/maxime-wallart_ac"
         user = "maxime-wallart_alt"  password = "mdp2mdp"/>
 
    <sql:query dataSource = "${snapshot}" var = "result">
         SELECT * FROM archipel WHERE idjoueur = <c:out value="${sessionScope.joueur.id}"/> LIMIT 1;
    </sql:query>
      
    <c:forEach var = "a" items = "${result.rows}">
    
    <sql:query dataSource = "${snapshot}" var="iles">
    		SELECT * FROM ile WHERE idArchipel = <c:out value="${a.id}"/>;
    </sql:query>
    
    <sql:query dataSource = "${snapshot}" var="joueur">
    		SELECT * FROM joueur WHERE id = <c:out value="${a.idjoueur}"/> LIMIT 1;
   	</sql:query>
      
    <header class="user__header">
        <img src="https://avatars.githubusercontent.com/u/19550140?v=4" alt="" height="100px" />
        <h1 class="user__title">Affichage de l'archipel <c:out value="${a.nom}"/> </h1><br>
        <h1 class="user__title">Localisation : <c:out value="${a.localisation}"/> </h1><br>
        <c:forEach var="j" items="${joueur.rows}">
        	<h1 class="user__title">Propriétaire : <c:out value="${j.prenom}"/> <c:out value="${j.nom}"/></h1>
        </c:forEach>
    </header>
    
    </c:forEach>
      
      <br><br>
      
    <div class="user__header">
         
         <c:forEach var="ile" items="${iles.rows}">
         	<h1><c:out value = "${ile.nom}"/></h1>
         	<form method="post" action="/modificationIle?id=${ile.id}">
         		<input type="submit" value="Modifier"/>
         	</form>
         	<table>
         		<tr>
         		<c:forEach items="${show}" var="child" varStatus="status">
         		<c:if test="${fn:startsWith(child, ile.id)}">
         			<c:if test="${status.count%5 == 0 && status.count != 0 }">
         				</tr><tr>
         			</c:if>
         			<c:if test="${fn:contains(child,'Forêt')}">
         				<td style="background-color:green; color: green; padding:5px">_</td>
         			</c:if>
         			<c:if test="${fn:contains(child,'Plage')}">
         				<td style="background-color:yellow; color: yellow; padding:5px">_</td>
         			</c:if>
         			<c:if test="${fn:contains(child,'Magasin')}">
         				<td style="background-color:grey; color: white; padding:5px">M</td>
         			</c:if>
         			<c:if test="${fn:contains(child,'Ecole')}">
         				<td style="background-color:grey; color: white; padding:5px">E</td>
         			</c:if>
         			<c:if test="${fn:contains(child,'Cinema')}">
         				<td style="background-color:grey; color: white; padding:5px">C</td>
         			</c:if>
         		</c:if>
         		</c:forEach>
         		</tr>
         	</table>
         </c:forEach>
    </div>
    
</div>
</body>
</html>