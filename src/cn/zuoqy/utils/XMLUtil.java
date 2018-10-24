package cn.zuoqy.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;

/**
 * XML文档的读取和写入
 * Created by zuoqy on 23:30 2018/10/24.
 */

public class XMLUtil {

    /**
     * 读取xml文档方法
     * @param path 文档路径
     * @return Document 文档对象
     */
    public static Document getDocument(String path) {
        try {
            return new SAXReader().read(new File(path));
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 写出到xml文档中
     * @param doc 写出的Document
     * @param path 写出的文件路径
     */
    public static void writeXml(Document doc, String path) {
        try {
            FileOutputStream out = new FileOutputStream(path);
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("utf-8");
            XMLWriter writer = new XMLWriter(out,format);
            writer.write(doc);
            writer.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
