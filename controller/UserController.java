
package controller;

import model.UserModel;
import view.LoginRegisterView;

public class UserController {

    private UserModel model;
    private LoginRegisterView view;

    public UserController(UserModel model, LoginRegisterView view) {
        this.model = model;
        this.view = view;

        // Tombol Login
        view.getLoginButton().addActionListener(e -> login());

        // Pindah ke Register
        view.getGoRegisterButton().addActionListener(e -> {
            view.showPage("REGISTER");
        });

        // Tombol Register
        view.getRegisterButton().addActionListener(e -> register());

        // Kembali ke Login
        view.getBackLoginButton().addActionListener(e -> {
            view.showPage("LOGIN");
        });

        // Tombol Logout
        view.getLogoutButton().addActionListener(e -> {
            view.clearLoginFields();
            view.showPage("LOGIN");
        });
    }

    private void register() {
        String username = view.getRegisterUsername();
        String password = view.getRegisterPassword();

        if (model.register(username, password)) {
            view.showMessage("Register berhasil!");
            view.clearRegisterFields();
            view.showPage("LOGIN");
        } else {
            view.showMessage(
                "Register gagal! Username kosong, sudah digunakan, "
                + "atau kapasitas user penuh."
            );
        }
    }

    private void login() {
        String username = view.getLoginUsername();
        String password = view.getLoginPassword();

        if (model.login(username, password)) {
            view.setHello(username);
            view.showPage("HELLO");
        } else {
            view.showMessage("Username atau password salah!");
        }
    }
}
