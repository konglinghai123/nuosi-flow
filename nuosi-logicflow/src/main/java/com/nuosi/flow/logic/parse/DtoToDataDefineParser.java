package com.nuosi.flow.logic.parse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nuosi.flow.data.BDataDefine;
import com.nuosi.flow.data.BDataLimit;
import com.nuosi.flow.data.impl.BizDataDefine;
import com.nuosi.flow.data.limit.*;
import com.nuosi.flow.logic.model.domain.Attr;
import com.nuosi.flow.logic.model.domain.DomainModel;
import com.nuosi.flow.logic.model.domain.Limit;

import java.io.InputStream;
import java.util.List;

/**
 * <p>desc: Dto XML文件转换为DataDefine </p>
 * <p>date: 2021/4/8 21:01 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class DtoToDataDefineParser {
    private String dtoConfig;

    public DtoToDataDefineParser(String dtoConfig) {
        this.dtoConfig = dtoConfig;
    }

    public BDataDefine parse() throws Exception {
        JSONObject beanJson = parseJSONObject();
        DomainModel domainModel = JSON.toJavaObject(beanJson, DomainModel.class);

        BDataDefine dataDefine = new BizDataDefine(domainModel.getId());
        List<Attr> attrs = domainModel.getAttrs();
        for (Attr attr : attrs) {
            BDataDefine.BDataType dataType = BDataDefine.BDataType.valueOf(attr.getType().toUpperCase());
            List<Limit> limits = attr.getLimits();
            if (limits == null) {
                dataDefine.defineType(attr.getId(), dataType);
                continue;
            }

            Limit limit = limits.get(0);
            BDataLimit dataLimit = null;
            switch (dataType) {
                /*校验整数类型*/
                case INT:
                    dataLimit = parseIntegerLimit(limit);
                    break;
                /*校验字符类型*/
                case STRING:
                    dataLimit = parseStringLimit(limit);
                    break;
                /*校验小数类型*/
                case DECIMAL:
                    dataLimit = parseDecimalLimit(limit);
                    break;
                /*校验日期类型*/
                case DATE:
                    dataLimit = parseDateLimit(limit);
                    break;
                /*校验日期时间类型*/
                case DATETIME:
                    dataLimit = parseDatetimeLimit(limit);
                    break;
                default:
                    break;
            }
            dataDefine.defineType(attr.getId(), dataType, dataLimit);
        }
        return dataDefine;
    }

    private JSONObject parseJSONObject() throws Exception {
        InputStream is = null;
        JSONObject beanJson;
        try {
            is = getClass().getClassLoader().getResourceAsStream(dtoConfig);
            beanJson = new XmlToBizDataParser(is).getBeanJson();
        } finally {
            if (is != null) {
                is.close();
            }
        }
        return beanJson;
    }

    private BDataLimit parseIntegerLimit(Limit limit) {
        IntegerLimit integerLimit = new IntegerLimit();
        if (limit.getMax() != null) {
            integerLimit.setMax(limit.getMax());
        }
        if (limit.getMin() != null) {
            integerLimit.setMin(limit.getMin());
        }
        return integerLimit;
    }

    private BDataLimit parseStringLimit(Limit limit) {
        StringLimit stringLimit = new StringLimit();
        if (limit.getSize() != null) {
            stringLimit.setSize(limit.getSize());
        }
        return stringLimit;
    }

    private BDataLimit parseDecimalLimit(Limit limit) {
        DecimalLimit decimalLimit = new DecimalLimit();
        if (limit.getScale() != null) {
            decimalLimit.setScale(limit.getScale());
        }
        if (limit.getPrecision() != null) {
            decimalLimit.setPrecision(limit.getPrecision());
        }
        if (limit.getMaxDecimal() != null) {
            decimalLimit.setMaxDecimal(limit.getMaxDecimal());
        }
        if (limit.getMinDecimal() != null) {
            decimalLimit.setMinDecimal(limit.getMinDecimal());
        }
        return decimalLimit;
    }

    private BDataLimit parseDateLimit(Limit limit) {
        DateLimit dateLimit = new DateLimit();
        if (limit.getStartDate() != null) {
            dateLimit.setStartDate(limit.getStartDate());
        }
        if (limit.getEndDate() != null) {
            dateLimit.setEndDate(limit.getEndDate());
        }
        return dateLimit;
    }

    private BDataLimit parseDatetimeLimit(Limit limit) {
        DatetimeLimit datetimeLimit = new DatetimeLimit();
        if (limit.getStartDatetime() != null) {
            datetimeLimit.setStartDatetime(limit.getStartDatetime());
        }
        if (limit.getEndDatetime() != null) {
            datetimeLimit.setEndDatetime(limit.getEndDatetime());
        }
        return datetimeLimit;
    }
}
