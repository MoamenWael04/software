import java.util.ArrayList;
import java.util.Scanner;


public class financialGoals
{
    private ArrayList<Goal> goals = new ArrayList<>();
    public financialGoals()
    {
        goals.add(new Goal().setGoal("Retirement", 1000000, "2035-12-31", 200000));
        goals.add(new Goal().setGoal("Wealth Accumulation", 500000, "2028-06-30", 150000));
        goals.add(new Goal().setGoal("Retirement", 750000, "2040-01-01", 50000));
        goals.add(new Goal().setGoal("Wealth Accumulation", 300000, "2026-10-15", 120000));
    }

    public boolean addGoal(Goal goal)
    {
        if (goal.verifyGoal())
        {
            goals.add(goal);
            System.out.println("Goal added successfully.");
            return true;
        }
        return false;
    }

    public void listGoals()
    {
        if (goals.isEmpty())
        {
            System.out.println("No goals found.");
        }
        else
        {
            System.out.println();
            System.out.println("Your Financial Goals:");
            System.out.println("=====================");
            for (Goal goal : goals)
            {
                goal.printGoal();
            }
        }
    }

    public void goalsMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nFinancial Goals Dashboard:");
            System.out.println("1. Add New Goal");
            System.out.println("2. List Goals");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter Goal Type (Retirement / Wealth Accumulation):");
                    String type = scanner.nextLine();

                    System.out.println("Enter Target Amount:");
                    double amount = scanner.nextDouble();

                    System.out.println("Enter Deadline (e.g. 2025-12-31):");
                    scanner.nextLine(); // consume newline
                    String deadline = scanner.nextLine();

                    System.out.println("Enter Current Progress:");
                    double progress = scanner.nextDouble();

                    Goal goal = new Goal().setGoal(type, amount, deadline, progress);
                    addGoal(goal);
                    break;

                case 2:
                    listGoals();
                    break;

                case 3:
                    System.out.println("Returning to main menu...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3);
    }
}
