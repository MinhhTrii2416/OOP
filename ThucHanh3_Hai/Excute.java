package ThucHanh3_Hai;

import java.util.Scanner;
public class Excute {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int chon;

        do {
            System.out.println("========================================= MENU BAI TAP ======================================");
            System.out.println("1. Bai tap 1: Xay dung lop Nhan Vien(Employee)");
            System.out.println("2. Bai tap 2: Xay dung lop can bo quan ly (Staff) dua tren lop Employee");
            System.out.println("3. Bai tap 3: Xay dung lop hang hoa(Commodity) va nuoc giai khat(Drinks)");
            System.out.println("4. Bai tap 4: Xay dung lop NhanVien va lop CBLanhDao");
            System.out.println("5. Bai tap 5: Xay dung lop Nguoi va lop SinhVien");
            System.out.println("0. Thoat");
            System.out.print("Chon bai tap (0-5): ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    Employee employee = new Employee();
                    employee.input();
                    employee.output();
                    break;
                case 2:
                    Staff staff = new Staff();
                    staff.input();
                    staff.output();
                    break;
                case 3:
                    Drinks drinks = new Drinks();
                    drinks.output();
                    break;
                case 4:
                    CBLanhDao cbLanhDao = new CBLanhDao();
                    cbLanhDao.xuat();
                    break;
                case 5:
                    SinhVien sinhvien = new SinhVien();
                    sinhvien.xuat();
                    break;
                case 0:
                    System.out.println("Ket thuc chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
            if(chon != 0)
                for(int i=0; i<=10; i++)
                    System.out.println();
        } while (chon != 0);
    }
}
