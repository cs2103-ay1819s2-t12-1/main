package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ID_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ID_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.customer.Customer;

/**
 * A utility class containing a list of {@code Customer} objects to be used in tests.
 */
public class TypicalCustomers {

    public static final Customer ALICE = new CustomerBuilder().withName("Alice Pauline")
        .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
        .withId("1234535")
        .withPhone("94351253")
        .withTags("friends").build();
    public static final Customer BENSON = new CustomerBuilder().withName("Benson Meier")
        .withAddress("311, Clementi Ave 2, #02-25")
        .withId("1233535")
        .withEmail("johnd@example.com").withPhone("98765432")
        .withTags("owesMoney", "friends").build();
    public static final Customer CARL = new CustomerBuilder().withName("Carl Kurz").withPhone("95352563")
        .withEmail("heinz@example.com").withId("1234535").withAddress("wall street").build();
    public static final Customer DANIEL = new CustomerBuilder().withName("Daniel Meier").withPhone("87652533")
        .withEmail("cornelia@example.com").withId("123334535").withAddress("10th street").withTags("friends").build();
    public static final Customer ELLE = new CustomerBuilder().withName("Elle Meyer").withPhone("9482224")
        .withEmail("werner@example.com").withId("1114535").withAddress("michegan ave").build();
    public static final Customer FIONA = new CustomerBuilder().withName("Fiona Kunz").withPhone("9482427")
        .withEmail("lydia@example.com").withId("12345545").withAddress("little tokyo").build();
    public static final Customer GEORGE = new CustomerBuilder().withName("George Best").withPhone("9482442")
        .withEmail("anna@example.com").withId("12934535").withAddress("4th street").build();
    public static final Customer VIP_CUSTOMER = new CustomerBuilder().withName("I am VIP").withPhone("94824425")
        .withEmail("vip@example.com").withId("0004535").withAddress("VIP street").withTags("VIP").build();
    public static final Customer VIP_CUSTOMER2 = new CustomerBuilder().withName("I am also VIP").withPhone("34824425")
        .withEmail("vip2@example.com").withId("1234000").withAddress("VVIP street").withTags("vip").build();

    // Manually added
    public static final Customer HOON = new CustomerBuilder().withName("Hoon Meier").withPhone("8482424")
        .withEmail("stefan@example.com").withId("1234535").withAddress("little india").build();
    public static final Customer IDA = new CustomerBuilder().withName("Ida Mueller").withPhone("8482131")
        .withEmail("hans@example.com").withId("0004535").withAddress("chicago ave").build();


    // Manually added - Customer's details found in {@code CommandTestUtil}
    public static final Customer AMY = new CustomerBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
        .withEmail(VALID_EMAIL_AMY).withId(VALID_ID_AMY).withAddress(VALID_ADDRESS_AMY).withTags(VALID_TAG_FRIEND).build();
    public static final Customer BOB = new CustomerBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
        .withEmail(VALID_EMAIL_BOB).withId(VALID_ID_BOB).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
        .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalCustomers() {
    } // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical customers.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Customer customer : getTypicalCustomers()) {
            ab.addCustomer(customer);
        }
        return ab;
    }

    public static List<Customer> getTypicalCustomers() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
