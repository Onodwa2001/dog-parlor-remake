package za.ac.cput.dogparlor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.dogparlor.domain.Contact;
import za.ac.cput.dogparlor.repository.ContactRepository;
import za.ac.cput.dogparlor.service.IContactService;

import java.util.List;

@Service
public class ContactService implements IContactService {

    private final ContactRepository repository;
    @Autowired
    private ContactService(ContactRepository contactRepository){this.repository = contactRepository;}

    @Override
    public Contact create(Contact contact) {
        return repository.save(contact);
    }

    @Override
    public Contact read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Contact update(Contact contact) {
        if (repository.existsById(contact.getContactID()))
            return repository.save(contact);
        return null;
    }

    @Override
    public boolean delete(String id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;

        }
        return false;
    }

    @Override
    public List<Contact> getAll() {
        return repository.findAll();
    }
}
