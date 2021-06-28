import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public abstract class Weapon {
    public abstract void perform(int n,Player player,Breakable_Bricks bricks);
    public abstract void draw(Graphics g);
    public abstract int getX();
    public abstract int getY();
    public abstract void move(String face);
    public abstract Weapon create();
}
