package repository;

import model.BookingRoom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BookingRoomRepository implements IBookingRoomRepository{
    public Connection conn= BaseRepository.getConnection();
    private static final String INSERT="INSERT INTO `book_room` ( `name`, `quantity`, `start_date`, `end_date`, `message`, `id_loai_dich_vu`) VALUES (?,?,?,?,?,?);";
    private static final String DELETE="delete * from book_room where book_room.id=?";

    @Override
    public void addNew(BookingRoom room) {
        try {
            PreparedStatement ps = conn.prepareStatement(INSERT);
            ps.setString(1,room.getName());
            ps.setInt(2,room.getQuantity());
            ps.setString(3, String.valueOf(room.getStartTime()));
            ps.setString(4, String.valueOf(room.getEndTime()));
            ps.setString(5, String.valueOf(room.getMessage()));
            ps.setString(6, String.valueOf(room.getIdLoaiDichVu()));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(BookingRoom room) {
        try {
            PreparedStatement ps = conn.prepareStatement(DELETE);
            ps.setInt(1,room.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<BookingRoom> findAll() {
        return null;
    }
}
