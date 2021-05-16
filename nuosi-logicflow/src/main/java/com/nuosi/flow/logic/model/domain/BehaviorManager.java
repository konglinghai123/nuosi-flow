package com.nuosi.flow.logic.model.domain;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>desc: 领域模型行为统一管理 </p>
 * <p>date: 2021/5/15 9:05 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class BehaviorManager {
    private static Map<String, Map<String, Behavior>> behaviorCache = new ConcurrentHashMap<String, Map<String, Behavior>>();

    public static void initBehaviors(String modelId, List<Behavior> behaviors) {
        Map<String, Behavior> behaviorMap = new ConcurrentHashMap<String, Behavior>();
        for(Behavior behavior : behaviors){
            behaviorMap.put(behavior.getId(), behavior);
        }
        behaviorCache.put(modelId, behaviorMap);
    }

    public static void registerBehavior(String modelId, Behavior behavior) {
        Map<String, Behavior> modelBehavior = behaviorCache.get(modelId);
        modelBehavior.put(behavior.getId(), behavior);
    }

    public static Behavior getBehavior(String modelId, String behaviorId) {
        Map<String, Behavior> modelBehavior = behaviorCache.get(modelId);
        if(modelBehavior==null){
            return null;
        }
        return modelBehavior.get(behaviorId);
    }
}
