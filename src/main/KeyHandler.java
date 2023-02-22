package main;
import java.awt.event.*;

import javax.swing.UIDefaults.ActiveValue;

public class KeyHandler implements KeyListener{

    public boolean pressed, pressed_b;
    public int active_move = -1;

    // Key typed will not be used for the purposes of the campus game
    @Override
    public void keyTyped(KeyEvent e) {
    }

    public boolean IsClicked(){
        return (pressed == true) && (pressed_b == false);
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();
        active_move = code;
        pressed = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            //upPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            //leftPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            //downPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            //rightPressed = false;
        }

        pressed = false;
    }
    
}
