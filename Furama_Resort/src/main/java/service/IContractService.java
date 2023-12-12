package service;

import model.Contracts;

import java.util.List;

public interface IContractService {
    List<Contracts> findAll();
    void addAll(Contracts contract);
    int seNv(String url);
    int seKh(String url);
    int seDv(String url);
    List<String> khachHang();
    List<String> dichVu();
    List<String> nhanVien();
}
