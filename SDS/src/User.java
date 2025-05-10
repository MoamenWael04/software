/**
 * Represents a base user in the InvestEase system.
 * Provides basic user properties and authentication methods.
 */
public class User {
    /** The unique identifier for this user */
    public String UserID;

    /** The display name for this user */
    public String Username;

    /** The email address for this user */
    public String email;

    /** The password for this user's account */
    public String password;

    /**
     * Constructs a User with full details.
     *
     * @param userID   The user ID for this user
     * @param userName The name of this user
     * @param email    The email of this user
     * @param password The password for this user
     */
    public User(String userID, String userName, String email, String password) {
        this.UserID = userID;
        this.Username = userName;
        this.email = email;
        this.password = password;
    }

    /**
     * Constructs a User with minimal details for login.
     *
     * @param userID   The user ID for this user
     * @param password The password for this user
     */
    public User(String userID, String password) {
        this.UserID = userID;
        this.password = password;
    }

    /**
     * Attempts to log in with the provided credentials.
     *
     * @param UID  The user ID to check
     * @param pass The password to check
     * @return true if login was successful, false otherwise
     */
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

    /**
     * Attempts to sign up a new user with the provided details.
     *
     * @param UID   The user ID for the new user
     * @param pass  The password for the new user
     * @param Uname The name for the new user
     * @param Email The email for the new user
     * @return A new User object if signup was successful, null otherwise
     */
    public User signup(String UID, String pass, String Uname, String Email) {
        return Authentcation.createUser(UID, pass, Uname, Email);
    }
}