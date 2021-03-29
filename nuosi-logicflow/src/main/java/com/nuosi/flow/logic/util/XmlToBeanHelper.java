package com.nuosi.flow.logic.util;

import com.ai.ipu.common.xml.Dom4jHelper;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.dom4j.Attribute;
import org.dom4j.Element;

import java.io.InputStream;
import java.util.Iterator;

/**
 * <p>desc: 将XML转化成BeanJson的工具类 </p>
 * <p>date: 2021/3/26 0:41 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 * update:[序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
public class XmlToBeanHelper extends Dom4jHelper {
    public XmlToBeanHelper(InputStream in) throws Exception {
        super(in);
    }

    public JSONObject getBeanJson() {
        return this.getElementBeanJson(this.getRoot());
    }

    private JSONObject getElementBeanJson(Element element) {
        // 遍历子标签
        JSONObject elementMap = new JSONObject(true);//设置顺序

        // 遍历标签属性
        JSONObject attrMap = new JSONObject(true);
        Iterator<?> ait = element.attributeIterator();
        while(ait.hasNext()) {
            Attribute attr = (Attribute)ait.next();
            attrMap.put(attr.getName(), attr.getValue());
        }
        elementMap.putAll(attrMap);
        if(!element.getTextTrim().isEmpty()){
            elementMap.put(element.getName(), element.getTextTrim());
        }

         //存储标签的子标签
        JSONObject childElement = null;
        Iterator<?> eit = element.elementIterator();
        while(eit.hasNext()) {
            Element ele = (Element)eit.next();
            childElement = this.getElementBeanJson(ele); //递归获取子元素
            if(elementMap.containsKey(convertPlural(ele.getName()))){
                JSONArray childElements = (JSONArray) elementMap.get(convertPlural(ele.getName()));
                childElements.add(childElement);
            }else{
                JSONArray childElements = new JSONArray();
                childElements.add(childElement);
                elementMap.put(convertPlural(ele.getName()), childElements);
            }
        }
        return elementMap;
    }

    private String convertPlural(String tag){
        if(tag.endsWith("s")){
            return tag + "es";
        }else if(tag.endsWith("y")){
            return tag.substring(0, tag.length()-1) + "ies";
        }else{
            return tag + "s";
        }
    }
}
