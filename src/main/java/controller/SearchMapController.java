package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//http://localhost:8090/myapp/searchMap.do

@Controller
public class SearchMapController {
	public SearchMapController() {

	}
	
	@RequestMapping(value="/searchMap.do")
	public String searchMap() {
		return "searchMap";
	}
	
	
}