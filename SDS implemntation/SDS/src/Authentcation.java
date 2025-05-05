import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class Authentcation {

    public static boolean checkpassword(String UID, String pass) {
        String filePath = "credentials.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] credentials = line.split(",");
                if (credentials.length == 2) {
                    String storedUID = credentials[0];
                    String storedPass = credentials[1];

                    if (storedUID.equals(UID) && storedPass.equals(pass)) {
                        return true;  // Credentials match
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading credentials file: " + e.getMessage());
            return false;
        }

        return false;  // No matching credentials found
    }




    public static boolean verifycredentials(String userID, String password, String userName, String email) {

        return userID != null && password != null && userName != null && email != null; // can be modified later ya mariam
    }
    public static User createUser(String userID, String password, String userName, String email) {
        if (verifycredentials(userID, password, userName, email)) {
            // First check if user already exists
            if (checkpassword(userID, password)) {
                System.out.println("User ID already exists!");
                return null;
            }

            // Try to add credentials to file
            if (addCredentialsToFile(userID, password)) {
                return new User(userID, userName, email, password);
            } else {
                System.out.println("Failed to save credentials");
                return null;
            }
        } else {
            System.out.println("Invalid credentials");
            return null;
        }
    }







    private static boolean addCredentialsToFile(String userID, String password) {
        String filePath = "credentials.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) { // true for append mode , Add a new line if file is not empty
            writer.newLine();
            // Write the credentials in the format: userID,password
            writer.write(userID + "," + password);
            return true;
        } catch (IOException e) {
            System.out.println("Error writing to credentials file: " + e.getMessage());
            return false;
        }
    }

}
