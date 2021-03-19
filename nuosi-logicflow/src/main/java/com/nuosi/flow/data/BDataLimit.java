package com.nuosi.flow.data;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author nuosi fsofs@163.com
 * @version 0.1.0
 * @name BDataLimit
 * @desc TODO
 * @date 2021/3/16 23:40
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
