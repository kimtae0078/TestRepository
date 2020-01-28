package com.takim.siem.jdbc.controller;

import java.util.List;
import java.util.UUID;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.takim.siem.constant.Constant;
import com.takim.siem.jdbc.model.JdbcInfo;
import com.takim.siem.jdbc.model.KeyInfo;
import com.takim.siem.jdbc.service.JdbcWebService;

@Controller
public class JdbcWebController {
	private static String token = "";

	@Autowired
	JdbcWebService jdbcWebService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String selectJdbcInfoList(@ModelAttribute JdbcInfo vo, Model model) {

		List<JdbcInfo> jdbcList = jdbcWebService.selectJdbcInfoList();
		model.addAttribute("jdbcList", jdbcList);

		return "jdbcList";
	}

	@RequestMapping(value = "/addSchedulerPage", method = RequestMethod.GET)
	public String moveAddSchedulerPage() {
		return "addSchedulerPage";
	}

	@RequestMapping(value = "/addScheduler", method = RequestMethod.POST)
	public String insertScheduler(@ModelAttribute JdbcInfo jdbcVO, @ModelAttribute KeyInfo keyVO) {

		UUID randomUuid = UUID.randomUUID();
		jdbcVO.setIdx(randomUuid.toString());
		keyVO.setJdbcIdx(randomUuid.toString());

		jdbcWebService.insertScheduler(jdbcVO);
		jdbcWebService.insertTableKey(keyVO);

		Gson gson = new Gson();
		String jdbcJson = gson.toJson(jdbcVO);
		String url = "https://tomcat:8443/add";

		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(url);
		Invocation.Builder invocationBuilder = webTarget.request();

		if (!token.isEmpty()) {
			invocationBuilder.header(Constant.HEADER_AUTH, token);
		}

		Response response = invocationBuilder.post(Entity.entity(jdbcJson, MediaType.TEXT_PLAIN_TYPE));
		if (response.getCookies().get(Constant.COOKIE_NAME) != null) {
			token = response.getCookies().get(Constant.COOKIE_NAME).getValue();
		}

		return "redirect:/";
	}

	@RequestMapping(value = "/deleteScheduler", method = RequestMethod.GET)
	public String deleteScheduler(@RequestParam("idx") String schedulerIdx) {
		jdbcWebService.deleteKey(schedulerIdx);
		jdbcWebService.deleteScheduler(schedulerIdx);

		String url = "https://tomcat:8443/delete";
		String idx = schedulerIdx;

		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(url);
		Invocation.Builder invocationBuilder = webTarget.request();

		if (!token.isEmpty()) {
			invocationBuilder.header(Constant.HEADER_AUTH, token);
		}

		Response response = invocationBuilder.post(Entity.entity(idx, MediaType.TEXT_PLAIN_TYPE));
		if (response.getCookies().get(Constant.COOKIE_NAME) != null) {
			token = response.getCookies().get(Constant.COOKIE_NAME).getValue();
		}

		return "redirect:/";
	}

	@RequestMapping(value = "/updateSchedulerPage", method = RequestMethod.GET)
	public String moveUpdateSchedulerPage(@RequestParam("idx") String schedulerIdx, Model model) {
		JdbcInfo jdbcVO = jdbcWebService.selectOneJdbcInfo(schedulerIdx);
		KeyInfo keyVO = jdbcWebService.selectOneKeyInfo(schedulerIdx);
		model.addAttribute("jdbcVO", jdbcVO);
		model.addAttribute("keyVO", keyVO);

		return "updateSchedulerPage";
	}

	@RequestMapping(value = "/updateScheduler", method = RequestMethod.POST)
	public String updateScheduler(@ModelAttribute JdbcInfo jdbcVO, @ModelAttribute KeyInfo keyVO,
			@RequestParam String keyCheck) {
		jdbcWebService.updateScheduler(jdbcVO);
		jdbcWebService.uptateTableKey(keyVO);
		Gson gson = new Gson();
		String jdbcJson = gson.toJson(jdbcVO);
		
		String url = "https://tomcat:8443/update";

		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(url);
		Invocation.Builder invocationBuilder = webTarget.request();

		if (!token.isEmpty()) {
			invocationBuilder.header(Constant.HEADER_AUTH, token);
		}

		Response response = invocationBuilder.post(Entity.entity(jdbcJson, MediaType.APPLICATION_JSON));
		if (response.getCookies().get(Constant.COOKIE_NAME) != null) {
			token = response.getCookies().get(Constant.COOKIE_NAME).getValue();
		}

		return "redirect:/";
	}

	@RequestMapping(value = "/validationCheck.ajax", method = RequestMethod.POST)
	@ResponseBody
	public String getTableValidation(@RequestBody JdbcInfo jdbcVO) {
		Gson gson = new Gson();
		String jdbcJson = gson.toJson(jdbcVO);
		
		String url = "https://tomcat:8443/validationCheck";

		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(url);
		Invocation.Builder invocationBuilder = webTarget.request();

		if (!token.isEmpty()) {
			invocationBuilder.header(Constant.HEADER_AUTH, token);
		}

		Response response = invocationBuilder.post(Entity.entity(jdbcJson, MediaType.APPLICATION_JSON));
		if (response.getCookies().get(Constant.COOKIE_NAME) != null) {
			token = response.getCookies().get(Constant.COOKIE_NAME).getValue();
		}
		
		String responseData = "";
		if (response.getStatus() == 200) {
			responseData = response.readEntity(String.class);
		}
		return responseData;
}}
