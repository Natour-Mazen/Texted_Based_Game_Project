package POO_Project.structures;

import POO_Project.characters.*;
import POO_Project.characters.Character;
import POO_Project.items.*;

public class Room extends Location {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	/******************************************************/
	/*   		          ATTRIBUTES                      */
	/******************************************************/
	 private String name;
	 private String desc;
	 private ItemsList contents;
	 private int numberOfThings;
	 private CharactersList characters;
	 
	/******************************************************/
	/*   		          CONSTRUCTOR                     */
	/******************************************************/
	 public Room(String name, String desc) {
		 this.name = name;
		 this.desc = desc;
		 contents = new ItemsList();
		 characters = new CharactersList();
		 setType("Room");
	 }
	 
	/******************************************************/
	/*   		         	 METHODS                	  */
	/******************************************************/ 
	 public void viewRoomCharacters() {
		 System.out.println("<> Room Characters :");
		 System.out.println();
		 characters.describeCharacter();
	 }
	 
	 public void viewRoomContent() {
		 System.out.println("<> Room Contents :");
		 System.out.println();
		 contents.describeItems();
		 System.out.println();
	 }

	 @Override
	 public String toString() {
		 return "Room : \n"
	 		+ "# name = " + this.name + "\n"
	 		+ "# desc = " + this.desc + "\n"
	 		+ "# numberOfThings here = " + this.getNumberOfThings() + "\n";
	 }
	 
	 public Item getRoomItem(String obname) {
			Item aItem = contents.thisOb(obname);
			dropObj(aItem);
			return aItem;
	}
	 
	 public boolean CheckItemInRoom(String obname)
	 {
		 String itemName = "";
		 for (Item item : contents) {
				itemName = item.getName();
				if (itemName.equals(obname)) {
					return true;
				}
			}
		return false;
	 }
	 
	 public Character getScpRoom() {
		 Character scp = null;
		 for (Character sc : characters) {
				if (sc instanceof Scp ) {
					return scp = sc;
				}
			}
		 return scp;
	 }
	 
	 public void addObj(Item item){
		 this.contents.add(item);
	 }
	 public void dropObj(Item item){
		 this.contents.remove(item);
	 }
	 
	 public void addCharacter(Character cr){
		 this.characters.add(cr);
	 }
	 public void removeCharacter(Character cr){
		 this.characters.remove(cr);
	 }
	 
	/******************************************************/
	/*   		          GETTERS&SETTERS                 */
	/******************************************************/
	 public int getNumberOfThings() {
		 numberOfThings = contents.size();
		 return numberOfThings;
	 }
	
	 public String getName() {
		 return name;
	 }
	 
	 public void setName(String name) {
		 this.name = name;
	 }
	 
	 public String getDesc() {
		 return desc;
	 }
	 
	 public void setDesc(String desc) {
		 this.desc = desc;
	 }
	 
	 public String setLocationType() {
		 return "Room";
	 }
}
