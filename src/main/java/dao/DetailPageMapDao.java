package dao;

import java.util.HashMap;
import java.util.List;

import dto.DetailPageMapDTO;

public interface DetailPageMapDao {
	public List<DetailPageMapDTO> coordinate(HashMap<String, Object> data);

}