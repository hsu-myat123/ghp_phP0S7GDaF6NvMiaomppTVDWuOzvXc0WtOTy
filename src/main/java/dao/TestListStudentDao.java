package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import bean.TestListStudent;

public class TestListStudentDao extends Dao {

	private String baseSql =
		"select " +
		"subject_name, " +
		"subject_cd, " +
		"num, " +
		"point " +
		"from test " +
		"where school_cd = ? ";

	public List<TestListStudent> filter(Student student) throws Exception {

		List<TestListStudent> list = new ArrayList<>();

		Connection connection = getConnection();

		PreparedStatement statement = null;

		ResultSet rSet = null;

		String order = " order by subject_cd asc";

		try {

			statement = connection.prepareStatement(baseSql + order);

			statement.setString(1, student.getSchool().getCd());

			rSet = statement.executeQuery();

			list = postFilter(rSet);

		} finally {

			if (rSet != null) {
				rSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connection != null) {
				connection.close();
			}
		}

		return list;
	}

	private List<TestListStudent> postFilter(ResultSet rSet) throws Exception {

		List<TestListStudent> list = new ArrayList<>();

		while (rSet.next()) {

			TestListStudent res = new TestListStudent();

			res.setSubjectName(rSet.getString("subject_name"));
			res.setSubjectCd(rSet.getString("subject_cd"));
			res.setNum(rSet.getInt("num"));
			res.setPoint(rSet.getInt("point"));

			list.add(res);
		}

		return list;
	}
}