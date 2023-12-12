package service;

import model.Contract_Detail;

import java.util.List;

public interface IContractDetailService {
    List<Contract_Detail> findAll();
    void addNew (Contract_Detail con);
    List<Integer> seContract();
    List<String> seService();
}
