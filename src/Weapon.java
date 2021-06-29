import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public abstract class Weapon {
//    public abstract void perform(int n, Player player,Breakable_Bricks bricks);
    public abstract boolean perform(int n,Player user,Player enemy,Breakable_Bricks bricks);
    public abstract void draw(Component c,Graphics g);
    public abstract int getX();
    public abstract int getY();
    public abstract void move(String face);
    public abstract Weapon create();
}
