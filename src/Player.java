import javax.swing.*;
import java.util.ArrayList;

public class Player {
    private ArrayList<Weapon> WeaponList;
    private ImageIcon player;
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

}
