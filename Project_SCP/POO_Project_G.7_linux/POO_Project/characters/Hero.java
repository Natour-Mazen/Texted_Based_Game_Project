package POO_Project.characters;

import POO_Project.items.Item;
import POO_Project.items.ItemsList;
import POO_Project.structures.Location;

public class Hero extends Character {

	private static final long serialVersionUID = 1L;
	 /**
	 * 
	 */
	/******************************************************/
	 /*   		          ATTRIBUTES                       */
	 /******************************************************/
	 private ItemsList inventory;
	 private int numberOfObjects;

	 /******************************************************/
	 /*   		          CONSTRUCTOR                      */
	 /******************************************************/
	 public Hero(String name,Location location,int pv) {
		 super(name,location,pv);
		 this.inventory = new ItemsList();
	 }
	 
	 /******************************************************/
	/*   		         	 METHODS                	  */
	/******************************************************/ 
	public void take(Item item){
		 inventory.add(item);
	 }
		 
	public void drop(Item item){
		 inventory.remove(item);
	 }
	
	 public void viewInventory() {
		 System.out.println("<> Inventory :");
		 inventory.describeItems();
	 }

	 public boolean checkInventoryItem(Item Thing) {
		 for(Item i : inventory ) {
			 if(i.equals(Thing))
				 return true;
		 }
		 return false;
	 }
		 
	 @Override
	 public String toString() {
		 return "   name : " + this.getName() + " (You)\n"
	 	  + "   PV : " + this.getPV()  + "\n"
	 	  + "   number Of Objects in inventory : " + this.getNumberOfObjects() + "\n";
	 }
	 
	 public Item getItemHero(String obname) {
			Item aItem = null;
			String itemName = "";
			for (Item item : inventory) {
				itemName = item.getName();
				if (itemName.equals(obname)) {
					aItem = item;
					
				}
			}
			return aItem;
	 }
	 
	 /******************************************************/
	 /*   		          GETTERS&SETTERS                  */
	 /******************************************************/	 
	 public int getNumberOfObjects() {
		 this.numberOfObjects = this.inventory.size();
		 return numberOfObjects;
	 }
}
		 
