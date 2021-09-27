 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="/css/inscription.css" />
<title>Inscription</title>
</head>
<body>
   <div class="user">
    <header class="user__header">
        <img src="https://www.yescodeplease.com/images/human-space.png" alt=""  height="100px"  />
        <h1 class="user__title">Données de l'utilisateur</h1>
    </header>
    
    <form class="form" method="post" action="/creaArchipel">
        <div class="form__group">
            <input type="text" name="nom" placeholder="Nom" class="form__input" />
        </div>
        
        <div class="form__group">
            <input type="text" name="prenom" placeholder="Prenom" class="form__input" />
        </div>
        
        <div class="form__group">
            <input type="email" name="mail" placeholder="Email" class="form__input" />
        </div>
        
        <button class="btn" type="submit">Valider</button>
    </form>
</div>
</body>
</html>