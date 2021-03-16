package com.nuosi.flow.data.impl;

import com.ai.ipu.basic.util.IpuUtility;
import com.ai.ipu.data.impl.JsonMap;
import com.nuosi.flow.data.BData;
import com.nuosi.flow.data.BDataDefine;
import com.nuosi.flow.util.LogicFlowConstants;

/**
 * @author nuosi fsofs@163.com
 * @version 0.1.0
 * @name BizData
 * @desc 业务传输对象的弱类型实现
 * 基于Map数据结构的Dto、JavaBean表达类
 * @date 2021/3/5 0:51
 */
public class BizData extends JsonMap implements BData {
    private final String bizName;
    private final BDataDefine dataDefine;

    public BizData(String bizName, BDataDefine dataDefine) {
        this.bizName = bizName;
        this.dataDefine = dataDefine;
    }

    /**
     * @name put
     * @version 0.1.0
     * @desc 存值时判断业务属性是否存在
     * @return java.lang.Object
     * @throws
     * @author nuosi fsofs@163.com
     * @date 2021/3/6 0:30
     */
    @Override
    public BizData put(String key, Object value) {
        if(!dataDefine.containsAttr(key)){
            //业务属性不存在时抛出异常
            IpuUtility.errorCode(LogicFlowConstants.LOGICFLOW_ATTR_NOT_EXIST);
        }
        if(!dataDefine.checkDataType(key, value)){
            //业务属性数据格式不正确时抛出异常
            IpuUtility.errorCode(LogicFlowConstants.LOGICFLOW_ATTR_FORMAT_ERROR);
        }
        super.put(key, value);
        return this;
    }

    @Override
    public Object get(Object key) {
        if(!dataDefine.containsAttr((String) key)){
            //业务属性不存在时抛出异常
            IpuUtility.errorCode(LogicFlowConstants.LOGICFLOW_ATTR_NOT_EXIST);
        }
        return super.get(key);
    }

    public String getBizName() {
        return bizName;
    }

    public BDataDefine getDataDefine() {
        return dataDefine;
    }
}
