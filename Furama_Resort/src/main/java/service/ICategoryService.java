package service;

import model.CategoryService;

import java.util.List;

public interface ICategoryService {
    List<CategoryService> findAll();
    String selectById(int id);
}
