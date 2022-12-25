package game;

import java.io.Serializable;
import java.util.*;

import characters.*;
import characters.Character;
import items.*;
import structures.*;
import weapons.*;
import utilities.*;


public class Game implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/******************************************************/
	/*   		          ATTRIBUTES                      */
	/******************************************************/
	 private Location rooms[];
	 private Item things[];
	 private Hero hero;
	 private Scp scps[];
	 
	 List<String> commands = new ArrayList<>(Arrays.asList("GO", "HELP", "LOOK", "SHOOT", "TAKE", "USE", "QUIT","INVENTORY"));
	 List<String> directions = new ArrayList<>(Arrays.asList("NORTH", "WEST", "EAST", "SOUTH"));
	 List<String> items = new ArrayList<>(Arrays.asList("GUN", "KEYCARD"));
	
	/******************************************************/
	/*   		          CONSTRUCTOR                     */
	/******************************************************/
	 public Game() {
		 initGame();
	 }
	 
	 /******************************************************/
	 /*   		         	 METHODS                	  */
	 /******************************************************/ 
	 public void showIntro() {
			System.out.println("|======================================================================================================================================|\n"
							  +"|  		      Welcome in our Text-Based Adventure Game inspired by SCP: Containment Breach Game.                               |\n"
							  +"| You have just woken up in the middle of a dark room.  You hear screams and gunshots in the distance muffled by the resounding alarm. |\n"
							  +"|   Your instinct quickly understands the situation: you must leave this place. Write \"help\" to know the commands available to you.    |\n"
							  +"|======================================================================================================================================|\n");
			look("");
	}
	 
	 public void initGame(){ 
		 /******************************************************************/
		 /* 						CREATION ROOMS 						   */	
		 /******************************************************************/ 
		 this.rooms = new Room[7];
		 					// NAME                    DESCRIPTION
		 rooms[0] = new Room("StartingRoom","\n>> Welcome here, dear adventurer. This is where your adventure starts, \n"
		 									+ "  you are in the Starting Room, in this room you will not find stuff, \n"
		 									+ "  explore a little to advance in your adventure, all I can tell you is \n"
		 									+ "  that there is light to the north of this room, good luck.");
		 
		 rooms[1] = new Room("TheLostRoom","\n>> Oh, dear adventurer. You are now in The Lost Room, This room is a bit \n"
		 								+ "  weird, you feel lost in this one, We don't see any stuff here, however \n"
		 								+ "  We see a Blocked door to the north, on which there is a picture of a gun ! ,\n"
		 								+ "  This is still strange? ; I also see an open door to the East, there may be interesting things there.");
		 
		 rooms[2] = new Room("LuckOrNotRoom","\n>> There may be hope dear adventurer, you now find yourself in the Luck Or Not Room. In this room there \n"
		 									+ "  is a gun maybe on the ground, it can be useful to you. There is a lot of light on the south side but there is \n"
		 									+ "  a locked door with a code you will definitely need a keycard.");
		 
		 rooms[3] = new Room("WhatRoom","\n>> WHAT IS THIS ? , you are now in the What Room. There is a very weird smell, yuck  ; what is this weird creature at the \n"
		 								+ "  back of the room !!! , you can use your gun on it , but remember a man once said 'wisdom gives all'. Continue to the \n"
		 								+ "  east you will have less problem.");
		 
		 rooms[4] = new Room("SlimyRoom","\n>> Ah it's too sticky here -_- , you are now in the Slimy Room. There's a creature stuck to the ceiling just above the east \n"
		 								+ "  door, how strange ! , go on your way.");
		 
		 rooms[5] = new Room("DarknessRoom","\n>> It's too dark here, you're in the Darkness Room. There is the keycard\n"
		 								+ "  right next to the very large sleeping creature, quickly get the keycard and head south using the secret door !");
		 
		 rooms[6] = new Room("VictoryRoom","\n>> Bravo dear adventurer, you are in the Victory Room.");
		 
		 
		 /******************************************************************/
		 /* 						CREATION SCP 						   */	
		 /******************************************************************/
		 this.scps = new Scp[3];
		 
		 scps[0] = new Scp("Scp-387\n",(Room)rooms[3],900,"I AM I AM, KILL ME AND YOU WILL SEE YOUR PEINE. \n",900);
		 
		 scps[1] = new Scp("Scp-4049\n",(Room)rooms[4],100,"APPROACH ME AND YOU WILL BE STICK FOR LIFE WITH ME HAHAHA. \n",1000);
		 
		 scps[2] = new Scp("Scp-501\n",(Room)rooms[5],12698,"ZzzZzzZZzz, WAKE ME UP AND YOU WILL SEE ME IN ALL YOUR NIGHTMARE. \n",500);
		 
		 
		 /******************************************************************/
		 /* 						CREATION ITEM 						   */	
		 /******************************************************************/
		 this.things = new Item[2];
		 
		 things[0] = new Gun("GUN","USE ME TO KILL",25,2);
		 
		 things[1] = new Keycards("KEYCARD","USE ME TO OPEN A LOCKED DOOR",255);
		 
		 /******************************************************************/
		 /* 						CREATION HERO 						   */	
		 /******************************************************************/
		 this.hero = new Hero("Prisoner-3945",(Room)rooms[0],30);
				
		 
		 /******************************************************************/
		 /* 						ADDING OBJECTS TO ROOMS 			   */	
		 /******************************************************************/
		 ((Room) rooms[2]).addObj(things[0]);
		 
		 ((Room) rooms[5]).addObj(things[1]);
		 
		 /******************************************************************/
		 /* 						ADDING ENTITIES TO ROOMS		       */	
		 /******************************************************************/
		 ((Room) rooms[0]).addCharacter(hero);
		 
		 ((Room) rooms[3]).addCharacter(scps[0]);
		 ((Room) rooms[4]).addCharacter(scps[1]);
		 ((Room) rooms[5]).addCharacter(scps[2]);
		 
		 /******************************************************************/
		 /* 						MAPING ROOMS DIRECTION   			   */	
		 /******************************************************************/
		 rooms[0].addDirection("NORTH", rooms[1]);
		 
		 rooms[1].addDirection("NORTH", rooms[3]);
		 rooms[1].addDirection("EAST", rooms[2]);
		 
		 rooms[2].addDirection("SOUTH",rooms[6]);
		 rooms[2].addDirection("WEST",rooms[1]);
		 
		 rooms[3].addDirection("EAST", rooms[4]);
		 
		 rooms[4].addDirection("EAST", rooms[5]);
		 
		 rooms[5].addDirection("SOUTH", rooms[2]);
	 }
	 
	 public void showHelpMenu() {
			System.out.println("\n<> Available commands: ");
			System.out.println("  * GO direction : north, east, south, west");
			System.out.println("  * LOOK [arg] : have infos on something or, if no args, on the actual room");
			System.out.println("  * TAKE arg : take an object in the room (you should look the room to know if there is something you can take...)");
			System.out.println("  * USE arg : use an object in our inventory (be careful about the item's details to know how it works)");
			System.out.println("  * INVENTORY : to see our inventory");
			System.out.println("  * SAVE : to save your game (only one save possible for now)");
			System.out.println("  * LOAD : to load an game");
			System.out.println("  * QUIT : to leave the game, remember to save!");
			System.out.println();
	}
	 
	 public boolean IsHeroaLive() {
		 if(this.hero.getPV()>0)
			 return true;
		 return false;
	 }
	 
	 public boolean checkPathExist(String path , Location loc) {
         HashMap<String ,Location> hm = loc.getExitDir();
         
         if(hm.containsKey(path)) {
             if(hm.get(path) instanceof Room)
                     return true;
             }   
         return false;
     }
     
	 public Location HeroNextLoc(String path , Location loc) {
         HashMap<String ,Location> hm = loc.getExitDir();
         
         if(hm.containsKey(path)) {
             if(hm.get(path) instanceof Room)
                     return hm.get(path);
                }
         return loc;
     }
     
	 public void ChangePosHero(Location nextloc, Location currentloc) {
		  ((Room) currentloc).removeCharacter(hero);
		 this.hero.setLocation(nextloc);
		 ((Room) nextloc).addCharacter(hero);
     }
     
     
	 public void runTimer(Hero h) {
		 Timer chrono = new Timer();
		 chrono.schedule(new TimerTask() {
			 int time = 25;
			 @Override
			 public void run() {
				 if(!h.getLocation().equals(rooms[5]))
					 cancel();
	
				 if (time ==0)
				 {
					 h.setPV(0);
					 cancel();
				 }
				 time --;
			}
			
		 }, 1000,1000);
		 
		
     }
     
     
     
	 public String go(String noun) {
    	 String msgErr = "  >> You can't move here, sorry.\n";
    	 String msgOk = "  >> You are in the next Room.\n";
    	 Location currentloc = this.hero.getLocation();
    	 boolean path = checkPathExist(noun ,currentloc); 
    	 if(path) {
    		 Location nextloc = HeroNextLoc(noun,currentloc);
    		 if(nextloc.equals(rooms[3]) )
    		 {
    			 boolean check = this.hero.checkInventoryItem(things[0]);
    			 if(check)
    			 {
    				 	this.ChangePosHero(nextloc,currentloc);
		    		 	return msgOk;
    			 }
    			 return msgErr;
    			 
    		 }
    		 if(nextloc.equals(rooms[5]) )
    		 {
    			 runTimer(this.hero);
    		 }	
    		 if(nextloc.equals(rooms[6]) )
    		 {
    			 boolean check = this.hero.checkInventoryItem(things[1]);
    			 if(check)
    			 {
    				 	this.ChangePosHero(nextloc,currentloc);
    				 	this.look("");
		    		 	return "";
    			 }
    			 return msgErr;
    		 }	 
    		 else
    		 {
    			this.ChangePosHero(nextloc,currentloc);
		    	return msgOk;
    		 }  		
    	 }
		return msgErr;
	}
     
	 public void look(String noun) {
    	 String msgerr ="  /!\\ You don't have this item. ";
    	if( noun.equals("GUN"))
    	{
    		boolean check =this.hero.checkInventoryItem(things[0]);
    		if (check)
    			System.out.println(things[0].toString());
    		else
    			System.out.println(msgerr);
    	}
    	if (noun.equals("KEYCARD"))
    	{
    		boolean check =this.hero.checkInventoryItem(things[1]);
    		if (check)
    			System.out.println(things[1].toString());
    		else
    			System.out.println(msgerr);
    	}
    	if(noun.equals(""))
    	{
    		Location currentLoc =  this.hero.getLocation();
    		System.out.println(">> You are in the "+ currentLoc.toString());
    		((Room) currentLoc).viewRoomContent();
    		((Room) currentLoc).viewRoomCharacters();
    	}	
	}
     
	 public String takeOb(String noun) {
 		if(noun != "") {
 			Location currentloc = this.hero.getLocation();
 			if( ((Room) currentloc).CheckItemInRoom(noun)){
 						Item item = ((Room) currentloc).getRoomItem(noun);
 						this.hero.take(item);
 						return "  >> You have successfully retrieved the item";
 			}
 		}
 		return "  >> You have not successfully retrieved the item";
 	}
      
	 public String useOb(String noun) {
		Location currentloc = this.hero.getLocation();
		
		if( noun.equals("GUN") && this.hero.checkInventoryItem( things[0]) )
    	{
			Item ite = this.hero.getItemHero(noun);
			if(((Gun) ite).getAmmunitions() > 0) 
			{
				if ( currentloc.equals(rooms[3]))
				{
					((Gun) ite).MainAttack();
					Character scp = ((Room) currentloc).getScpRoom();
					((Scp) scp).setHero(hero);
					((Scp) scp).MainAttack();
					((Scp) scp).removeHero();
				}
				((Gun) ite).MainAttack();
				return "  >> GUN USED";
			}
			return "   >> You're out of ammunition";
    	}
		if( noun.equals("KEYCARD") && this.hero.checkInventoryItem( things[1]) )
		{
			if(currentloc.equals(rooms[2]))
			{
				return "  >> KEYCARD USED";
			}
		}
		return "  >> ITEM NOT USED";
	}

 	
	 public boolean IsVictory() {
		 Location currentloc = this.hero.getLocation();
		 if(currentloc.equals(rooms[6])) 
			 return true;
		 return false;
			
	 }
	 
	 
     public String processVerb(List<String> wordlist) {
    	 String verb;
    	 String msg = "";
    	 
    	 verb = wordlist.get(0);
    	 
    	 if (!commands.contains(verb)) {
    		 msg = verb + " is not a known verb! Check help to see available commands! ";
    	 } else {
    		 switch (verb) {
    		 	case "HELP" :
    		 		showHelpMenu();
    		 		break;
    		 	case "QUIT" :
    		 		msg = "QUIT";
    		 		break;
    		 	case "LOOK" :
    		 		look("");
    		 		break;
    		 	case "INVENTORY" :
    		 		this.hero.viewInventory();;
    		 		break;
    			default :
    				msg = verb + " (not yet implemented)";
    				break;
       		 }
    	 }
    	 return msg;
     }

	public String processVerbNoun(List<String> wordlist) {
    	 String verb;
    	 String noun;
    	 String msg = "";
    	 Boolean error = false;
    	 
    	 verb = wordlist.get(0);
    	 noun = wordlist.get(1);
    	 
    	 if (!commands.contains(verb)) {
    		 msg = verb + " is not a known verb! Check help to see available commands! ";
    		 error = true;
    	 }
    	 if (!directions.contains(noun) && !items.contains(noun)) {
    		 msg += (noun + " is not a known noun!");
    		 error = true;
    	 }
    	 if (!error) {
    		 switch (verb) {
    		 	case "GO" :
    		 		msg = go(noun);
    		 		break;
    		 	case "LOOK" :
    		 		look(noun);
    		 		break;
    		 	case "TAKE" :
    		 		msg = takeOb(noun);
    		 		break;
    		 	case "USE" :
    		 		msg += useOb(noun) ;
    		 		break;
    		 	default :
    		 		msg += " (not yet implemented)";
    		 		break;
    		 }
    	 }
    	 return msg;
     }

	public String parseCommand(List<String> wordlist) {
    	 String msg;
    	 
    	 if (wordlist.size() == 1) {
    		 msg = processVerb(wordlist);
    	 } else if (wordlist.size() == 2) {
    		 msg = processVerbNoun(wordlist);
    	 } else {
    		 msg = "Only 2 word commands allowed!";
    	 }
    	 return msg;
     }
	 
	 //Method to extract the words individually from the line of text entered by the player
	 //Useful to take only important words, especially commands like "take sword" without " "
	 public List<String> wordList(String input) {
         String delims = "[ ,.:;?!\"']+"; //Delims to take out from the input string
         String[] words = input.split(delims); //The input string transformed in words
         List<String> wordsList = new ArrayList<>(); //Because we need to return a List<String>
         
         for (String word : words) {
             if (word != "")
                 wordsList.add(word);
         }
         return wordsList;
     }
	 
	 //Method to have a understandable input for parse it 
	 public String runCommand(String input) {
		 List<String> wordlist;
		 String s = "ok";
		 
		 if (input.equals("")) {
			 s = "You must enter a command";
		 } else {
			 wordlist = wordList(input); //To get a words list from our input
			 s = parseCommand(wordlist); //And parse it to execute the user's wish
		 }
		 return s;
	 } 
 
	 /******************************************************/
	 /*   		          GETTERS&SETTERS                 */
	 /******************************************************/
	 public Location getRoomInGame(int ind) {
        return rooms[ind];
     }
     
     public Item getItemInGame(int ind) {
         return things[ind];
     }
     
     public Hero getHero() {
         return hero;
     }
     
     public Scp getScpInGame(int ind) {
         return scps[ind];
     }
	
}


