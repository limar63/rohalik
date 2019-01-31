package ekrani;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;

public class StartScreen implements Ekran {

    public void displayOutput(AsciiPanel terminal) {
        terminal.write("Proverka Startscreena", 1, 1);
        terminal.writeCenter("-- press [enter] to start --", 22);
    }

    public Ekran respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
    }
}

