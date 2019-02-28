package seedu.address.model.bill;

import seedu.address.model.customer.Customer;


public class Bill {

    private Customer customer;
    private int amount_paid;


    public Bill(Customer customer, int amount_paid) {

        this.customer = customer;
        this.amount_paid = amount_paid;

    }

    public Customer getCustomer() {
        return customer;
    }

    public int getAmountPaid() {
        return amount_paid;
    }


    @Override
    public String toString() {
        return " Amount already paid " + amount_paid
            + " by " + customer;
    }
}


