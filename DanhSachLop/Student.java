package DanhSachLop;

import java.util.Comparator;

public class Student {
    private String SBD, HT;
    private int NamSinh;
    private float Toan, Van, NN;

    public void setSBD(String sbd){this.SBD = sbd;}
    public void setHT(String ten){this.HT = ten;}
    public void setNamSinh(int namsinh){this.NamSinh = namsinh;}
    public void setToan(float toan){this.Toan = toan;}
    public void setVan(float van){this.Van = van;}
    public void setNN(float nn){this.NN = nn;}
    public String getSBD() {return this.SBD;}
    public String getHT() {return this.HT;}
    public int getNamSinh() {return this.NamSinh;}
    public float getToan() {return this.Toan;}
    public float getVan() {return this.Van;}
    public float getNN() {return this.NN;}
    public String getTen() {
        this.HT = this.HT.trim(); // loại bỏ khoảng trắng đầu/cuối
        String[] parts = this.HT.split("\\s+"); // tách theo khoảng trắng
        return parts[parts.length - 1]; // lấy phần tử cuối cùng
    }
    
    public Student(){}
    public Student(String ten, String sbd, int namSinh, float toan, float van, float nn){
        this.HT = ten; this.SBD = sbd; this.NamSinh = namSinh;
        this.Toan = toan; this.Van = van; this.NN = nn;
    }
    public Student(Student t){
        this.HT = t.HT; this.SBD = t.SBD;
        this.NN = t.NN;
        this.NamSinh = t.NamSinh;
        this.Toan = t.Toan;
        this.Van = t.Van;
    }
    // cau b
    public float tong_diem() {
        return this.Toan + this.Van + this.NN*2;
    }
    // cau c
    public String ketqua() {
        if(this.tong_diem() <= 25) return "Rot";
        return "Dau";
    }
    // cau d
    public void Xuat() {
            System.out.print("SBD: "+ this.getSBD());
            System.out.print("\tHo Ten: "+ this.getHT());
            System.out.print("\tNam sinh: "+ this.getNamSinh());
            System.out.print("\tDiem Toan: "+ this.getToan());
            System.out.print("\tDiem Van: "+ this.getVan());
            System.out.print("\tDiem Ngoai Ngu: "+ this.getNN());
            System.out.print("\tTong diem 3 mon: "+ this.tong_diem());
            System.out.println("\tket qua: "+ this.ketqua());
    }

    public static Comparator<Student> total = new Comparator<Student>() {
        @Override
        public int compare(Student t1, Student t2){
            if(t2.tong_diem() < t1.tong_diem()) return -1;
            else if(t2.tong_diem() == t1.tong_diem()) return 0;
            else return 1;
        }
    };

    public static Comparator<Student> name = new Comparator<Student>() {
        @Override
        public int compare(Student n1, Student n2){
            int temp = n1.getTen().compareToIgnoreCase(n2.getTen());
            if(temp != 0)
                return temp;
            else
                return n1.getToan() < n2.getToan() ? 1 : (n1.getToan() > n2.getToan() ? -1 : 0);
        }
    };
}
