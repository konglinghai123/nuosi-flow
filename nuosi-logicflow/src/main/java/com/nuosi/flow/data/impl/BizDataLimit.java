package com.nuosi.flow.data.impl;

import com.nuosi.flow.data.BDataLimit;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author nuosi fsofs@163.com
 * @version 0.1.0
 * @name 业务传输对象的数据限制和校验
 * @desc TODO
 * @date 2021/3/16 23:40
 */
public class BizDataLimit implements BDataLimit {
    /**属性需要初始化空值，用于后续的判断逻辑*/
    private Integer max = null;
    private Integer min = null;

    private int size = -1;

    private int precision = -1;
    private int scale = -1;
    private BigDecimal maxDecimal = null;
    private BigDecimal minDecimal = null;

    private Date startDate = null;
    private Date endDate = null;

    private Timestamp startDatetime = null;
    private Timestamp endDatetime = null;

    @Override
    public Integer getMax() {
        return max;
    }

    public BizDataLimit setMax(int max) {
        this.max = max;
        return this;
    }

    @Override
    public Integer getMin() {
        return min;
    }

    public BizDataLimit setMin(int min) {
        this.min = min;
        return this;
    }

    @Override
    public int getSize() {
        return size;
    }

    public BizDataLimit setSize(int size) {
        this.size = size;
        return this;
    }

    @Override
    public int getPrecision() {
        return precision;
    }

    public BizDataLimit setPrecision(int precision) {
        this.precision = precision;
        return this;
    }

    @Override
    public int getScale() {
        return scale;
    }

    public BizDataLimit setScale(int scale) {
        this.scale = scale;
        return this;
    }

    @Override
    public BigDecimal getMaxDecimal() {
        return maxDecimal;
    }

    public BizDataLimit setMaxDecimal(BigDecimal maxDecimal) {
        this.maxDecimal = maxDecimal;
        return this;
    }

    @Override
    public BigDecimal getMinDecimal() {
        return minDecimal;
    }

    public BizDataLimit setMinDecimal(BigDecimal minDecimal) {
        this.minDecimal = minDecimal;
        return this;
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }

    public BizDataLimit setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    @Override
    public Date getEndDate() {
        return endDate;
    }

    public BizDataLimit setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    @Override
    public Timestamp getStartDatetime() {
        return startDatetime;
    }

    public BizDataLimit setStartDatetime(Timestamp startDatetime) {
        this.startDatetime = startDatetime;
        return this;
    }

    @Override
    public Timestamp getEndDatetime() {
        return endDatetime;
    }

    public BizDataLimit setEndDatetime(Timestamp endDatetime) {
        this.endDatetime = endDatetime;
        return this;
    }
}
