package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.CommandHistory;
import seedu.address.model.HotelManagementSystem;
import seedu.address.model.Model;

/**
 * Clears the address book.
 */
public class ClearCustomerCommand extends Command {

    public static final String COMMAND_ALIAS = "clearc";
    public static final String COMMAND_WORD = "clearcustomers";
    public static final String MESSAGE_SUCCESS = "Address book has been cleared!";


    @Override
    public CommandResult execute(Model model, CommandHistory history) {
        requireNonNull(model);
        model.setHotelManagementSystem(new HotelManagementSystem());
        model.commitHotelManagementSystem();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
