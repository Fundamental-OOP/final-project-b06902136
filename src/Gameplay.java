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
    public Timer timer;
    private int delay = 8;
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
        timer = new Timer(delay, this);
        timer.start();
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

        if(play){
            player1.draw(this, graphics);
            player2.draw(this, graphics);

            if(player1.getUsingWeapon() != null && player1.Shoot){
                if(player1.shootDirection.equals("")){
                    if(player1.up){
                        player1.shootDirection = "up";
                    }
                    else if(player1.down){
                        player1.shootDirection = "down";
                    }
                    else if(player1.right){
                        player1.shootDirection = "right";
                    }
                    else if(player1.left){
                        player1.shootDirection = "left";
                    }
                }
                else{
                    player1.getUsingWeapon().move(player1.shootDirection);
                    player1.getUsingWeapon().draw(this, graphics);
                    player1.getUsingWeapon().draw(this, graphics);
                }

                if(player1.getUsingWeapon().perform(player1, player2)){
                    player1.setUsingWeapon(null);
                    player1.Shoot = false;
                    player1.shootDirection = "";
                }
            }
            if(player2.getUsingWeapon() != null && player2.Shoot){
                if(player2.shootDirection.equals("")){
                    if(player2.up){
                        player2.shootDirection = "up";
                    }
                    else if(player2.down){
                        player2.shootDirection = "down";
                    }
                    else if(player2.right){
                        player2.shootDirection = "right";
                    }
                    else if(player2.left){
                        player2.shootDirection = "left";
                    }
                }
                else{
                    player2.getUsingWeapon().move(player2.shootDirection);
                    player2.getUsingWeapon().draw(this, graphics);
                    player2.getUsingWeapon().draw(this, graphics);
                }

                if(player2.getUsingWeapon().perform(player2, player1)){
                    player2.setUsingWeapon(null);
                    player2.Shoot = false;
                    player2.shootDirection = "";
                }
            }
            // the scores
            graphics.setColor(Color.white);
            graphics.setFont(new Font("serif",Font.BOLD, 15));
            graphics.drawString("Scores", 700,30);
            graphics.drawString("Player 1:  "+ player1.score, 670,60);
            graphics.drawString("Player 2:  "+ player2.score, 670,90);

            graphics.drawString("Lives", 700,150);
            graphics.drawString("Player 1:  "+ player1.lives, 670,180);
            graphics.drawString("Player 2:  "+ player2.lives, 670,210);

            if(player1.lives == 0){
                graphics.setColor(Color.white);
                graphics.setFont(new Font("serif",Font.BOLD, 60));
                graphics.drawString("Game Over", 200,300);
                graphics.drawString("Player 2 Won", 180,380);
                graphics.setColor(Color.white);
                graphics.setFont(new Font("serif",Font.BOLD, 30));
                graphics.drawString("(Space to Restart)", 230,430);
                setPlay(false);
            }
            else if(player2.lives == 0){
                graphics.setColor(Color.white);
                graphics.setFont(new Font("serif",Font.BOLD, 60));
                graphics.drawString("Game Over", 200,300);
                graphics.drawString("Player 1 Won", 180,380);
                graphics.setColor(Color.white);
                graphics.setFont(new Font("serif",Font.BOLD, 30));
                graphics.drawString("(Space to Restart)", 230,430);
                setPlay(false);
            }
            graphics.dispose();
        }
    }
    public void setPlay(boolean b){
        play = b;
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
                setPlay(true);
                repaint();
            }

        }
    }
}