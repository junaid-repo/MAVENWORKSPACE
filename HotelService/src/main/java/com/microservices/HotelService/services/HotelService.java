package com.microservices.HotelService.services;

import com.microservices.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);

    List<Hotel> getAllHotel();

    Hotel getHotel(String id);

}
