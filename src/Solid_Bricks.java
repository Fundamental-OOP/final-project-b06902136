import javax.swing.*;
import java.awt.*;

public class Solid_Bricks extends Brick{
    public Solid_Bricks(){
        brickImage = new ImageIcon("solid_brick.jpg");
        int x[] = {150,350,150,500,450,300,600,400,350,200,0,200,500};
        brickXpos = x;
        int y[] = {0,0,50,100,150,200,200,250,300,350,400,400,450};
        for(int i = 0; i < brickOn.length; ++i)
            brickOn[i] = true;
        count = new int[13];
        brickOn = new boolean[13];
        for(int i = 0; i < count.length; ++i)
            count[i] = 2;
        for(int i = 0; i < brickOn.length; ++i)
            brickOn[i] = true;
    }
    @Override
    public boolean collisionCheck(int n, int x, int y, int width, int height) {
        boolean collided = false;
        for(int i=0; i< brickXpos.length; ++i){
            if(new Rectangle(x, y, width, height).intersects(new Rectangle(brickXpos[i], brickYpos[i], brickWidth, brickHeight))){
                collided = true;
                break;
            }
        }
        return collided;
    }
}
