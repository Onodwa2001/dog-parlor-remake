package za.ac.cput.dogparlor.service;

import za.ac.cput.dogparlor.domain.GroomService;

import java.util.List;

public interface IGroomServiceService extends IService<GroomService, String> {

    List<GroomService> getAll();

}
