package dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.DetailPageMapDTO;

public class DetailPageMapDaoImp implements DetailPageMapDao {

	private SqlSessionTemplate sqlSession;

	public DetailPageMapDaoImp() {

	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<DetailPageMapDTO> res_coordinate(HashMap<String, Object> coor) {
		return sqlSession.selectList("res_test.res_coordindate",coor);
	}

	@Override
	public List<DetailPageMapDTO> res_all(HashMap<String, Object> all) {
		return sqlSession.selectList("res_test.res_all",all);
	}


}
