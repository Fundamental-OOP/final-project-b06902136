import javax.swing.*;
import java.awt.*;

public class  extends Buff{
    public ImageIcon N2OImage;
    public N2O() {
        super();
        N2OImage = new ImageIcon("N2O.png");
    }
    public void draw(Component component, Graphics graphics){

    }
    @Override
    public boolean acquireCheck(int x, int y, int width, int height){
        return true;
    }
}
