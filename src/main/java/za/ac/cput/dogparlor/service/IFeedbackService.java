package za.ac.cput.dogparlor.service;

import za.ac.cput.dogparlor.domain.Feedback;

import java.util.List;

public interface IFeedbackService extends IService<Feedback, String> {

    List<Feedback> getAll();

}
