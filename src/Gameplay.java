import java.util.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.*;

import javax.swing.*;
import javax.swing.Timer;
public class Gameplay extends JPanel implements ActionListener {
    private Brick solid_brick;
    private Brick brakable_brick;
    public Gameplay(){
        solid_brick = new Solid_Bricks();
        brakable_brick = new Breakable_Bricks();
    }
    public void paint(){

    }
    @Override
    public void actionPerformed(ActionEvent e){
        repaint();
    }
}
