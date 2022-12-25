package characters;

import interfaces.Attackable;
import structures.Location;


public class Scp extends Character implements Attackable {

	private static final long serialVersionUID = 1L;	
	/**
	 * 
	 */
	/******************************************************/
	/*   		          ATTRIBUTES                       */
	/******************************************************/
	private String desc;
	private Hero hero;
	private int Strength;


	/******************************************************/
	/*   		          CONSTRUCTOR                      */
	/******************************************************/
	public Scp(String name,Location location, int Pv, String desc, int Strength) {
		 super(name,location,Pv);
		 this.desc = desc;
		 this.Strength = Strength;
	}

	/******************************************************/
	/*   		         	 METHODS                	  */
	/******************************************************/ 
	@Override
	public void MainAttack() {
		Hero Htokill = this.getHero();
		int scpstrength = this.getStrength();
		Htokill.setPV(Htokill.getPV() - scpstrength);
	}

	 public String toString() {
		 return "   name : " + this.getName()
		 	  + "   Description : " + this.getDesc()  
		 	  + "   Strength : " + this.getStrength()
		 	  + "\n   PV : " + this.getPV();
	 }	 	
	 
	 public void removeHero() {
		 this.setHero(null);
	 }
	/******************************************************/
	/*   		          GETTERS&SETTERS                  */
	/******************************************************/
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero h) {
		this.hero = h;
	}
	
	public int getStrength() {
		return Strength;
	}

	public void setStrength(int strength) {
		Strength = strength;
	}
	
}