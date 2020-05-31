package com.ems.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ems.model.Department;

public class DepartmentDaoImpl implements DepartmentDao {

	@Override
	public List<Department> getAllDepartments() {
		List<Department> departments = new ArrayList<>();
		Connection connection = null;
		Statement st = null; // used only to SELECT files in sql
		try {
			connection = DaoUtilities.getConnection();
			st = connection.createStatement();
			String sql = "SELECT * FROM department";
			ResultSet rs;
			rs = st.executeQuery(sql);
			// TODO Auto-generated catch block
			while (rs.next()) {
				Department d = new Department();
				d.setDepartmentId(rs.getInt("department_id"));
				d.setDepartmentName(rs.getString("department_name"));
//				System.out.println(rs.getInt("department_id"));
//				System.out.println(rs.getString("department_name"));
				departments.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return departments;
	}

}
