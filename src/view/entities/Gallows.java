package view.entities;
import view.entities.gResources.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Color;

public class Gallows {
    private final JPanel panel;
    private final JLabel label;
    private final Graphics g;

    public Gallows(int width, int height, int posX, int posY, Graphics g) {

        panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(new FlowLayout());
        panel.setBounds(posX, posY, width, height);

        // Setting up Graphics
        this.g = g;

        label = new JLabel();
        panel.add(label);
        label.setIcon(g.gallows);
        label.setVisible(true);
        panel.setVisible(true);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void reset(){
        label.setIcon(g.gallows);
    }

    public void setLabel(int scene) {
        switch (scene){
            case 1:
                label.setIcon(g.head);
                break;
            case 2:
                label.setIcon(g.body);
                break;
            case 3:
                label.setIcon(g.arms);
                break;
            case 4:
                label.setIcon(g.legs);
                break;
            case 5:
                label.setIcon(g.death);
                break;
            case 6:
                label.setIcon(g.happy);
                break;
            default:
                label.setIcon(g.gallows);
        }

    }

}
