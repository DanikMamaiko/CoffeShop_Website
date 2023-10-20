package com.dessert.project.dessert.Service.impl;


import com.dessert.project.dessert.DAO.ReservationsRepository;
import com.dessert.project.dessert.Entities.Reservations;
import com.dessert.project.dessert.Service.interf.ServiceReservatoinsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceReservationsImpl implements ServiceReservatoinsInterface {

    @Autowired
    private ReservationsRepository reservationsRepository;

    @Override
    @Transactional
    public Reservations getReservation(long id) {
        return reservationsRepository.getById(id);
    }

    @Override
    @Transactional
    public List<Reservations> getReservations() {
        return reservationsRepository.findAll();
    }

    @Override
    @Transactional
    public void saveReservation(Reservations reservation) {
        reservationsRepository.save(reservation);
    }

    @Override
    @Transactional
    public void updateReservation(Reservations reservation) {
        Reservations oldReservation = reservationsRepository.getById(reservation.getId());

        oldReservation.setLocalDate(reservation.getLocalDate());
        oldReservation.setTableNum(reservation.getTableNum());
        oldReservation.setPlaceCount(reservation.getPlaceCount());
    }

    @Override
    @Transactional
    public void deleteReservation(long id) {
        reservationsRepository.deleteById(id);
    }
}
