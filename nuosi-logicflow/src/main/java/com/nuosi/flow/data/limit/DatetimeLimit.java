package com.nuosi.flow.data.limit;

import com.nuosi.flow.data.BDataLimit;

import java.sql.Timestamp;

/**
 * <p>desc: 时间戳数据限制和校验 </p>
 * <p>date: 2021/4/8 15:31 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class DatetimeLimit implements BDataLimit {
    private Timestamp startDatetime = null;
    private Timestamp endDatetime = null;

    public Timestamp getStartDatetime() {
        return startDatetime;
    }

    public DatetimeLimit setStartDatetime(Timestamp startDatetime) {
        this.startDatetime = startDatetime;
        return this;
    }

    public Timestamp getEndDatetime() {
        return endDatetime;
    }

    public DatetimeLimit setEndDatetime(Timestamp endDatetime) {
        this.endDatetime = endDatetime;
        return this;
    }
}
