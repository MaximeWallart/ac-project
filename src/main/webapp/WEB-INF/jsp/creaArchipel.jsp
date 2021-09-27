<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <h1 class="user__title">Création d'un Archipel pour <c:out value="${joueur.prenom}"/> </h1>
    </header>
    
    <script type="text/javascript">
    function add() {
        var spanvar = document.getElementById("myspan");
        var nmbIles = document.getElementById("nmbIles").value;
        var nmbChild = document.querySelectorAll("#myspan > div").length;
        if(nmbChild< nmbIles) {
        	for(let i=nmbChild; i<nmbIles; i++) {
        		var division = document.createElement("div");
        					 division.setAttribute("id", "Ile" + i);
        					 division.classList.add("ile_form");
        		var input = document.createElement("input");
        					input.setAttribute("type", "text");
        					input.setAttribute("name", "ile" + i + "_nom");
        					input.setAttribute("placeholder","Nom de l'ile " + (i+1) )
        					input.classList.add("form__input");
        		division.appendChild(input);
                //var element = document.createElement("input");
                //element.setAttribute("type", "text");
                //element.setAttribute("name", 'nom' + i );
                //element.setAttribute("id", 'input' + i );
               spanvar .appendChild(division);
        	}
        }
        else{
        	for(let i=nmbChild; i>nmbIles; i--) {
        		var toremove = document.getElementById('Ile' + (i-1) );
        		console.log(toremove.value);
        		spanvar.removeChild(toremove);
        	}
        }
      }
    </script>
    
    <form class="form" method="post" action="/affichageArchipel">
        <div class="form__group">
            <input type="number" id="nmbIles" name="nmbIles" placeholder="Nombre d'iles" min="0" max="5" class="form__input" onchange="add();"/>
        </div>
        
        <div class="form__group">
            <input type="text" name="nom" placeholder="Nom de l'archipel" class="form__input" />
        </div>
        
        <div class="form__group">
            <input type="text" name="loca" placeholder="Localisation" class="form__input" />
        </div>
        
        <button class="btn" type="submit">Valider</button>
        
        <span id="myspan"></span>
    
    </form>
</div>
</body>
</html>