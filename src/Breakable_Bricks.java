import javax.swing.*;
import java.awt.*;

public class Breakable_Bricks extends Brick{
    public Breakable_Bricks(){
        super();
        brickImage = new ImageIcon("break_brick.jpg");
        int x[] = {50,350,450,550,50,300,350,450,550,150,150,450,550,
                   250,50,100,150,550,250,350,450,550,50,250,350,550,
                   50,150,250,300,350,550,50,150,250,350,450,550,50,
                   250,350,550};
        brickXpos = x;
        int y[] = {50,50,50,50,100,100,100,100,100,150,200,200,200,250,
                   300,300,300,300,350,350,350,350,400,400,400,400,450,
                   450,450,450,450,450,500,500,500,500,500,500,550,550,
                   550,550};
        count = new int[21];
        brickOn = new boolean[21];
        for(int i = 0; i < count.length; ++i)
            count[i] = 2;
        for(int i = 0; i < brickOn.length; ++i)
            brickOn[i] = true;
    }
    @Override
    public boolean collisionCheck(int n, int x, int y, int width, int height){
        boolean collided = false;
        for(int i=0; i< brickOn.length; ++i) {
            if(brickOn[i]){
                if(new Rectangle(x, y, width, height).intersects(new Rectangle(brickXpos[i], brickYpos[i], brickWidth, brickHeight))) {
                    count[i] -= n;
                    if(count[i] <= 0) brickOn[i] = false;
                    if(count[i] == 1) brickImage = new ImageIcon("break_brick_cracked.jpg");

                    collided = true;
                    break;
                }
            }
        }
        return collided;
    }
}
