package POO_Project.items;

import java.util.ArrayList;

public class ItemsList extends ArrayList<Item>{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	public void describeItems() {
        int size = this.size();
        if (size == 0) {
        	System.out.println("   --> No items here.\n");;
        } else {
        	 for(int i = 0 ; i < size ; i++) {
				  Item ite = this.get(i);
				  System.out.println(" * Contents "+ (i+1) +" :" );
				  System.out.println( ite.toString());
            }
        }
 
    }

	public Item thisOb(String name) {
        Item aItem = null;
        String ItemName = "";
        for (Item item : this) {
            ItemName = item.getName();
            if (ItemName.equals(name)) {
                aItem = item;
            }
        }
        return aItem;
    }
	
	public ItemsList getItems() {
        return this;
    }
}
