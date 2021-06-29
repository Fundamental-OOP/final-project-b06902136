import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Bomb extends Weapon{
    public Component component;
    public Graphics graphics;
    private int countDown;
    private int x;
    private int y;
    private int effectCountDown;
    //private int times;
    Breakable_Bricks bricks;
    private ImageIcon explosion_effect;

    private ImageIcon bombImage;
    private ArrayList<Brick>bricksList;
    public Bomb(Player myUser, ArrayList<Brick> bricksList){
        super(myUser);
        super.count = 10;
        this.bombImage = new ImageIcon("bomb.png");
        this.bricksList = bricksList;
        countDown = 800;
        effectCountDown = 100;
        explosion_effect = new ImageIcon("explosion_effect.png");
    }

    @Override
    public boolean perform(Player enemy){
        this.update();
        if(this.countDown == 0){
            this.update();
            if(collisionCheck(enemy.X, enemy.Y)){
                user.score += 10;
                --enemy.lives;
            }
            if(collisionCheck(user.X, user.Y)){
                enemy.score += 10;
                --user.lives;
            }
            this.explode();
            return false;
        }
        else{
            if(countDown < 0 && effectCountDown > 0){
                --effectCountDown;
                return false;
            }
            else if(effectCountDown == 0){
                user.Shoot = false;
                user.shootDirection = "";
                user.setUsingWeapon(null);
                return true;
            }
            else return false;
        }
    }
    public void setX(int X){
        x = X;
    }
    public void setY(int Y){
        y = Y;
    }
    @Override
    public void draw(Component c, Graphics g) {
        if(countDown > 0) bombImage.paintIcon(c, g, this.x, this.y);
        else{
            for(int i = 0; i < 3; ++i){
                for(int j = 0; j <3; ++j)
                    explosion_effect.paintIcon(c, g, x-50+50*i, y-50+50*j);
            }
        }
    }

    @Override
    public Weapon create(Player user){
        Bomb newBomb = new Bomb(user, bricksList);
        newBomb.setX(user.X + 10);
        newBomb.setY(user.Y + 10);
        return newBomb;
    }


    @Override
    public void move(String face){
        return;
    }

    @Override
    public Weapon releaseNewOne(){
        if(super.count > 0){
            --super.count;
            return this.create(user);
        }else{
            return null;
        }
    }

    private void update(){
        this.countDown -= 1;
        return;
    }
    private boolean collisionCheck(int Xpos, int Ypos){
        if(new Rectangle(x - 50, y - 50, 150, 150)
                .intersects(new Rectangle(Xpos, Ypos, 50, 50))){
            return true;
        }
        return false;
    }
    private void explode(){
        for(Brick br : bricksList)
            br.collisionCheck(1, x - 50 , y - 50, 150, 150);

    }
}

