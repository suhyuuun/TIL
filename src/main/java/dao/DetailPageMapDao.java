package dao;

import java.util.HashMap;
import java.util.List;

import dto.DetailPageMapDTO;

public interface DetailPageMapDao {
	public List<DetailPageMapDTO> res_coordinate(HashMap<String, Object> coor);
	public List<DetailPageMapDTO> res_all(HashMap<String, Object> all);

}