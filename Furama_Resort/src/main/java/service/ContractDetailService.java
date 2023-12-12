package service;

import model.Contract_Detail;
import repository.ContractDetailRepository;
import repository.IContractDetailRepository;

import java.util.List;

public class ContractDetailService implements IContractDetailService {
    private IContractDetailRepository repo= new ContractDetailRepository();
    @Override
    public List<Contract_Detail> findAll() {
        return repo.findAll();
    }

    @Override
    public void addNew(Contract_Detail con) {
  repo.addNew(con);
    }

    @Override
    public List<Integer> seContract() {
        return repo.seContract();
    }

    @Override
    public List<String> seService() {
        return repo.seService();
    }
}
