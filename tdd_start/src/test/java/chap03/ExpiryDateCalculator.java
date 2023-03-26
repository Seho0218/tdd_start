package test.java.chap03;

import main.chap03.PayData;

import java.time.LocalDate;

public class ExpiryDateCalculator {

    /*
    *   P78
    public LocalDate calculateExpiryDate(LocalDate billingDate, int payAmount) {
        return billingDate.plusMonths(1);
    }
    */

    public LocalDate calculateExpiryDate(PayData payData) {
        return payData.getBillingDate().plusMonths(1);
    }

}
