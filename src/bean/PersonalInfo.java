package bean;

public class PersonalInfo {
	private String username;
	private String phoneNumber;
	private String name;
	private String sex;
	private String school;
	private String major;
	private String className;
	private String photoPath;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getClassName() {
		return className;
	}
	public String getMajor() {
		return major;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public String getSchool() {
		return school;
	}
	public String getSex() {
		return sex;
	}
	public String getUsername() {
		return username;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
