package com.nuosi.flow.data;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * <p>desc: 业务传输对象数据限制和校验的接口抽象</p>
 * <p>date: 2021/3/16 23:40</p>
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public interface BDataLimit {
    public Integer getMax();

    public Integer getMin();

    public int getSize();

    public int getPrecision();

    public int getScale();

    public BigDecimal getMaxDecimal();

    public BigDecimal getMinDecimal();

    public Date getStartDate();

    public Date getEndDate();

    public Timestamp getStartDatetime();

    public Timestamp getEndDatetime();
}
