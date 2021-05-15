package com.nuosi.flow.logic.model.domain;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>desc: 领域模型统一管理 </p>
 * <p>date: 2021/5/15 9:05 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class FunctionManager {
    private static Map<String, Map<String, Function>> functionCache = new ConcurrentHashMap<String, Map<String, Function>>();

    public static void initFunctions(String modelId, List<Function> functions) {
        Map<String, Function> functionMap = new ConcurrentHashMap<String, Function>();
        for(Function function : functions){
            functionMap.put(function.getId(), function);
        }
        functionCache.put(modelId, functionMap);
    }

    public static void registerFunction(String modelId, Function function) {
        Map<String, Function> modelFunction = functionCache.get(modelId);
        modelFunction.put(function.getId(), function);
    }

    public static Function getFunction(String modelId, String functionId) {
        Map<String, Function> modelFunction = functionCache.get(modelId);
        if(modelFunction==null){
            return null;
        }
        return modelFunction.get(functionId);
    }
}
