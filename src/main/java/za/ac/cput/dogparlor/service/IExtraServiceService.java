package za.ac.cput.dogparlor.service;

import za.ac.cput.dogparlor.domain.ExtraService;

import java.util.List;

public interface IExtraServiceService extends IService<ExtraService, String> {

    List<ExtraService> getAllExtraServices();

}
