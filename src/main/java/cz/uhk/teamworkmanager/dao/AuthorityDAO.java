package cz.uhk.teamworkmanager.dao;

import java.util.List;

import cz.uhk.teamworkmanager.model.Authority;
import cz.uhk.teamworkmanager.model.Notice;

public interface AuthorityDAO {

	public void save(Authority authority) ;
	
	public void update (Authority authority);
	
	public List<Authority> list() ;
	
}
