import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyboardDispatcher implements KeyEventDispatcher {

    private MyPanel panel;

    public KeyboardDispatcher(MyPanel panel) {
        this.panel = panel;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {

        if (e.getID() == KeyEvent.KEY_PRESSED) {

            panel.character.isMoving = true;

            if (e.getKeyCode() == KeyEvent.VK_A) {
                panel.character.startRunningLeft();
            } else if (e.getKeyCode() == KeyEvent.VK_D) {
                panel.character.startRunningRight();
            } else if (e.getKeyCode() == KeyEvent.VK_W) {
                panel.character.startRunningUp();
            } else if (e.getKeyCode() == KeyEvent.VK_S) {
                panel.character.startRunningDown();
            }
        }

        if (e.getID() == KeyEvent.KEY_RELEASED) {

            panel.character.isMoving = false;

            if (e.getKeyCode() == KeyEvent.VK_A) {
                panel.character.stopRunningLeft();
            } else if (e.getKeyCode() == KeyEvent.VK_D) {
                panel.character.stopRunningRight();
            } else if (e.getKeyCode() == KeyEvent.VK_W) {
                panel.character.stopRunningUp();
            } else if (e.getKeyCode() == KeyEvent.VK_S) {
                panel.character.stopRunningDown();
            }
        }


        return false;
    }
}
