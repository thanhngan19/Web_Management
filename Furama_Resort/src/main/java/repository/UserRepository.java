package repository;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository implements IUserRepository{
    public Connection conn = BaseRepository.getConnection();
    private static final String SELECT="select * from user where user.user_name=?";
    @Override
    public boolean checkPass(User userCheck) {
        boolean check= false;
        User userFind = null;
        try {
            PreparedStatement ps = conn.prepareStatement(SELECT);
            ps.setString(1, userCheck.getUserName());
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                userFind = new User();
                userFind.setUserName(rs.getString("user_name"));
                userFind.setPassword(rs.getString("pass_word"));
            }
            if(userFind.getUserName()==null){
                check= false;
            }
            if(userFind.getPassword()!= userCheck.getPassword()){
                check= false;
            }
            if(userFind.getPassword().equals(userCheck.getPassword()) && userFind.getUserName().equals( userCheck.getUserName())){
                check=true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return check;
    }
}
