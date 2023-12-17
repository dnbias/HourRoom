package com.dnbias.hroom.room;

import com.dnbias.hroom.user.Landlord;

import java.util.List;

public class Room extends Insertion{
    public Room(String features, String description, double price, String city, String address,
                List<Long> receivedFeedbacks, int area, Landlord landlord, String photo, String name,
                int meanRating, Long availabilityId, Long id) {
        super(features, description, price, city, address, receivedFeedbacks, area, landlord, photo, name, meanRating, availabilityId, id);
    }
}
