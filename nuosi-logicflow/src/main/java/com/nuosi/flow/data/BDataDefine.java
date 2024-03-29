package com.nuosi.flow.data;

import com.nuosi.flow.data.impl.BizDataDefine;

import java.util.Map;

/**
 * <p>desc: 业务传输对象数据定义的接口抽象</p>
 * <p>date: 2021/3/16 14:36</p>
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public interface BDataDefine {

    public enum BDataType {
        INT, STRING, DECIMAL, DATE, DATETIME, BDATA; //后续扩展更多类型
    }

    public BizDataDefine defineType(String attr, BDataType dataType, BDataLimit dataLimit);

    public BizDataDefine defineType(String attr, BDataType dataType);

    public String getBizName();

    public BDataDefine.BDataType getDataType(String bizName);

    public Map<String, BDataDefine.BDataType> getDataTypes();

    public String[] getAllAttr();

    public boolean containsAttr(String attr);

    public Map<String, BDataLimit> getDataLimits();

    public BDataLimit getDataLimit(String bizName);

    /**校验数据的基础类型*/
    public boolean checkData(String key, Object value);
}
