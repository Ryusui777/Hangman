package controller.entities;

import javax.swing.JOptionPane;

public class ErrorHandler {

    public static void error(Errors error, String arg){
        JOptionPane.showMessageDialog(null, error+" "+arg,"Error", JOptionPane.ERROR_MESSAGE);
    }
}
