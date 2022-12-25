package tests;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import game.*;
import structures.Room;
import weapons.Gun;
import utilities.Keycards;

public class GameIT {
	
	Game game;
	Gun anOtherGun;
	Keycards secondKeycard;
	
	@Before
	public void setUp() {
		game = new Game();
		anOtherGun = new Gun("FAKE GUN", "I am fake", 0, 0);
		secondKeycard = new Keycards("Second Keycard","Im not the real Keycard",123);
	}
	
	@Test
	public void testSaveLoad() {
		game.ChangePosHero(game.getRoomInGame(2), game.getHero().getLocation());
		
		assertSame(game.getHero().getLocation(), game.getRoomInGame(2));
		
		game.takeOb("GUN");
		
		assertSame(game.getHero().getItemHero("GUN"), game.getItemInGame(0));
		
		/******************************************************/
		/*   		          SAVE                 			  */
		/******************************************************/
		try {
			FileOutputStream fos = new FileOutputStream("Scp.sav");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(game);
			
			oos.flush();
			oos.close();
			
			System.out.println(" ______________________________\n"
							  +"|                              |\n"
							  +"|                              |\n"
					          +"|          GAME SAVED          |\n"
					          +"|                              |\n"
					          +"|______________________________|\n");
			
			
		} catch (Exception e) {
			System.out.print("Serialization Error! Can't save data.\n"
					+ e.getClass() + ": " + e.getMessage() + "\n");
		}
		
		/******************************************************/
		/*   		          SAVE                 			  */
		/******************************************************/
		
		game.useOb("GUN");
		
		assertSame(((Gun) game.getHero().getItemHero("GUN")).getAmmunitions(), 1);
		
		/******************************************************/
		/*   		          LOAD                 			  */
		/******************************************************/
		
		try {
			FileInputStream fis = new FileInputStream("Scp.sav");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			game = (Game) ois.readObject();
			
			ois.close();
			
			System.out.println(" ______________________________\n"
					  		  +"|                              |\n"
					  		  +"|                              |\n"
					  		  +"|          GAME LOADED         |\n"
					  		  +"|                              |\n"
					  		  +"|______________________________|\n");
			
		} catch (Exception e) {
			System.out.print("Serialization Error! Can't load data.\n"
					+e.getClass() + ": " + e.getMessage() + "\n");
		}
		
		/******************************************************/
		/*   		          LOAD                 			  */
		/******************************************************/
		
		assertSame(((Gun) game.getHero().getItemHero("GUN")).getAmmunitions(), 2);
	}
	
	
	
	@Test
	public void testGoRoom3() {
		game.ChangePosHero(game.getRoomInGame(1), game.getHero().getLocation());
		
		assertSame(game.getHero().getLocation(), game.getRoomInGame(1));
		
		game.getHero().take(anOtherGun);
		
		assert(game.getHero().checkInventoryItem(anOtherGun));
		
		game.go("NORTH");
		
		assertSame(game.getHero().getLocation(), game.getRoomInGame(1));
	}
	
	
	
	@Test
	public void testGoRoom6() {
		game.ChangePosHero(game.getRoomInGame(2), game.getHero().getLocation());

		assertSame(game.getHero().getLocation(), game.getRoomInGame(2));

		game.getHero().take(secondKeycard);
		
		assert(game.getHero().checkInventoryItem(secondKeycard));

		game.go("South");

		assertSame(game.getHero().getLocation(), game.getRoomInGame(2));
	}
	
	
	
	@Test
	public void testUseGun() {
		game.ChangePosHero(game.getRoomInGame(3), game.getHero().getLocation());
		
		assertSame(game.getHero().getLocation(), game.getRoomInGame(3));
		
		assertSame(((Room)game.getHero().getLocation()).getScpRoom(), game.getScpInGame(0));
		
		game.useOb("GUN");
		
		assertTrue(game.IsHeroaLive());
	}
	
	
	
	@Test
	public void testUseGunBis() {
		game.ChangePosHero(game.getRoomInGame(3), game.getHero().getLocation());
		
		assertSame(game.getHero().getLocation(), game.getRoomInGame(3));
		
		assertSame(((Room)game.getHero().getLocation()).getScpRoom(), game.getScpInGame(0));
		
		game.getHero().take(anOtherGun);
		
		assert(game.getHero().checkInventoryItem(anOtherGun));
		
		game.useOb("GUN");
		
		assertSame(anOtherGun.getAmmunitions(), 0);
		
		assertTrue(game.IsHeroaLive());
	}
	
	
	
	@Test
	public void testGoRoom2toRoom5() {
		game.ChangePosHero(game.getRoomInGame(2), game.getHero().getLocation());
		
		assertSame(game.getHero().getLocation(), game.getRoomInGame(2));

		game.go("NORTH");
		
		assertSame(game.getHero().getLocation(), game.getRoomInGame(2));
	}
	
	
	
	@Test
	public void testWordList() {
		List<String> wordsList = new ArrayList<>();
		wordsList.add("CECI");
		wordsList.add("EST");
		wordsList.add("UN");
		wordsList.add("TEST");
		
		List<String> wordsList2 = new ArrayList<>();
		wordsList2 = game.wordList("    ??,,'    CECI   EST UN          TEST ");
		
		Assert.assertEquals(wordsList2,wordsList);
	}

}