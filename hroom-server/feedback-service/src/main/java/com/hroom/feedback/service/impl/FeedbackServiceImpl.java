package com.hroom.feedback.service.impl;

import com.hroom.feedback.service.FeedbackService;
import com.hroom.feedback.entity.Feedback;
import com.hroom.feedback.repository.FeedbackRepository;
import com.hroom.feedback.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackRepository repository;
    private boolean isValidRating(int rating) {
        if (rating  < 0 || rating > 5) {
            return false;
        }
        return true;
    }
    @Override
    public Feedback saveFeedback(Feedback feedback) throws BusinessException {

        if (!isValidRating(feedback.getRating())) {
            throw new BusinessException("rating should be between 0 and 5");
        }
        return repository.save(feedback);
    }

    @Override
    public Feedback findById(Long id) throws BusinessException {
        if (id < 0) {
            throw new BusinessException("id cannot be" + id);
        }
        Feedback feedback = null;
        try {
            feedback = repository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new BusinessException("No feedback found for id " + id);
        }
        return feedback;

    }

    @Override
    public Feedback updateFeedback(Feedback feedback, Long feedbackId) throws BusinessException {
        if (!isValidRating(feedback.getRating())) {
            throw new BusinessException("rating should be between 0 and 5");
        }

        if (feedback.getId() < 0) {
            throw new BusinessException("id cannot be " + feedback.getId());
        }
        try {
            repository.findById(feedback.getId()).get();
        } catch (NoSuchElementException e) {
            throw new BusinessException("No feedback found for id " + feedback.getId());
        }
        return repository.save(feedback);

    }

    @Override
    public void deleteFeedbackById(Long id) throws BusinessException {
        if (id < 0) {
            throw new BusinessException("id cannot be" + id);
        }
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new BusinessException("No feedback found for id " + id);
        }

    }

    @Override
    public List<Feedback> fetchFeedbackList() {
        return (List<Feedback>) repository.findAll();
    }

    @Override
    public List<Feedback> fetchFeedbacksOfTenant(Long tenantId) {
        return (List<Feedback>) repository.findByTenantId(tenantId);
    }

    @Override
    public List<Feedback> fetchFeedbacksOfInsertion(Long insertionId) {
        return (List<Feedback>) repository.findByInsertionId(insertionId);
    }

}
