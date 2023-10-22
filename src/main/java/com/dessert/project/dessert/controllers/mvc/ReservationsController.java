//package com.dessert.project.dessert.Controllers.mvc;
//
//
//import com.dessert.project.dessert.Service.impl.ServiceReservationsImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import java.util.List;
//
//@Controller
//public class ReservationsController {
//
//    @Autowired
//    private ServiceReservationsImpl serviceReservations;
//
//    @GetMapping("/reservations")
//    public String getAllReservations(Model model){
//
//        List<Reservations> reservationsList = serviceReservations.getReservations();
//
//        model.addAttribute("reservations", reservationsList);
//
//        return "backend/reservations/reservationsPage";
//
//    }
//
//    @GetMapping("/addNewReservation")
//    public String addNewReservation(Model model){
//
//        model.addAttribute("reservation", new Reservations());
//
//        return "backend/reservations/reservationsFormPage";
//
//    }
//
//    @PostMapping("/saveReservation")
//    public String saveReservation(@ModelAttribute("reservation") Reservations reservation){
//
//        serviceReservations.saveReservation(reservation);
//
//        return "redirect:/reservations";
//
//    }
//
//}
