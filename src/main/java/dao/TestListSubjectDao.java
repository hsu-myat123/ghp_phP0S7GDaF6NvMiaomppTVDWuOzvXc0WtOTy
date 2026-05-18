package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import bean.TestListSubject;

public class TestListSubjectDao extends Dao {

    // 基本SQL
    private String baseSql =
        "SELECT * FROM TEST t " +
        "INNER JOIN STUDENT s ON t.STUDENT_NO = s.NO ";

    // ResultSetからList<TestListSubject>へ変換
    public List<TestListSubject> postFilter(ResultSet rs) throws Exception {

        List<TestListSubject> list = new ArrayList<>();

        while (rs.next()) {

            TestListSubject student = new TestListSubject();

            student.setEntYear(rs.getInt("ENT_YEAR"));
            student.setStudentNo(rs.getString("STUDENT_NO"));
            student.setStudentName(rs.getString("NAME"));
            student.setClassNum(rs.getString("CLASS_NUM"));

            list.add(student);
        }

        return list;
    }

    // 学生ごとの成績一覧取得
    public List<TestListSubject> filter(Student student) throws Exception {

        List<TestListSubject> list = new ArrayList<>();

        Connection con = getConnection();

        String sql = baseSql + "WHERE s.NO = ?";

        PreparedStatement st = con.prepareStatement(sql);

        st.setString(1, student.getNo());

        ResultSet rs = st.executeQuery();

        list = postFilter(rs);

        st.close();
        con.close();

        return list;
    }
}