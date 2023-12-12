package repository;

import model.Contract_Detail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailRepository implements IContractDetailRepository {
    public static final String SELECT="select hdc.ma_hop_dong_chi_tiet,hdc.so_luong,hdc.ma_hop_dong,dvk.ten_dich_vu_di_kem\n" +
            "from hop_dong_chi_tiet hdc\n" +
            "join dich_vu_di_kem dvk\n" +
            "on hdc.ma_dich_vu_di_kem = dvk.ma_dich_vu_di_kem;\n";
    public static final String INSERT= "insert into hop_dong_chi_tiet (so_luong,ma_hop_dong,ma_dich_vu_di_kem) values (?,?,?)";
    public Connection conn = BaseRepository.getConnection();
    public List<Contract_Detail> findAll(){
        List<Contract_Detail> contract = new ArrayList<Contract_Detail>();
        Contract_Detail contractDe= null;
        try {
            PreparedStatement ps = conn.prepareStatement(SELECT);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                contractDe = new Contract_Detail();
                contractDe.setIdContractDetail(rs.getInt("ma_hop_dong_chi_tiet"));
                contractDe.setQuantity(rs.getInt("so_luong"));
                contractDe.setIdContract(rs.getInt("ma_hop_dong"));
                contractDe.setBonusService(rs.getString("ten_dich_vu_di_kem"));
                contract.add(contractDe);


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contract;
    }
    public void addNew (Contract_Detail con){
        try {
            PreparedStatement ps = conn.prepareStatement(INSERT);
            ps.setInt(1,con.getQuantity());
            ps.setInt(2,con.getIdContract());
            ps.setInt(3,Trans(con.getBonusService()));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int Trans(String url){
        String SQL= "select dk.ma_dich_vu_di_kem from dich_vu_di_kem dk where dk.ten_dich_vu_di_kem like ? ";
        int count=0;
        try {
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1,url);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                count = rs.getInt("ma_dich_vu_di_kem");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
    public List<Integer> seContract(){
        List<Integer> list = new ArrayList<Integer>();
        String SQL="select hop_dong.ma_hop_dong from hop_dong;";
        try {
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add((rs.getInt("ma_hop_dong")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<String> seService(){
        List<String> list = new ArrayList<String>();
        String SQL="select dvk.ten_dich_vu_di_kem from dich_vu_di_kem dvk;";
        try {
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add((rs.getString("ten_dich_vu_di_kem")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }




}
