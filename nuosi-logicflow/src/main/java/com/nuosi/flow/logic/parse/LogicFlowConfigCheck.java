package com.nuosi.flow.logic.parse;

import com.ai.ipu.basic.util.IpuUtility;
import com.ai.ipu.data.JMap;
import com.ai.ipu.data.impl.JsonMap;
import com.ai.ipu.database.conn.SqlSessionManager;
import com.nuosi.flow.data.BDataDefine;
import com.nuosi.flow.data.BizDataManager;
import com.nuosi.flow.logic.invoke.handler.ActionProcesserManager;
import com.nuosi.flow.logic.invoke.handler.IActionProcesser;
import com.nuosi.flow.logic.model.LogicFlow;
import com.nuosi.flow.logic.model.action.Expression;
import com.nuosi.flow.logic.model.action.Foreach;
import com.nuosi.flow.logic.model.action.If;
import com.nuosi.flow.logic.model.action.Sql;
import com.nuosi.flow.logic.model.body.Action;
import com.nuosi.flow.logic.model.body.End;
import com.nuosi.flow.logic.model.body.Start;
import com.nuosi.flow.logic.model.domain.Attr;
import com.nuosi.flow.logic.model.element.Input;
import com.nuosi.flow.logic.model.element.Output;
import com.nuosi.flow.logic.model.element.Var;
import com.nuosi.flow.logic.model.global.Databus;
import com.nuosi.flow.logic.model.global.Import;
import com.nuosi.flow.util.LogicFlowConstants;

import java.util.*;

/**
 * <p>desc: 逻辑编排配置文件检查 </p>
 * <p>date: 2021/4/28 17:40 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 */
public class LogicFlowConfigCheck {

}
