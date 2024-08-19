package ai.rnt.auth2.server.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employee_master")
public class EmployeeMaster{


	@Id
	@GeneratedValue(strategy = GenerationType .IDENTITY)
	@Column(name = "staff_id")
	private Integer staffId;

	@Column(name = "password")
	private String password;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "f_name")
	private String firstName; // first_name

	@Column(name = "m_name")
	private String middleName; // middle_name

	@Column(name = "l_name")
	private String lastName;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "manager_id")
	private Integer managerId;

	@Column(name = "emp_job_title")
	private String employeeJobTitle;


	@Column(name = "date_of_departure")
	private LocalDate departureDate;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), 
	               inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<RoleMaster> employeeRole = new ArrayList<>();
	
	public EmployeeMaster() {}


	public EmployeeMaster(Integer staffId, String firstName, String lastName, LocalDate departureDate,String emailId) {
		super();
		this.staffId = staffId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.departureDate = departureDate;
		this.emailId = emailId;
	}


	public Integer getStaffId() {
		return staffId;
	}


	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public Integer getManagerId() {
		return managerId;
	}


	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}


	public String getEmployeeJobTitle() {
		return employeeJobTitle;
	}


	public void setEmployeeJobTitle(String employeeJobTitle) {
		this.employeeJobTitle = employeeJobTitle;
	}


	public LocalDate getDepartureDate() {
		return departureDate;
	}


	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}


	public List<RoleMaster> getEmployeeRole() {
		return employeeRole;
	}


	public void setEmployeeRole(List<RoleMaster> employeeRole) {
		this.employeeRole = employeeRole;
	}
	
	
}
