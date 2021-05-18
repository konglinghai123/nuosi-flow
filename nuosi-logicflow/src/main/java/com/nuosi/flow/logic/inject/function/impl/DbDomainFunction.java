package com.nuosi.flow.logic.inject.function.impl;

import com.ai.ipu.database.dao.IpuDaoManager;
import com.ai.ipu.database.dao.impl.CrudDao;
import com.nuosi.flow.logic.inject.function.AbstractDomainFunction;

import java.util.List;
import java.util.Map;

/**
 * <p>desc: 数据持久域的函数功能实现 </p>
 * <p>date: 2021/5/17 23:43 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class DbDomainFunction extends AbstractDomainFunction {

    public Map<String, Object> select(String connName, String tableName, Map<String, Object> data, boolean isMatchColumn) throws Exception {
        CrudDao dao = IpuDaoManager.takeCrudDao(connName);
        return dao.select(tableName, data, isMatchColumn);
    }

    public Map<String, Object> select(String connName, String tableName, Map<String, Object> data) throws Exception {
        CrudDao dao = IpuDaoManager.takeCrudDao(connName);
        return dao.select(tableName, data);
    }

    public int insert(String connName, String tableName, Map<String, Object> data) throws Exception {
        CrudDao dao = IpuDaoManager.takeCrudDao(connName);
        return dao.insert(tableName, data);
    }

    public int update(String connName, String tableName, Map<String, Object> data, boolean isMatchColumn) throws Exception {
        CrudDao dao = IpuDaoManager.takeCrudDao(connName);
        return dao.update(tableName, data, isMatchColumn);
    }

    public int update(String connName, String tableName, Map<String, Object> data) throws Exception {
        CrudDao dao = IpuDaoManager.takeCrudDao(connName);
        return dao.update(tableName, data);
    }

    public int delete(String connName, String tableName, Map<String, Object> data, boolean isMatchColumn) throws Exception {
        CrudDao dao = IpuDaoManager.takeCrudDao(connName);
        return dao.delete(tableName, data, isMatchColumn);
    }

    public int delete(String connName, String tableName, Map<String, Object> data) throws Exception {
        CrudDao dao = IpuDaoManager.takeCrudDao(connName);
        return dao.delete(tableName, data);
    }

    public int deleteByCond(String connName, String tableName, Map<String, Object> condition) throws Exception {
        CrudDao dao = IpuDaoManager.takeCrudDao(connName);
        return dao.deleteByCond(tableName, condition);
    }

    public List<Map<String, Object>> selectByCond(String connName, String tableName, Map<String, Object> condition) throws Exception {
        CrudDao dao = IpuDaoManager.takeCrudDao(connName);
        return dao.selectByCond(tableName, condition);
    }

    public int updateByCond(String connName, String tableName, Map<String, Object> data, Map<String, Object> condition) throws Exception {
        CrudDao dao = IpuDaoManager.takeCrudDao(connName);
        return dao.updateByCond(tableName, data, condition);
    }
}
