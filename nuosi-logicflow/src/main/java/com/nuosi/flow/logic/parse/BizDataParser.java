package com.nuosi.flow.logic.parse;

import com.ai.ipu.basic.util.IpuUtility;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nuosi.flow.logic.model.action.Sql;
import com.nuosi.flow.logic.model.body.Action;
import com.nuosi.flow.logic.model.domain.Attr;
import com.nuosi.flow.logic.model.domain.DomainModel;
import com.nuosi.flow.logic.model.element.Input;
import com.nuosi.flow.logic.model.element.Output;
import com.nuosi.flow.logic.model.element.Var;
import com.nuosi.flow.logic.util.XmlHelper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>desc: 描述这个类功能的注释 </p>
 * <p>date: 2021/3/25 13:49 </p>
 *
 * @author nuosi fsofs@163.com
 * @version v1.0.0
 * update:[序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
public class BizDataParser {
    public static final String MODEL = "model";
    public static final String ATTR = "attr";
    public static final String ACTION = "action";
    public static final String CHILDREN = XmlHelper.CHILDREN_TAG;

    public static final String INPUT = "input";
    public static final String OUTPUT = "output";
    public static final String SQL = "sql";

    public static final String VAR = "var";
    public static final String SUFFIX_ATTR = com.ai.ipu.common.xml.Dom4jHelper.SUFFIX_ATTR;

    private Map<String, Attr> attrMap = new HashMap<String, Attr>();

    public DomainModel parser(InputStream flowInputStream) throws Exception {
        XmlHelper dh = new XmlHelper(flowInputStream);
        JSONObject allJson = dh.getAllJson();
        DomainModel domainModel = parserDomainModel(allJson);
        return domainModel;
    }

    public DomainModel parserDomainModel(JSONObject allJson){
        JSONObject domainModelObject = allJson.getJSONObject(MODEL);
        JSONObject domainModeAttr = domainModelObject.getJSONObject(MODEL + SUFFIX_ATTR);
        DomainModel domainModel = domainModeAttr.toJavaObject(DomainModel.class);

        JSONArray children = domainModelObject.getJSONArray(CHILDREN);
        if (children != null && !children.isEmpty()) {
            List<Attr> attrs = new ArrayList<Attr>();
            List<Action> actions = new ArrayList<Action>();
            JSONObject modelItem;
            for (int i = 0; i < children.size(); i++) {
                modelItem = children.getJSONObject(i);
                if (modelItem.containsKey(ATTR)) {
                    Attr attr = parserAttr(modelItem.getJSONObject(ATTR));
                    attrMap.put(attr.getId(), attr);
                    attrs.add(attr);
                } else if (modelItem.containsKey(ACTION)) {
                    Action action = parserAction(modelItem.getJSONObject(ACTION));
                    actions.add(action);
                } else{
                    IpuUtility.error("无可匹配标签："+ modelItem);
                }
            }
            if(!attrs.isEmpty()){
                domainModel.setAttrs(attrs);
            }
            if(!actions.isEmpty()){
                domainModel.setActions(actions);
            }
        }

        return domainModel;
    }

    public Attr parserAttr(JSONObject attrObject){
        JSONObject attrJson = attrObject.getJSONObject(ATTR + SUFFIX_ATTR);
        Attr attr = attrJson.toJavaObject(Attr.class);
        return attr;
    }

    public Action parserAction(JSONObject actionObject){
        JSONObject actionJson = actionObject.getJSONObject(ACTION + SUFFIX_ATTR);
        Action action = actionJson.toJavaObject(Action.class);

        JSONArray children = actionObject.getJSONArray(CHILDREN);
        if (children != null && !children.isEmpty()) {
            JSONObject actionItem;
            List<Input> inputs = null;
            List<Output> outputs = null;
            List<Sql> sqlActions = null;
            for (int i = 0; i < children.size(); i++) {
                actionItem = children.getJSONObject(i);
                if (actionItem.containsKey(OUTPUT)) {
                    outputs = outputs==null?new ArrayList<Output>():outputs;
                    Output output = parserOutput(actionItem.getJSONObject(OUTPUT));
                    outputs.add(output);
                } else if (actionItem.containsKey(INPUT)) {
                    inputs = inputs==null?new ArrayList<Input>():inputs;
                    Input input = parserInput(actionItem.getJSONObject(INPUT));
                    inputs.add(input);
                } else if (actionItem.containsKey(SQL)) {
                    sqlActions = sqlActions==null?new ArrayList<Sql>():sqlActions;

                }else{
                    IpuUtility.error("无可匹配标签："+ actionItem);
                }
            }
            action.setInputs(inputs);
            action.setOutputs(outputs);
        }
        return action;
    }

    public Output parserOutput(JSONObject outputObject){
        JSONArray children = outputObject.getJSONArray(CHILDREN);
        List<Var> vars = new ArrayList<Var>();
        Var var;
        if (children != null && !children.isEmpty()) {
            for (int i = 0; i < children.size(); i++) {
                var = parserVar(children.getJSONObject(i));
                vars.add(var);
            }
        }
        return new Output().setVars(vars);
    }

    public Input parserInput(JSONObject inputObject){
        JSONArray children = inputObject.getJSONArray(CHILDREN);
        List<Var> vars = new ArrayList<Var>();
        Var var;
        if (children != null && !children.isEmpty()) {
            for (int i = 0; i < children.size(); i++) {
                var = parserVar(children.getJSONObject(i));
                vars.add(var);
            }
        }
        return new Input().setVars(vars);
    }

    public Var parserVar(JSONObject varObject){
        JSONObject varJson = varObject.getJSONObject(VAR);
        JSONObject varAttr = varJson.getJSONObject(VAR + SUFFIX_ATTR);
        if (varAttr.containsKey(ATTR)) {
            String attrId = varAttr.getString(ATTR);
            if(attrMap.containsKey(attrId)){
                Attr attr = attrMap.get(attrId);
                varAttr.putAll((JSONObject) JSON.toJSON(attr));
            }else{
                IpuUtility.error("未声明属性"+attrId);
            }
        }
        Var var = varAttr.toJavaObject(Var.class);
        return var;
    }
}
