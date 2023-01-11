package kr.co.kico.json;

import java.io.PrintWriter;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import kr.co.kico.start.FirstTestDTO;
import kr.co.kico.start.FirstTestService;

@Controller
public class JsonController2 {
	
	public static final Logger logger = LoggerFactory.getLogger(JsonController2.class);
	
	@Autowired
	private FirstTestService service;
	
	@RequestMapping(value ="/json12", method = RequestMethod.GET)
	public String page4Json12()
	{
		return "json/json12";
	}
	
	@RequestMapping(value ="/json12return", method = RequestMethod.GET)
	public void page4Json12r(PrintWriter out)
	{
		JSONObject obj = new JSONObject();
		obj.put("movieName", "about time");
		obj.put("mainActor", "레이첼");
		obj.put("mainActorRole", "카페 주인");
		
		JSONObject obj2 = new JSONObject();
		obj2.put("movieName", "어벤져스");
		obj2.put("mainActor", "톰");
		obj2.put("mainActorRole", "스파이더맨");
		
		JSONObject obj3 = new JSONObject();
		obj3.put("movieName", "워낭소리");
		obj3.put("mainActor", "소");
		obj3.put("mainActorRole", "방울단 소");
		
		JSONArray arr = new JSONArray();
		arr.add(obj);
		arr.add(obj2);
		arr.add(obj3);
		
		logger.info(arr.toJSONString());
		
		out.print(arr.toJSONString());
	}
	
	@RequestMapping(value ="/json13return", method = RequestMethod.GET)
	public void page4Json13ret(PrintWriter out)
	{
		List<FirstTestDTO> list = service.selectAllEmp();
		out.print(new Gson().toJson(list));
		
	}// page4Json13ret
	
	
	@RequestMapping(value ="/json13", method = RequestMethod.GET)
	public String page4Json13()
	{
		return "json/json13";
	}
	
	@RequestMapping(value ="/json11", method = RequestMethod.GET)
	public String page4Json11(Model model)
	{
		JSONObject obj = new JSONObject();
		obj.put("movieName", "about time");
		obj.put("mainActor", "레이첼");
		obj.put("mainActorRole", "카페 주인");
		
		JSONObject obj2 = new JSONObject();
		obj2.put("movieName", "어벤져스");
		obj2.put("mainActor", "톰");
		obj2.put("mainActorRole", "스파이더맨");
		
		JSONObject obj3 = new JSONObject();
		obj3.put("movieName", "워낭소리");
		obj3.put("mainActor", "소");
		obj3.put("mainActorRole", "방울단 소");
		
		JSONArray arr = new JSONArray();
		arr.add(obj);
		arr.add(obj2);
		arr.add(obj3);
		
		logger.info(arr.toJSONString());
		model.addAttribute("jsonArrString", arr.toJSONString());
		return "json/json11";
	}
}
