package ThucHanh3_Hai;

import java.util.Scanner;

public class Staff extends Employee {
    String role, department;
    float roleAllowanceCoeff; // hệ số phụ cấp chức vụ
    // getter - setter
    public void setDepartment(String department) {this.department = department;}
    public void setRole(String role) {this.role = role;}
    public void setRoleAllowanceCoeff(float roleAllowanceCoeff) {this.roleAllowanceCoeff = roleAllowanceCoeff;}
    public String getDepartment() {return this.department;}
    public String getrole() {return this.role;}
    public float getRoleAllowanceCoeff() {return this.roleAllowanceCoeff;}
    // constructor
    public Staff() {
        super();
        this.role = "Truong phong";
        this.department = "Phong hanh chinh";
        this.roleAllowanceCoeff = 5;
    }
    public Staff(String id, String name, float salaryCoefficent, String role, float roleAllowanceCoeff) {
        super(id, name, salaryCoefficent);
        this.role = role;
        Scanner sc = new Scanner(System.in);
        while (roleAllowanceCoeff < 0) {
            System.out.println("Role allowance coefficent have to greater than zero!");
            System.out.print("Role allowace coefficent: ");
            roleAllowanceCoeff = sc.nextFloat();
        }
        this.roleAllowanceCoeff = roleAllowanceCoeff;
        this.setNumberDayOff(1);
    }
    public Staff(String id, String name, float salaryCoefficent, int yearApply, int numberDayOff, String role, String department, float roleAllowanceCoeff){
        super(id, name, salaryCoefficent, yearApply, numberDayOff);
        this.role = role;
        Scanner sc = new Scanner(System.in);
        while (roleAllowanceCoeff < 0) {
            System.out.println("Role allowance coefficent have to greater than zero!");
            System.out.print("Role allowace coefficent: ");
            roleAllowanceCoeff = sc.nextFloat();
        }
        this.roleAllowanceCoeff = roleAllowanceCoeff;
        this.department = department;
    }
    // methods
    @Override
    public char compettion_Coefficent() { // Tính lại hệ số thi đua
        return 'A';
    }
    @Override
    public double calc_Salary() { // (he so luong + he so phu cap lanh dao) * luong co ban * he so thi dua + phu cap tham nien
        return  (this.salaryCoefficent + this.roleAllowanceCoeff) * this.getGeneralSalary() * 1.0 + this.seniority_Allowance();
    }
    @Override
    public void input() {
        super.input();
        String role, department;
        float roleAllowanceCoeff;
        Scanner sc = new Scanner(System.in);
        System.out.print("Role of staff: "); role = sc.nextLine();
        System.out.print("Department: "); department = sc.nextLine();
        do{
            System.out.print("Role Allowance Coefficent: "); roleAllowanceCoeff = sc.nextFloat();
            if(roleAllowanceCoeff < 0) {
                System.out.println("Role allowance coeff must be positive number. Try again");
            }
        }while(roleAllowanceCoeff < 0);
        this.setRole(role); this.setDepartment(department); this.setRoleAllowanceCoeff(roleAllowanceCoeff);
    }
    @Override
    public void output(){
        System.out.println("\t\t\t\t\t----------------------------------Infomation-------------------------------------\n");
        System.out.printf("%-15s %-25s %-15s %-15s %-20s %-20s %-10s %-15s %-20s %-25s %-15s\n",
                "ID", "Name", "Year apply", "Role", "Department", "Salary coeffient", "Day off", 
                        "Allowance", "Compettion coef", "Role allowance coeff", "Salary");
        System.out.printf("%-15s %-25s %-15s %-15s %-20s %-20s %-10s %-15s %-20s %-25s %-15s\n",
                this.getID(), this.getName(), this.getYearApply(), this.getrole(), this.getDepartment(), 
                this.getSalaryCoefficent(), this.getNumberDayOff(), this.seniority_Allowance(), 
                this.compettion_Coefficent(), this.getRoleAllowanceCoeff(),this.calc_Salary());
    }
}