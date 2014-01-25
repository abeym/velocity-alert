package com.prowise.alert.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/alert-submit.htm")
public class AlertController {

	@RequestMapping(method = RequestMethod.POST)
	public String submitAlertDef(ModelMap model) {
		String text = (String) model.get("rule1");
		StringBuffer convRule = new StringBuffer();
		if(text!=null)
		{
			text.replaceAll("\n", "<br/>");
			convRule.append("<div style='width: 392px; height: 106px; border: medium;border-color: black;'>");
			convRule.append(text); 
			convRule.append("</div>");
		}
		model.addAttribute("message", convRule.toString());
		return "alert";

	}

	@RequestMapping(method = RequestMethod.GET)
	public String getAlertDef(ModelMap model) {
		return "alert";
	}
	
}
