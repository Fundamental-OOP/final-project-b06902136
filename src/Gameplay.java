import java.util.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.*;

import javax.swing.*;
import javax.swing.Timer;
public class Gameplay extends JPanel implements ActionListener {
    private Brick solid_brick;
    private Brick breakable_brick;
    public Gameplay(){
        solid_brick = new Solid_Bricks();
        breakable_brick = new Breakable_Bricks();
    }
    public void paint(){

    }
    @Override
    public void actionPerformed(ActionEvent e){
        repaint();
    }
    public void setBrick(){
        solid_brick = new Solid_Bricks();
        breakable_brick = new Breakable_Bricks();
    }
}
