import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Missile extends Weapon{
    private int x, y;
    public ArrayList<Brick> BrickList;
    public ImageIcon missileImage;
    public boolean isUsing;
    public Missile(ArrayList<Brick> bList) {
        super();
        super.count = 3;
        BrickList = bList;
        missileImage = new ImageIcon("../resource/missile.png");
        this.isUsing = true;
    }
    @Override
    public boolean perform(Player user, Player enemy) {
        if(new Rectangle(getX(), getY(), 24, 50)
                .intersects(new Rectangle(enemy.X, enemy.Y, 50, 50)))
        {
            user.score += 10;
            enemy.lives -= 1;
            user.Shoot = false;
            user.shootDirection = "";
            return true;
        }
        for(Brick br:BrickList)
            if(br.collisionCheck(2, getX(), getY(), 24, 50))
            {
                user.Shoot = false;
                user.shootDirection = "";
                return true;
            }
        if(getY() < 1
                || getY() > 580
                || getX() < 1
                || getX() > 630)
        {
            user.Shoot = false;
            user.shootDirection = "";
            return true;
        }
        return false;
    }
    @Override
    public void draw(Component c, Graphics g) {
        if(this.isUsing){
            missileImage.paintIcon(c, g, x, y);
        }
    }
    @Override
    public int getX() {
        return x;
    }
    @Override
    public int getY() {
        return y;
    }
    @Override
    public void move(String face)
    {
        if (face.equals("right")) {
            x += 5;
        }
        else if (face.equals("left")) {
            x -= 5;
        }
        else if (face.equals("up")) {
            y -= 5;
        }
        else {
            y += 5;
        }
    }
    @Override
    public Weapon create() {
        return new Missile(BrickList);
    }
    @Override
    public Weapon releaseNewOne(){
        if (super.count > 0) {
            super.count -= 1;
            return  this.create();
        }
        else {
            return null;
        }
    }
}
