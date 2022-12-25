package POO_Project.items;

public abstract class Weapons extends Item{

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	/******************************************************/
	/*   		          ATTRIBUTES                      */
	/******************************************************/
	private int damage;
	
	/******************************************************/
	/*   		          CONSTRUCTOR                     */
	/******************************************************/
	public Weapons(String name, String desc, int damage) {
		super(name, desc);
		this.damage = damage;
	}
	
	/******************************************************/
	/*   		          GETTERS&SETTERS                 */
	/******************************************************/
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
}
