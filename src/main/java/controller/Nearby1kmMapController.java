package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// http://localhost:8090/myapp/nearby1kmMap.do

@Controller
public class Nearby1kmMapController {
	public Nearby1kmMapController() {

	}
	
	@RequestMapping(value = "/nearby1kmMap.do")
	public String nearby1kmMap() {
		return "nearby1kmMap";
	}
}