package seedu.address.model.customer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import seedu.address.testutil.Assert;

public class IDTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        Assert.assertThrows(NullPointerException.class, () -> new ID(null));
    }

    @Test
    public void constructor_invalidId_throwsIllegalArgumentException() {
        String invalidId = "";
        Assert.assertThrows(IllegalArgumentException.class, () -> new Address(invalidId));
    }

    @Test
    public void isValidId() {
        // null Id
        Assert.assertThrows(NullPointerException.class, () -> ID.isValidId(null));

        // invalid id numbers
        assertFalse(ID.isValidId("")); // empty string
        assertFalse(ID.isValidId(" ")); // spaces only
        assertFalse(ID.isValidId("91")); // less than 3 numbers
        assertFalse(ID.isValidId("ID")); // non-numeric
        assertFalse(ID.isValidId("9011p041")); // alphabets within digits
        assertFalse(ID.isValidId("9312 1534")); // spaces within digits

        // valid id numbers
        assertTrue(ID.isValidId("911")); // exactly 3 numbers
        assertTrue(ID.isValidId("93121534"));
        assertTrue(ID.isValidId("124293842033123")); // long ID numbers
    }
}

