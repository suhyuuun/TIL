package service;

import java.util.List;

import dto.DetailPageMapDTO;

public interface DetailPageMapService {
	public List<DetailPageMapDTO> res_all(String res,String latitude, String longtitude);
	public List<DetailPageMapDTO> f_coordinate(String latitude, String longtitude);
}