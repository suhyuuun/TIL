package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dto.DetailPageMapDTO;
import service.DetailPageMapService;

//http://localhost:8090/myapp/detailPage.do
//http://localhost:8090/myapp/detailPageMap.do
@Controller
public class DetailPageMapController {
//	private DetailPageMapService service;
//	
//	public DetailPageMapController() {
//
//	}
//	
//	public void setService(DetailPageMapService service) {
//		this.service = service;
//	}

	@RequestMapping(value="/detailPage.do")
	public String detailPageForm() {
		return "detailPage";
	}
	
//	@RequestMapping(value="/detailPageMap.do")
//	public String detailPageMapForm() {
//		return "detailPageMap";
//	}
	
//	@RequestMapping(value="/detailPage.do", method=RequestMethod.POST)
//	public ModelAndView detailPageMap(String latitude, String longitude, String data, ModelAndView mav) {
//		List<DetailPageMapDTO> mList = service.f_coordinate(data, latitude, longitude);
//		mav.addObject("mList",mList);
//		mav.addObject("latitude",latitude);
//		mav.addObject("longitude",longitude);
//		mav.setViewName("detailPageMap.do?lat=" + latitude + "lng=" + longitude);
//		return mav;
//	}
	
	
	@RequestMapping(value="/detailPageMap.do", method=RequestMethod.POST)
	public ModelAndView detailMap(String lat, String lng, ModelAndView mav) {
//		System.out.println("lat :" + lat + "lng : " + lng);
		mav.addObject("lat",lat);
		mav.addObject("lng",lng);
		mav.setViewName("jsonView");
		return  mav;
	}

}