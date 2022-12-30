package service;

import java.util.List;

import dto.DetailPageMapDTO;

public interface DetailPageMapService {
	public List<DetailPageMapDTO> f_coordinate(String res, String latitude, String longtitude);
}