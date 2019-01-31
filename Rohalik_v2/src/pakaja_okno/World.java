package pakaja_okno;

import java.awt.Color;


//класс где эти клетки хранятся
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
	}
	
	//Проверка на Out of Bounds и обозначение цвета/глифа для отображения
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
	    while (!kletki(x,y).isGround());

	    creature.x = x;
	    creature.y = y;
	}
}
