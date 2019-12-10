package xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        read("a.xml");
        write("b.xml");

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

    static void write(String name) throws Exception {
        Document doc= DocumentHelper.createDocument();
        //增加根节点
        Element books=doc.addElement("books");
        //增加子节点
        Element b1=books.addElement("book");
        Element title1=b1.addElement("title");
        Element author1=b1.addElement("author");

        Element b2=books.addElement("book");
        Element title2=b2.addElement("title");
        Element author2=b2.addElement("author");

        //为子节点添加属性
        b1.addAttribute("id","001");

        //为元素添加文本内容
        title1.setText("三国演义");
        author1.setText("罗贯中");
        title2.setText("红楼梦");
        author2.setText("曹雪芹");

        OutputFormat f=OutputFormat.createPrettyPrint();
        XMLWriter writer=new XMLWriter(new FileOutputStream(name),f);
        writer.write(doc);
        writer.close();
    }
}
