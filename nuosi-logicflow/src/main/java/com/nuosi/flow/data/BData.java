package com.nuosi.flow.data;

import com.ai.ipu.data.JMap;

/**
 * @author nuosi fsofs@163.com
 * @version 0.1.0
 * @name BData
 * @desc 业务传输对象的弱类型抽象
 * @date 2021/3/5 0:48
 */
public interface BData extends JMap {

    public String getBizName();

    public BDataDefine getDataDefine();

}
