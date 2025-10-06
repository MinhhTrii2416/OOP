package DanhSachLop;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Excute {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        Diem2D_List list2d = new Diem2D_List();

        list2d.ReadXML();
        list2d.xuatDS();

        for(int i=1; i<=5; i++) System.out.println();

        list2d.count();
    }
}
