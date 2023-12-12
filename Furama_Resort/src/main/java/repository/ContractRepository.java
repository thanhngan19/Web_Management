package repository;

import model.Contracts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository implements IContractRepository{
    public static final String SELECT="select hd.ma_hop_dong,hd.ngay_lam_hop_dong,hd.ngay_ket_thuc,hd.tien_dat_coc,nv.ho_ten as ho_ten_nhan_vien ,kh.ho_ten as ho_ten_khach_hang,dv.ten_dich_vu\n" +
            "from hop_dong hd\n" +
            "join nhan_vien nv\n" +
            "on hd.ma_nhan_vien= nv.ma_nhan_vien\n" +
            "join khach_hang kh\n" +
            "on hd.ma_khach_hang= kh.ma_khach_hang\n" +
            "join dich_vu dv \n" +
            "on hd.ma_dich_vu= dv.ma_dich_vu;";
    public static final String INSERT="insert into hop_dong(ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,ma_nhan_vien,ma_khach_hang,ma_dich_vu) values (?,?,?,?,?,?);";
    public static final String SE_MNV= "select nv.ma_nhan_vien from nhan_vien nv where nv.ho_ten like ? ";
    public static final String SE_KH="select kh.ma_khach_hang from khach_hang kh where kh.ho_ten like ?";
    public static final String SE_DV="select dv.ma_dich_vu from dich_vu dv where dv.ten_dich_vu like ?";



    private Connection conn = BaseRepository.getConnection();
    @Override
    public List<Contracts> findAll() {
        List<Contracts> contract= new ArrayList<Contracts>();
        Contracts contracts=null;
        try {
            PreparedStatement ps = conn.prepareStatement(SELECT);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                contracts = new Contracts();
                contracts.setMhd(rs.getInt("ma_hop_dong"));
                contracts.setStartdate(String.valueOf(rs.getDate("ngay_lam_hop_dong")));
                contracts.setEnddate(String.valueOf(rs.getDate("ngay_ket_thuc")));
                contracts.setTdc(rs.getDouble("tien_dat_coc"));
                contracts.setTnv(rs.getString("ho_ten_nhan_vien"));
                contracts.setTkh(rs.getString("ho_ten_khach_hang"));
                contracts.setTdv(rs.getString("ten_dich_vu"));
                contract.add(contracts);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contract;
    }

    @Override
    public void addAll(Contracts contract) {
        try {
            PreparedStatement ps = conn.prepareStatement(INSERT);
//            ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,ma_nhan_vien,ma_khach_hang,ma_dich_vu
            ps.setString(1, contract.getStartdate());
            ps.setString(2, contract.getEnddate());
            ps.setString(3, String.valueOf(contract.getTdc()));
            ps.setString(4, String.valueOf(seNv(contract.getTnv())));
            ps.setString(5, String.valueOf(seKh(contract.getTkh())));
            ps.setString(6, String.valueOf(seDv(contract.getTdv())));
          ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public int seNv(String url) {
        int mnv=0;
        try {
            PreparedStatement ps = conn.prepareStatement(SE_MNV);
            ps.setString(1,url);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                mnv= rs.getInt("ma_nhan_vien");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return mnv;
    }

    @Override
    public int seKh(String url) {
        int count=0;
        try {
            PreparedStatement ps = conn.prepareStatement(SE_KH);
            ps.setString(1, url);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                count= rs.getInt("ma_khach_hang");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    @Override
    public int seDv(String url) {
        int count =0;
        try {
            PreparedStatement ps = conn.prepareStatement(SE_DV);
            ps.setString(1, url);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                count = rs.getInt("ma_dich_vu");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return count;
    }

    @Override
    public List<String> khachHang() {
        List<String> list = new ArrayList<String>();
        String SQL="select kh.ho_ten from khach_hang kh;";
        try {
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next()) {
                list.add(rs.getString("ho_ten"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<String> dichVu() {
        List<String> list = new ArrayList<String>();
        try {
            PreparedStatement ps = conn.prepareStatement("select dv.ten_dich_vu from dich_vu dv;");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(rs.getString("ten_dich_vu"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<String> nhanVien() {
        List<String> list = new ArrayList<String>();
        try {
            PreparedStatement ps= conn.prepareStatement("select nv.ho_ten from nhan_vien nv ");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                list.add(rs.getString("ho_ten"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
//    @Override
//    public List<String> nhanVien(){
//        List<String> list = new ArrayList<String>();
//        try {
//            PreparedStatement ps= conn.prepareStatement("select nv.ho_ten from nhan_vien nv ");
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()) {
//                list.add(rs.getString("ho_ten"));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return list;
//    }
//    @Override
//    public List<String> khachHang(){
//        List<String> list = new ArrayList<String>();
//        String SQL="select kh.ho_ten from khach_hang kh;";
//        try {
//            PreparedStatement ps = conn.prepareStatement(SQL);
//            ResultSet rs= ps.executeQuery();
//            while(rs.next()) {
//                list.add(rs.getString("ho_ten"));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return list;
//    }
//@Override
//    public List<String> dichVu(){
//        List<String> list = new ArrayList<String>();
//        try {
//            PreparedStatement ps = conn.prepareStatement("select dv.ten_dich_vu from dich_vu dv;");
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                list.add(rs.getString("ten_dich_vu"));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return list;
//    }
}
