package cz.uhk.teamworkmanager.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

@Entity
@Table( name = "tasks" )
public class Task implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * Třída pro úkoly
	 */
	
	@Id
	@GeneratedValue
	private int taskId;
	
	private String title;
	private String description;
	
	private User owner;
	private User assignedUser;
	
	private Timestamp deadline;
	private Timestamp dateCreated;
	private Timestamp dateModified;
	
	private int state;
	final static int STATE_NEW = 1;
	final static int STATE_WAITING_FOR_RESOURCES = 2;
	final static int STATE_WORKING_ON = 3;
	final static int STATE_COMPLETE = 4;
	
	private int priority;
	final static int PRIORITY_LOW = 1;
	final static int PRIORITY_NORMAL = 2;
	final static int PRIORITY_HIGH = 3;
	final static int PRIORITY_CRITICAL = 4;
	
	public Task(){
		
	}

	public Task(String title, User owner) {
		this.title = title;
		this.owner = owner;
	}
	
	public Task(String title, String description, User owner,
			User assignedUser, Timestamp deadline, Timestamp dateCreated,
			Timestamp dateModified, int state, int priority) {
		this.title = title;
		this.description = description;
		this.owner = owner;
		this.assignedUser = assignedUser;
		this.deadline = deadline;
		this.dateCreated = dateCreated;
		this.dateModified = dateModified;
		this.state = state;
		this.priority = priority;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Comment.class)
	@JoinTable(name = "task_comments", joinColumns = { @JoinColumn(name = "taskId") }, inverseJoinColumns = { @JoinColumn(name = "commentId") })
	
	private Set<Comment> taskComments = new HashSet<Comment>(0);
		
	public Set<Comment> getTaskComments() {
		return taskComments;
	}

	public void setTaskComments(Set<Comment> taskComments) {
		this.taskComments = taskComments;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public User getAssignedUser() {
		return assignedUser;
	}

	public void setAssignedUser(User assignedUser) {
		this.assignedUser = assignedUser;
	}

	public Timestamp getDeadline() {
		return deadline;
	}

	public void setDeadline(Timestamp deadline) {
		this.deadline = deadline;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Timestamp getDateModified() {
		return dateModified;
	}

	public void setDateModified(Timestamp dateModified) {
		this.dateModified = dateModified;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	
}
