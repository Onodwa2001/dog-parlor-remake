package za.ac.cput.dogparlor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.dogparlor.domain.ExtraService;
import za.ac.cput.dogparlor.factory.ExtraServiceFactory;
import za.ac.cput.dogparlor.service.impl.ExtraServiceService;

import java.util.List;

@RestController
@RequestMapping("/extra-service")
public class ExtraServiceController {

    @Autowired
    public ExtraServiceService service;

    @PostMapping("/create")
    public ExtraService create(@RequestBody ExtraService extraService) {
        ExtraService generatedExtraService =
                ExtraServiceFactory.createExtraService(extraService.getExtraServiceName(), extraService.getPrice());
        return service.create(generatedExtraService);
    }

    @DeleteMapping("/delete")
    public boolean delete(@PathVariable String id) {
        return service.delete(id);
    }

    @GetMapping("/getall")
    public List<ExtraService> getAll() {
        return service.getAllExtraServices();
    }

}
