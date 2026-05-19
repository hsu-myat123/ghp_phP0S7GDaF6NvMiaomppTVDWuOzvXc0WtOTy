package scoremanager.main;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectUpdateAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        // ローカル変数の指定 1
        HttpSession session = req.getSession(); // セッション
        Teacher teacher = (Teacher)session.getAttribute("user");
        String cd = ""; // 学生番号
        String name = ""; // 氏名
        
        Subject subject = new Subject();
        SubjectDao subjectDao = new SubjectDao();
       

        // リクエストパラメーターの取得 2(from SubjectDao)
        cd = req.getParameter("cd");

        // DBからデータ取得 3
        // 学生の詳細データを取得
        subject = subjectDao.get(cd,teacher.getSchool());
        
        // ビジネスロジック 4
        name = subject.getName();

        // レスポンス値をセット 6
        req.setAttribute("cd", cd);
        req.setAttribute("name", name);
        
        // JSPへフォワード 7
        req.getRequestDispatcher("subject_update.jsp").forward(req, res);
    }

}