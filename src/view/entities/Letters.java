package view.entities;

import view.entities.gResources.Graphics;

import javax.swing.*;
import java.awt.*;

public class Letters {
    private Graphics g;
    private JPanel panel;
    private Letter[] lettersLabels;

    public Letters(int width, int height, int posX, int posY, Graphics g) {

        panel = new JPanel();
        panel.setBounds(posX, posY, width, height);
        panel.setLayout(new GridLayout(3, 9));
        panel.setBackground(Color.BLACK);

        this.g = g;
        this.lettersLabels = new Letter[g.alphabet.length];
        showAlphabet();
    }

    private void showAlphabet(){
        int labelWidth = (int)(panel.getWidth()/9);
        int labelHeight = (int)(panel.getHeight()/3);
        for(int i = 0; i < lettersLabels.length; i++){
            lettersLabels[i] = new Letter(labelWidth,labelHeight, g.alphabet[i]);
            panel.add(lettersLabels[i]);
        }
    }



    private class Letter extends JButton {
        private static Color defaultColor = Color.BLACK;
        private static Color good = new Color(0,100,0);
        private static Color bad = new Color(100,0,0);


        public Letter(int width, int height, ImageIcon icon){
            setLayout(new FlowLayout());
            setFocusable(false);
            setIcon(icon);
            setBackground(defaultColor);
        }

        public void setBad(){
            setBackground(bad);
        }

        public void setGood(){
            setBackground(good);
        }

    }

    public JPanel getPanel() {
        return panel;
    }
}
