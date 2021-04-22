package com.sumbab.project.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class NoticeDaoImpl implements NoticeDao{
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	public NoticeDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int selectClassify(String id) {
		return sqlSessionTemplate.selectOne("selectClassify", id);
	}

	@Override
	public List<Notice> selectNotice(String id) {
		return sqlSessionTemplate.selectList("selectNotice", id);
	}

	@Override
	public List<Notice> allNotice() {
		return sqlSessionTemplate.selectList("allNotice");
	}

	@Override
	public Notice noticeDetail(int noticeNum) {
		return (Notice)sqlSessionTemplate.selectOne("noticeDetail", noticeNum);
	}
	
	

}
