package za.ac.cput.dogparlor.service;

import za.ac.cput.dogparlor.domain.Contact;

import java.util.List;

public interface IContactService extends IService<Contact, String> {
    List<Contact> getAll();
}
