######################################################################
##			    SIMPLE MAKEFILE FOR PROJECT POO-IHM1	       		##
##							 BY MAZEN								##
######################################################################
JFLAGS = -g
JC = javac
JVM = java 

.SUFFIXES: .java .class

.java.class:
	@$(JC) $(JFLAGS) $*.java

CLASSES = \
 		  POO_Project/structures/Location.java \
		  POO_Project/characters/Character.java \
		  POO_Project/characters/CharactersList.java \
		  POO_Project/characters/Hero.java \
		  POO_Project/characters/Scp.java \
		  POO_Project/interfaces/Attackable.java \
		  POO_Project/items/Item.java \
		  POO_Project/items/ItemsList.java \
		  POO_Project/items/Utilities.java \
		  POO_Project/items/Weapons.java \
		  POO_Project/utilities/Keycards.java \
		  POO_Project/weapons/Gun.java \
		  POO_Project/structures/Room.java \
		  POO_Project/game/Game.java \
		  POO_Project/game/SCP_CB.java 

## ici j'ai choisi de compiler de cette maniere on aurait pu egalement le faire via un make allfaster de cette maniere :
## allfaster : @$(JC) $(JFLAGS) POO_Project/*/*.java , cela prenderait beaucoup moins de temps à la compilation qu'avec la methode all que j'utilise mais cela ne marche malheureusement pas avec les tests.

all: .talk .classes
	@echo "--> Compilation terminee avec succes !"

start : all
	@echo "--> Amusez-vous bien !\n"
	@$(JVM) POO_Project/game/SCP_CB
	 

clean :
	@$(RM) POO_Project/*/*.class
	@echo "--> Tous les .classes ont ete supprimes avec succes !"

.classes: $(CLASSES:.java=.class)
	
.talk :
	@echo "--> Compilation en cours.... (cela peut prendre quelques secondes)"
	
