package view.entities;

import view.View;
import view.entities.gResources.Graphics;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.FlowLayout;

/**@code ResetButton is a class meant to show to the user a reset button which they can
 * press to reset the game.
 * */

public class ResetButton extends JButton {

    public ResetButton(int width, int height, int posX, int posY, Graphics g, View view) {
        setBorder(null);
        setIcon(g.reset); //Sets the icon to the image of the reset button
        setBackground(Color.BLACK);
        setLayout(new FlowLayout());
        setBounds(posX, posY, width, height); // Sets the dimensions and position
        addActionListener(e -> view.resetPressed()); // Sets an actionListener to communicate when the button gets pressed
    }

}
