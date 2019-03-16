package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.deleteFirstCustomer;
import static seedu.address.testutil.TypicalCustomers.getTypicalHotelManagementSystem;

import org.junit.Before;
import org.junit.Test;

import seedu.address.logic.CommandHistory;
import seedu.address.model.CustomerManager;
import seedu.address.model.CustomerModel;
import seedu.address.model.UserPrefs;
import seedu.address.model.VersionedHotelManagementSystem;

public class RedoCommandTest {

    private final CustomerModel model = new CustomerManager(
            new VersionedHotelManagementSystem(getTypicalHotelManagementSystem()), new UserPrefs());
    private final CustomerModel expectedModel = new CustomerManager(
            new VersionedHotelManagementSystem(getTypicalHotelManagementSystem()), new UserPrefs());
    private final CommandHistory commandHistory = new CommandHistory();

    @Before
    public void setUp() {
        // set up of both models' undo/redo history
        deleteFirstCustomer(model);
        deleteFirstCustomer(model);
        model.undoHotelManagementSystem();
        model.undoHotelManagementSystem();

        deleteFirstCustomer(expectedModel);
        deleteFirstCustomer(expectedModel);
        expectedModel.undoHotelManagementSystem();
        expectedModel.undoHotelManagementSystem();
    }

    @Test
    public void execute() {
        // multiple redoable states in model
        expectedModel.redoHotelManagementSystem();
        assertCommandSuccess(new RedoCommand(), model, commandHistory, RedoCommand.MESSAGE_SUCCESS, expectedModel);

        // single redoable state in model
        expectedModel.redoHotelManagementSystem();
        assertCommandSuccess(new RedoCommand(), model, commandHistory, RedoCommand.MESSAGE_SUCCESS, expectedModel);

        // no redoable state in model
        assertCommandFailure(new RedoCommand(), model, commandHistory, RedoCommand.MESSAGE_FAILURE);
    }
}
