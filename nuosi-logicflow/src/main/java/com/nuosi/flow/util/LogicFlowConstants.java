package com.nuosi.flow.util;

/**
 * <p>desc: 逻辑流程引擎使用的常量</p>
 * <p>date: 2021/3/6 12:00</p>
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class LogicFlowConstants {
    /*表达式内置变量*/
    public static final String DATABUS = "DATABUS";
    public static final String INPUT = "INPUT";

    /*LogicFlow异常编码*/
    public static final String FLOW_DATABUS_VAR_NO_EXISTS = "FLOW_DATABUS_VAR_NO_EXISTS";
    public static final String FLOW_NODE_TAG_ARRT_EXCEPT = "FLOW_NODE_TAG_ARRT_EXCEPT";
    public static final String FLOW_NODE_OUTPUT_VAR_NULL = "FLOW_NODE_OUTPUT_VAR_NULL";
    public static final String FLOW_END_NO_MATCH = "FLOW_END_NO_MATCH";
    public static final String FLOW_START_SINGLE = "FLOW_START_SINGLE";
    public static final String FLOW_END_SINGLE = "FLOW_END_SINGLE";

    /*BData异常编码*/
    public static final String BDATA_DEFINE_NO_EXISTS = "BDATA_DEFINE_NO_EXISTS";
    public static final String BDATA_STRUCTURE_EXISTS = "BDATA_STRUCTURE_EXISTS";
    public static final String BDATA_ATTR_DEFINE_NO_EXISTS = "BDATA_ATTR_DEFINE_NO_EXISTS";
    public static final String BDATA_ATTR_FORMAT_ERROR = "BDATA_ATTR_FORMAT_ERROR";

    public static final String BDATA_CHECK_INT = "BDATA_CHECK_INT";
    public static final String BDATA_CHECK_INT_MAX = "BDATA_CHECK_INT_MAX";
    public static final String BDATA_CHECK_INT_MIN = "BDATA_CHECK_INT_MIN";
    public static final String BDATA_CHECK_STRING_LENGTH = "BDATA_CHECK_STRING_LENGTH";
    public static final String BDATA_CHECK_DECIMAL = "BDATA_CHECK_DECIMAL";
    public static final String BDATA_CHECK_DECIMAL_PRECISION = "BDATA_CHECK_DECIMAL_PRECISION";
    public static final String BDATA_CHECK_DECIMAL_SCALE = "BDATA_CHECK_DECIMAL_SCALE";
    public static final String BDATA_CHECK_DECIMAL_MAX = "BDATA_CHECK_DECIMAL_MAX";
    public static final String BDATA_CHECK_DECIMAL_MIN = "BDATA_CHECK_DECIMAL_MIN";
    public static final String BDATA_CHECK_DATE = "BDATA_CHECK_DATE";
    public static final String BDATA_CHECK_DATE_START = "BDATA_CHECK_DATE_START";
    public static final String BDATA_CHECK_DATE_END = "BDATA_CHECK_DATE_END";
    public static final String BDATA_CHECK_DATETIME = "BDATA_CHECK_DATETIME";
    public static final String BDATA_CHECK_DATETIME_START = "BDATA_CHECK_DATETIME_START";
    public static final String BDATA_CHECK_DATETIME_END = "BDATA_CHECK_DATETIME_END";

}
