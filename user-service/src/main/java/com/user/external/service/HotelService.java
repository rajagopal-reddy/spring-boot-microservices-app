//package com.user.external.service;
//
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import com.user.model.Hotel;
//
//@FeignClient(name = "Hotel") // Specify the base URL here
//public interface HotelService {
//    @GetMapping("/hotel/{hotelId}") // Correct the endpoint path here
//    Hotel getHotel(@PathVariable("hotelId") String hotelId);
//}
//
