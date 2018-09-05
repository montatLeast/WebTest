package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.JdbcLink;

public class PersonalService {
	private Connection conn;
	private PreparedStatement pstmt;
	public PersonalService() {
		conn = new JdbcLink().getConn();
	}
	public PersonalInfo queryInfo(String account){
		try{
			PersonalInfo personalInfo = new PersonalInfo();
			pstmt = conn.prepareStatement("select * from person where account="+"'"+account+"'");
			ResultSet rst = pstmt.executeQuery();
			if(rst.next()){
				
				personalInfo.setName(rst.getString(3));
				personalInfo.setSex(rst.getString(4));
				personalInfo.setSchool(rst.getString(5));
				personalInfo.setMajor(rst.getString(6));
				personalInfo.setClassName(rst.getString(7));
				personalInfo.setPhotoPath(rst.getString(8));
			}
			return personalInfo;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean updateInfo(PersonalInfo personalInfo){
		try {
			pstmt=conn.prepareStatement("update person set sex=?,school=?,major=?,classname=? where account=?");

			pstmt.setString(1, personalInfo.getSex());
			pstmt.setString(2, personalInfo.getSchool());
			pstmt.setString(3, personalInfo.getMajor());
			pstmt.setString(4, personalInfo.getClassName());
			pstmt.setString(5, personalInfo.getUsername());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updatePhoto(String usr,String photopath){
		try{
			pstmt=conn.prepareStatement("update person set photopath=? where account=?");
			pstmt.setString(1, photopath);
			pstmt.setString(2, usr);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	public String getPhoneNumber(String usr) {
		try{
			String phoneNumber = "";
			pstmt = conn.prepareStatement("select * from person where account="+"'"+usr+"'");
			ResultSet rst = pstmt.executeQuery();
			if(rst.next()){
				phoneNumber = rst.getString(2);
			}
			return phoneNumber;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
}
