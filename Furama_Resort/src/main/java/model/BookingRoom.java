package model;

import java.time.LocalDateTime;

public class BookingRoom {
    private int id ;
    private String name;
    private int quantity;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String message;
    private int idLoaiDichVu;

    public BookingRoom(int id, String name, int quantity, LocalDateTime startTime, LocalDateTime endTime, String message, int idLoaiDichVu) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.startTime = startTime;
        this.endTime = endTime;
        this.message = message;
        this.idLoaiDichVu = idLoaiDichVu;
    }

    public BookingRoom(String name, int quantity, LocalDateTime startTime, LocalDateTime endTime, String message, int idLoaiDichVu) {
        this.name = name;
        this.quantity = quantity;
        this.startTime = startTime;
        this.endTime = endTime;
        this.message = message;
        this.idLoaiDichVu = idLoaiDichVu;
    }

    public BookingRoom() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getIdLoaiDichVu() {
        return idLoaiDichVu;
    }

    public void setIdLoaiDichVu(int idLoaiDichVu) {
        this.idLoaiDichVu = idLoaiDichVu;
    }
}
