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
	public List<DetailPageMapDTO> coordinate(HashMap<String, Object> data) {
		return sqlSession.selectList("res_test.res_coordindate",data);
	}

}
