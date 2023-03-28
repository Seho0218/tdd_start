package test.java.chap03;

import main.chap03.PayData;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {

    /*
    *   P78
    public LocalDate calculateExpiryDate(LocalDate billingDate, int payAmount) {
        return billingDate.plusMonths(1);
    }
    */

    public LocalDate calculateExpiryDate(PayData payData) {
        int addedMonths = payData.getPayAmount() / 10_000;
        if (payData.getFirstBillingDate() != null) {
            LocalDate candidateExp =
                    payData.getBillingDate().plusMonths(addedMonths);
            final int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();
            if (dayOfFirstBilling != candidateExp.getDayOfMonth()) {
                final int dayLenOfCandiMon =
                        YearMonth.from(candidateExp).lengthOfMonth();
                if (dayLenOfCandiMon < payData.getFirstBillingDate().getDayOfMonth()) {
                    return candidateExp.withDayOfMonth(dayLenOfCandiMon);
                }
                return candidateExp.withDayOfMonth(dayOfFirstBilling);
            } else {
                return candidateExp;
            }
        } else {

           /*
            if (payData.getFirstBillingDate().equals(LocalDate.of(2019, 1, 31))) {
                return LocalDate.of(2019, 3, 31);
            }
            */

            return payData.getBillingDate().plusMonths(addedMonths);
        }
    }
}

