package repository;

import model.BookingRoom;

import java.util.List;

public interface IBookingRoomRepository {
    void addNew(BookingRoom room);
    void delete(BookingRoom room);
    List<BookingRoom> findAll();
}
