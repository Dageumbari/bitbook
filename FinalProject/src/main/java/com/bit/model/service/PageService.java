package com.bit.model.service;

import java.util.List;

import com.bit.model.vo.PageVO;

public interface PageService {
	public List<PageVO> getPageList();
	public List<PageVO> getAllList();
	public int pageSave(PageVO pv);

	//public int pagePudate(PageVO pv);

}