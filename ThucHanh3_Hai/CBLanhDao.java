package ThucHanh3_Hai;

public class CBLanhDao extends NhanVien {
    String chucvu; int thamNien;
    public String getChucvu() { return chucvu; }
    public int getThamNien() { return thamNien; }
    public void setChucvu(String chucvu) { this.chucvu = chucvu; }
    public void setThamNien(int thamNien) { this.thamNien = thamNien; }
// constructor
    public CBLanhDao() {
        this.maNV = "NV009"; this.tenNV = "Dieu Hien";
        this.heSoLuong = (float)4.67; this.chucvu = "Giam doc";
        this.thamNien = 10;
    }

    public float heSoLanhDao() {
        if(this.getChucvu().equalsIgnoreCase("Giam doc"))
            return (float)7.0;
        else if(this.getChucvu().equalsIgnoreCase("Truong phong"))
            return (float)6.0;
        else if(this.getChucvu().equalsIgnoreCase("Pho phong"))
            return (float)4.5;
        else
            return (float)1.0;
    }

    public float phuCapLanhDao() {
        return 1500 * this.heSoLanhDao();
    }

    @Override
    public double thunhap() {
        return super.thunhap() + phuCapLanhDao();
    }

    @Override
    public void xuat() {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-= Infomation =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
        System.out.printf("%-15s %-20s %-15s %-15s %-15s\n", 
        "Ma nhan vien", "Ten nhan vien", "He so luong", "Thu nhap", "Chuc vu");
        System.out.printf("%-15s %-20s %-15s %-15s %-15s\n", 
                this.getMaNV(), this.getTenNV(), this.getHeSoLuong(), this.thunhap(), this.getChucvu());
    }
}
