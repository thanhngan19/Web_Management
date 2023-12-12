package repository;

import model.CategoryService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ICategoryRepository{
    public Connection conn = BaseRepository.getConnection();
    private static final String SELECT="select * from loai_dich_vu";
    private static final String SELECT_BY_ID="select * from loai_dich_vu where loai_dich_vu.ma_loai_dich_vu=?";
    @Override
    public List<CategoryService> findAll() {
        CategoryService cate= null;
        List<CategoryService> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(SELECT);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                cate = new CategoryService();
                cate.setId(rs.getInt("ma_loai_dich_vu"));
                cate.setName(rs.getString("ten_loai_dich_vu"));
                list.add(cate);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public String selectById(int id) {
        String name = null;
        try {
            PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                name = rs.getString("ten_loai_dich_vu");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return name;
    }
}
