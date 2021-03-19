package com.nuosi.flow.data;

import com.nuosi.flow.data.impl.BizDataDefine;

import java.util.Map;

/**
 * @author nuosi fsofs@163.com
 * @version 0.1.0
 * @name BDataDefine
 * @desc TODO
 * @date 2021/3/16 14:36
 */
public interface BDataDefine {

    public enum DataType{
        INT, STRING, DECIMAL, DATE, DATETIME, BDATA; //后续扩展更多类型
    }

    public BizDataDefine defineType(String attr, DataType dataType, BDataLimit dataLimit);

    public BizDataDefine defineType(String attr, DataType dataType);

    public String getBizName();

    public BDataDefine.DataType getDataType(String bizName);

    public Map<String, BDataDefine.DataType> getDataTypes();

    public String[] getAllAttr();

    public boolean containsAttr(String attr);

    public Map<String, BDataLimit> getDataLimits();

    public BDataLimit getDataLimit(String bizName);

    public boolean checkDataType(String key, Object value);
}
