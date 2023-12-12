package service;

import model.Contracts;
import repository.ContractRepository;
import repository.IContractRepository;

import java.util.List;

public class ContractService implements IContractService{
    IContractRepository repo= new ContractRepository();
    @Override
    public List<Contracts> findAll() {
        return repo.findAll();
    }

    @Override
    public void addAll(Contracts contract) {
        repo.addAll(contract);
    }

    @Override
    public int seNv(String url) {
        return repo.seNv(url);
    }

    @Override
    public int seKh(String url) {
        return repo.seKh(url);
    }

    @Override
    public int seDv(String url) {
        return repo.seDv(url);
    }

    @Override
    public List<String> khachHang() {
        return repo.khachHang();
    }

    @Override
    public List<String> dichVu() {
        return repo.dichVu();
    }

    @Override
    public List<String> nhanVien() {
        return repo.nhanVien();
    }
}
