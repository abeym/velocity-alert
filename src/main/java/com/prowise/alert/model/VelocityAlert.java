package com.prowise.alert.model;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.velocity.*;
import org.apache.velocity.app.*;


public class VelocityAlert {
	
	private VelocityEngine ve = new VelocityEngine();
	public VelocityAlert(String vmPath)
	{
		Properties p = new Properties();
		try {
			p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("velocity.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setProperty(Velocity.RUNTIME_LOG_LOGSYSTEM_CLASS, "org.apache.velocity.runtime.log.SystemLogChute");                        
		//
		p.setProperty("resource.loader", "class");
		p.setProperty("class.resource.loader.description", "Velocity Classpath Resource Loader");
		p.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		p.setProperty("file.resource.loader.path", vmPath+"/WEB-INF/classes//");
		//
		//Velocity.init(p);
		ve.init(p);
	}
	public String parse(String tmFile, Map<String, Object> contextVars)
	{
		VelocityContext context = new VelocityContext();
		for (Map.Entry<String, Object> vars : contextVars.entrySet()) {
			context.put(vars.getKey(), vars.getValue());
		}
		Template tm = null;
		try {
			//tm = Velocity.getTemplate(tmFile);
			tm = ve.getTemplate(tmFile);
		} catch (Exception e) {
			System.out.println(e);
		}
		StringWriter sw = new StringWriter();
		tm.merge(context, sw);
		return sw.toString();
	}

	public static void main(String[] args) {
		VelocityAlert va = new VelocityAlert("src/main/java/");
		String tmFile = "sqlTemplate.vm";
		Map<String, Object> contextVars = new HashMap<String, Object>();
		List entityList = getEntityList();
		contextVars.put("entityList", entityList);
		String msg = va.parse(tmFile,contextVars);
		
		System.out.println("Parsed Msg:\n"+msg);
	}

	public static List getEntityList2()
	{
		List entityList = new ArrayList();
		Map entity = new HashMap();
		entity.put("name", "ACCOUNT_TABLE");
		List columns = new ArrayList();
		Map col;
		//column 1
		col = new HashMap();
		col.put("LHS", "ACCOUNT_BAL");
		col.put("condition", "<=");
		col.put("RHS", "100");
		columns.add(col);
		//column 2
		col = new HashMap();
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
		List entityList = new ArrayList();
		Entity entity = new Entity();
		entity.setName("ACCOUNT_TABLE");
		List columns = new ArrayList();
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
