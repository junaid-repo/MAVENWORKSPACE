package com.microservices.HotelService.controller;


import com.microservices.HotelService.entities.Hotel;
import com.microservices.HotelService.services.HotelService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelDetails(@PathVariable String id){

        Hotel hotel=hotelService.getHotel(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(hotel);
    }
    @PostMapping
    public ResponseEntity<Hotel> createHotelData(@RequestBody Hotel hotel){

        Hotel returnData=hotelService.create(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(returnData);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel(){
        List<Hotel> allHotels=new ArrayList<>();
        allHotels=hotelService.getAllHotel();
        return ResponseEntity.status(HttpStatus.FOUND).body(allHotels);
    }

}
