package za.ac.cput.dogparlor.service;



import za.ac.cput.dogparlor.domain.PaymentHistory;

import java.util.List;

public interface IPaymentHistoryService extends IService<PaymentHistory,String> {
    List<PaymentHistory> getAll();
}
