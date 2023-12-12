package repository;

import model.CategoryService;

import java.util.List;

public interface ICategoryRepository {
    List<CategoryService> findAll();
    String selectById(int id);
}
