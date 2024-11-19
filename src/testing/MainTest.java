package testing;
import controller.Controller;
import model.Model;
import view.View;

public class MainTest {

    public static void main(String [] args){

        Controller controller = new Controller();

        Model model = new Model(controller);
        View view = new View(controller);

        controller.setUp(model, view);

    }
}
