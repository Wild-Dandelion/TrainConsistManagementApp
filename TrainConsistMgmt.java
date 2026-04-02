import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TrainConsistMgmt {
    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println("UC11 Validate Train ID and Cargo Code ");
        System.out.println("================================\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Train ID (Format: TRN-): ");
        String trainID = scanner.nextLine();
        System.out.println("");

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();
        System.out.println("");

        Pattern pattern = Pattern.compile("TRN-\\d{4}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(trainID);
        boolean matchFound = matcher.find();
        System.out.print("Train Code Valid: ");
        if(matchFound) {
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }

        Pattern cargoCodePattern = Pattern.compile("PET-[A-Z]{2}", Pattern.CASE_INSENSITIVE);
        Matcher cargoCodeMatcher = cargoCodePattern.matcher(cargoCode);
        boolean matchFoundCargoCode = cargoCodeMatcher.find();
        System.out.print("Cargo Code Valid: ");
        if(matchFoundCargoCode) {
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
        System.out.println("\nUC11 validation completed...");
    }
}