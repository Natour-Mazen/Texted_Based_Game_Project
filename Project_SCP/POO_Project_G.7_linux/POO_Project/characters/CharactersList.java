package POO_Project.characters;

import java.util.ArrayList;

public class CharactersList extends ArrayList<Character> {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	public void describeCharacter() { 
		int size = this.size();
		if (size == 0 ) {
			System.out.println("   --> No one in this Room");
		} else {
			for(int i = 0 ; i < size ; i++) {
				Character chara =  this.get(i);
				System.out.println(" * Character "+ (i+1) +" :");
				System.out.println(chara.toString());	
				System.out.println();
			}	
		}
	}

	
	public Character thisCharacter( String name ) {
		Character aChar = null;
		String CharName = "";
		for ( Character charac : this ) {
            CharName = charac.getName();
            if (CharName.equals(name)) {
                aChar = charac;
            }
	    }
	    return aChar;
	}
}