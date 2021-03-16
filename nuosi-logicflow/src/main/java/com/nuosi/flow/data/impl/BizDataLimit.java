package com.nuosi.flow.data.impl;

import com.nuosi.flow.data.BDataLimit;

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
    private int max;
    private int min;

    private int size;

    private int precision;
    private int scale;

    private Date startDate;
    private Date endDate;

    private Timestamp startDatetime;
    private Timestamp endDatetime;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int getPrecision() {
        return precision;
    }

    @Override
    public void setPrecision(int precision) {
        this.precision = precision;
    }

    @Override
    public int getScale() {
        return scale;
    }

    @Override
    public void setScale(int scale) {
        this.scale = scale;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Timestamp getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(Timestamp startDatetime) {
        this.startDatetime = startDatetime;
    }

    public Timestamp getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(Timestamp endDatetime) {
        this.endDatetime = endDatetime;
    }
}
