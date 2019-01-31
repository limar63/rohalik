package ekrani;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;
import pakaja_okno.Creature;
import pakaja_okno.CreatureFactory;
import pakaja_okno.World;
import pakaja_okno.WorldBuilder;
import ekrani.LoseScreen;
import ekrani.Ekran;
import ekrani.WinScreen;

public class PlayScreen implements Ekran {
	private World world;
	private Creature player;
	private int EkranWidth;
	private int EkranHeight;
	
	public PlayScreen(){
		EkranWidth = 80;
		EkranHeight = 21;
		createWorld();
		
		CreatureFactory creatureFactory = new CreatureFactory(world);
	    createCreatures(creatureFactory);
	}
	
	private void createCreatures(CreatureFactory creatureFactory){
	    player = creatureFactory.newPlayer();
	  
	    for (int i = 0; i < 8; i++){
	        creatureFactory.newFungus();
	    }
	}
	private void createWorld(){
		world = new WorldBuilder(90, 32)
					.makeCaves()
					.build();
	}
	
	public int getScrollX() { return Math.max(0, Math.min(player.x - EkranWidth / 2, world.width() - EkranWidth)); }
	
	public int getScrollY() { return Math.max(0, Math.min(player.y - EkranHeight / 2, world.height() - EkranHeight)); }
	
	@Override
	public void displayOutput(AsciiPanel terminal) {
		
		int left = getScrollX();
		int top = getScrollY(); 
		
		displayTiles(terminal, left, top);
		
		terminal.write(player.glyph(), player.x - left, player.y - top, player.color());
		
		terminal.writeCenter("-- press [escape] to lose or [enter] to win --", 22);
	}

	private void displayTiles(AsciiPanel terminal, int left, int top) {
		for (int x = 0; x < EkranWidth; x++){
	        for (int y = 0; y < EkranHeight; y++){
	            int wx = x + left;
	            int wy = y + top;

	            Creature creature = world.creature(wx, wy);
	            if (creature != null)
	                terminal.write(creature.glyph(), creature.x - left, creature.y - top, creature.color());
	            else
	                terminal.write(world.glyph(wx, wy), x, y, world.color(wx, wy));
	        }
	    }
	}
	
	@Override
	public Ekran respondToUserInput(KeyEvent key) {
		switch (key.getKeyCode()){
		case KeyEvent.VK_ESCAPE: return new LoseScreen();
		case KeyEvent.VK_ENTER: return new WinScreen();
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_H: player.moveBy(-1, 0); break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_L: player.moveBy( 1, 0); break;
		case KeyEvent.VK_UP:
		case KeyEvent.VK_K: player.moveBy( 0,-1); break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_J: player.moveBy( 0, 1); break;
		case KeyEvent.VK_Y: player.moveBy(-1,-1); break;
		case KeyEvent.VK_U: player.moveBy( 1,-1); break;
		case KeyEvent.VK_B: player.moveBy(-1, 1); break;
		case KeyEvent.VK_N: player.moveBy( 1, 1); break;
		}
		
		
		world.update();
		
		
		return this;
	}
}