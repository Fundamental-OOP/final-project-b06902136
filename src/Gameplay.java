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
    public ArrayList<Brick> bList = new ArrayList<>();
    public ArrayList<Weapon> wList = new ArrayList<>();
    private boolean play;
    public Gameplay(){
        solid_brick = new Solid_Bricks();
        breakable_brick = new Breakable_Bricks();
        bList.add(solid_brick);
        bList.add(breakable_brick);
        Bullet bullet = new Bullet(bList);
        Missile missile = new Missile(bList);
        Bomb bomb = new Bomb(bList);
        wList.add(bullet);
        wList.add(missile);
        wList.add(bomb);
        player1 = new Player(200, 500, false, false, false, true, "player1_tank_right",
                "player1_tank_left", "player1_tank_up", "player1_tank_down",
                KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_R, KeyEvent.VK_T, KeyEvent.VK_Y, wList);
        player2 = new Player(400, 500, false, false, false, true, "player2_tank_right",
                "player2_tank_left", "player2_tank_up", "player2_tank_down",
                KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_J, KeyEvent.VK_K, KeyEvent.VK_L, wList);
        player1.BrickList.add(solid_brick);
        player1.BrickList.add(breakable_brick);
        player2.BrickList.add(solid_brick);
        player2.BrickList.add(breakable_brick);
        play = true;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        repaint();
    }
    private void setBrick(){
        solid_brick = new Solid_Bricks();
        breakable_brick = new Breakable_Bricks();
    }
    public void paint(Graphics graphics){
        // play background
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, 650, 600);
        // right side background
        graphics.setColor(Color.DARK_GRAY);
        graphics.fillRect(660, 0, 140, 600);
        // draw bricks
        breakable_brick.draw(this, graphics);
        solid_brick.draw(this, graphics);
    }
    public void setPlay(){
        play = true;
    }
    private class resetListener implements KeyListener{
        public void keyTyped(KeyEvent e) {}
        public void keyReleased(KeyEvent e) {}
        public void keyPressed(KeyEvent e){
            if(e.getKeyCode() == KeyEvent.VK_SPACE && (player1.lives == 0 || player2.lives == 0)){
                setBrick();
                player1 = new Player(200, 500, false, false, false, true, "player1_tank_right",
                        "player1_tank_left", "player1_tank_up", "player1_tank_down",
                        KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_R, KeyEvent.VK_T, KeyEvent.VK_Y, wList);
                player2 = new Player(400, 500, false, false, false, true, "player2_tank_right",
                        "player2_tank_left", "player2_tank_up", "player2_tank_down",
                        KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_J, KeyEvent.VK_K, KeyEvent.VK_L, wList);
                player1.BrickList.add(solid_brick);
                player1.BrickList.add(breakable_brick);
                player2.BrickList.add(solid_brick);
                player2.BrickList.add(breakable_brick);
                setPlay();
            }

        }
    }
}