package pakaja_okno;

import java.awt.Color;
import asciiPanel.AsciiPanel;

public enum Kletki {
	FLOOR((char)250, AsciiPanel.yellow),
    WALL((char)177, AsciiPanel.yellow),
    BOUNDS('x', AsciiPanel.brightBlack);

    private char glyph;
    public char glyph() { return glyph; }

    private Color color;
    public Color color() { return color; }

    Kletki(char glyph, Color color){
        this.glyph = glyph;
        this.color = color;
    }
    
    public boolean isDiggable() {
        return this == Kletki.WALL;
    }
    
    public boolean isGround() {
        return this != WALL && this != BOUNDS;
    }
}