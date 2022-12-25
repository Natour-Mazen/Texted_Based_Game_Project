package items;

import java.io.Serializable;

public abstract class Item implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	/******************************************************/
	/*   		          ATTRIBUTES                      */
	/******************************************************/
	private String name;
	private String desc;
 
	
	
	/******************************************************/
	/*   		          CONSTRUCTOR                     */
	/******************************************************/
	 public Item(String name, String desc){
		 this.name = name;
		 this.desc = desc;
	 }
	 
	/******************************************************/
	/*   		         	 METHODS                	  */
	/******************************************************/ 
	 @Override
	 public String toString(){
		 return "   name = " + getName() + "\n"
			  + "   desc = " + getDesc() + "\n";
	 }
	 
	 
	/******************************************************/
	/*   		          GETTERS&SETTERS                 */
	/******************************************************/
	 public String getName(){
		 return name;
	 }
	 
	 public void setName(String name){
		 this.name = name;
	 }
	 
	 public String getDesc(){
		 return desc;
	 }
	 
	 public void setDesc(String desc){
		 this.desc = desc;
	 }
	
}
