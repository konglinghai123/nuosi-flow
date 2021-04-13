package com.nuosi.flow.logic.parse;

import com.ai.ipu.common.xml.Dom4jHelper;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.dom4j.Attribute;
import org.dom4j.Element;

import java.io.InputStream;
import java.util.Iterator;

/**
 * <p>desc: 逻辑流模型解析</p>
 * <p>date: 2021/3/27 12:59</p>
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class XmlToLogicFlowParser extends Dom4jHelper {
    private static final String REUSE = "reuse";
    private static final String ATTR = "attr";
    private static final String ID = "id";
    private static final String VAR = "var";
    private static final String IMPORT = "import";
    private static final String MODEL = "model";

    public XmlToLogicFlowParser(InputStream in) throws Exception {
        super(in);
    }

    public JSONObject getBeanJson() {
        return this.getElementBeanJson(this.getRoot());
    }

    private JSONObject getElementBeanJson(Element element) {
        // 遍历子标签
        JSONObject elementMap = new JSONObject(true);//设置顺序

        // 遍历标签属性
        JSONObject attrJsonObject = new JSONObject(true);
        Iterator<?> ait = element.attributeIterator();
        while (ait.hasNext()) {
            Attribute attr = (Attribute) ait.next();
            attrJsonObject.put(attr.getName(), attr.getValue());
        }
        elementMap.putAll(attrJsonObject);

        if (!element.getTextTrim().isEmpty()) {
            // 存储标签的text内容
            elementMap.put(element.getName(), element.getTextTrim());
        } else {
            //存储标签的子标签
            JSONObject childElement = null;
            Iterator<?> eit = element.elementIterator();
            while (eit.hasNext()) {
                Element ele = (Element) eit.next();
                childElement = this.getElementBeanJson(ele); //递归获取子元素
                if (elementMap.containsKey(convertPlural(ele.getName()))) {
                    JSONArray childElements = (JSONArray) elementMap.get(convertPlural(ele.getName()));
                    childElements.add(childElement);
                } else {
                    JSONArray childElements = new JSONArray();
                    childElements.add(childElement);
                    elementMap.put(convertPlural(ele.getName()), childElements);
                }
            }
        }
        return elementMap;
    }

    private String convertPlural(String tag) {
        if (tag.endsWith("s")) {
            return tag + "es";
        } else if (tag.endsWith("y")) {
            return tag.substring(0, tag.length() - 1) + "ies";
        } else {
            return tag + "s";
        }
    }
}
