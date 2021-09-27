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
    <header class="user__header">
        <img src="https://avatars.githubusercontent.com/u/19550140?v=4" alt="" height="100px" />
        <h1 class="user__title">Affichage de l'archipel </h1>
    </header>
    
    <sql:setDataSource var = "snapshot" dataSource="maxime-wallart_ac"
         url = "postgresql-maxime-wallart.alwaysdata.net"
         user = "maxime-wallart"  password = "PAS2MDP"/>
 
      <sql:query dataSource = "${snapshot}" var = "result">
         SELECT * from joueur;
      </sql:query>
    
</div>
</body>
</html>