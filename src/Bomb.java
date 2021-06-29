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

    private int countDown;
    private int x;
    private int y;
    //private int times;
    Breakable_Bricks bricks;

    private ImageIcon bombImage;
    private ArrayList<Brick>bricksList;
    public Bomb(Player myUser, ArrayList<Brick> bricksList){
        super(myUser);
        super.count = 3;
        this.bombImage = new ImageIcon("bomb.png");
        this.bricksList = bricksList;
        countDown = 2000;
    }

    @Override
    public boolean perform(Player enemy){
        this.update();
        if(this.countDown <= 0){
            if(collisionCheck(enemy.X, enemy.Y)){
                user.score += 10;
                enemy.lives -= 1;
                return true;
            }
            this.explode();
            return true;
        }
        else{
            return false;
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
        bombImage.paintIcon(c, g, this.x, this.y);
    }

    @Override
    public Weapon create(Player user){
        Bomb newBomb = new Bomb(user, bricksList);
        newBomb.setX(user.X);
        newBomb.setY(user.Y);
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
    private boolean collisionCheck(int Xpos,int Ypos){
        if(getX() + 50 >= Xpos && Xpos <= getX() - 50 && getY() + 50 >= Ypos && Ypos <= getY() - 50){
            return true;
        }
        return false;
    }
    private void explode(){
        for(Brick br : bricksList){
            for(int i = 0;i<br.count.length;i++){
                if(collisionCheck(br.brickXpos[i], br.brickYpos[i])){
                    br.count[i] -= 1;
                    if(br.count[i] <= 0) br.brickOn[i] = false;
                    if(br.count[i] == 1) br.brickImage = new ImageIcon("break_brick_cracked.jpg");
                }
            }
        }

    }
}

