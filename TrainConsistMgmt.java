import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistMgmt {
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }
    static class PassengerBogie {
        private String type;
        private int capacity;

        public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
            System.out.println("Created Bogie: " + type + " " + capacity);
        }
    }
    public static void main(String[] args) {
        System.out.println("================================");
        System.out.println("UC14: Handle Invalid Bogie Capacity (Custom Exception)");
        System.out.println("================================\n");

        try {
            PassengerBogie bogie1 = new PassengerBogie("Sleeper", 72);
            PassengerBogie bogie2 = new PassengerBogie("General", 0);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("UC14 exception handling completed...");
    }
}