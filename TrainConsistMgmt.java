import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    void display() {
        System.out.println(name + " -> " + capacity);
    }
}

public class TrainConsistMgmt {

    public static List<Bogie> filterBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println("UC8 Filter Passenger Bogies Using Streams");
        System.out.println("================================\n");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("All Bogies:");
        bogies.forEach(b -> b.display());

        List<Bogie> filteredBogies = filterBogies(bogies, 70);

        System.out.println("\nFiltered Bogies (Capacity > 70):");
        filteredBogies.forEach(b -> b.display());

        System.out.println("\nUC8 filtering completed...");
    }
}
