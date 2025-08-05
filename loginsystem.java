import java.io.*;
import java.util.*;

public class LoginSystem {

    static final String FILE_NAME = "users.txt";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Login Authentication System");

        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    register(sc);
                    break;
                case 2:
                    login(sc);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    static void register(Scanner sc) throws IOException {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true));
        writer.write(username + "," + password);
        writer.newLine();
        writer.close();

        System.out.println("User registered successfully!");
    }

    static void login(Scanner sc) throws IOException {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
        String line;
        boolean success = false;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 2) {
                if (parts[0].equals(username) && parts[1].equals(password)) {
                    success = true;
                    break;
                }
            }
        }
        reader.close();

        if (success) {
            System.out.println("Login successful! Accessing secured page...");
            securedPage(username);
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    static void securedPage(String username) {
        System.out.println("Welcome to the secured page, " + username + "!");
       
    }
}
