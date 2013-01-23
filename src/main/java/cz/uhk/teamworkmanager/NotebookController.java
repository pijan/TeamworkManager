package cz.uhk.teamworkmanager;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.uhk.teamworkmanager.dao.NoticeDAOImpl;
import cz.uhk.teamworkmanager.dao.UserDAOImpl;
import cz.uhk.teamworkmanager.model.Notice;
import cz.uhk.teamworkmanager.model.User;

@Controller
@RequestMapping("/notebook")
public class NotebookController extends BaseController {

	//NoticeDAOImpl noticeDAO = new NoticeDAOImpl(this.session);
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String notebook(@PathVariable String name, Locale locale, Model model) {
		
		model.addAttribute("noteName", name);
		
		
		return "notebookDetail"; 
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String notebookList(Locale locale, Model model) {
		
		/*
		Notice n = new Notice("Poznámka");
		noticeDAO.saveNotice(n);
		
		List result = noticeDAO.listNotes();
		for ( Notice ntc : (List<Notice>) result ) {
			System.out.println( "Poznamka (" + ntc.getText() + ")" );
		}
		*/
		return "notebook"; 
	}
	
}
