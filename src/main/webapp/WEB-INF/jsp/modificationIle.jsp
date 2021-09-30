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
<title>Modification Ile</title>
</head>
<body>
   <div class="user">
    
    <sql:setDataSource var = "snapshot"
         url = "jdbc:postgresql://postgresql-maxime-wallart.alwaysdata.net:5432/maxime-wallart_ac"
         user = "maxime-wallart_alt"  password = "mdp2mdp"/>
 
    <sql:query dataSource = "${snapshot}" var = "result">
         SELECT * FROM ile WHERE id = <c:out value="${id}"/> LIMIT 1;
    </sql:query>
      
    <c:forEach var = "i" items = "${result.rows}">
      
    <header class="user__header">
        <img src="https://avatars.githubusercontent.com/u/19550140?v=4" alt="" height="100px" />
        <h1 class="user__title">Modification de l'Ile <c:out value="${i.nom}"/> </h1><br>
        <h1 class="user__title">Localisation : <c:out value="${i.localisation}"/> </h1><br>
    </header>
    
    </c:forEach>
      
      <br><br>
      
    <div class="user__header">
    	<form method="post" action="/changementArchipel">
        	<div class="form__group">
           		<input type="text" id="nom" name="nomIle" value="${i.nom}" placeholder="Nom de l'ile" class="form__input" />
        	</div>
         	<table>
         		<tr>
         		<c:forEach items="${childrens}" var="child" varStatus="status">
         			<% System.out.println(request.getAttribute("child")); %>
         			<div class="form-popup" id="myForm" style="display:none;"> 
						  <form action="/" class="form-container">
						    <input type="text" placeholder="Nom" name="nom" required>
						    <br>
						    <select name="type" style="width: 200px; overflow: hidden;" required>
						    	<option value="Plage">Plage</option>
						    	<option value="Forêt">Forêt</option>
						    	<option value="École">École</option>
						    	<option value="Magasin">Magasin</option>
						    	<option value="Cinema">Cinema</option>
						    </select>
						    <button type="submit" class="btn">Changer</button>
						    <button type="button" class="btn cancel" onclick="closeForm()">Fermer</button>
						  </form>
						</div>
         			<c:if test="${status.count%5 == 0 && status.count != 0 }">
         				</tr><tr>
         			</c:if>
         			<c:if test="${fn:contains(child,'Forêt')}">
         				<td><button type="button" onclick="openForm()" style="background-color:green; color: green; padding:15px">_</button></td>
         			</c:if>
         			<c:if test="${fn:contains(child,'Plage')}">
         				<td><button type="button" onclick="openForm()" style="background-color:yellow; color: yellow; padding:15px">_</button></td>
         			</c:if>
         			<c:if test="${fn:contains(child,'Magasin')}">
         				<td style="background-color:grey; color: white; padding:15px">M</td>
         			</c:if>
         			<c:if test="${fn:contains(child,'Ecole')}">
         				<td style="background-color:grey; color: white; padding:15px">E</td>
         			</c:if>
         			<c:if test="${fn:contains(child,'Cinema')}">
         				<td style="background-color:grey; color: white; padding:15px">C</td>
         			</c:if>
         		</c:forEach>
         		</tr>
         	</table>
         	<input type="submit" value="Valider"/>
        </form>
    </div>
    
	<script>
	function openForm() {
		document.getElementById("myForm").style.display = "block";
	}
	function closeForm() {
		document.getElementById("myForm").style.display = "none";
	}
	</script>
    
</div>
</body>
</html>