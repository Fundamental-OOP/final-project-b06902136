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
    public boolean isUsing;
    Bomb(ArrayList<Brick>bricksList){
        this.bombImage = new ImageIcon("mine.png");
        this.bricksList = bricksList;
        this.isUsing = true;
    }

    @Override
    public boolean perform(Player user,Player enemy){
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

    @Override
    public void draw(Component c,Graphics g){
        if(this.isUsing){
            bombImage.paintIcon(c,g,this.x,this.y);
            update();
        }
    }

    @Override
    public Weapon create(){
        return new Bomb(bricksList);
    }

    @Override
    public int getX(){
        return this.x;
    }

    @Override
    public int getY(){
        return this.y;
    }

    @Override
    public void move(String face){
        return;
    }

    @Override
    public Weapon releaseNewOne(){
        if(super.count > 0){
            super.count -= 1;
            return this.create();
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
        for(int i = 0;i<bricks.count.length;i++){
            if(collisionCheck(bricks.brickXpos[i],bricks.brickYpos[i])){
                bricks.count[i] -= 1;
                if(bricks.count[i] <= 0) bricks.brickOn[i] = false;
                if(bricks.count[i] == 1) bricks.brickImage = new ImageIcon("break_brick_cracked.jpg");
            }
        }
    }
}

