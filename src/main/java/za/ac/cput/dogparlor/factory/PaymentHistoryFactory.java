package za.ac.cput.dogparlor.factory;


import za.ac.cput.dogparlor.domain.Booking;
import za.ac.cput.dogparlor.domain.PaymentHistory;
import za.ac.cput.dogparlor.util.Helper;

import java.time.LocalDateTime;

public class PaymentHistoryFactory {

    public static PaymentHistory createPaymentHistory(Booking booking, double amount,
                                                      String paymentMethod) {

        if (booking == null || amount < 0 || Helper.isNullOrEmpty(paymentMethod))
            return null;

        String paymentID = Helper.generateID();
        LocalDateTime paymentDate = LocalDateTime.now();
        return new PaymentHistory.Builder()
                .setPaymentID(paymentID)
                .setAmount(amount)
                .setPaymentDate(paymentDate)
                .setPaymentMethod(paymentMethod)
                .build();
    }

}
