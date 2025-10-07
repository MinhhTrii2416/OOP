package ThucHanh3_Hai;

import java.time.LocalDate;

public class SinhVien extends Nguoi {
    String maSV;
    private enum HDT{
        DAI_HOC("Dai hoc"), CAO_DANG("Cao dang"), CAO_DANG_NGHE("Cao dang nghe");
        private final String mota; // mô tả
        HDT(String mota){
            this.mota = mota;
        }
        public String getMoTa(){return this.mota;}
    }
    HDT heDaoTao;
    int tongTinChi;
    public void setMaSV(String maSV) {this.maSV = maSV;}
    public void setHeDaoTao(HDT heDaoTao) {this.heDaoTao = heDaoTao;}
    public void setTongTinChi(int tongTinChi) {this.tongTinChi = tongTinChi;}
    public String getMaSV() {return maSV;}
    public HDT getHeDaoTao() {return heDaoTao;}
    public int getTongTinChi() {return tongTinChi;}

    public SinhVien(){
        super();
        this.maSV = "3124410369";
        this.heDaoTao = HDT.DAI_HOC;
        this.tongTinChi = 150;
    }
    public SinhVien(String hoten, LocalDate ngaysinh, String gt, String maSV, int tongTinChi, String hdt){
        super(hoten, ngaysinh, gt);
        this.maSV = maSV;
        if(hdt.equalsIgnoreCase("dai hoc")) { this.heDaoTao = HDT.DAI_HOC; this.tongTinChi = 150;}
        else if(hdt.equalsIgnoreCase("cao dang")) { this.heDaoTao = HDT.CAO_DANG; this.tongTinChi = 100;}
        else if(hdt.equalsIgnoreCase("Cao dang nghe")) { this.heDaoTao = HDT.CAO_DANG_NGHE; this.tongTinChi = 130;}
        else { this.heDaoTao = HDT.DAI_HOC; this.tongTinChi = 150;}
    }

    public long tongHocPhi() {
        if(this.heDaoTao == HDT.DAI_HOC) return 150*200000;
        else if(this.heDaoTao == HDT.CAO_DANG) return 100 * 150000;
        else return 130 * 120000;
    }
    @Override
    public void xuat(){
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-= Infomation =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
        System.out.printf("%-20s %-15s %-15s %-15s %-15s %-15s %-15s\n", 
        "Ho Ten", "Gioi tinh", "Ngay sinh", "Ma sinh vien", 
                "He dao tao", "Tong tin chi", "Tong hoc phi");
        System.out.printf("%-20s %-15s %-15s %-15s %-15s %-15s %-15s\n", 
                this.getHoten(), this.getGioitinh().getMoTa(), this.getNgaysinh(), 
                this.getMaSV(), this.getHeDaoTao().getMoTa(), this.getTongTinChi(), this.tongHocPhi());
    }
}
