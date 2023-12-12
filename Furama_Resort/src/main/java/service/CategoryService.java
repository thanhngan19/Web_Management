package service;

import repository.CategoryRepository;
import repository.ICategoryRepository;

import java.util.List;

public class CategoryService implements ICategoryService{
    private ICategoryRepository repo= new CategoryRepository();
    @Override
    public List<model.CategoryService> findAll() {
        return repo.findAll();
    }

    @Override
    public String selectById(int id) {
        return repo.selectById(id);
    }
}
