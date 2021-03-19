package com.nuosi.flow.data.impl;

import com.nuosi.flow.data.BDataDefine;
import com.nuosi.flow.data.BDataLimit;
import com.nuosi.flow.util.DataTypeCheckUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nuosi fsofs@163.com
 * @version 0.1.0
 * @name 业务传输对象的数据类型和格式定义
 * @desc TODO
 * @date 2021/3/16 14:36
 */
public class BizDataDefine implements BDataDefine{
    private final String bizName;
    private final Map<String, DataType> dataTypes;
    private final Map<String, BDataLimit> dataLimits;

    public BizDataDefine(String bizName) {
        this.bizName = bizName;
        this.dataTypes = new HashMap<String, DataType>();
        this.dataLimits = new HashMap<String, BDataLimit>();
    }

    @Override
    public BizDataDefine defineType(String attr, DataType dataType, BDataLimit dataLimit){
        dataTypes.put(attr, dataType);
        dataLimits.put(attr, dataLimit);
        return this;
    }

    @Override
    public BizDataDefine defineType(String attr, DataType dataType){
        dataTypes.put(attr, dataType);
        return this;
    }

    @Override
    public String getBizName() {
        return bizName;
    }

    @Override
    public Map<String, BDataDefine.DataType> getDataTypes() {
        return dataTypes;
    }

    @Override
    public BDataDefine.DataType getDataType(String bizName){
        return dataTypes.get(bizName);
    }

    @Override
    public String[] getAllAttr() {
        return dataTypes.keySet().toArray(new String[]{});
    }

    @Override
    public boolean containsAttr(String attr) {
        return dataTypes.containsKey(attr);
    }

    @Override
    public Map<String, BDataLimit> getDataLimits() {
        return dataLimits;
    }

    @Override
    public BDataLimit getDataLimit(String bizName){
        return dataLimits.get(bizName);
    }

    @Override
    public boolean checkDataType(String attr, Object value) {
        // 校验各种基础业务类型
        DataTypeCheckUtil.check(bizName, attr, value);
        return true;
    }
}
