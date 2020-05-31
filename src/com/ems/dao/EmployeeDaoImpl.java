package com.ems.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ems.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		Connection con = null;
		Statement st = null;
		try {
			con = DaoUtilities.getConnection();
			st = con.createStatement();
			String sql = "SELECT * FROM display";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Employee e = new Employee();
				e.setEmployeeId(rs.getInt("Employee ID"));
				e.setFirstName(rs.getString("First Name"));
				e.setLastName(rs.getString("Last Name"));
				e.setDepartmentName(rs.getString("Department"));
				employees.add(e);
			}
		} catch (SQLException e) {
			System.out.println("Failed in: getAllEmployees located in EmployeeDaoImpl");
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employees;
	}

}
