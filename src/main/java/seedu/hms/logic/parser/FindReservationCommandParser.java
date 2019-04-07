package seedu.hms.logic.parser;

import static seedu.hms.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.hms.logic.parser.CliSyntax.PREFIX_IDENTIFICATION_NUMBER;
import static seedu.hms.logic.parser.CliSyntax.PREFIX_ROOM;

import seedu.hms.logic.commands.FindReservationCommand;
import seedu.hms.logic.parser.exceptions.ParseException;
import seedu.hms.model.ReservationManager;
import seedu.hms.model.ReservationModel;
import seedu.hms.model.reservation.ReservationContainsPayerPredicate;
import seedu.hms.model.reservation.ReservationWithTypePredicate;

/**
 * Parses input arguments and creates a new FindReservationCommand object
 */
public class FindReservationCommandParser implements Parser<FindReservationCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the FindReservationCommand
     * and returns an FindReservationCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindReservationCommand parse(String args, ReservationModel reservationModel) throws ParseException {
        ArgumentMultimap argMultimap =
            ArgumentTokenizer.tokenize(args, PREFIX_IDENTIFICATION_NUMBER,
                PREFIX_ROOM);

        if (!argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                FindReservationCommand.MESSAGE_USAGE));
        }

        ReservationContainsPayerPredicate reservationContainsPayerPredicate;
        if (argMultimap.getValue(PREFIX_IDENTIFICATION_NUMBER).isPresent()) {
            reservationContainsPayerPredicate = new ReservationContainsPayerPredicate(
                ParserUtil.parseIdNum(argMultimap.getValue(PREFIX_IDENTIFICATION_NUMBER).get()).toString());
        } else {
            reservationContainsPayerPredicate = new ReservationContainsPayerPredicate("");
        }

        ReservationWithTypePredicate reservationWithTypePredicate;
        if (argMultimap.getValue(PREFIX_ROOM).isPresent()) {
            reservationWithTypePredicate = new ReservationWithTypePredicate(
                ParserUtil.parseRoom(argMultimap.getValue(PREFIX_ROOM).get(), reservationModel).getName());
        } else {
            reservationWithTypePredicate = new ReservationWithTypePredicate("");
        }

        //search in whole day if timing is not provided
        //        DateRange dateRange = ParserUtil.parseDates(argMultimap.getValue(PREFIX_DATES)
        //            .orElse("01/01/0001-31/12/9999"));
        //        ReservationWithDatePredicate reservationWithDatePredicate = new ReservationWith
        // DatePredicate(dateRange);

        return new FindReservationCommand(reservationContainsPayerPredicate,
            reservationWithTypePredicate);
    }

    @Override
    public FindReservationCommand parse(String args) throws ParseException {
        return parse(args, new ReservationManager());
    }

}
