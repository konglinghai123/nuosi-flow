package com.nuosi.flow.data.limit;

import com.nuosi.flow.data.BDataLimit;

import java.sql.Date;

/**
 * <p>desc: 日期数据限制和校验 </p>
 * <p>date: 2021/4/8 15:31 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class DateLimit implements BDataLimit {
    private java.sql.Date startDate = null;
    private java.sql.Date endDate = null;

    public Date getStartDate() {
        return startDate;
    }

    public DateLimit setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public DateLimit setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }
}
