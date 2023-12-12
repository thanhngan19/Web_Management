package service;

import model.Service;
import repository.IServiceRepository;
import repository.ServiceRepository;

import java.util.List;

public class ServiceFurama implements IServiceFurama {
    private IServiceRepository service= new ServiceRepository();


    @Override
    public List<Service> findAll() {
        return service.findAll();
    }

    @Override
    public void addNew(Service serive) {
        service.addNew(serive);
    }

    @Override
    public List<String> ldv() {
        return service.ldv();
    }

    @Override
    public List<String> tkt() {
        return service.tkt();
    }
}
