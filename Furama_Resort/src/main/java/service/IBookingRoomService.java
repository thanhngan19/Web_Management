package service;

import model.BookingRoom;

public interface IBookingRoomService {
    void addNew(BookingRoom room);
    void delete(BookingRoom room);
}
