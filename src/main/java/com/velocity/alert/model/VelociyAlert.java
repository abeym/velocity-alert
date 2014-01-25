package com.velocity.alert.model;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class VelociyAlert {
	
	public String parse(String tmFile, Map<String, Object> contextVars)
	{
		Velocity.init();
		VelocityContext context = new VelocityContext();
		for (Map.Entry<String, Object> vars : contextVars.entrySet()) {
			context.put(vars.getKey(), vars.getValue());
		}

		Template tm = null;
		try {
			tm = Velocity.getTemplate(tmFile);
		} catch (Exception e) {
			System.out.println(e);
		}
		StringWriter sw = new StringWriter();
		tm.merge(context, sw);
		return sw.toString();
	}
	public static void main(String[] args) {
		VelociyAlert va = new VelociyAlert();
		String tmFile = "sqlTemplate.vm";
		Map<String, Object> contextVars = new HashMap<String, Object>();
		contextVars.put("name", "Abey");
		String msg = va.parse(tmFile,contextVars);
		
		System.out.println("Parsed Msg:"+msg);
	}

	public List getTableData()
	{
		List tableData = new ArrayList<>();
		return tableData;
		
	}
}
