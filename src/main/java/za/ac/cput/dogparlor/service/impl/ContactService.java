package za.ac.cput.dogparlor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.dogparlor.domain.Contact;
import za.ac.cput.dogparlor.repository.ContactRepository;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepository repository;

    @Autowired
    private ContactService(ContactRepository contactRepository) {
        this.repository = contactRepository;
    }

    public List<Contact> getAll() {
        return repository.findAll();
    }

    public List<Contact> create(List<Contact> contacts) {
        return repository.saveAll(contacts);
    }

    public boolean delete(String contact) {
        if (repository.existsById(contact)) {
            repository.deleteById(contact);
            return true;
        }
        return false;
    }

    public void deleteAll(List<Contact> contacts) {
        System.out.println(contacts);
        repository.deleteAll(contacts);
    }

}
