package com.nuosi.flow.data.limit;

import com.ai.ipu.basic.util.IpuUtility;
import com.nuosi.flow.data.BDataLimit;
import com.nuosi.flow.util.LogicFlowConstants;

/**
 * <p>desc: 字符串数据限制和校验 </p>
 * <p>date: 2021/4/8 14:45 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class StringLimit implements BDataLimit {

    private int size = -1;

    public int getSize() {
        return size;
    }

    public StringLimit setSize(int size) {
        this.size = size;
        return this;
    }
}
