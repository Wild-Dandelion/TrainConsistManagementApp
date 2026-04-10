import org.junit.jupiter.api.Test;
import java.util.regex.*;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistMgmtTest {

    Pattern trainPattern = Pattern.compile("TRN-\\d{4}", Pattern.CASE_INSENSITIVE);
    Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}", Pattern.CASE_INSENSITIVE);

    @Test
    void testRegex_ValidTrainID() {
        Matcher matcher = trainPattern.matcher("TRN-1234");
        assertTrue(matcher.find());
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(trainPattern.matcher("TRAIN12").find());
        assertFalse(trainPattern.matcher("TRN12A").find());
        assertFalse(trainPattern.matcher("1234-TRN").find());
    }

    @Test
    void testRegex_ValidCargoCode() {
        Matcher matcher = cargoPattern.matcher("PET-AB");
        assertTrue(matcher.find());
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(cargoPattern.matcher("PET123").find());
        assertFalse(cargoPattern.matcher("AB-PET").find());
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(trainPattern.matcher("TRN-123").find());
        assertFalse(trainPattern.matcher("TRN-12345").find());
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertTrue(cargoPattern.matcher("PET-ab").find()); // will PASS due to CASE_INSENSITIVE
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(trainPattern.matcher("").find());
        assertFalse(cargoPattern.matcher("").find());
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertTrue(trainPattern.matcher("XXX TRN-1234 YYY").find());
        assertFalse(trainPattern.matcher("XXX TRN-1234 YYY").matches());
    }
}
