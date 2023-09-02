package za.ac.cput.dogparlor.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.dogparlor.domain.PaymentHistory;
import za.ac.cput.dogparlor.repository.PaymentHistoryRepository;
import za.ac.cput.dogparlor.service.IPaymentHistoryService;

import java.util.List;

@Service
public class PaymentHistoryService implements IPaymentHistoryService {

   private final PaymentHistoryRepository repo;

   @Autowired
    private PaymentHistoryService(PaymentHistoryRepository historyRepository){
        this.repo = historyRepository;
    }

    @Override
    public PaymentHistory create(PaymentHistory history) {
        return repo.save(history);
    }

    @Override
    public PaymentHistory read(String id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public PaymentHistory update(PaymentHistory history) {
       if (repo.existsById(history.getPaymentID()))
           return repo.save(history);
        return null;
    }

    @Override
    public boolean delete(String id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<PaymentHistory> getAll() {
        return repo.findAll();
    }
}