package minhnqph38692.fpoly.du_an1_nhom10_doan.DTO;

public class DoAn_DTO {
    private String madoan;
    private String tendoan;
    private int giadoan;
    private int maloai;
    private String tenloai;
    private String thongtin;

    public DoAn_DTO() {
        this.madoan = madoan;
        this.tendoan = tendoan;
        this.giadoan = giadoan;
        this.maloai = maloai;
        this.tenloai = tenloai;
        this.thongtin=thongtin;
    }

    public String getMadoan() {
        return madoan;
    }

    public void setMadoan(String madoan) {
        this.madoan = madoan;
    }

    public String getTendoan() {
        return tendoan;
    }

    public void setTendoan(String tendoan) {
        this.tendoan = tendoan;
    }

    public int getGiadoan() {
        return giadoan;
    }

    public void setGiadoan(int giadoan) {
        this.giadoan = giadoan;
    }

    public int getMaloai() {
        return maloai;
    }

    public void setMaloai(int maloai) {
        this.maloai = maloai;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    public String getThongtin() {
        return thongtin;
    }

    public void setThongtin(String thongtin) {
        this.thongtin = thongtin;
    }
}
