import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Player {
    private ArrayList<Weapon> WeaponList;
    private ImageIcon playerIMG;
    public int X;
    public int Y;
    public boolean right;
    public boolean left;
    public boolean down;
    public boolean up;
    public int score = 0;
    public int lives = 5;
    public boolean Shoot;
    public String shootDirection = "";
    private String right_img;
    private String left_img;
    private String up_img;
    private String down_img;
    public ArrayList<Brick> BrickList;
    public Player(int x, int y, boolean r, boolean l, boolean d, boolean u, String RightIMG, String LeftIMG, String UpIMG, String DownIMG){
        X = x;
        Y = y;
        right = r;
        left = l;
        down = d;
        up = u;
        right_img = RightIMG;
        left_img = LeftIMG;
        up_img = UpIMG;
        down_img = DownIMG;
        if(u)
            playerIMG = new ImageIcon(UpIMG);
        else if(d)
            playerIMG = new ImageIcon(DownIMG);
        else if(r)
            playerIMG = new ImageIcon(RightIMG);
        else playerIMG = new ImageIcon(LeftIMG);
        Bullet bullet = new Bullet();
        Missile missile = new Missile();
        Bomb bomb = new Bomb(); //我不確定constructer長怎樣所以先寫這樣
        WeaponList.add(bullet);
        WeaponList.add(missile);
        WeaponList.add(bomb);
    }
    public ImageIcon getPlayerIMG(){
        return playerIMG;
    }
    private class Listener implements KeyListener{
        public void keyTyped(KeyEvent e) {}
        public void keyReleased(KeyEvent e) {}
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()== KeyEvent.VK_W){
                right = false;
                left = false;
                down = false;
                up = true;
                boolean testCollision = false;
                if(Y >= 10){
                    for(int i = 0; i < BrickList.size(); ++i){
                        Brick b = BrickList.get(i);
                        if(testCollision) break;
                        for(int j = 0; j < b.brickOn.length; ++j){
                            if (new Rectangle(X, Y - 10, 10, 10).intersects(new Rectangle(b.brickXpos[j], b.brickYpos[j], b.brickWidth, b.brickHeight))) {
                                testCollision = true;
                                break;
                            }
                        }
                    }
                    if(!testCollision) Y -= 10;
                }
            }
            if(e.getKeyCode()== KeyEvent.VK_A){
                right = false;
                left = true;
                down = false;
                up = false;
                boolean testCollision = false;
                if(X >= 10){
                    for(int i = 0; i < BrickList.size(); ++i){
                        Brick b = BrickList.get(i);
                        if(testCollision) break;
                        for(int j = 0; j < b.brickOn.length; ++j){
                            if (new Rectangle(X - 10, Y, 10, 10).intersects(new Rectangle(b.brickXpos[j], b.brickYpos[j], b.brickWidth, b.brickHeight))) {
                                testCollision = true;
                                break;
                            }
                        }
                    }
                    if(!testCollision) X -= 10;
                }
            }
            if(e.getKeyCode()== KeyEvent.VK_S){
                right = false;
                left = false;
                down = true;
                up = false;
                boolean testCollision = false;
                if(Y <= 540){
                    for(int i = 0; i < BrickList.size(); ++i){
                        Brick b = BrickList.get(i);
                        if(testCollision) break;
                        for(int j = 0; j < b.brickOn.length; ++j){
                            if (new Rectangle(X, Y + 10, 10, 10).intersects(new Rectangle(b.brickXpos[j], b.brickYpos[j], b.brickWidth, b.brickHeight))) {
                                testCollision = true;
                                break;
                            }
                        }
                    }
                    if(!testCollision) Y += 10;
                }
            }
            if(e.getKeyCode()== KeyEvent.VK_D){
                right = true;
                left = false;
                down = false;
                up = true;
                boolean testCollision = false;
                if(X <= 540){
                    for(int i = 0; i < BrickList.size(); ++i){
                        Brick b = BrickList.get(i);
                        if(testCollision) break;
                        for(int j = 0; j < b.brickOn.length; ++j){
                            if(new Rectangle(X + 10, Y, 10, 10).intersects(new Rectangle(b.brickXpos[j], b.brickYpos[j], b.brickWidth, b.brickHeight))) {
                                testCollision = true;
                                break;
                            }
                        }
                    }
                    if(!testCollision) X += 10;
                }
            }
        }
    }
}
