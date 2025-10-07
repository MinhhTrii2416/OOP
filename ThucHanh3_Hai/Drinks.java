package ThucHanh3_Hai;

public class Drinks extends Commodity {
    String donviTinh;
    int soLuong;
    float donGia;
    static float tiLeChetKhau = (float)1.05;
    public void setDonGia(float donGia) {this.donGia = donGia;}
    public void setDonviTinh(String donviTinh) {this.donviTinh = donviTinh;}
    public void setSoLuong(int soLuong) {this.soLuong = soLuong;}
    public void setTiLeChetKhau(float tiLeChetKhau) {Drinks.tiLeChetKhau = tiLeChetKhau;}
    public float getDonGia() {return this.donGia;}
    public String getDonviTinh() {return this.donviTinh;}
    public int getSoLuong() {return this.soLuong;}
    public float getTiLeChetKhau() {return tiLeChetKhau;}
// constructor
    public Drinks() {
        super();
        this.donviTinh = "null";
        this.donGia = -1; this.soLuong = -1;
    }
    public Drinks(String id, String name, String donviTinh, int soLuong, int donGia){
        super(id, name);
        if( !donviTinh.equalsIgnoreCase("ket") &&
            !donviTinh.equalsIgnoreCase("thung") &&
            !donviTinh.equalsIgnoreCase("chai") &&
            !donviTinh.equalsIgnoreCase("lon"))
            this.donviTinh = "ket";
        else this.donviTinh = donviTinh;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
//methods
    public float thanhTien() {
        switch (this.donviTinh) {
            case "chai":
                return this.soLuong * this.donGia/20;
            case "lon":
                return this.soLuong * this.donGia/24;
            default:
                return this.soLuong * this.donGia;
        }
    }
    public float tongTien() {
        return this.thanhTien() * tiLeChetKhau;
    }
    @Override
    public void output(){
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-= Infomation =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
        System.out.printf("%-15s %-20s %-15s %-15s %-15s %-15s\n", 
        "Ma san pham", "Ten hang hoa", "Don vi", "So luong", "Don gia", "Tong Tien");
        System.out.printf("%-15s %-20s %-15s %-15s %-15s %-15s\n", 
                this.getcID(), this.getcName(), this.getDonviTinh(), this.getSoLuong(), this.getDonGia(), this.tongTien());
    }
}
