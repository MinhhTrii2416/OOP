package ThucHanh3_Hai;

import java.text.DecimalFormat;
import java.util.Scanner;

public class NhanVienMau extends Nguoi_Mau {
    String emID; float hsl, salary;
// getter - setter
    public void setEmID(String id) {this.emID = id;}
    public void setHSL(float hsl) {this.hsl = hsl;}
    public String getEmID() {return this.emID;}
    public float getHSL() {return this.hsl;}
    public float getSalary() {return this.salary;}
    // calculate salary
    private void calc_Salary() { this.salary = this.hsl * 2000000;}
// constructor
    public NhanVienMau() {
        super();
        this.emID = "none"; this.hsl = -1; this.salary = -1;
    }
    public NhanVienMau(String name, String cccd, String birthday, String id, float hsl){
        super(name, cccd, birthday);
        this.emID = id; this.hsl = hsl;
        this.calc_Salary();
    }
    @Override
    public void setINFO() {
        super.setINFO();
        Scanner sc = new Scanner(System.in);
        System.out.print("Employee id: ");
        this.setEmID(sc.nextLine());
        System.out.print("Salary coefficient: ");
        this.setHSL(sc.nextFloat());
        this.calc_Salary();
    }
    @Override
    public void getINFO(){
        super.getINFO();
        DecimalFormat df = new DecimalFormat("#");
        System.out.println("Employee ID: "+ this.getEmID() +"\nsalary coefficient: "+ 
                            this.getHSL() +"\ncurrent salary: "+df.format(this.getSalary()));
    }
}
