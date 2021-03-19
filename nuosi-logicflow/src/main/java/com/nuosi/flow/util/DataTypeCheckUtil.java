package com.nuosi.flow.util;

import com.ai.ipu.basic.util.IpuUtility;
import com.nuosi.flow.data.BDataDefine;
import com.nuosi.flow.data.BDataLimit;
import com.nuosi.flow.data.BizDataManager;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author nuosi fsofs@163.com
 * @version 0.1.0
 * @name DataTypeCheckUtil
 * @desc 数据类型校验工具类
 * @date 2021/3/16 23:24
 */
public class DataTypeCheckUtil {

    public static void check(String bizName, String attr, Object value) {
        BDataDefine dataDefine = BizDataManager.getDataDefine(bizName);
        BDataDefine.DataType dataType = dataDefine.getDataType(attr);
        BDataLimit dataLimit = dataDefine.getDataLimit(attr);
        switch (dataType) {
            /*校验整数类型*/
            case INT:
                checkInt(value, dataLimit, bizName, attr);
                break;
            /*校验字符类型*/
            case STRING:
                checkString(value, dataLimit, bizName, attr);
                break;
            /*校验小数类型*/
            case DECIMAL:
                checkDecimal(value, dataLimit, bizName, attr);
                break;
            /*校验日期类型*/
            case DATE:
                checkDate(value, dataLimit, bizName, attr);
                break;
            /*校验日期时间类型*/
            case DATETIME:
                checkDatetime(value, dataLimit, bizName, attr);
                break;
            default:
                break;
        }
    }

    static void checkInt(Object value, BDataLimit dataLimit, String bizName, String attr) {
        Integer val = null;
        try {
            val = Integer.parseInt(String.valueOf(value));
        } catch (Exception e) {
            IpuUtility.errorCode(LogicFlowConstants.BDATA_CHECK_INT, bizName, attr);
        }
        if (dataLimit == null) {
            return;
        }

        if (dataLimit.getMax() != null && val > dataLimit.getMax()) {
            IpuUtility.errorCode(LogicFlowConstants.BDATA_CHECK_INT_MAX, bizName, attr, String.valueOf(dataLimit.getMax()));
        }
        if (dataLimit.getMin() != null && val < dataLimit.getMin()) {
            IpuUtility.errorCode(LogicFlowConstants.BDATA_CHECK_INT_MIN, bizName, attr, String.valueOf(dataLimit.getMin()));
        }
    }

    static void checkString(Object value, BDataLimit dataLimit, String bizName, String attr) {
        if (dataLimit == null) {
            return;
        }
        String val = String.valueOf(value);
        if (dataLimit.getSize() != -1 && val.length() > dataLimit.getSize()) {
            IpuUtility.errorCode(LogicFlowConstants.BDATA_CHECK_STRING_LENGTH, bizName, attr, String.valueOf(dataLimit.getSize()));
        }
    }

    static void checkDecimal(Object value, BDataLimit dataLimit, String bizName, String attr) {
        BigDecimal val = null;
        try {
            val = new BigDecimal(String.valueOf(value));
        } catch (Exception e) {
            IpuUtility.errorCode(LogicFlowConstants.BDATA_CHECK_DECIMAL, bizName, attr);
        }
        if (dataLimit == null) {
            return;
        }

        if (dataLimit.getPrecision() != -1 && val.precision() > dataLimit.getPrecision()) {
            IpuUtility.errorCode(LogicFlowConstants.BDATA_CHECK_DECIMAL_PRECISION, bizName, attr, String.valueOf(dataLimit.getPrecision()));
        }
        if (dataLimit.getScale() != -1 && val.scale() > dataLimit.getScale()) {
            IpuUtility.errorCode(LogicFlowConstants.BDATA_CHECK_DECIMAL_SCALE, bizName, attr, String.valueOf(dataLimit.getScale()));
        }
        if (dataLimit.getMaxDecimal() != null && val.compareTo(dataLimit.getMaxDecimal()) > 0) {
            IpuUtility.errorCode(LogicFlowConstants.BDATA_CHECK_DECIMAL_MAX, bizName, attr, String.valueOf(dataLimit.getMaxDecimal()));
        }
        if (dataLimit.getMinDecimal() != null && val.compareTo(dataLimit.getMinDecimal()) < 0) {
            IpuUtility.errorCode(LogicFlowConstants.BDATA_CHECK_DECIMAL_MIN, bizName, attr, String.valueOf(dataLimit.getMinDecimal()));
        }
    }

    static void checkDate(Object value, BDataLimit dataLimit, String bizName, String attr) {
        java.sql.Date val = null;
        try {
            val = java.sql.Date.valueOf(String.valueOf(value));
        } catch (Exception e) {
            IpuUtility.errorCode(LogicFlowConstants.BDATA_CHECK_DATE, bizName, attr);
        }
        if (dataLimit == null) {
            return;
        }

        if (dataLimit.getStartDate() != null && val.compareTo(dataLimit.getStartDate()) < 0) {
            IpuUtility.errorCode(LogicFlowConstants.BDATA_CHECK_DATE_START, bizName, attr, String.valueOf(dataLimit.getStartDate()));
        }
        if (dataLimit.getEndDate() != null && val.compareTo(dataLimit.getEndDate()) > 0) {
            IpuUtility.errorCode(LogicFlowConstants.BDATA_CHECK_DATE_END, bizName, attr, String.valueOf(dataLimit.getEndDate()));
        }
    }

    static void checkDatetime(Object value, BDataLimit dataLimit, String bizName, String attr) {
        Timestamp val = null;
        try {
            val = Timestamp.valueOf(String.valueOf(value));
        } catch (Exception e) {
            IpuUtility.errorCode(LogicFlowConstants.BDATA_CHECK_DATETIME, bizName, attr);
        }
        if (dataLimit == null) {
            return;
        }

        if (dataLimit.getStartDatetime() != null && val.compareTo(dataLimit.getStartDatetime()) < 0) {
            IpuUtility.errorCode(LogicFlowConstants.BDATA_CHECK_DATETIME_START, bizName, attr, String.valueOf(dataLimit.getStartDatetime()));
        }
        if (dataLimit.getEndDatetime() != null && val.compareTo(dataLimit.getEndDatetime()) > 0) {
            IpuUtility.errorCode(LogicFlowConstants.BDATA_CHECK_DATETIME_END, bizName, attr, String.valueOf(dataLimit.getEndDatetime()));
        }
    }
}
