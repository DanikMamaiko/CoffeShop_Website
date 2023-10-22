package com.dessert.project.dessert.Service.interf;


import java.util.List;

public interface ServiceReservatoinsInterface {

    public Reservations getReservation(long id);

    public List<Reservations> getReservations();

    public void saveReservation(Reservations reservation);

    public void updateReservation(Reservations reservation);

    public void deleteReservation(long id);

}
