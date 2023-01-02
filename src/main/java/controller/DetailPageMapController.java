package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import service.DetailPageMapService;

//http://localhost:8090/myapp/detailPage.do
//http://localhost:8090/myapp/detailPageMap.do
@Controller
public class DetailPageMapController {
	private DetailPageMapService service;

	public DetailPageMapController() {

	}

	public void setService(DetailPageMapService service) {
		this.service = service;
	}

	@RequestMapping(value = "/detailPage.do")
	public String detailPageForm() {
		return "detailPage";
	}

	@RequestMapping(value = "/detailPageMap.do", method = RequestMethod.POST)
	public ModelAndView detailMap(String lat, String lng, ModelAndView mav) {
		mav.addObject("lat", lat);
		mav.addObject("lng", lng);
		mav.setViewName("jsonView");
		return mav;
	}

}