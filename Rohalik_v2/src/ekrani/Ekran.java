package ekrani;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;

public interface Ekran {
    public void displayOutput(AsciiPanel terminal);

    public Ekran respondToUserInput(KeyEvent key);
}
