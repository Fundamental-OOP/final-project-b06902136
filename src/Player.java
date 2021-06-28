import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Player {
    private ArrayList<Weapon> WeaponList;
    private ImageIcon player;
    private
    private int X;
    private int Y;
    private boolean right;
    private boolean left;
    private boolean down;
    private boolean up;
    private int score = 0;
    private int lives = 5;
    private boolean Shoot;
    private String shootDirection = "";
    private String right_img;
    private String left_img;
    private String up_img;
    private String down_img;
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
        Bullet bullet = new Bullet();
        Missile missile = new Missile();
        Bomb bomb = new Bomb(); //我不確定constructer長怎樣所以先寫這樣
        WeaponList.add(bullet);
        WeaponList.add(missile);
        WeaponList.add(bomb);
    }



    private class Listener implements KeyListener{
        public void keyTyped(KeyEvent e) {}
        public void keyReleased(KeyEvent e) {}
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_SPACE && (player1lives == 0 || player2lives == 0))
            {
                br = new brick();
                X = 200;
                Y = 550;
                right = false;
                left = false;
                player1down = false;
                player1up = true;

                player2X = 400;
                player2Y = 550;
                player2right = false;
                player2left = false;
                player2down = false;
                player2up = true;

                player1score = 0;
                player1lives = 5;
                player2score = 0;
                player2lives = 5;
                play = true;
                repaint();
            }
            if(e.getKeyCode()== KeyEvent.VK_U)
            {
                if(!player1Shoot)
                {
                    if(player1up)
                    {
                        player1Bullet = new Player1Bullet(player1X + 20, player1Y);
                    }
                    else if(player1down){
                        player1Bullet = new Player1Bullet(player1X + 20, player1Y + 40);
                    }
                    else if(player1right){
                        player1Bullet = new Player1Bullet(player1X + 40, player1Y + 20);
                    }
                    else if(player1left)
                    {
                        player1Bullet = new Player1Bullet(player1X, player1Y + 20);
                    }

                    player1Shoot = true;
                }
            }
            if(e.getKeyCode()== KeyEvent.VK_W)
            {
                player1right = false;
                player1left = false;
                player1down = false;
                player1up = true;

                if(!(player1Y < 10)){
                    player1Y-=10;
                }


            }
            if(e.getKeyCode()== KeyEvent.VK_A)
            {
                player1right = false;
                player1left = true;
                player1down = false;
                player1up = false;

                if(!(player1X < 10)){
                    player1X-=10;
                }

            }
            if(e.getKeyCode()== KeyEvent.VK_S)
            {
                player1right = false;
                player1left = false;
                player1down = true;
                player1up = false;

                if(!(player1Y > 540)){
                    boolean check = false;
                    for(int i = 0; i < br.bricksYPos.length ; ++i){
                        if(player1Y + 10>= br.bricksYPos[i] && player1X == br.bricksXPos[i])
                            check = true;
                    }
                    if(!check) player1Y+=10;
                }

            }
            if(e.getKeyCode()== KeyEvent.VK_D)
            {
                player1right = true;
                player1left = false;
                player1down = false;
                player1up = false;

                if(!(player1X > 590)){
                    player1X+=10;
                }

            }
        }
    }
    }
}
