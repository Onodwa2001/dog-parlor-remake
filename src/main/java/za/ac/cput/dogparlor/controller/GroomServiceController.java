package za.ac.cput.dogparlor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.dogparlor.domain.GroomService;
import za.ac.cput.dogparlor.factory.GroomServiceFactory;
import za.ac.cput.dogparlor.service.impl.GroomServiceServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/groomservice")
public class GroomServiceController {

    @Autowired
    GroomServiceServiceImpl groomServiceService;

    // this controller is for admin
    @PostMapping("/create")
    public GroomService create(@RequestBody GroomService groomService) {
        GroomService createdGroomService = GroomServiceFactory.createService(groomService.getName(),
                groomService.getDescription(), groomService.getServiceDuration(), groomService.getPrice(),
                groomService.getExtraServices());

        return groomServiceService.create(createdGroomService);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return groomServiceService.delete(id);
    }

    // will be for admin and users
    @GetMapping("/getall")
    public List<GroomService> getAll() {
        return groomServiceService.getAll();
    }

}

