package ThucHanh3_Hai;

import java.util.Scanner;

public class Nguoi_Mau {
    String name, cccd, birthday;
// getter - setter
    public void setName(String name) {this.name = name;}
    public void setCCCD(String CCCD) {this.cccd = CCCD;}
    public void setBirthday(String Brithday) {this.birthday = Brithday;}
    public String getName() {return this.name;}
    public String getCCCD() {return this.cccd;}
    public String getBirthday() {return this.birthday;}
// constructor
    public Nguoi_Mau() {
        this.birthday = "no date"; this.cccd = "no id"; this.name = "no name";
    }
    public Nguoi_Mau(String name, String cccd, String birthday){
        this.birthday = birthday; this.name = name; this.cccd = cccd;
    }
    public Nguoi_Mau(Nguoi_Mau h) {
        this.name = h.name; this.birthday = h.birthday; this.cccd = h.cccd;
    }
// input - output
    public void setINFO() {
        Scanner sc = new Scanner(System.in);
        // nhap name
        System.out.print("name: ");
        this.setName(sc.nextLine());
        // nhap cccd
        System.out.print("CCCD: ");
        this.setCCCD(sc.nextLine());
        // nhap birthday
        System.out.print("Birthday: ");
        this.setBirthday(sc.nextLine());
    }
    public void getINFO() {
        System.out.println("Name: "+ this.getName() +"\nCMND: "+ this.getCCCD() +"\nNgay sinh: "+this.getBirthday());
    }
}
