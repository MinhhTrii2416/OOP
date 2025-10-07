package ThucHanh3_Hai;

public class Commodity {
    String cID, cName;
    public void setcID(String cID) {this.cID = cID;}
    public void setcName(String cName) {this.cName = cName;}
    public String getcID() {return this.cID;}
    public String getcName() {return this.cName;}
// constructor
    public Commodity() {
        this.cID = "null"; this.cName = "null";
    }
    public Commodity(String id, String name) {
        if(id.length() > 5 || id.length() < 5) this.cID = "HH001";
        else if(!id.matches("^HH\\d+$")){ // ^HH chuỗi bắt đầu bằng HH | \\d+ là nhiều số nguyên | $ là kết thúc chuỗi
            this.cID = "HH001";
        }
        else this.cID = id;
        this.cName = name;
    }
// methods
    public void output() {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-= Infomation =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
        System.out.printf("%-15s %-20s\n", "Commodity id", "Name of commodity");
        System.out.printf("%-15s %-20s\n", this.getcID(), this.getcName());
    }
}
