package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Subject;

public class SubjectDao extends Dao {

    // 科目コードと学校コードから1件取得
    public Subject get(String cd, School school) throws Exception {

        Subject subject = null;

        Connection con = getConnection();

        String sql = "SELECT * FROM SUBJECT WHERE CD = ? AND SCHOOL_CD = ?";

        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, cd);
        st.setString(2, school.getCd());

        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            subject = new Subject();

            subject.setCd(rs.getString("CD"));
            subject.setName(rs.getString("NAME"));
            subject.setSchool(school);
        }

        st.close();
        con.close();

        return subject;
    }

    // 学校ごとの科目一覧取得
    public List<Subject> filter(School school) throws Exception {

        List<Subject> list = new ArrayList<>();

        Connection con = getConnection();

        String sql = "SELECT * FROM SUBJECT WHERE SCHOOL_CD = ?";

        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, school.getCd());

        ResultSet rs = st.executeQuery();

        while (rs.next()) {

            Subject subject = new Subject();

            subject.setCd(rs.getString("CD"));
            subject.setName(rs.getString("NAME"));
            subject.setSchool(school);

            list.add(subject);
        }

        st.close();
        con.close();

        return list;
    }

    // 登録
    public boolean save(Subject subject) throws Exception {

        Connection con = getConnection();

        String sql = "INSERT INTO SUBJECT(CD, NAME, SCHOOL_CD) VALUES(?, ?, ?)";

        PreparedStatement st = con.prepareStatement(sql);

        st.setString(1, subject.getCd());
        st.setString(2, subject.getName());
        st.setString(3, subject.getSchool().getCd());

        int line = st.executeUpdate();

        st.close();
        con.close();

        return line > 0;
    }

    // 削除
    public boolean delete(Subject subject) throws Exception {

        Connection con = getConnection();

        String sql = "DELETE FROM SUBJECT WHERE CD = ? AND SCHOOL_CD = ?";

        PreparedStatement st = con.prepareStatement(sql);

        st.setString(1, subject.getCd());
        st.setString(2, subject.getSchool().getCd());

        int line = st.executeUpdate();

        st.close();
        con.close();

        return line > 0;
    }
}