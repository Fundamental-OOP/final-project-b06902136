import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Health extends Buff{
    public ImageIcon HealthImage;
    public Health(int x, int y) {
        super();
        HealthImage = new ImageIcon("health.png");
        super.buffXpos = x;
        super.buffYpos = y;
        buffOn = true;
    }
    public void draw(Component component, Graphics graphics){
        if(super.buffOn)
            HealthImage.paintIcon(component, graphics, super.buffXpos, super.buffYpos);
    }
    @Override
    public boolean acquireCheck(Player p){
        if(new Rectangle(super.buffXpos, super.buffYpos, 50, 50)
                .intersects(new Rectangle(p.X, p.Y, 50, 50))) {
            p.lives += 1;
            buffOn = false;
            return true;
        }
        return false;
    }
}
