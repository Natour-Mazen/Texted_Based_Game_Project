package POO_Project.weapons;

import POO_Project.interfaces.Attackable;
import POO_Project.items.Weapons;

public class Gun extends Weapons implements Attackable {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	/******************************************************/
	/*   		          ATTRIBUTES                      */
	/******************************************************/
	private int ammunitions; 
	
	/******************************************************/
	/*   		          CONSTRUCTOR                     */
	/******************************************************/
	public Gun(String name, String desc, int damage, int nbmunitions) {
		super(name, desc, damage);
		this.setAmmunitions(nbmunitions);
	}

	/******************************************************/
	/*   		         	 METHODS                	  */
	/******************************************************/ 
	@Override
	public void MainAttack() {
		if(this.getAmmunitions() > 0) {
			System.out.println("POW POW POW ");
			int NewNbMunitions = this.getAmmunitions() - 1;
			this.setAmmunitions(NewNbMunitions);
		}	
	}
	
	 @Override
	 public String toString(){
		 return "   name = " + getName() + "\n"
			  + "   desc = " + getDesc() + "\n"
			  + "   number of ammunitions = " + getAmmunitions()+ "\n";
	 }
	 

	/******************************************************/
	/*   		          GETTERS&SETTERS                 */
	/******************************************************/
	public int getAmmunitions() {
		return ammunitions;
	}

	public void setAmmunitions(int munitions) {
		this.ammunitions = munitions;
	}


}
