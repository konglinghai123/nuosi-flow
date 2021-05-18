package com.nuosi.flow.logic.inject.function;

import com.nuosi.flow.logic.inject.function.impl.DbDomainFunction;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>desc: 函数功能统一管理 </p>
 * <p>date: 2021/5/17 23:20 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class FunctionManager {
    public static final String DB = "DB";

    private static Map<String, IDomainFunction> domainFunctionCache = new ConcurrentHashMap<String, IDomainFunction>();

    public static void init() {
        registerDomainFunction(DB, new DbDomainFunction());
    }

    public static void registerDomainFunction(String domain, IDomainFunction domainFunction) {
        domainFunctionCache.put(domain, domainFunction);
    }

    public static IDomainFunction getDomainFunction(String domain) {
        return domainFunctionCache.get(domain);
    }
}
