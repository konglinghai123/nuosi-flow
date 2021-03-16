package com.nuosi.flow.data;

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

    public int getMax();

    public void setMax(int max);

    public int getMin();

    public void setMin(int min);

    public int getSize();

    public void setSize(int size);

    public int getPrecision();

    public void setPrecision(int precision);

    public int getScale();

    public void setScale(int scale);

    public Date getStartDate();

    public void setStartDate(Date startDate);

    public Date getEndDate();

    public void setEndDate(Date endDate);

    public Timestamp getStartDatetime();

    public void setStartDatetime(Timestamp startDatetime);

    public Timestamp getEndDatetime();

    public void setEndDatetime(Timestamp endDatetime);
}
