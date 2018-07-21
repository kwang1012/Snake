package game;

import java.awt.event.*;

public class GameKeyListener implements KeyListener {
    Player p1;
    GameKeyListener(Player player) {
        p1 = player;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(Main.window==1) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_ENTER:
                    if(BeginWindow.choice==0)
                        Main.window = 2;
                    break;
                case KeyEvent.VK_UP:
                    if(BeginWindow.choice!=0) {
                        BeginWindow.choice--;
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(BeginWindow.choice!=1)
                        BeginWindow.choice++;
                    break;
            }
        }
        else if(Main.window==2) {
            try {
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        if(p1.getSnake().dir!=0 && GameWindow.valid) {
                            p1.getSnake().dir = 1;
                            GameWindow.valid = false;
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if(p1.getSnake().dir!=1 && GameWindow.valid) {
                            p1.getSnake().dir = 0;
                            GameWindow.valid = false;
                        }
                        break;
                    case KeyEvent.VK_UP:
                        if(p1.getSnake().dir!=3 && GameWindow.valid) {
                            p1.getSnake().dir = 2;
                            GameWindow.valid = false;
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if(p1.getSnake().dir!=2 && GameWindow.valid) {
                            p1.getSnake().dir = 3;
                            GameWindow.valid = false;
                        }
                        break;
                    case KeyEvent.VK_ESCAPE:
                        Main.PAUSE = !Main.PAUSE;
                        break;
                }
            } catch (NotEnoughSnakeException exception) {
                Main.RESET = true;
            }
        }
        //System.out.println(KeyEvent.getKeyText(e.getKeyCode()));
    }
    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {

        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
}