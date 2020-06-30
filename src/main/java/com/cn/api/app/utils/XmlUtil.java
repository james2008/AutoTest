package com.cn.api.app.utils;

import com.cn.api.app.bean.ApiDataBean;
import com.cn.api.app.bean.BaseBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;


@Slf4j
public class XmlUtil {

    public static <T extends BaseBean> List<T> readXml(Class<T> clz, String path) {
        if (StringUtils.isEmpty(path)) {
            return null;
        }
        try {
            // 获取解析工厂
            SAXParserFactory factory = SAXParserFactory.newInstance();
            // 从解析工厂获取解析器
            SAXParser parse = factory.newSAXParser();
            // 得到解读器
            XMLReader reader = parse.getXMLReader();
            //解析器实例化
            XmlHandler xmlHandler = new XmlHandler();
            // 设置内容处理器
            reader.setContentHandler(xmlHandler);
            // 读取xml的文档内容
            reader.parse(path);
            List<ApiDataBean> allData = xmlHandler.dataList;
//            for (ApiDataBean bean : allData) {
//                System.out.println("testcase ：" + bean.toString());
//            }
            return (List<T>)xmlHandler.dataList;
        } catch (Exception e) {
            throw new RuntimeException("转换XML文件失败：" + e.getMessage());
        }
    }

    private static class XmlHandler extends DefaultHandler {
        private List<ApiDataBean> dataList;
        private ApiDataBean dataBean;
        private String tag; // 存储操作标签

        /**
         * @param
         * @return void
         * @author lastwhisper
         * @desc 文档解析开始时调用，该方法只会调用一次
         */
        @Override
        public void startDocument() throws SAXException {
            dataList = new ArrayList<ApiDataBean>();
        }

        /**
         * @param uri        xml文档的命名空间
         * @param localName  标签的名字
         * @param qName      带命名空间的标签的名字
         * @param attributes 标签的属性集
         * @return void
         * @author lastwhisper
         * @desc 标签（节点）解析开始时调用
         */
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            tag = qName;
            if ("case".equals(tag)) {
                dataBean = new ApiDataBean();
            }
        }

        /**
         * @param ch     字符
         * @param start  字符数组中的起始位置
         * @param length 要从字符数组使用的字符数
         * @return void
         * @author lastwhisper
         * @desc 解析标签的内容的时候调用
         */
        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String content = new String(ch, start, length).trim();
            if ("run".equals(tag)) {
                dataBean.setRun((content.equalsIgnoreCase("true") ? true : false));
            } else if ("method".equals(tag)) {
                dataBean.setMethod(content);
            } else if ("url".equals(tag)) {
                dataBean.setUrl(content);
            } else if ("desc".equals(tag)) {
                dataBean.setDesc(content);
            } else if ("param".equals(tag)) {
                dataBean.setParam(content);
            } else if ("verify".equals(tag)) {
                dataBean.setVerify(content);
            } else if ("save".equals(tag)) {
                dataBean.setSave(content);
            }
        }

        /**
         * @param uri       xml文档的命名空间
         * @param localName 标签的名字
         * @param qName     带命名空间的标签的名字
         * @return void
         * @author lastwhisper
         * @desc 标签（节点）解析结束后调用
         */
        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("case".equals(qName)) {
                dataList.add(dataBean);
            }
            tag = null; //tag丢弃了
        }

        /**
         * @param
         * @return void
         * @author lastwhisper
         * @desc 文档解析结束后调用，该方法只会调用一次
         */
        @Override
        public void endDocument() throws SAXException {
        }

        public List<ApiDataBean> getApiDataList() {
            return dataList;
        }
    }
}
