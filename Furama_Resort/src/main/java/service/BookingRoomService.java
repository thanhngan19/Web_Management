package service;

import model.BookingRoom;
import repository.BookingRoomRepository;
import repository.IBookingRoomRepository;

public class BookingRoomService implements IBookingRoomService{
    private IBookingRoomRepository repo= new BookingRoomRepository();
    @Override
    public void addNew(BookingRoom room) {
        repo.addNew(room);
    }

    @Override
    public void delete(BookingRoom room) {
      repo.delete(room);
    }
}
