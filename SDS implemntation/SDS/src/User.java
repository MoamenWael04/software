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


    public void login(String UID , String pass)
    {
        if (Authentcation.checkpassword(UID,pass))
        {
            System.out.println("Login Successful");
        }
        else
        {
            System.out.println("Login Failed");
        }
    }

    public static User signup(String UID, String pass, String Uname, String Email) {
        return Authentcation.createUser(UID, pass, Uname, Email);
    }
}
