public class Investor extends User {
    Investor(String userID, String userName, String email, String password)
    {
        super(userID, userName, email, password);
    }
    public void viewDashboard() {
        System.out.println( "Hello " + this.Username);
        System.out.println("Welcome to InvestEase!");
        System.out.println("select 1 to view your investment dashboard"); // until now for user story 3&4
    }
}