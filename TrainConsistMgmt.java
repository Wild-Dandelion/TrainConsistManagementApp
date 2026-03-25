import java.util.LinkedList;

public class TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("UC4 Maintain Ordered Bogie Consist");

        LinkedList<String> train = new LinkedList<>();

        // Add bogies
        train.add("Engine");
        train.add("Sleeper");
        train.add("AC");
        train.add("Cargo");
        train.add("Guard");

        System.out.println("Initial Train Consist");
        System.out.println(train);

        train.add(2, "Pantry Car");
        System.out.println("After Inserting 'Pantry Car' at position 2:");
        System.out.println(train);

        train.removeFirst();
        train.removeLast();

        System.out.println("After Removing First and Last Bogie:");
        System.out.println(train);

        System.out.println("UC4 ordered consist operations completed...");
    }
}