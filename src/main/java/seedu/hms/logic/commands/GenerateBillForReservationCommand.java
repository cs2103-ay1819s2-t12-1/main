package seedu.hms.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.hms.logic.parser.CliSyntax.PREFIX_DATES;
import static seedu.hms.logic.parser.CliSyntax.PREFIX_INDEX;
import static seedu.hms.logic.parser.CliSyntax.PREFIX_ROOM;

import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.hms.logic.CommandHistory;
import seedu.hms.logic.commands.exceptions.CommandException;
import seedu.hms.model.BillModel;
import seedu.hms.model.reservation.Reservation;
import seedu.hms.model.reservation.ReservationContainsPayerPredicate;
import seedu.hms.model.reservation.ReservationWithDatePredicate;
import seedu.hms.model.reservation.ReservationWithTypePredicate;

/**
 * Generates the bill for a customer who is identified using displayed index from hms book
 */
public class GenerateBillForReservationCommand extends BillCommand {

    public static final String COMMAND_ALIAS = "gb-r";
    public static final String COMMAND_WORD = "generate-bill-reservation";

    public static final String MESSAGE_USAGE = COMMAND_WORD
        + ": Generates reservation bill for the customer identified by the index used in the displayed "
        + "customer list.\n"
        + "Parameters: INDEX\n"
        + "Example: " + COMMAND_WORD
        + PREFIX_INDEX + "1 "
        + "[" + PREFIX_ROOM + "SINGLE ROOM] "
        + "[" + PREFIX_DATES + "12/12/2019 - 14/12/2019]";


    public static final String MESSAGE_GENERATE_BILL_FOR_RESERVATION_SUCCESS = "Reservation Bill: %1$s";

    private final Predicate<Reservation> reservationPredicate;


    public GenerateBillForReservationCommand(ReservationContainsPayerPredicate reservationContainsPayerPredicate,
                                             ReservationWithTypePredicate reservationWithTypePredicate,
                                             ReservationWithDatePredicate reservationWithDatePredicate) {

        this.reservationPredicate = (reservationTested) -> reservationContainsPayerPredicate.test(reservationTested)
            && reservationWithTypePredicate.test(reservationTested)
            && reservationWithDatePredicate.test(reservationTested);
    }


    @Override

    public CommandResult execute(BillModel model, CommandHistory history) throws CommandException {

        requireNonNull(model);

        model.updateFilteredReservationList(reservationPredicate);
        ObservableList<Reservation> reservationObservableList = model.getFilteredReservationList();

        double amount = model.generateBillForReservation(reservationObservableList);


        return new CommandResult(String.format(MESSAGE_GENERATE_BILL_FOR_RESERVATION_SUCCESS, amount));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof GenerateBillForReservationCommand // instanceof handles nulls
            && reservationPredicate.equals(((GenerateBillForReservationCommand) other).reservationPredicate));
    }
}