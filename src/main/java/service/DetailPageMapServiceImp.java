package service;

import java.util.HashMap;
import java.util.List;

import dao.DetailPageMapDao;
import dto.DetailPageMapDTO;

public class DetailPageMapServiceImp  implements DetailPageMapService{
	private DetailPageMapDao dao;
	
	public DetailPageMapServiceImp() {
	
	}

	public void setDao(DetailPageMapDao dao) {
		this.dao = dao;
	}

	@Override
	public List<DetailPageMapDTO> f_coordinate(String latitude, String longtitude) {
		HashMap<String, Object> coordinate = new HashMap<String, Object>();
		coordinate.put("latitude", latitude);
		coordinate.put("longtitude", longtitude);
		return dao.res_coordinate(coordinate);
	}

	@Override
	public List<DetailPageMapDTO> res_all(String res, String latitude, String longitude) {
		HashMap<String, Object> res_all = new HashMap<String, Object>();
		res_all.put("res", res);
		res_all.put("latitude", latitude);
		res_all.put("longitude", longitude);
		return dao.res_all(res_all);
	}

	
}