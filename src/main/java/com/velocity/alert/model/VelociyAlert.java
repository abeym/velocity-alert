package com.velocity.alert.model;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class VelociyAlert {
	
	public String parse(String tmFile, Map<String, Object> contextVars)
	{
		Velocity.init("src/main/java/velocity.properties");
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
		String tmFile = "src/main/java/sqlTemplate.vm";
		Map<String, Object> contextVars = new HashMap<String, Object>();
		List entityList = getEntityList();
		contextVars.put("entityList", entityList);
		String msg = va.parse(tmFile,contextVars);
		
		System.out.println("Parsed Msg:\n"+msg);
	}

	public static List getEntityList2()
	{
		List entityList = new ArrayList<>();
		Map entity = new HashMap<>();
		entity.put("name", "ACCOUNT_TABLE");
		List columns = new ArrayList<>();
		Map col;
		//column 1
		col = new HashMap<>();
		col.put("LHS", "ACCOUNT_BAL");
		col.put("condition", "<=");
		col.put("RHS", "100");
		columns.add(col);
		//column 2
		col = new HashMap<>();
		col.put("LHS", "BAL_DATE");
		col.put("condition", "<=");
		col.put("RHS", getCurrentDate());
		columns.add(col);
		//
		entity.put("columns", columns);
		return entityList;
		
	}

	public static List getEntityList()
	{
		List entityList = new ArrayList<>();
		Entity entity = new Entity();
		entity.setName("ACCOUNT_TABLE");
		List columns = new ArrayList<>();
		Column col;
		//column 1
		col = new Column();
		col.setLHS("ACCOUNT_BAL");
		col.setCondition("<=");
		col.setRHS("100");
		columns.add(col);
		//column 2
		col = new Column();
		col.setLHS("BAL_DATE");
		col.setCondition("<=");
		col.setRHS(getCurrentDate());
		columns.add(col);
		//
		entity.setColumns(columns);
		entityList.add(entity);
		return entityList;
	}

	private static String getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		return sdf.format(new Date());
	}
}
