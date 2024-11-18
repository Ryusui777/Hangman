package view.entities;
import view.View;
import view.entities.gResources.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Color;

public class Gallows {
    private JPanel panel;
    private JLabel label;
    private Graphics g;
    private Window window;

    public Gallows(int width, int height, int posX, int posY, Graphics g, View view) {


        panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(new FlowLayout());
        panel.setBounds(posX, posY, width, height);


        // Setting up Graphics
        this.g = g;

        label = new JLabel();
        label.setIcon(g.gallows);
        panel.add(label);
        label.setVisible(true);
        panel.setVisible(true);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setLabel(int scene) {
        switch (scene){
            case 0:
                label.setIcon(g.gallows);
                break;
            case 1:
                label.setIcon(g.head);
                break;
            case 2:
                label.setIcon(g.body);
                break;
            case 3:
                label.setIcon(g.legs);
                break;
            default:
                label.setIcon(g.arms);
        }

    }

    public JLabel getLabel() {
        return label;
    }
}
