import javax.swing.*;
import java.awt.*;

public class Health extends Buff{
    public ImageIcon HealthImage;
    public Health() {
        super();
        HealthImage = new ImageIcon("health.png");
    }
    public void draw(Component component, Graphics graphics){

    }
    @Override
    public boolean acquireCheck(int x, int y, int width, int height){
        return true;
    }
}
