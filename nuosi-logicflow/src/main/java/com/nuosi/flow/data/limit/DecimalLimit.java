package com.nuosi.flow.data.limit;

import com.nuosi.flow.data.BDataLimit;

import java.math.BigDecimal;

/**
 * <p>desc: 小数数据限制和校验 </p>
 * <p>date: 2021/4/8 15:30 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class DecimalLimit implements BDataLimit {
    private int precision = -1;
    private int scale = -1;
    private BigDecimal maxDecimal = null;
    private BigDecimal minDecimal = null;

    public int getPrecision() {
        return precision;
    }

    public DecimalLimit setPrecision(int precision) {
        this.precision = precision;
        return this;
    }

    public int getScale() {
        return scale;
    }

    public DecimalLimit setScale(int scale) {
        this.scale = scale;
        return this;
    }

    public BigDecimal getMaxDecimal() {
        return maxDecimal;
    }

    public DecimalLimit setMaxDecimal(BigDecimal maxDecimal) {
        this.maxDecimal = maxDecimal;
        return this;
    }

    public BigDecimal getMinDecimal() {
        return minDecimal;
    }

    public DecimalLimit setMinDecimal(BigDecimal minDecimal) {
        this.minDecimal = minDecimal;
        return this;
    }
}
