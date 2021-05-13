package com.nuosi.flow.logic.model.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>desc: 逻辑流元素：领域模型</p>
 * <p>date: 2021/3/25 18:08</p>
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class DomainModel {
    private String id;
    private String name;
    private String desc;
    private List<Attr> attrs;
    private List<Function> functions;
    private Map<String, Function> functionMap;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Attr> getAttrs() {
        return attrs;
    }

    public void setAttrs(List<Attr> attrs) {
        this.attrs = attrs;
    }

    public List<Function> getFunctions() {
        return functions;
    }

    public void setFunctions(List<Function> functions) {
        if(functions!=null){
            Map<String, Function> functionMap = new HashMap<String, Function>();
            for(Function function : functions){
                functionMap.put(function.getId(), function);
            }
            this.functionMap = functionMap;
        }
        this.functions = functions;
    }

    public Map<String, Function> getFunctionMap() {
        return functionMap;
    }
}
