package model;

public class Service {



    private int maDv;
    private String name;
    private String square;
    private double chiPhiThue;
    private int soNguoi;
    private String kieuThue;
    private String dichVu;
    private String standardRoom;
    private String diff;
    private  String squareOfSwin;
    private int soTang;

    public Service() {
    }

    public Service(int maDv, String name, String square, double chiPhiThue, int soNguoi, String kieuThue, String dichVu, String standardRoom, String diff, String squareOfSwin, int soTang) {
        this.maDv = maDv;
        this.name = name;
        this.square = square;
        this.chiPhiThue = chiPhiThue;
        this.soNguoi = soNguoi;
        this.kieuThue = kieuThue;
        this.dichVu = dichVu;
        this.standardRoom = standardRoom;
        this.diff = diff;
        this.squareOfSwin = squareOfSwin;
        this.soTang = soTang;
    }

    public Service(String name, String square, double chiPhiThue, int soNguoi, String kieuThue, String dichVu, String standardRoom, String diff, String squareOfSwin, int soTang) {
        this.name = name;
        this.square = square;
        this.chiPhiThue = chiPhiThue;
        this.soNguoi = soNguoi;
        this.kieuThue = kieuThue;
        this.dichVu = dichVu;
        this.standardRoom = standardRoom;
        this.diff = diff;
        this.squareOfSwin = squareOfSwin;
        this.soTang = soTang;
    }

    public int getMaDv() {
        return maDv;
    }

    public void setMaDv(int maDv) {
        this.maDv = maDv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSquare() {
        return square;
    }

    public void setSquare(String square) {
        this.square = square;
    }

    public double getChiPhiThue() {
        return chiPhiThue;
    }

    public void setChiPhiThue(double chiPhiThue) {
        this.chiPhiThue = chiPhiThue;
    }

    public int getSoNguoi() {
        return soNguoi;
    }

    public void setSoNguoi(int soNguoi) {
        this.soNguoi = soNguoi;
    }

    public String getKieuThue() {
        return kieuThue;
    }

    public void setKieuThue(String kieuThue) {
        this.kieuThue = kieuThue;
    }

    public String getDichVu() {
        return dichVu;
    }

    public void setDichVu(String dichVu) {
        this.dichVu = dichVu;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDiff() {
        return diff;
    }

    public void setDiff(String diff) {
        this.diff = diff;
    }

    public String getSquareOfSwin() {
        return squareOfSwin;
    }

    public void setSquareOfSwin(String squareOfSwin) {
        this.squareOfSwin = squareOfSwin;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }


}
