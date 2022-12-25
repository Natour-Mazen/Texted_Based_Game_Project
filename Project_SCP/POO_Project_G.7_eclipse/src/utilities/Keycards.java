package utilities;

import items.Utilities;

public class Keycards extends Utilities {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	/******************************************************/
	/*   		          ATTRIBUTES                      */
	/******************************************************/
	private final int code; 
	
	/******************************************************/
	/*   		          CONSTRUCTOR                     */
	/******************************************************/
	public Keycards(String name, String desc, int code) {
		super(name, desc);
		this.code = code;
	}

	/******************************************************/
	/*   		          GETTERS&SETTERS                 */
	/******************************************************/
	public int getCode() {
		return code;
	}
}
