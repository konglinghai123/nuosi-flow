package com.nuosi.flow.logic.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.dom4j.Attribute;
import org.dom4j.Element;

import java.io.InputStream;
import java.util.Iterator;

/**
 * @author nuosi fsofs@163.com
 * @version 0.1.0
 * @name Dom4jHelper
 * @desc TODO
 * @date 2021/3/7 17:00
 */
public class Dom4jHelper extends com.ai.ipu.common.xml.Dom4jHelper{
    public static final String CHILDREN_TAG = "children";

    public Dom4jHelper(InputStream in) throws Exception {
        super(in);
    }

    public JSONObject getAllJson() {
        return this.getElementAllJson(this.getRoot());
    }

    private JSONObject getElementAllJson(Element element) {
        JSONObject eleMap = new JSONObject(true); //设置顺序
        JSONObject childrenMap = new JSONObject(true); //设置顺序

        // 遍历子标签
        JSONArray childElements = new JSONArray(); //存储标签的子标签
        JSONObject childElement = null;
        Iterator<?> eit = element.elementIterator();
        while(eit.hasNext()) {
            Element ele = (Element)eit.next();
            childElement = this.getElementAllJson(ele); //递归获取子元素
            childElements.add(childElement);
        }

        // 遍历标签属性
        JSONObject attrMap = new JSONObject();
        Iterator<?> ait = element.attributeIterator();
        while(ait.hasNext()) {
            Attribute attr = (Attribute)ait.next();
            attrMap.put(attr.getName(), attr.getValue());
        }

        childrenMap.put(element.getName() + Dom4jHelper.SUFFIX_ATTR, attrMap);
        childrenMap.put(element.getName() + Dom4jHelper.SUFFIX_TEXT, element.getTextTrim());
        childrenMap.put(CHILDREN_TAG, childElements);

        eleMap.put(element.getName(), childrenMap);
        return eleMap;
    }
}
