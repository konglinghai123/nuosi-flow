package com.nuosi.flow.logic.invoke.handler;

import com.nuosi.flow.logic.model.body.Action;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>desc: 描述这个类功能的注释 </p>
 * <p>date: 2021/3/30 18:32 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 * update:[序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
public class ActionProcesserManager {
    private static final Map<Action.ActionType, IActionProcesser> actionProcessers;

    static {
        Map<Action.ActionType, IActionProcesser> map = new HashMap<Action.ActionType, IActionProcesser>(6);
        map.put(Action.ActionType.SQL, new SqlProcesser());
        actionProcessers = Collections.unmodifiableMap(map);
    }

    public static IActionProcesser getProcesser(Action.ActionType actionType) {
        return actionProcessers.get(actionType);
    }

}
