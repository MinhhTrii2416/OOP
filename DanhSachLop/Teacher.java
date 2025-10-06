package DanhSachLop;

import java.util.Comparator;

public class Teacher {
    private String name;
    private int group_num;

    public String getName(){return this.name;}
    public int getGroup_num(){return this.group_num;}
    public void setName(String name){this.name=name;}
    public void setGroup_num(int group_num){this.group_num=group_num;}

    public Teacher(){}
    public Teacher(String name, int group_num){
        this.name = name;
        this.group_num = group_num;
    }

    // public static Comparator<Teacher> TeacherName = new Comparator<Teacher>() {
    //     @Override
    //     public 
    // };
    public static Comparator<Teacher> TGroup_num = new Comparator<Teacher>() {
        @Override
        public int compare(Teacher g1, Teacher g2){
            if(g1.group_num < g2.group_num) return -1;
            else if(g1.group_num == g2.group_num) return 0;
            else return 1;
        }
    };

    public static Comparator<Teacher> T_name = new Comparator<Teacher>() {
        @Override
        public int compare(Teacher n1, Teacher n2) {
            return n1.getName().compareTo(n2.getName());
        }
    };
}
