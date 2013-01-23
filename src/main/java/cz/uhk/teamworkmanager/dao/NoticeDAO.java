package cz.uhk.teamworkmanager.dao;

import java.util.List;

import cz.uhk.teamworkmanager.model.Notice;

public interface NoticeDAO {

	public void saveNotice(Notice notice) ;
	public List<Notice> listNotes() ;
	
}
