package com.nuosi.flow.logic.model.header;

import com.nuosi.flow.logic.model.domain.Attr;

import java.util.List;

/**
 * <p>desc: 逻辑流元素：全局区域</p>
 * <p>date: 2021/3/6 12:13</p>
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class Global {
    private List<Attr> attrs;
    private List<Databus> databuses;

    public List<Attr> getAttrs() {
        return attrs;
    }

    public void setAttrs(List<Attr> attrs) {
        this.attrs = attrs;
    }

    public List<Databus> getDatabuses() {
        return databuses;
    }

    public void setDatabuses(List<Databus> databuses) {
        this.databuses = databuses;
    }
}
