import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Magazine extends Buff{
    public ImageIcon MagazineImage;
    public Magazine() {
        super();
        MagazineImage = new ImageIcon("magazine.png");
        int x[] = {0};
        int y[] = {0};
        buffXpos = x;
        buffYpos = y;
        count = new int[1];
        buffOn = new boolean[1];
        Arrays.fill(count, 2);
        Arrays.fill(buffOn, true);
    }
    public void draw(Component component, Graphics graphics){
        for(int i = 0; i < buffOn.length; ++i) {
            if(buffOn[i])
                MagazineImage.paintIcon(component, graphics, buffXpos[i], buffYpos[i]);
        }
    }

    public boolean acquireCheck(Player p){

        return false;
    }
}
