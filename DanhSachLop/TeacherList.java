package DanhSachLop;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TeacherList {
    ArrayList<Teacher> TList = new ArrayList<>();
    public void setTList(ArrayList<Teacher> tList) {this.TList = tList;}
    public ArrayList<Teacher> getTList(){return this.TList;}

    public TeacherList(){
        super();
        this.TList = new ArrayList<>();
    }

    public void ReadXML() throws ParserConfigurationException, SAXException, IOException {
        File xmlFile = new File("D:\\BaiTap_OOP\\DanhSachLop\\TeacherList.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        org.w3c.dom.Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        System.out.println("Root: "+ doc.getDocumentElement().getNodeName());
        NodeList nodeList = doc.getElementsByTagName("teacher");

        System.out.println("----------------------");

        for(int i=0; i<nodeList.getLength(); i++){
            Teacher t = new Teacher();
            Node node = nodeList.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE)
            {
                org.w3c.dom.Element element = (org.w3c.dom.Element)node;
                t.setName(element.getElementsByTagName("name").item(0).getTextContent());
                t.setGroup_num(Integer.parseInt(element.getElementsByTagName("group_num").item(0).getTextContent()));
            }
            TList.add(t);
        }
    }
    
    public void xuatDS(){
        for(Teacher t: TList) {
            System.out.println("Name: "+ t.getName());
            System.out.println("Group number: "+ t.getGroup_num());
            System.out.println("-------------------");
        }
    }

    public int sum_GrNum() {
        int sum=0;
        for(int i=0; i<TList.size(); i++){
            sum++;
        }
        return sum;
    }

    public void cpare_name() {
        Collections.sort(TList, Teacher.T_name);
        xuatDS();
    }

    public void cpare_num() {
        Collections.sort(TList, Teacher.TGroup_num);
        xuatDS();
    }

    public void filter() {
        System.out.println("Cac giao vien co nhom > 1: ");
        for(Teacher t: TList){
            if(t.getGroup_num()>1){
                System.out.println("Name: "+ t.getName());
                System.out.println("Group number: "+ t.getGroup_num());
                System.out.println("-------------------");
            }
        }
    }
}
