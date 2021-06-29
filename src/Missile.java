import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Missile extends Weapon{
    private int x, y;
    public ArrayList<Brick> brickList;
    public ImageIcon missileImage;
    public Missile(Player myUser, ArrayList<Brick> bList) {
        super(myUser);
        super.count = 3;
        brickList = bList;
        missileImage = new ImageIcon("missile.png");
    }
    @Override
    public boolean perform(Player enemy) {
        if(user.left || user.right){
            if(new Rectangle(getX(), getY(), 50, 24)
                    .intersects(new Rectangle(enemy.X, enemy.Y, 50, 50))) {
                user.score += 10;
                enemy.lives -= 1;
                user.Shoot = false;
                user.shootDirection = "";
                return true;
            }
        }
        else if(user.up || user.down){
            if(new Rectangle(getX(), getY(), 24, 50)
                    .intersects(new Rectangle(enemy.X, enemy.Y, 50, 50))) {
                user.score += 10;
                enemy.lives -= 1;
                user.Shoot = false;
                user.shootDirection = "";
                return true;
            }
        }
        for(int i = 0; i < brickList.size(); ++i){
            Brick br = brickList.get(i);
            if(user.up || user.down){
                if(br.collisionCheck(2, getX(), getY(), 24, 50)) {
                    if(i == 0){
                        user.Shoot = false;
                        user.shootDirection = "";
                        return true;
                    }
                    else return false;
                }
            }
            else if(user.right || user.left){
                if(br.collisionCheck(2, getX(), getY(), 50, 24)) {
                    if(i == 0){
                        user.Shoot = false;
                        user.shootDirection = "";
                        return true;
                    }
                    else return false;
                }
            }
        }
        if(getY() < 1 || getY() > 580 || getX() < 1 || getX() > 600){
            user.Shoot = false;
            user.shootDirection = "";
            return true;
        }
        return false;
    }
    @Override
    public void draw(Component c, Graphics g) {
        if(user.up) missileImage = new ImageIcon("missile_up.png");
        else if(user.down) missileImage = new ImageIcon("missile_down.png");
        else if(user.left) missileImage = new ImageIcon("missile_left.png");
        else  missileImage = new ImageIcon("missile_right.png");
        missileImage.paintIcon(c, g, x, y);
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
            x += 2;
        }
        else if (face.equals("left")) {
            x -= 2;
        }
        else if (face.equals("up")) {
            y -= 2;
        }
        else {
            y += 2;
        }
    }
    public void setX(int X){
        x = X;
    }
    public void setY(int Y){
        y = Y;
    }
    @Override
    public Weapon create(Player user) {
        Missile newMissile = new Missile(user, brickList);
        newMissile.setX(user.X);
        newMissile.setY(user.Y);
        if(user.up || user.down) newMissile.setX(user.X + 14);
        if(user.down) newMissile.setY(user.Y + 50);
        if(user.left || user.right) newMissile.setY(user.Y + 14);
        if(user.right) newMissile.setX(user.X + 50);
        return newMissile;
    }
    @Override
    public Weapon releaseNewOne(){
        if (super.count > 0) {
            --super.count;
            return  this.create(user);
        }
        else {
            return null;
        }
    }
}
