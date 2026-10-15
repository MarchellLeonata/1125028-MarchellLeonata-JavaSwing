package model;

public class UserModel {
    private User[] users = new User[100];
    private int jumlahUser = 0;

    public boolean register(String username, String password){
        if(username.isEmpty() || password.isEmpty()){
            return false;
        }

        for(int i = 0; i < jumlahUser; i++){
            if(users[i].getUsername().equals(username)){
                return false;
            }
        }

        if(jumlahUser >= users.length){
            return false;
        }

        users[jumlahUser] = new User(username, password);
        jumlahUser++;

        return true;

    }

    public boolean login (String username, String password){
        for(int i = 0; i < jumlahUser; i++){
            if(users[i].getUsername().equals(username) && users[i].getPassword().equals(password)){
                return true;
            }
        }

        return false;
    }
}
