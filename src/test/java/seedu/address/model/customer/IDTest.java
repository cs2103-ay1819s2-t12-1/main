package seedu.address.model.customer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import seedu.address.testutil.Assert;

public class IDTest {

    @Test
    public void constructorNullThrowsNullPointerException() {
        Assert.assertThrows(NullPointerException.class, () -> new IdentificationNo(null));
    }

    @Test
    public void constructorInvalidIdThrowsIllegalArgumentException() {
        String invalidId = "";
        Assert.assertThrows(IllegalArgumentException.class, () -> new IdentificationNo(invalidId));
    }

    @Test
    public void isValidId() {
        // null IdentificationNo
        Assert.assertThrows(NullPointerException.class, () -> IdentificationNo.isValidId(null));

        // invalid IdentificationNo numbers
        assertFalse(IdentificationNo.isValidId("")); // empty string
        assertFalse(IdentificationNo.isValidId(" ")); // spaces only
        assertFalse(IdentificationNo.isValidId("91")); // less than 3 numbers
        assertFalse(IdentificationNo.isValidId("IdentificationNo")); // non-numeric
        assertFalse(IdentificationNo.isValidId("9011p041")); // alphabets within digits
        assertFalse(IdentificationNo.isValidId("9312 1534")); // spaces within digits

        // valid IdentificationNo numbers
        assertTrue(IdentificationNo.isValidId("911")); // exactly 3 numbers
        assertTrue(IdentificationNo.isValidId("93121534"));
        assertTrue(IdentificationNo.isValidId("124293842033123")); // long IdentificationNo numbers
    }
}

