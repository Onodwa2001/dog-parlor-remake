package za.ac.cput.dogparlor.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.dogparlor.domain.PaymentHistory;
import za.ac.cput.dogparlor.factory.PaymentHistoryFactory;
import za.ac.cput.dogparlor.service.impl.PaymentHistoryService;

import java.util.List;

@RestController
@RequestMapping("/paymentHistory")
public class PaymentHistoryController {

    @Autowired
    private PaymentHistoryService service;

    @PostMapping("/create")
    public PaymentHistory create(@RequestBody PaymentHistory history){
        PaymentHistory create = PaymentHistoryFactory.createPaymentHistory(history.getBooking(), history.getAmount(), history.getPaymentMethod());
        return service.create(create);
    }

    @GetMapping("/read/{id}")
    public PaymentHistory read(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/update")
    public PaymentHistory update(@RequestBody PaymentHistory history){
        return service.update(history);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return service.delete(id);
    }

    @GetMapping("/getall")
    public List<PaymentHistory> getAll(){
        return service.getAll();
    }
}
