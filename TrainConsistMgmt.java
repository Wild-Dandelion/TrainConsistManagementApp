import java.util.LinkedHashSet;

public class TrainConsistMgmt {
    public static void main(String[] args) {

        System.out.println("================================ \nUC5 Preserve Insertion Order of Bogies \n================================\n \n");
        LinkedHashSet<String> train = new LinkedHashSet<>();

        train.add("Engine");
        train.add("Sleeper");
        train.add("Cargo");
        train.add("Guard");

        train.add("Sleeper");

        System.out.println("Final Train Formation:");
        System.out.println(train);

        System.out.println("Note:");
        System.out.println("LinkedHashSet preserves insertion order and removes duplicates automatically.");

        System.out.println("UC5 formation setup completed...");
    }
}