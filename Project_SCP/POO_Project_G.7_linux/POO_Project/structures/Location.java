package POO_Project.structures;

import java.io.Serializable;
import java.util.*;

public abstract class Location implements Serializable {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/******************************************************/
	/*   		          ATTRIBUTES                      */
	/******************************************************/
	 private String type;
	 private HashMap<String ,Location> exits;
	 
	 
	/******************************************************/
	/*   		          CONSTRUCTOR                     */
	/******************************************************/
	 public Location() {
		 exits = new HashMap<String,Location>();
	 }
	 
	 
	/******************************************************/
	/*   		         	 METHODS                	  */
	/******************************************************/
	 @Override
	 public String toString() {
		 return "Location [type=" + type + ", roomDir=" + exits + "]";
	 }
	 
	 public void addDirection(String dir,Location location){
		 exits.put(dir, location);  
	 }
	 
	 
	/******************************************************/
	/*   		          GETTERS&SETTERS                 */
	/******************************************************/
	 public String getType() {
		 return type;
	 }

	 public void setType(String type) {
		 this.type = type;
	 }
	 
	 public HashMap<String, Location> getExitDir() {
		 return exits;
	 }

	 public void setExitDir(HashMap<String, Location> roomDir) {
		 this.exits = roomDir;
	 }
}
