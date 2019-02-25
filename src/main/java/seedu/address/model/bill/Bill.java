package seedu.address.model.bill;

import java.util.Optional;

public class Bill {

    private Customer customer;
    private int amount_paid;
    private Optional<List<Booking>> bookings;
    private Optional<List<Reservation>> reservations;

    public Bill(Customer customer, int amount_paid, Optional<List<Booking>> bookings, Optional<List<Reservations>> reservations){

        this.customer = customer;
        this.amount_paid = amount_paid;
        this.bookings = bookings;
        this.reservations = reservations;
    }

    public Customer getCustomer(){
        return customer;
    }

    public int getAmountPaid(){
        return amount_paid;
    }

    public Optional<List<Booking>> getBookings() {
        return bookings;
    }

    public Optional<List<Reservation>> getReservations() {
        return reservations;
    }

    @Override
    public String toString(){
        return " Amount already paid " + amount_paid
            + " by " + customer;
    }
}


