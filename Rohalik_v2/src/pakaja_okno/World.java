package pakaja_okno;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;



//класс где эти клетки хран€тс€
public class World {
	private Kletki[][] kletki;
	private int width;
	public int width() { return width; }
	
	private int height;
	public int height() { return height; }
	
	public World(Kletki[][] kletki){
        this.kletki = kletki;
        this.width = kletki.length;
        this.height = kletki[0].length;
        this.creatures = new ArrayList<Creature>();
	}
	
	//ѕроверка на Out of Bounds и обозначение цвета/глифа дл€ отображени€
	public Kletki kletki(int x, int y){
        if (x < 0 || x >= width || y < 0 || y >= height)
            return Kletki.BOUNDS;
        else
            return kletki[x][y];
    }
	
	public char glyph(int x, int y){
        return kletki(x, y).glyph();
    }
	public Color color(int x, int y){
        return kletki(x, y).color();
    }
	
	public void dig(int x, int y) {
	    if (kletki(x,y).isDiggable())
	        kletki[x][y] = Kletki.FLOOR;
	}

	
	public void addAtEmptyLocation(Creature creature){
		int x;
	    int y;
	  
	    do {
	        x = (int)(Math.random() * width);
	        y = (int)(Math.random() * height);
	    } 
	    while (!kletki(x,y).isGround() || creature(x,y) != null);
	  
	    creature.x = x;
	    creature.y = y;
	    creatures.add(creature);
	}
	
	private List<Creature> creatures;

	public Creature creature(int x, int y){
		for (Creature c : creatures){
			if (c.x == x && c.y == y)
				return c;
		}
		return null;
	}
	
    public void remove(Creature other) {
        creatures.remove(other);
    }
    
    //очередь дл€ монстра что-то сделать
    public void update(){
        List<Creature> toUpdate = new ArrayList<Creature>(creatures);
        for (Creature creature : toUpdate){
            creature.update();
        }
    }
}
