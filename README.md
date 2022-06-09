Rapport projet Calculatrice POO2 

Projet réalisé SEUL.

Ce projet de calculatrice a été réalisé avec 7 classes :
- la classe principale « Calculatrice »,
- les classes filles de la classe « Calculatrice » : « CalcOct », « CalcHexa », « CalcBin », « Courbe » et « Questions »
- et la classe fille de la classe « Questions » : « Lien ».


Les principaux algorithmes + explications : 


Pour l’affichage graphique, j’ai utilisé des GridLayout pour disposer les boutons de la calculatrice.

Pour les fonctions spéciales (exp, ln …), j’ai inclus la bibliothèque Math de Java. Pour pouvoir les utiliser, il faut d’abord écrire un nombre, et ensuite choisir la fonction souhaitée : celle-ci s’appliquera sur le nombre (ex : 4 et après exp).

Pour l’exposant, l’algorithme est le suivant : on parcourt la String qui contient les données entrées par l’utilisateur (l.getText() avec l qui est le Jtextfield). Tant que l’on ne rencontre pas le caractère ‘^’ , on stocke le nombre (la mantisse hors exposant) dans une variable temp_mantisse et lorsqu’on rencontre le caractère ‘^’ on stocke les caractères suivants ce caractère (la puissance, l’exposant) dans la variable temp_exposant. Et après tout ça on va calculer le résultat avec Math.pow.

Pour pouvoir utiliser l’exposant sur la calculatrice, on doit écrire un nombre, ensuite on appuie sur le caractère ‘^’. Après on marque la puissance que l’on souhaite et pour terminer on appuie sur le bouton res_exposant ce qui nous donnera le résultat attendu.
(ex : 4 ^ 2 et le bouton res_exposant donnera le résultat, ici 16.0)

L’algorithme des boutons d’opérateur plus, moins, div et fois : on stocke le premier opérande dans la variable « op1 » et on indique dans la variable « opérateur » le type de l’opérateur utilisé (si c’est plus, moins , fois, div).
Et pour le bouton égal, on va récupérer le deuxième opérande qu’on va stocker dans « op2 » et selon l’opérateur du calcul, on va réaliser l’opération adaptée et afficher le résultat du calcul.

Pour rendre un nombre négatif, il faut d’abord entrer un chiffre et ensuite appuyer sur le bouton 
« (-) » 
(ex : 4 et (-) → -4)

Le bouton C va effacer toute la zone de texte alors que le bouton Del va effacer uniquement un caractère dans la zone de texte.
Les résultats s’afficheront avec au maximum 3 chiffres après la virgule.

Pour l’affichage de la courbe, l’algorithme est le suivant : il faut tout d’abord appuyer sur le bouton « param » qui, une fois appuyé, affichera les valeurs qu’il lui faut. Il sera demander divers nombres pour l’affichage de la courbe. Le premier nombre demandé est celui de « a » dans la formule ax^n + b. Une fois la valeur entrée au clavier ou avec les boutons, il faut appuyer sur le bouton « Entrer a de ax^n+b » et il sera demander le « n ». Après avoir entré n, appuyer sur « Entrer n de ax^n+b » et pour finir il sera demander de rentrer « b ». Après avoir entré « b » il faut appuyer sur « Entrer b de ax^n + b » et pour terminer il faut appuyer sur le bouton Graph et la courbe s’affichera sur une nouvelle fenêtre.

POUR TOUS LES MODES

Il est uniquement supporté des calculs avec deux opérandes ou un seul UNIQUEMENT. Et pour le mode calculatrice classique en décimal il est possible de récupérer le résultat d’un calcul en appuyant sur un opérateur après un résultat (ex : 4 + 2 = 8 et + 2 = 10 etc.)

Il faut que la zone de texte ne contienne pas de « = » pour pouvoir changer de mode sinon rien ne se passera. 


Pour les autres classes sur les changements de base accessible en appuyant sur le bouton du mode souhaité (Octal, Binaire ou Hexa).


Les algorithmes des opérateur plus, moins, div et fois ont été modifiés pour convertir les entrées de l’utilisateur dans la bonne base : pour l’octal conversion avec Integer.parseInt(l.getText(), 8), pour le binaire conversion avec Integer.parseInt(l.getText(), 2) et pour l’hexadécimal conversion avec Integer.parseInt(l.getText(), 16).  

Et pour le résultat avec le bouton « = », on utilisera pour l’octal Integer.toOctalString, pour le binaire Integer.toBinaryString et pour l’hexadécimal Integer.toHexString.


Pour la classe « Questions » accessible depuis la classe principale en appuyant sur le bouton « Questions ».

Il sera possible d’écrire des questions qui sont les suivantes : 
- « date » renverra la date et l’heure actuelle
- « nom » renverra le nom de la session ou le nom d’utilisateur
- « version » renverra la version de Java installée sur la machine
- « jaune » rendra le bouton « C » jaune

Le bouton décimal ramènera vers la classe principale Calculatrice décimale.


La classe « Lien » accessible en appuyant sur le bouton « Lien vers Unistra » (uniquement si la zone de texte est vide sinon le bouton ne fera rien) va ouvrir une fenêtre avec un lien vers le site de l’Unistra . Si on appuie dessus, un navigateur s’ouvrira et ramènera sur le site de l’Unistra




















