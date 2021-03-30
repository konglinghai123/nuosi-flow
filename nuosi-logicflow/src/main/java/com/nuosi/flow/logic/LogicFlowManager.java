package com.nuosi.flow.logic;

import com.nuosi.flow.logic.model.LogicFlow;
import com.nuosi.flow.logic.model.domain.DomainModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>desc: 描述这个类功能的注释 </p>
 * <p>date: 2021/3/29 18:27 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 * update:[序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
public class LogicFlowManager {
    private static Map<String, DomainModel> domainModelCache;
    private static Map<String, LogicFlow> logicFlowlCache;

    static {
        domainModelCache = new ConcurrentHashMap<String, DomainModel>();
        logicFlowlCache = new ConcurrentHashMap<String, LogicFlow>();
    }

    public static void storageDomainModel(DomainModel domainModel){
        domainModelCache.put(domainModel.getId(), domainModel);
    }

    public static DomainModel getDomainModel(String dtoName){
        return domainModelCache.get(dtoName);
    }

    public static void storageLogicFlow(LogicFlow logicFlow){
        logicFlowlCache.put(logicFlow.getId(), logicFlow);
    }

    public static LogicFlow getLogicFlow(String logicFlow){
        return logicFlowlCache.get(logicFlow);
    }
}
