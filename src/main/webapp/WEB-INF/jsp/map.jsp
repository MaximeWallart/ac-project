<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
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
      
    <header class="user__header">
        <img src="https://avatars.githubusercontent.com/u/19550140?v=4" alt="" height="100px" />
        <h1 class="user__title">Affichage de l'archipel <c:out value="${a.nom}"/> </h1>
    </header>
    
    
    <sql:query dataSource = "${snapshot}" var="iles">
    		SELECT * FROM ile WHERE idArchipel = <c:out value="${a.id}"/>;
    </sql:query>
    
    </c:forEach>
      
      <br><br>
      
    <div class="iles">
    
    <h2>OUI oUI</h2>
      
       <table border = "1" width = "100%">
         <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Localisation</th>
         </tr>
         
         <c:forEach var="a" items="${iles.rows}">
            <tr>
               <td><c:out value = "${a.id}"/></td>
               <td><c:out value = "${a.nom}"/></td>
               <td><c:out value = "${a.localisation}"/></td>
            </tr>
         </c:forEach>
      </table>
    </div>
    
</div>
</body>
</html>