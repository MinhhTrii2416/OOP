package DanhSachLop;

import java.util.Comparator;
import java.util.Scanner;

public class Diem2D {
    private float x, y;
    public float getX() {return x;}
    public float getY() {return y;}
    public void setX(float x) {this.x = x;}
    public void setY(float y) {this.y = y;}

    // constructor
    public Diem2D() { this.x = 0; this.y = 0;}
    public Diem2D(float x, float y) {
        this.x = x; this.y = y;
    }

    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap diem x: ");
        setX(sc.nextFloat());
        System.out.print("Nhap diem y: ");
        setY(sc.nextFloat());
    }

    public void xuat() {
        float x =  this.getX();
        float y =  this.getY();
        System.out.println("Diem ( "+ x +" ; "+ y +" ) co khoang cach la "+ String.format("%.2f", this.length()));;
}

    // tính khoảng cách tới gốc tọa độ
    public double length(){
        return Math.sqrt(this.getX()*this.getX() + this.getY()*this.getY());
    }

    public static Comparator<Diem2D> length = new Comparator<Diem2D>() {
        @Override
        public int compare (Diem2D x, Diem2D y){
            if(x.length() < y.length())
                return 1;
            else if (x.length() > y.length()) 
                return -1;
            else {
                return x.getX() > y.getX() ? -1 : (x.getX() < y.getX() ? 1 : 0);
            }
        }
    };
}
