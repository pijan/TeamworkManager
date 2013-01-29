package cz.uhk.teamworkmanager.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cz.uhk.teamworkmanager.model.Task;

public class TaskDAOImpl implements TaskDAO {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public void saveTask(Task task) {
		sessionFactory.getCurrentSession().save(task);
	}

	@Override
	public void deleteTask(int taskId) {
		String hql = "delete from Task where taskId= :taskId";
		sessionFactory.getCurrentSession().createQuery(hql).setInteger("taskId", taskId).executeUpdate();
	}

	@Override
	public void updateTask(Task task) {
		sessionFactory.getCurrentSession().update(task);
	}

	@Override
	public Task loadTaskById(int taskId) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Task where taskId= :taskId");
		query.setParameter("taskId", taskId); 
		List<Task> result = query.list(); 
	    return (result.isEmpty() ? null : result.get(0)); 
	}

	@Override
	public List<Task> listTask() {
		List result = sessionFactory.getCurrentSession().createCriteria(Task.class).list();
		return result;
	}

}
