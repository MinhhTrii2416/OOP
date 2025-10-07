package ThucHanh3_Hai;

import java.time.LocalDate;

public class Nguoi {
    String hoten;
    LocalDate ngaysinh;
    public enum Sexual{
        NAM("Nam"),
        NU("Nu");
        private String mota;
        Sexual(String mota) { 
            this.mota = mota;
        }
        public String getMoTa(){
            return this.mota;
        }
    }
    Sexual gioitinh;
    public void setNgaysinh(LocalDate ngaysinh) {this.ngaysinh = ngaysinh;}
    public void setGioitinh(Sexual gioitinh) {this.gioitinh = gioitinh;}
    public void setHoten(String hoten) { this.hoten = hoten; }
    public String getHoten() { return hoten; }
    public LocalDate getNgaysinh() {return ngaysinh;}
    public Sexual getGioitinh() {return gioitinh;}
// constructor
    public Nguoi(){
        this.hoten = "Vo Minh Tri"; this.ngaysinh = LocalDate.of(2006, 1, 24);
        this.gioitinh = Sexual.NAM;
    }
    public Nguoi(String hoten, LocalDate ngaysinh, String gt){
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        if(gt.equalsIgnoreCase("nam")) this.gioitinh = Sexual.NAM;
        else if(gt.equalsIgnoreCase("nu")) this.gioitinh = Sexual.NU;
        else this.gioitinh = Sexual.NAM;
    }
// methods
    public void xuat() {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-= Infomation =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
        System.out.printf("%-20s %-15s %-15s\n", 
        "Ho Ten", "Gioi tinh", "Ngay sinh");
        System.out.printf("%-20s %-15s %-15s\n", 
                this.getHoten(), this.getGioitinh().getMoTa(), this.getNgaysinh());
    }
}
