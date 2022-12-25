package characters;

import java.io.Serializable;

import structures.Location;

public abstract class Character  implements Serializable {

	private static final long serialVersionUID = 1L;	
	/**
	* 
	*/
	/******************************************************/
	 /*   		          ATTRIBUTES                       */
	 /******************************************************/
	 private Location location;
	 private final String name;
	 private int PV;

	 
	 /******************************************************/
	 /*   		          CONSTRUCTOR                      */
	 /******************************************************/
	 Character(String name,Location location, int pv){
		 this.location = location;
		 this.name = name;
		 this.PV = pv;
	 }
	
	/******************************************************/
	/*   		          GETTERS&SETTERS                 */
	/******************************************************/
	 public Location getLocation() {
		 return location;
	 }
	 
	 public void setLocation(Location location) {
		 this.location = location;
	 }
	 
	 public String getName() {
		 return name;
	 }
	 
	 public int getPV() {
		 return PV;
	 }
	 
	 public void setPV(int pV) {
		 PV = pV;
	 }
	 
}
