package DanhSachLop;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class StudentList {
    ArrayList<Student> StuList = new ArrayList<>();
    public void setStuList(ArrayList<Student> Stu) {this.StuList = Stu;}
    public ArrayList<Student> getStuList(){return this.StuList;}

    public StudentList(){
        super();
        this.StuList = new ArrayList<>();
    }
// cau b
    public void ReadXML() throws ParserConfigurationException, SAXException, IOException {
        File xmlFile = new File("D:\\BaiTap_OOP\\DanhSachLop\\studentList.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        org.w3c.dom.Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        System.out.println("Root: "+ doc.getDocumentElement().getNodeName());
        NodeList nodeList = doc.getElementsByTagName("ThiSinh");

        System.out.println("----------------------");

        for(int i=0; i<nodeList.getLength(); i++){
            Student stu = new Student();
            Node node = nodeList.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE)
            {
                org.w3c.dom.Element element = (org.w3c.dom.Element)node;
                stu.setHT(element.getElementsByTagName("HT").item(0).getTextContent());
                stu.setSBD(element.getElementsByTagName("SBD").item(0).getTextContent());
                stu.setNamSinh(Integer.parseInt(element.getElementsByTagName("NamSinh").item(0).getTextContent()));
                stu.setToan(Float.parseFloat(element.getElementsByTagName("Toan").item(0).getTextContent()));
                stu.setVan(Float.parseFloat(element.getElementsByTagName("Van").item(0).getTextContent()));
                stu.setNN(Float.parseFloat(element.getElementsByTagName("NN").item(0).getTextContent()));
            }
            StuList.add(stu);
        }
    }
// cau a
    public void nhapDS(){
        Scanner sc = new Scanner(System.in);
        int length;
        System.out.print("Nhap so luong sinh vien: ");
        length = sc.nextInt();
        sc.nextLine();
        Student student = new Student();
        for(int i = 0; i<length; i++){
            System.out.print("Nhap ho ten: ");
            student.setHT(sc.nextLine());
            System.out.print("Nhap so bao danh: ");
            student.setSBD(sc.nextLine());
            System.out.print("Nhap ngay sinh: ");
            student.setNamSinh(sc.nextInt());
            System.out.print("Nhap diem toan: ");
            student.setToan(sc.nextFloat());
            System.out.print("Nhap diem van: ");
            student.setVan(sc.nextFloat());
            System.out.print("Nhap diem ngoai ngu: ");
            student.setNN(sc.nextFloat());

            StuList.add(student);
        }
    }
//cau c
    public void xuatDS(){
        for(Student stu: StuList) {
            stu.Xuat();
        }
    }
// cau d
    public void total_sort() {
        Collections.sort(StuList, Student.total);
        xuatDS();
    }
// cau e
    public void name_sort() {
        Collections.sort(StuList, Student.name);
        xuatDS();
    }
// cau f
    public ArrayList<Student> passExam_list() {
        ArrayList<Student> passExam = new ArrayList<>();
        for(Student t: StuList){
            if(t.ketqua().equalsIgnoreCase("Dau"))
                t.Xuat();
                passExam.add(t);
        }
        return passExam;
    }
// cau g
    public ArrayList<Student> ToanGT9_NamsinhGT1995() {
        ArrayList<Student> list = new ArrayList<>();
        for(Student t: StuList){
            if(t.getNamSinh() > 1995 || t.getToan() >= 9.0)
                t.Xuat();
                list.add(t);
        }
        return list;
    }
}
