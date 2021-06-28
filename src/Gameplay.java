import java.util.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.*;

import javax.swing.*;
import javax.swing.Timer;
public class Gameplay extends JPanel implements ActionListener {
    private Player player1;
    private Player player2;
    private Brick solid_brick;
    private Brick breakable_brick;
    public Gameplay(){
        solid_brick = new Solid_Bricks();
        breakable_brick = new Breakable_Bricks();
        player1 = new Player(200, 500, false, false, false, true, "player1_tank_right",
                "player1_tank_left", "player1_tank_up", "player1_tank_down");
        player2 = new Player(400, 500, false, false, false, true, "player2_tank_right",
                "player2_tank_left", "player2_tank_up", "player2_tank_down");
        player1.BrickList.add(solid_brick);
        player1.BrickList.add(breakable_brick);
        player2.BrickList.add(solid_brick);
        player2.BrickList.add(breakable_brick);
    }
    public void paint(){

    }
    @Override
    public void actionPerformed(ActionEvent e){
        repaint();
    }
    private void setBrick(){
        solid_brick = new Solid_Bricks();
        breakable_brick = new Breakable_Bricks();
    }

    private class resetListener implements KeyListener{
        public void keyTyped(KeyEvent e) {}
        public void keyReleased(KeyEvent e) {}
        public void keyPressed(KeyEvent e){
            if(e.getKeyCode() == KeyEvent.VK_SPACE && (player1.lives == 0 || player2.lives == 0)){
                setBrick();
                player1 = new Player(200, 500, false, false, false, true, "player1_tank_right",
                        "player1_tank_left", "player1_tank_up", "player1_tank_down");
                player2 = new Player(400, 500, false, false, false, true, "player2_tank_right",
                        "player2_tank_left", "player2_tank_up", "player2_tank_down");
            }

        }
    }
}
