package cz.uhk.teamworkmanager.service;

import java.util.List;

import cz.uhk.teamworkmanager.model.Authority;
import cz.uhk.teamworkmanager.model.User;

public interface AuthorityService {
	
	public void save(Authority authority) ;
	
	public void update (Authority authority);
	
	public List<Authority> list() ;

}
