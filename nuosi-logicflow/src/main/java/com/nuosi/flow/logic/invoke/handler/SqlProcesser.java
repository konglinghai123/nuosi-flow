package com.nuosi.flow.logic.invoke.handler;

import com.ai.ipu.data.JMap;
import com.ai.ipu.database.dao.ISqlDao;
import com.ai.ipu.database.dao.impl.SqlDao;
import com.nuosi.flow.logic.model.action.Sql;
import com.nuosi.flow.logic.model.body.Action;

import java.util.List;
import java.util.Map;

/**
 * <p>desc: 节点执行处理器的SQL类型实现 </p>
 * <p>date: 2021/3/29 21:33 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class SqlProcesser implements IActionProcesser {

    @Override
    public Object execute(Map<String, Object> databus, Action action, JMap input, Object ... param) throws Exception {
        List<Sql> sqls = action.getSqls();
        Sql sql = sqls.get(0);

        System.out.println("执行SQL语句：" + sql.getSql());
        System.out.println("执行SQL参数：" + input);
        ISqlDao dao = new SqlDao(sql.getConn());
        List<Map<String, Object>> result = dao.executeSelect(sql.getSql(), input);
        return result;
    }
}
