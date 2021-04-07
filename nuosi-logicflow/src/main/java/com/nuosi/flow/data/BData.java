package com.nuosi.flow.data;

import com.ai.ipu.data.JMap;

/**
 * <p>desc: 弱类型业务传输对象的接口抽象</p>
 * <p>date: 2021/3/5 0:48</p>
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public interface BData extends JMap {

    public String getBizName();

    public BDataDefine getDataDefine();

}
