package com.dnbias.hroom.feedback;

import jakarta.persistence.MappedSuperclass;
import java.sql.Timestamp;

@MappedSuperclass
public abstract class Feedback {
    private int rating;
    private String description;
    private Timestamp timestamp;

    public Feedback(int rating, String description, Timestamp timestamp) {
        this.rating = rating;
        this.description = description;
        this.timestamp = timestamp;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
