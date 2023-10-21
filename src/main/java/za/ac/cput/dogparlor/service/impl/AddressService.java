package za.ac.cput.dogparlor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.dogparlor.domain.Address;
import za.ac.cput.dogparlor.repository.AddressRepository;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> create(List<Address> address) {
        return addressRepository.saveAll(address);
    }

    public void deleteAll(List<Address> addressList) {
        addressRepository.deleteAll(addressList);
    }

}
