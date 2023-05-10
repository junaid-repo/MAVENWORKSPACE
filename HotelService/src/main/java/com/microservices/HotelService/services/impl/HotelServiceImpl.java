package com.microservices.HotelService.services.impl;

import com.microservices.HotelService.entities.Hotel;
import com.microservices.HotelService.exceptions.ResourceNotFoundException;
import com.microservices.HotelService.respositories.HotelRepository;
import com.microservices.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository repo;

    @Override
    public Hotel create(Hotel hotel) {

        String hotelId= UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return repo.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotel() {
        return repo.findAll();
    }

    @Override
    public Hotel getHotel(String id) {
        return repo.findById(id).orElseThrow(()->new ResourceNotFoundException("User with the id "+id+" is not on the Server"));
    }
}
