import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistMgmtTest {

    private List<Bogie> createSampleBogies() {
        return Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("General", 90),
                new Bogie("Second Sitting", 70)
        );
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> bogies = createSampleBogies();
        List<Bogie> result = TrainConsistMgmt.filterBogies(bogies, 70);

        assertTrue(result.stream().allMatch(b -> b.capacity > 70));
        assertTrue(result.stream().anyMatch(b -> b.capacity == 72));
        assertTrue(result.stream().anyMatch(b -> b.capacity == 90));
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = createSampleBogies();
        List<Bogie> result = TrainConsistMgmt.filterBogies(bogies, 70);

        assertFalse(result.stream().anyMatch(b -> b.capacity == 70));
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> bogies = createSampleBogies();
        List<Bogie> result = TrainConsistMgmt.filterBogies(bogies, 70);

        assertFalse(result.stream().anyMatch(b -> b.capacity < 70));
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = createSampleBogies();
        List<Bogie> result = TrainConsistMgmt.filterBogies(bogies, 70);

        assertEquals(2, result.size()); // Sleeper(72), General(90)
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("A", 30),
                new Bogie("B", 40)
        );

        List<Bogie> result = TrainConsistMgmt.filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("A", 80),
                new Bogie("B", 90)
        );

        List<Bogie> result = TrainConsistMgmt.filterBogies(bogies, 70);

        assertEquals(bogies.size(), result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        List<Bogie> result = TrainConsistMgmt.filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>(createSampleBogies());
        int originalSize = bogies.size();

        TrainConsistMgmt.filterBogies(bogies, 70);

        assertEquals(originalSize, bogies.size());
        assertEquals(5, bogies.size());
    }
}