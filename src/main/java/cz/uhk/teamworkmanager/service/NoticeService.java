package cz.uhk.teamworkmanager.service;

import java.util.List;

import cz.uhk.teamworkmanager.model.Notice;

public interface NoticeService {
	
	public void save(Notice notice) ;
	public List<Notice> list() ;

}
