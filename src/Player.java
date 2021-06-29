import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Player {
    private ArrayList<Weapon> WeaponList;
    private Weapon usingWeapon;
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
    public Listener myListener;
    private int command1; //up
    private int command2; //down
    private int command3; //left
    private int command4; //right
    private int command5; //bullet
    private int command6; //bomb
    private int command7; //missile

    public Player(int x, int y, boolean r, boolean l, boolean d, boolean u, String RightIMG, String LeftIMG, String UpIMG, String DownIMG,
                  int c1, int c2, int c3, int c4, int c5, int c6, int c7, ArrayList<Weapon> wList){
        myListener = new Listener();
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
        for(int i = 0; i < wList.size(); ++i){
            Weapon w = wList.get(i);
            WeaponList.add(w.create());
        }
        command1 = c1;
        command2 = c2;
        command3 = c3;
        command4 = c4;
        command5 = c5;
        command6 = c6;
        command7 = c7;
        
    }
    public ImageIcon getPlayerIMG(){
        return playerIMG;
    }
    public Weapon getUsingWeapon(){return usingWeapon;}
    public void draw(Component component, Graphics graphics){
        playerIMG.paintIcon(component, graphics, X, Y);
    }
    public ArrayList<Weapon> getWeaponList(){
        return WeaponList;
    }
    public void setUsingWeapon(Weapon w){
        usingWeapon = w;
    }
    private class Listener implements KeyListener{
        public void keyTyped(KeyEvent e) {}
        public void keyReleased(KeyEvent e) {}
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()== command1){
                playerIMG = new ImageIcon(up_img);
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
            if(e.getKeyCode()== command3){
                playerIMG = new ImageIcon(left_img);
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
            if(e.getKeyCode()== command2){
                playerIMG = new ImageIcon(down_img);
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
            if(e.getKeyCode() == command4){
                playerIMG = new ImageIcon(right_img);
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
            if(e.getKeyCode() == command5){
            }
        }
    }
}
