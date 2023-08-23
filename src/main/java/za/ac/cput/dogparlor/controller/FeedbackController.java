package za.ac.cput.dogparlor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.dogparlor.domain.Feedback;
import za.ac.cput.dogparlor.factory.FeedbackFactory;
import za.ac.cput.dogparlor.service.impl.FeedbackService;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/create")
    public Feedback addNewFeedback(@RequestBody Feedback feedback) {
        Feedback createdFeedback = FeedbackFactory.createFeedback(feedback.getTitle(), feedback.getDescription(),
                feedback.getDatePosted(), feedback.getBooking());

        return feedbackService.create(createdFeedback);
    }

    @PostMapping("/update")
    public Feedback updateFeedback(@RequestBody Feedback feedback) {
        return feedbackService.update(feedback);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteFeedback(@PathVariable String id) {
        return feedbackService.delete(id);
    }

}
