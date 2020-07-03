package com.bharath.flightcheckin.controllers;

import com.bharath.flightcheckin.integration.ReservationRestClient;
import com.bharath.flightcheckin.integration.dto.Reservation;
import com.bharath.flightcheckin.integration.dto.ReservationUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckInController {

    @Autowired
    ReservationRestClient restClient;

    @RequestMapping("/showStartCheckin")
    public String showStartCheckin(){
        return "startCheckIn";
    }

    @RequestMapping("/startCheckIn")
    public String startChekin(@RequestParam("reservationId") int reservationId, ModelMap modelMap){
        Reservation reservation = restClient.findReservation(reservationId);
        System.out.println(reservation.getFlight().getEstimatedDepartureTime());
        modelMap.addAttribute("reservation", reservation);
        return "displayReservationDetails";
    }

    @RequestMapping("/completeCheckIn")
    public String completeCheckIn(@RequestParam Long reservationId, @RequestParam("numberOfBags") int numberOfBags){
        ReservationUpdateRequest reservationUpdateRequestObj = new ReservationUpdateRequest();

        reservationUpdateRequestObj.setId(reservationId);
        reservationUpdateRequestObj.setCheckedIn(true);
        reservationUpdateRequestObj.setNumberOfBags(numberOfBags);
        restClient.updateReservation(reservationUpdateRequestObj);
        return "checkInConfirmation";
    }
}
