 package mwcd.hk.REST;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class RESTrepository {

	
	
	
	Connection connection = null; 
	
	
	public RESTrepository() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hk?useSSL=false", "root", "root");
	}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	//USER
	public List<User> getUsers(){
		List<User> users = new ArrayList<>();
		String sql = "SELECT * FROM users";
		
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				User a = new User();
				a.setId(rs.getInt(1));
				a.setRole(rs.getString(2));
				a.setFullname(rs.getString(3));
				a.setEmail(rs.getString(4));
				a.setPassword(rs.getString(5));
				
				users.add(a);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return users;
	}
	
	 //Read 1 element
	public User getUser(int id) {
		
		String sql = "SELECT * FROM users WHERE id="+id;
		User a = new User();
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
			 	
				a.setId(rs.getInt(1));
				a.setRole(rs.getString(2));
				a.setFullname(rs.getString(3));
				a.setEmail(rs.getString(4));
				a.setPassword(rs.getString(5));
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return a; 
	}
	
	//Create
	public void create(User a1) {
		String sql = "INSERT INTO users VALUES(?,?,?,?,?)";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, a1.getId());
			st.setString(2, a1.getRole());
			st.setString(3, a1.getFullname());
			st.setString(4, a1.getEmail());
			st.setString(5, a1.getPassword());
			
			st.executeUpdate();
			
			
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	//Update
	public void update(User a1) {
		String sql = "UPDATE users SET role=?, `full Name`=?, email=?, password=? WHERE id=?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, a1.getRole());
			st.setString(2, a1.getFullname());
			st.setString(3, a1.getEmail());
			st.setString(4, a1.getPassword());
			st.setInt(5, a1.getId());
			
			st.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	//Delete   
	public void deleteUser(int id) {
		String sql = "DELETE FROM users WHERE id=?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			
			st.setInt(1, id);
			st.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
		
		
//PROJECTS
		public List<Project> getProjects(){
			List<Project> projects = new ArrayList<>();
			String sql = "SELECT * FROM projects";
			
			try {
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					Project p = new Project();
					p.setId(rs.getInt(1));
					p.setProjectTitle(rs.getString(2));
					p.setStart_date(rs.getString(3));
					p.setDue_date(rs.getString(4));
					p.setProjectDetails(rs.getString(5));
					
					projects.add(p);
				}
				
			} catch (Exception e) {
				System.out.println(e);
			}
			
			
			return projects;
		}
		
		 //Read 1 element
		public Project getProject(int id) {
			
			String sql = "SELECT * FROM projects WHERE id="+id;
			Project p = new Project();
			try {
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(sql);
				if(rs.next()) {
				 	
					p.setId(rs.getInt(1));
					p.setProjectTitle(rs.getString(2));
					p.setStart_date(rs.getString(3));
					p.setDue_date(rs.getString(4));
					p.setProjectDetails(rs.getString(5));
					
				}
				
			} catch (Exception e) {
				System.out.println(e);
			}
			return p; 
		}
		
		//Create
		public void create(Project p1) {
			String sql = "INSERT INTO projects VALUES(id,?,?,?,?)";
			try {
				PreparedStatement st = connection.prepareStatement(sql);
				st.setInt(1, p1.getId());
				st.setString(2, p1.getProjectTitle());
				st.setString(3, p1.getStart_date());
				st.setString(4, p1.getDue_date());
				st.setString(5, p1.getProjectTitle());
				
				st.executeUpdate();

			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
		
		//Update
		public void update(Project p1) {
			String sql = "UPDATE projects SET `Project Title`=?, `Start Date`=?, `Due Date`=?, `Project Details`=? WHERE id=?";
			try {
				PreparedStatement st = connection.prepareStatement(sql);
				st.setString(1, p1.getProjectTitle());
				st.setString(2, p1.getStart_date());
				st.setString(3, p1.getDue_date());
				st.setString(4, p1.getProjectDetails());
				st.setInt(5, p1.getId());
				
				st.executeUpdate();
				
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
		
		//Delete   
		public void deleteProject(int id) {
			String sql = "DELETE FROM projects WHERE id=?";
			try {
				PreparedStatement st = connection.prepareStatement(sql);
				
				st.setInt(1, id);
				st.executeUpdate();
				
			} catch (Exception e) {
				System.out.println(e);
			}
		
	}
	
}
