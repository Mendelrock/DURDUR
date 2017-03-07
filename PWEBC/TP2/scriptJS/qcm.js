/*contrairement à la version du jeu simple, avec une seule question
un tableau de questions est défini au format JSON.
- la fonction question() est modifiée pour tirer au sort une des questions du tableau
- la fonction reponse() est modifiée avec désormais un paramètre supplémentaire, la réponse attendue
- 2 fonctions supplémentaires permettent de produire le code HTML à partir d'informations issu du tableau
- la fonction() init est éliminé cat on peut mettre son contenu dans onload()
*/

var timer;  //variable référençant un objet temporisateur
var temps_imparti =  10000;  //temps imparti pour donner la réponse (10s)
var q; //référence au bloc div d'affichage (<div "id=QUEST"></div>)


var repOK = "Bonne r\351ponse !";
var repKO = "'D\351sol\351\n Mauvaise Réponse'";
var repNO = "d\351sol\351";

var invite = "Choisissez le temps disponible pour r\351pondre";
	invite += " apr\350s avoir d\351marr\351 le test <br/>";
	invite += "<form onsubmit='question(temps_imparti); return false'><input type='text' name='temps' onchange='changerTemps(this.value)'/></form>"
	invite += "<a href='' onclick='question(temps_imparti); return false'>d\351marrer</a>";

//tableau au format JSON représentant un ensemble de questions
//avec pour chaque question, 3 attributs : question (intitué de la question), différents choix, numéro de la réponse

/*
var myJSONtext; // A REMPLIR avec la description de toutes les questions

var tabObject = eval('('+myJSONtext+')');  //Exploiter myJSONtext pour faire le tableau javascript
*/

var myJSONtext ='[{"question":"quel est l\'intrus ?", "choix":["nez","yeux","oreilles"], "reponse":0},{"question":"Quel est le fruit ?", "choix":["patate","figue","carotte"], "reponse":1},{"question":"Quel musicien ne jouait pas de trompette ?", "choix":["Miles Davis","Dave Brubeck","Boris Vian"], "reponse":1}]';
var tabObject = eval('('+myJSONtext+')');

/*var tabObject =	[
						{"question":"quel est l\'intrus ?", "choix":["nez","yeux","oreilles"], "reponse":0},
						{"question":"Quel est le fruit ?", "choix":["patate","figue","carotte"], "reponse":1},
						{"question":"Quel musicien ne jouait pas de trompette ?", "choix":["Miles Davis","Dave Brubeck","Boris Vian"], "reponse":1}
					];
*/

//****************************************************************//

window.onload = lancer;

function changerTemps(temps){
	temps_imparti=temps*1000;
}

function lancer() {
	q=document.getElementById('QUEST');
	q.innerHTML = invite;	//affichage de l'invite
	}


function abandon () {	//message d'alerte repNO indiquant l'abandon
	alert(repNO);
	lancer();
}

function question (temps_imparti)  {
	var questionNum=Math.floor(Math.random()*tabObject.length);
	q.innerHTML = htmlQuestion(questionNum);//affichage de la question dans le bloc QUEST
	timer= setTimeout("abandon()", temps_imparti);  //définit "timer" pour lancer abandon() après le temps imparti	
}

function reponse(iChoix, repGood)  {
	clearTimeout(timer); 	//stoppe le timer
	(iChoix==repGood)?(alert(repOK)):(alert(repKO));
	lancer();
}

function htmlQuestion(numQ) {
	var quest  =   "<h3 align='center'> QUESTION :  </h3><hr>";
	quest += tabObject[numQ].question;
	quest += "<ul style='list-style-type:none'>";
	for(i in tabObject){
		quest += htmlLiInput(numQ, i, tabObject[numQ].choix[i]);
	}
	quest += "</ul>";
	return quest;
}

function htmlLiInput(numQ,iChoix,Choix) {
	var prop;	
	prop  =   "<li><input  type='radio' name='rd' value="+iChoix+"  onclick='reponse(this.value,"+tabObject[numQ].reponse+")' /> "+Choix+"</li>";
	return prop;
}




