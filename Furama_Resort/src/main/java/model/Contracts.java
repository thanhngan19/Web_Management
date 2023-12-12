package model;

public class Contracts {
//    select hd.ma_hop_dong,hd.ngay_lam_hop_dong,hd.ngay_ket_thuc,hd.tien_dat_coc,nv.ho_ten,kh.ho_ten,dv.ten_dich_vu
//    from hop_dong hd
//    join nhan_vien nv
//    on hd.ma_nhan_vien= nv.ma_nhan_vien
//    join khach_hang kh
//    on hd.ma_khach_hang= kh.ma_khach_hang
//    join dich_vu dv
//    on hd.ma_dich_vu= dv.ma_dich_vu;
    private int mhd;
    private String startdate;
    private String enddate;
    private Double tdc;
    private String tnv;
    private String tkh;
    private String tdv;

    public Contracts(int mhd, String startdate, String enddate, Double tdc, String tnv, String tkh, String tdv) {
        this.mhd = mhd;
        this.startdate = startdate;
        this.enddate = enddate;
        this.tdc = tdc;
        this.tnv = tnv;
        this.tkh = tkh;
        this.tdv = tdv;
    }

    public Contracts(String startdate, String enddate, Double tdc, String tnv, String tkh, String tdv) {
        this.startdate = startdate;
        this.enddate = enddate;
        this.tdc = tdc;
        this.tnv = tnv;
        this.tkh = tkh;
        this.tdv = tdv;
    }

    public Contracts() {
    }

    public int getMhd() {
        return mhd;
    }

    public void setMhd(int mhd) {
        this.mhd = mhd;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public Double getTdc() {
        return tdc;
    }

    public void setTdc(Double tdc) {
        this.tdc = tdc;
    }

    public String getTnv() {
        return tnv;
    }

    public void setTnv(String tnv) {
        this.tnv = tnv;
    }

    public String getTkh() {
        return tkh;
    }

    public void setTkh(String tkh) {
        this.tkh = tkh;
    }

    public String getTdv() {
        return tdv;
    }

    public void setTdv(String tdv) {
        this.tdv = tdv;
    }
}
