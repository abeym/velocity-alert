package com.prowise.alert.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prowise.alert.form.AlertForm;
import com.prowise.alert.model.VelocityAlert;
import com.prowise.alert.vo.AlertVO;

@Controller
@RequestMapping("/alert-submit.htm")
public class AlertController {

	@RequestMapping(method = RequestMethod.POST)
	public String submitAlertDef(@ModelAttribute(value="alertForm") AlertForm alertForm, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		if(alertForm == null)
		{
			alertForm = new AlertForm();
			model.addAttribute("alertForm", alertForm);
		}
		String rule = alertForm.getRule();
		String vmPath = request.getSession().getServletContext().getRealPath("/");
		VelocityAlert va = new VelocityAlert(vmPath);
		String tmFile = "sqlTemplate.vm";
		Map<String, Object> contextVars = new HashMap<String, Object>();
		List entityList = getEntityList(alertForm);
		contextVars.put("entityList", entityList);
		String convRule = va.parse(tmFile,contextVars);
		AlertVO alertVO = new AlertVO();
		alertVO.setRule(convRule);
		model.addAttribute("alertVO", alertVO);
		return "alert";

	}

	private List getEntityList(AlertForm alert) {
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
		col.put("RHS", "2014-01-01");
		columns.add(col);
		//
		entity.put("columns", columns);
		return entityList;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getAlertDef(@ModelAttribute(value="alertForm") AlertForm alertForm, ModelMap model) {
		if(alertForm == null)
		{
			alertForm = new AlertForm();
			model.addAttribute("alertForm", alertForm);
		}
		return "alert";
	}
	
}
