package pakaja_okno;

import asciiPanel.AsciiPanel;

public class CreatureFactory {
    private World world;

    public CreatureFactory(World world){
        this.world = world;
    }
    
    public Creature newPlayer(){
    	Creature player = new Creature(world, 'P', AsciiPanel.brightWhite, 100, 15, 7);
        world.addAtEmptyLocation(player);
        new PlayerAI(player);
        return player;
    }
    
    public Creature newFungus(){
    	Creature fungus = new Creature(world, 'f', AsciiPanel.green, 10, 0, 0);
        world.addAtEmptyLocation(fungus);
        new FungusAi(fungus, this);
        return fungus;
    }
}
