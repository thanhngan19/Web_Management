package repository;

import model.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements IServiceRepository{
    public Connection conn= BaseRepository.getConnection();
    public static final String SELECT="select dv.ma_dich_vu,dv.ten_dich_vu,dv.dien_tich,dv.chi_phi_thue,dv.so_nguoi_toi_da,kt.ten_kieu_thue,\n" +
            "ldv.ten_loai_dich_vu,dv.tieu_chuan_phong,dv.mo_ta_tien_nghi_khac,dv.dien_tich_ho_boi,dv.so_tang\n" +
            "from dich_vu dv\n" +
            "join kieu_thue kt\n" +
            "on dv.ma_kieu_thue= kt.ma_kieu_thue\n" +
            "join loai_dich_vu ldv\n" +
            "on dv.ma_loai_dich_vu= ldv.ma_loai_dich_vu;";
public static final String LDV="select ldv.ten_loai_dich_vu   from loai_dich_vu ldv;";
public static final String TKT="select tkt.ten_kieu_thue   from kieu_thue tkt;";
public static final String TRANS_KT="select tkt.ma_kieu_thue   from kieu_thue tkt where tkt.ten_kieu_thue like ?;";
public static final String TRANS_LDV="select ldv.ma_loai_dich_vu from loai_dich_vu ldv where ldv.ten_loai_dich_vu like ?;";
public static final String INSERT="insert into dich_vu  (ten_dich_vu,dien_tich,chi_phi_thue,so_nguoi_toi_da,ma_kieu_thue,ma_loai_dich_vu,tieu_chuan_phong,mo_ta_tien_nghi_khac,dien_tich_ho_boi,so_tang)" +
        " values(?,?,?,?,?,?,?,?,?,?)";
    @Override
    public List<Service> findAll() {
        Service service =null;
        List<Service> result = new ArrayList<Service>();
        try {
            PreparedStatement ps = conn.prepareStatement(SELECT);
            ResultSet rs= ps.executeQuery();
            while(rs.next()) {
                service = new Service();
                service.setMaDv(rs.getInt("ma_dich_vu"));
                service.setName(rs.getString("ten_dich_vu"));
                service.setSquare(String.valueOf(rs.getInt("dien_tich")));
                service.setChiPhiThue(Double.parseDouble(rs.getString("chi_phi_thue")));
                service.setSoNguoi(rs.getInt("so_nguoi_toi_da"));
                service.setKieuThue(rs.getString("ten_kieu_thue"));
                service.setDichVu(rs.getString("ten_loai_dich_vu"));
                service.setStandardRoom(rs.getString("tieu_chuan_phong"));
                service.setDiff(rs.getString("mo_ta_tien_nghi_khac"));
                service.setSquareOfSwin(rs.getString("dien_tich_ho_boi"));
                service.setSoTang(rs.getInt("so_tang"));
                result.add(service);



            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public void addNew(Service service) {
        try {
            PreparedStatement ps = conn.prepareStatement(INSERT);
            ps.setString(1, service.getName());
            ps.setString(2, service.getSquare());
            ps.setString(3, String.valueOf(service.getChiPhiThue()));
            ps.setInt(4,service.getSoNguoi());
            ps.setInt(5,transKt(service.getKieuThue()));
            ps.setInt(6,transLdv(service.getDichVu()));
            ps.setString(7,service.getStandardRoom());
            ps.setString(8,service.getDiff());
            ps.setString(9,service.getSquareOfSwin());
            ps.setInt(10,service.getSoTang());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<String> ldv(){
        List<String> ldv= new ArrayList<String>();
        try {
            PreparedStatement ps = conn.prepareStatement(LDV);
            ResultSet rs= ps.executeQuery();
            while(rs.next()) {
                ldv.add(rs.getString("ten_loai_dich_vu"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ldv;

    }
    public List<String> tkt(){
        List<String> tkt= new ArrayList<String>();
        try {
            PreparedStatement ps = conn.prepareStatement(TKT);
            ResultSet rs= ps.executeQuery();
            while(rs.next()) {
                tkt.add(rs.getString("ten_kieu_thue"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tkt;

    }
    public int transKt(String url){
        int count=0;
        try {
            PreparedStatement ps = conn.prepareStatement(TRANS_KT);
            ps.setString(1, url);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                count= rs.getInt("ma_kieu_thue");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
return count;

    }
    public int transLdv(String url){
        int count=0;
        try {
            PreparedStatement ps = conn.prepareStatement(TRANS_LDV);
            ps.setString(1, url);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                count= rs.getInt("ma_loai_dich_vu");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;

    }

}
