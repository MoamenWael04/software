import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class Goal
{
    private String goalType;
    private double targetAmount;
    private String deadline;
    private double currentProgress;

    public Goal setGoal(String goalType, double targetAmount, String deadline, double currentProgress)
    {
        this.goalType = goalType;
        this.targetAmount = targetAmount;
        this.deadline = deadline;
        this.currentProgress = currentProgress;
        return this;
    }

    public boolean verifyGoal()
    {
        boolean isValid = true;
        if (!(goalType.equalsIgnoreCase("retirement") || goalType.equalsIgnoreCase("wealth accumulation")))
        {
            System.out.println("Invalid goal type. Must be 'Retirement' or 'Wealth Accumulation'.");
            isValid = false;
        }
        if (targetAmount <= 0)
        {
            System.out.println("Target amount must be greater than 0.");
            isValid = false;
        }
        if (currentProgress < 0)
        {
            System.out.println("Current progress must be >= 0.");
            isValid = false;
        }
        // Deadline validation: must be valid date format YYYY-MM-DD
        try {
            LocalDate.parse(deadline, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid deadline format. Use YYYY-MM-DD.");
            isValid = false;
        }

        return isValid;
    }

    public void printGoal()
    {
        System.out.println("Goal Type: " + goalType);
        System.out.println("Target Amount: " + targetAmount);
        System.out.println("Deadline: " + deadline);
        System.out.println("Current Progress: " + currentProgress);
        System.out.println("------------------------------------");
    }
}

