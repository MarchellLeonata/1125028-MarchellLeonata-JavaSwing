
import controller.UserController;
import javax.swing.*;
import model.UserModel;
import view.LoginRegisterView;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            UserModel model = new UserModel();
            LoginRegisterView view = new LoginRegisterView();

            new UserController(model, view);

            view.setVisible(true);
        });
    }
}
