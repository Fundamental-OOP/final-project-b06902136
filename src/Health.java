import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Health extends Buff{
    public ImageIcon HealthImage;
    public Health() {
        super();
        HealthImage = new ImageIcon("health.png");
        int x[] = {0};
        buffXpos = x;
        int y[] = {0};
        buffYpos = y;
        count = new int[1];
        buffOn = new boolean[1];
        Arrays.fill(count, 2);
        Arrays.fill(buffOn, true);
    }
    public void draw(Component component, Graphics graphics){
        for(int i = 0; i < buffOn.length; ++i) {
            if(buffOn[i])
                HealthImage.paintIcon(component, graphics, buffXpos[i], buffYpos[i]);
        }
    }
    @Override
    public boolean acquireCheck(Player p){
        return true;
    }
}
