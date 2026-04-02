import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistMgmt {
    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println("UC13 Performance Comparison (Loops vs Streams)");
        System.out.println("================================");

        List<Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            if (i % 2 == 0)
                bogies.add(new Bogie("Cylindrical", 100));
            else
                bogies.add(new Bogie("Open", 80));
        }

        long startLoop = System.nanoTime();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.type.equalsIgnoreCase("Cylindrical")) {
                loopResult.add(b);
            }
        }

        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        long startStream = System.nanoTime();

        List<Bogie> streamResult = bogies.stream()
                .filter(b -> b.type.equalsIgnoreCase("Cylindrical"))
                .collect(Collectors.toList());

        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        System.out.println("Loop Execution Time (ns): " + loopTime);
        System.out.println("Stream Execution Time (ns): " + streamTime);

        System.out.println("UC13 performance benchmarking completed...");
    }
}