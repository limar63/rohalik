package pakaja_okno;

import java.awt.Color;

//класс для обозначения существ
public class Creature {
	private World world;
	
	public int x;
    public int y;

    private char glyph;
    public char glyph() { return glyph; }

    private Color color;
    public Color color() { return color; }

    public Creature(World world, char glyph, Color color){
        this.world = world;
        this.glyph = glyph;
        this.color = color;
    }
	
    private CreatureAI ai;
    public void setCreatureAI(CreatureAI ai) { this.ai = ai; }

    public void dig(int wx, int wy) {
        world.dig(wx, wy);
    }
    
    public void moveBy(int mx, int my){
        Creature other = world.creature(x+mx, y+my);
      
        if (other == null)
            ai.onEnter(x+mx, y+my, world.kletki(x+mx, y+my));
        else
            attack(other);
    }
    public void attack(Creature other){
        world.remove(other);
    }
    
    public void update(){   
        ai.onUpdate();  
    }
    
    public boolean canEnter(int wx, int wy) {
		return world.kletki(wx, wy).isGround() && world.creature(wx, wy) == null;
	}
}

