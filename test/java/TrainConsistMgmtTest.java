import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistMgmtTest {

    private List<Bogie> createSampleBogies() {
        return Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 60)
        );
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = createSampleBogies();

        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(282, total); // 72+56+24+70+60
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = createSampleBogies();

        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertTrue(total > 0);
        assertEquals(282, total);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 80)
        );

        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(80, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> bogies = createSampleBogies();

        List<Integer> capacities = bogies.stream()
                .map(b -> b.capacity)
                .collect(Collectors.toList());

        assertEquals(Arrays.asList(72, 56, 24, 70, 60), capacities);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = createSampleBogies();

        int expectedSum = 0;
        for (Bogie b : bogies) {
            expectedSum += b.capacity;
        }

        int actualSum = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(expectedSum, actualSum);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>(createSampleBogies());
        int originalSize = bogies.size();

        bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(originalSize, bogies.size());
    }
}
