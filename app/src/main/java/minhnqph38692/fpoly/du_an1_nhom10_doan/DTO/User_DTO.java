package minhnqph38692.fpoly.du_an1_nhom10_doan.DTO;

public class User_DTO {
    String MaND;
    String HoTen;
    String MatKhau;
    String Email;
    String NamSinh;
    String SDT;

    public User_DTO(String maND, String hoTen, String matKhau, String email, String namSinh, String SDT) {
        MaND = maND;
        HoTen = hoTen;
        MatKhau = matKhau;
        Email = email;
        NamSinh = namSinh;
        this.SDT = SDT;
    }

    public User_DTO() {
    }

    public String getMaND() {
        return MaND;
    }

    public void setMaND(String maND) {
        MaND = maND;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNamSinh() {
        return NamSinh;
    }

    public void setNamSinh(String namSinh) {
        NamSinh = namSinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
}
