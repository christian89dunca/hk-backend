package mwcd.hk.REST;



public class Project {
	
	private int id;
	private String projectTitle;
	private String start_date;
	private String due_date;
	private String projectDetails;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getDue_date() {
		return due_date;
	}
	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	public String getProjectDetails() {
		return projectDetails;
	}
	public void setProjectDetails(String projectDetails) {
		this.projectDetails = projectDetails;
	}
	@Override
	public String toString() {
		return "Projects [id=" + id + ", projectTitle=" + projectTitle + ", start_date=" + start_date + ", due_date="
				+ due_date + ", projectDetails=" + projectDetails + "]";
	}
	
	

	
	
}
