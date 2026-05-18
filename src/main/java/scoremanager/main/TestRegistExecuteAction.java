package scoremanager.main;

import bean.Student;
import bean.Subject;
import bean.Test;
import dao.StudentDao;
import dao.TestDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class TestRegistExecuteAction extends Action {

	@Override
	public void execute(
		HttpServletRequest req,
		HttpServletResponse res
	) throws Exception {

		// パラメータ取得
		String studentNo =
			req.getParameter("studentNo");

		String subjectCd =
			req.getParameter("subjectCd");

		String pointStr =
			req.getParameter("point");

		String noStr =
			req.getParameter("no");

		// 型変換
		int point =
			Integer.parseInt(pointStr);

		int no =
			Integer.parseInt(noStr);

		// StudentDao
		StudentDao studentDao =
			new StudentDao();

		// 学生取得
		Student student =
			studentDao.get(studentNo);

		// Subject
		Subject subject =
			new Subject();

		subject.setCd(subjectCd);

		// Test
		Test test =
			new Test();

		test.setStudent(student);

		test.setSubject(subject);

		test.setSchool(
			student.getSchool()
		);

		test.setClassNum(
			student.getClassNum()
		);

		test.setNo(no);

		test.setPoint(point);

		// 保存
		TestDao dao =
			new TestDao();

		boolean result =
			dao.save(test);

		System.out.println(result);

		// 完了画面
		String url =
			"/scoremanager/main/test_regist_done.jsp";

		req.getRequestDispatcher(url)
			.forward(req, res);
	}
}