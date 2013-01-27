package cz.uhk.teamworkmanager.web;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cz.uhk.teamworkmanager.model.Notice;
import cz.uhk.teamworkmanager.service.NoticeService;

@Controller
@RequestMapping("/notebook")
public class NotebookController {

	@Autowired
    NoticeService noticeService;
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String notebook(@PathVariable String name, Locale locale, Model model) {
		
		model.addAttribute("noteName", name);
		
		
		return "notebookDetail"; 
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String notebookList(Locale locale, Model model) {
		
		/*
		Notice n = new Notice("Poznámka");
		noticeService.save(n);
		
		List<Notice> result = noticeService.list();
		for ( Notice ntc : (List<Notice>) result ) {
			System.out.println( "Poznamka (" + ntc.getText() + ")" );
		}
		*/
		
		return "notebook"; 
	}
	
}
