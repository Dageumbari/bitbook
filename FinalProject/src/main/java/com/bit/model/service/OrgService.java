package com.bit.model.service;

import java.util.List;

import com.bit.model.vo.DashBoardVO;

public interface OrgService {
	
	public List<DashBoardVO> getAllOrgList(int userNo);
	public DashBoardVO getOrgInfo(String dashBoardUrl);
	public void createOrg(String dashBoardName);
	public void deleteOrg(String dashBoardCode); 
	
	//리턴자료형 설정 해야됨
	//public DashBoardVO orgNameModify(DashBoardVO dashBoardVO);
	//public DashBoardVO orgURLModify(DashBoardVO dashBoardVO);
	
	//조직 대표 이미지 업로드 변경
	//public void orgLogoModify();
}	
