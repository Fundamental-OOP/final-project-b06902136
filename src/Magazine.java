import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Magazine extends Buff{
    public ImageIcon MagazineImage;
    public Magazine(int x, int y) {
        MagazineImage = new ImageIcon("magazine.png");
        super.buffXpos = x;
        super.buffYpos = y;
        buffOn =true;
    }
    public void draw(Component component, Graphics graphics){

        if(super.buffOn)
            MagazineImage.paintIcon(component, graphics, super.buffXpos, super.buffYpos);

    }

    public boolean acquireCheck(Player p){
        if(new Rectangle(super.buffXpos, super.buffYpos, 50, 50)
                .intersects(new Rectangle(p.X, p.Y, 50, 50))) {
            p.getWeaponList().get(1).count+=10;
            p.getWeaponList().get(2).count+=10;
            buffOn = false;
            return true;
        }
        return false;
    }
}
