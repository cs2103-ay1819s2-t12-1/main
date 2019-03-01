package seedu.address.model.customer;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Customer's Identification Number in the HMS.
 * Guarantees: immutable; is valid as declared in {@link #isValidId(String)}
 */
public class IdentificationNo {

    public static final String MESSAGE_CONSTRAINTS = "Identification number should only contain numbers, and it should be at least 3 digits long";

    /*
     * The first character of the identification number must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "\\d{3,}";

    public final String value;

    /**
     * Constructs an {@code Address}.
     *
     * @param id A valid identification number.
     */
    public IdentificationNo(String id) {
        requireNonNull(id);
        checkArgument(isValidId(id), MESSAGE_CONSTRAINTS);
        value = id;
    }

    /**
     * Returns true if a given string is a valid email.
     */
    public static boolean isValidId(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof Address // instanceof handles nulls
            && value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
