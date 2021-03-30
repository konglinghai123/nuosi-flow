package com.nuosi.flow.logic.model.header;

import com.nuosi.flow.logic.model.domain.Attr;

import java.util.List;

/**
 * @author nuosi fsofs@163.com
 * @version 0.1.0
 * @name GlobalDomain
 * @desc TODO
 * @date 2021/3/6 12:13
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
