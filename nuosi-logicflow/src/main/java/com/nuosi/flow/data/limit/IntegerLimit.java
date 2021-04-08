package com.nuosi.flow.data.limit;

import com.ai.ipu.basic.util.IpuUtility;
import com.nuosi.flow.data.BDataLimit;
import com.nuosi.flow.util.LogicFlowConstants;

/**
 * <p>desc: 整型数据限制和校验 </p>
 * <p>date: 2021/4/8 11:27 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class IntegerLimit implements BDataLimit {
    private Integer max = null;
    private Integer min = null;

    public Integer getMax() {
        return max;
    }

    public IntegerLimit setMax(Integer max) {
        this.max = max;
        return this;
    }

    public Integer getMin() {
        return min;
    }

    public IntegerLimit setMin(Integer min) {
        this.min = min;
        return this;
    }

}
