package DanhSachLop;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.DebugGraphics;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Diem2D_List {
    ArrayList<Diem2D> dsDiem2d = new ArrayList<>();

    public void setDsDiem2d(ArrayList<Diem2D> dsDiem2d) {
        this.dsDiem2d = dsDiem2d;
    }
    public ArrayList<Diem2D> getDsDiem2d() {
        return dsDiem2d;
    }
    // constructor
    public Diem2D_List(){
        super();
        this.dsDiem2d = new ArrayList<>();
    }

    public void ReadXML() throws SAXException, ParserConfigurationException, IOException {
        File fileXML = new File("DanhSachLop\\listDiem2D.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fileXML);
        doc.getDocumentElement().normalize();

        System.out.println("Root: "+ doc.getDocumentElement().getNodeName());
        NodeList nodeList = doc.getElementsByTagName("Diem");
        
        System.out.println("----------------------");

        for(int i=0; i<nodeList.getLength(); i++){
            Diem2D diem2d = new Diem2D();
            Node node = nodeList.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element)node;
                diem2d.setX(Float.parseFloat(element.getElementsByTagName("x").item(0).getTextContent()));
                diem2d.setY(Float.parseFloat(element.getElementsByTagName("y").item(0).getTextContent()));
            }
            dsDiem2d.add(diem2d);
        }
    }

    public void nhapListDiem2d(){
        Scanner sc = new Scanner(System.in);
        int size;
        System.out.print("Nhap so luong diem: ");
        size = sc.nextInt();
        for(int i=0; i<=size; i++){
            dsDiem2d.get(i).nhap();
        }
    }

    public void xuatDS() {
        for(int i=0; i<dsDiem2d.size(); i++) {
            float x =  dsDiem2d.get(i).getX();
            float y =  dsDiem2d.get(i).getY();
            System.out.println("Diem ( "+ x +" ; "+ y +" ) co khoang cach la "+ String.format("%.2f", dsDiem2d.get(i).length()));;
        }
    }

    public void sortLength(){
        Collections.sort(dsDiem2d, Diem2D.length);
        xuatDS();
    }

    public void fillter_Circle1() {
        for(int i=0; i<dsDiem2d.size(); i++){
            if(dsDiem2d.get(i).length() <= 1){
                dsDiem2d.get(i).xuat();
            }
        }
    }

    public void fillter_rightConnerCircle() {
        for(int i=0; i<dsDiem2d.size(); i++){
            if(dsDiem2d.get(i).getX() > 0 && dsDiem2d.get(i).getY() > 0){
                dsDiem2d.get(i).xuat();
            }
        }
    }

    public void erase_point(){
        for(int i=0; i<dsDiem2d.size(); i++){
            float x = dsDiem2d.get(i).getX();
            float y = dsDiem2d.get(i).getY();
            if(x>5 && x<8 || y>5 && y<8)
                dsDiem2d.remove(i);
        }
        xuatDS();
    }

    public int count() {
        int res = 0;
        for(Diem2D diem : dsDiem2d){
            if(diem.getX() >= 0)
                res++;
        }
        System.out.println("Co " + res +" diem hoanh do duong");
        return res;
    }
}
