public class User {
    public String UserID;
    public String Username;
    public String email;
    public String password;


    public User(String userID, String userName, String email, String password) {
        this.UserID = userID;
        this.Username = userName;
        this.email = email;
        this.password = password;
    }
    public User(String userID, String password) {
        this.UserID = userID;
        this.password = password;
    }

    public boolean login(String UID, String pass) {
        if (Authentcation.checkpassword(UID,pass))
        {
            System.out.println("Login Successful");
            return true;
        }
        else
        {
            System.out.println("Login Failed");
            return false;
        }
    }

    public User signup(String UID, String pass, String Uname, String Email) {
        return Authentcation.createUser(UID, pass, Uname, Email);
    }
}
