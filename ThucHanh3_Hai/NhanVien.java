package ThucHanh3_Hai;

public class NhanVien {
    String tenNV, maNV;
    float heSoLuong;
    static float luongcoban = 1150;
    public float getHeSoLuong() {return this.heSoLuong;}
    public String getMaNV() {return this.maNV;}
    public String getTenNV() {return this.tenNV;}
    public float getLuongcoban() {return luongcoban;}
    public void setHeSoLuong(float heSoLuong) {this.heSoLuong = heSoLuong;}
    public void setMaNV(String maNV) {this.maNV = maNV;}
    public void setTenNV(String tenNV) {this.tenNV = tenNV;}
    public void setLuongcoban(float luongcoban) {NhanVien.luongcoban = luongcoban;}
//constructor
    public NhanVien(){
        this.maNV = "NV001"; this.tenNV = "Vo Minh Tri"; this.heSoLuong = (float)2.34;
    }
    public NhanVien(String maNV, String tenNV, float heSoLuong) {
        this.tenNV = tenNV; this.heSoLuong = heSoLuong;
        if(!maNV.matches("^NV\\d+$")) 
            this.maNV = "NV001";
        else this.maNV = maNV;
    }
    public double thunhap() {
        return this.getHeSoLuong() * luongcoban;
    }
    public void xuat(){
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-= Infomation =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
        System.out.printf("%-15s %-20s %-15s %-15s\n", 
        "Ma nhan vien", "Ten nhan vien", "He so luong", "Thu nhap");
        System.out.printf("%-15s %-20s %-15s %-15s\n", 
                this.getMaNV(), this.getTenNV(), this.getHeSoLuong(), this.thunhap());
    }
}
