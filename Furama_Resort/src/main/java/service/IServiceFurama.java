package service;

import model.Service;

import java.util.List;

public interface IServiceFurama {
    List<Service> findAll();
    void addNew(Service serive);
    List<String> ldv();
    List<String> tkt();
}
