package validate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Validator {
    public static  boolean test(int mhd){
        List<Integer> test = new ArrayList<Integer>();
        String SQL= "select hdct.ma_hop_dong from hop_dong_chi_tiet hdct where hdct.ma_hop_dong=?; ";
        Connection conn = BaseRepository.getConnection();
        try {
            PreparedStatement  ps = conn.prepareStatement(SQL);
            ps.setInt(1,mhd);
            ResultSet rs= ps.executeQuery();
            while(rs.next()) {
                test.add(rs.getInt("ma_hop_dong"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        boolean list= test!=null;
        return list;
    }
}
