package cz.uhk.teamworkmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import cz.uhk.teamworkmanager.dao.NoticeDAO;
import cz.uhk.teamworkmanager.model.Notice;

@Transactional
public class NoticeServiceImpl implements NoticeService{

	@Autowired
    private NoticeDAO noticeDAO;
     
    
    public void save(Notice notice) {
        noticeDAO.saveNotice(notice);
    }
    
    public List<Notice> list() {
        return noticeDAO.listNotes();
    }
	
}
