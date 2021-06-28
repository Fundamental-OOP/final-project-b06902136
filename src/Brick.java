import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Brick {
    public int brickXpos[];
    public int brickYpos[];
    public boolean brickOn[];
    public int brickWidth;
    public int brickHeight;
    public ImageIcon brickImage;
    public int count[];
    public Brick(){
        count = new int[21];
        brickOn = new boolean[21];
        for(int i = 0; i < count.length; ++i)
            count[i] = 2;
        for(int i = 0; i < brickOn.length; ++i)
            brickOn[i] = true;
        brickWidth = 50;
        brickHeight = 50;
    }
    public void draw(Component component, Graphics graphics){
        for(int i = 0; i < brickOn.length; ++i) {
            if(brickOn[i])
                brickImage.paintIcon(component, graphics, brickXpos[i], brickYpos[i]);
        }
    }
    public boolean collisionCheck(int n, int x, int y, int width, int height){
        boolean collided = false;
        for(int i=0; i< brickOn.length;i++) {
            if(brickOn[i]) {
                if(new Rectangle(x, y, width, height).intersects(new Rectangle(brickXpos[i], brickYpos[i], brickWidth, brickHeight))) {
                    brickOn[i] = false;
                    collided = true;
                    break;
                }
            }
        }
        return collided;
    }

}
