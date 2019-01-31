package pakaja_okno;

import javax.swing.JFrame;
import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import ekrani.Ekran;
import ekrani.StartScreen;

public class Okno extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1060623638149583738L;
	private AsciiPanel terminal;
	private Ekran ekran;
	public Okno(){
		super();
		terminal = new AsciiPanel();
		add(terminal);
        pack();
        ekran = new StartScreen();
        addKeyListener(this);
        repaint();
    }
	public void repaint(){
        terminal.clear();
        ekran.displayOutput(terminal);
        super.repaint();
    }

    public void keyPressed(KeyEvent e) {
        ekran = ekran.respondToUserInput(e);
        repaint();
    }

    public void keyReleased(KeyEvent e) { }

    public void keyTyped(KeyEvent e) { }

	public static void main(String[] args) {
		Okno app = new Okno();
	    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    app.setVisible(true);
	}
}

/*terminal.write("Proverochka", 0, 0);
terminal.write("Proverochka", 1, 1);
terminal.write("Proverochka", 2, 2);
terminal.write("Proverochka", 3, 3);
terminal.write("Proverochka", 4, 4);
terminal.write("Proverochka", 5, 5);
terminal.write("Proverochka", 6, 6);
terminal.write("Proverochka", 7, 7);
terminal.write("Proverochka", 6, 8);
terminal.write("Proverochka", 5, 9);
terminal.write("Proverochka", 4, 10);
terminal.write("Proverochka", 3, 11);
terminal.write("Proverochka", 2, 12);
terminal.write("Proverochka", 1, 13);
terminal.write("Proverochka", 0, 14);
terminal.write("Proverochka", 25, 0);
terminal.write("Proverochka", 24, 1);
terminal.write("Proverochka", 23, 2);
terminal.write("Proverochka", 22, 3);
terminal.write("Proverochka", 21, 4);
terminal.write("Proverochka", 20, 5);
terminal.write("Proverochka", 19, 6);
terminal.write("Proverochka", 18, 7);
terminal.write("Proverochka", 19, 8);
terminal.write("Proverochka", 20, 9);
terminal.write("Proverochka", 21, 10);
terminal.write("Proverochka", 22, 11);
terminal.write("Proverochka", 23, 12);
terminal.write("Proverochka", 24, 13);
terminal.write("Proverochka", 25, 14);*/ 