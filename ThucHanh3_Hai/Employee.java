package ThucHanh3_Hai;

import java.time.LocalDate;
import java.util.Scanner;

public class Employee {
    String ID, name;
    int yearApply, numberDayOff;
    float salaryCoefficent;
    static int generalSalary = 1150;

    public String getID() {return this.ID;}
    public String getName() {return this.name;}
    public int getNumberDayOff() {return this.numberDayOff;}
    public float getSalaryCoefficent() {return this.salaryCoefficent;}
    public int getYearApply() {return this.yearApply;}
    public void setID(String iD) {this.ID = iD;}
    public int getGeneralSalary() {return generalSalary;}
    public void setName(String name) {this.name = name;}
    public void setNumberDayOff(int numberDayOff) {this.numberDayOff = numberDayOff;}
    public void setSalaryCoefficent(float salaryCoefficent) {this.salaryCoefficent = salaryCoefficent;}
    public void setYearApply(int yearApply) {this.yearApply = yearApply;}
    public void setGeneralSalary(int generalSalary) {Employee.generalSalary = generalSalary;}

// constructor
    public Employee() {
        this.ID = "null"; this.name = "null";
        this.yearApply = -1; this.numberDayOff = -1; this.salaryCoefficent = -1;
    }
    public Employee(String id, String name, float salaryCoefficent){
        this.ID = id; this.name = name;
        Scanner sc = new Scanner(System.in);
        while (salaryCoefficent < 0) {
            System.out.println("Salary Coefficent have to greater than zero!");
            System.out.print("Salary coefficent: ");
            salaryCoefficent = sc.nextFloat();
        }
        this.salaryCoefficent = salaryCoefficent;
        this.yearApply = LocalDate.now().getYear();
        this.numberDayOff = 0;
    }
    public Employee(String id, String name, float salaryCoefficent, int yearApply, int numberDayOff){
        this.ID = id; this.name = name; 
        Scanner sc = new Scanner(System.in);
        while (salaryCoefficent < 0) {
            System.out.println("Salary Coefficent have to greater than zero! Try agian");
            System.out.print("Salary coefficent: ");
            salaryCoefficent = sc.nextFloat();
        }
        this.salaryCoefficent = salaryCoefficent;
        while (numberDayOff < 0) {
            System.out.println("Number of day off have to greater than zero! Try again");
            System.out.print("Number of day off: ");
            numberDayOff = sc.nextInt();
        }
        this.numberDayOff = numberDayOff;
        while (yearApply < 0 || yearApply > LocalDate.now().getYear()) {
            System.out.println("Year apply isn't valid! Try again");
            System.out.print("Year apply: ");
            yearApply = sc.nextInt();
        }
        this.yearApply = yearApply;
    }

    public float seniority_Allowance() { // phụ cấp thâm niên
        int year = LocalDate.now().getYear()-this.yearApply;
        if(year >=5) 
            return (float)year*generalSalary/100;
        else
            return 0;
    }

    public char compettion_Coefficent() { // hệ số thi đua
        return this.numberDayOff <= 1 ? 'A' : (this.numberDayOff <= 3 ? 'B' : 'C'); 
    }

    public double calc_Salary() {
        if(this.compettion_Coefficent() == 'A')
            return this.getGeneralSalary() * this.salaryCoefficent * 1.0 + this.seniority_Allowance();
        else if(this.compettion_Coefficent() == 'B')
            return this.getGeneralSalary() * this.salaryCoefficent * 0.75 + this.seniority_Allowance();
        else
            return this.getGeneralSalary() * this.salaryCoefficent * 0.5 + this.seniority_Allowance();
    }

    public void input() {
        String id, name;
        int yearApply=0, numberDayOff=0;
        float salaryCoefficent=0;

        Scanner sc = new Scanner(System.in);
        System.out.print("ID: "); id = sc.nextLine();
        System.out.print("Name: "); name = sc.nextLine();

        do{
            System.out.print("Year apply: "); yearApply = sc.nextInt();
            if(yearApply < 0 || yearApply > LocalDate.now().getYear()){
                System.out.println("Year apply isn't valid! Try again");
                continue;
            }

            System.out.print("Salary coefficent: "); salaryCoefficent = sc.nextFloat();
            if(salaryCoefficent < 0){
                System.out.println("Salary Coefficent have to greater than zero! Try agian");
                continue;
            }

            System.out.print("Number of day off: "); numberDayOff = sc.nextInt();
            if(numberDayOff < 0){
                System.out.println("Number day off have to greater than zero! Try agian");
                continue;
            }
        }while(yearApply < 0 || yearApply > LocalDate.now().getYear() || salaryCoefficent < 0 || numberDayOff < 0);
        this.setID(id); this.setName(name);
        this.setNumberDayOff(numberDayOff);
        this.setSalaryCoefficent(salaryCoefficent);
        this.setYearApply(yearApply);
    }

    public void output() {
        System.out.println("\t\t\t\t\t----------------------------------Infomation-------------------------------------\n");
        System.out.printf("%-15s %-25s %-15s %-20s %-10s %-15s %-20s %-15s\n",
                "ID", "Name", "Year apply", "Salary coeffient", "Day off", "Allowance", "Compettion coef", "Salary");
        System.out.printf("%-15s %-25s %-15s %-20s %-10s %-15s %-20s %-15s\n",
                this.getID(), this.getName(), this.getYearApply(), this.getSalaryCoefficent(), this.getNumberDayOff(),
                this.seniority_Allowance(), this.compettion_Coefficent(), this.calc_Salary());
    }
}
