package za.ac.cput.dogparlor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.dogparlor.domain.Feedback;
import za.ac.cput.dogparlor.repository.FeedbackRepository;
import za.ac.cput.dogparlor.service.IFeedbackService;

import java.util.List;

@Service
public class FeedbackService implements IFeedbackService {

    private final FeedbackRepository repository;

    @Autowired
    private FeedbackService(FeedbackRepository repository) {
        this.repository = repository;
    }

    @Override
    public Feedback create(Feedback feedback) {
        return repository.save(feedback);
    }

    @Override
    public Feedback read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Feedback update(Feedback feedback) {
        if (repository.existsById(feedback.getFeedbackID()))
            return repository.save(feedback);
        return null;
    }

    @Override
    public boolean delete(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Feedback> getAll() {
        return repository.findAll();
    }

}
