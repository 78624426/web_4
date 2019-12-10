package xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Test {
    public static void main(String[] args) throws DocumentException {
        read("a.xml");

    }
    static void read(String name) throws DocumentException {
        //创建解析器
        SAXReader r=new SAXReader();
        Document doc=r.read(Test.class.getResourceAsStream(name));
        System.out.println(doc.asXML());

        Element root = doc.getRootElement();
        List<Element>childs= root.elements();
        Element first=childs.get(0);
        System.out.println("标签中属性名为name的值 为"+first.attributeValue("name"));
        System.out.println("标签名为:" + first.getName());
        //first.elements();

        childs=first.elements();
        System.out.println(childs.get(0).getTextTrim());


    }
}
