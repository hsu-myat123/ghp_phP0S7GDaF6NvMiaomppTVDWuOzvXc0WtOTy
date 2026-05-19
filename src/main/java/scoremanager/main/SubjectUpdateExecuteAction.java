package scoremanager.main;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectUpdateExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        // ローカル変数の指定 1
    	
    	HttpSession session = req.getSession();
    	Teacher teacher = (Teacher)session.getAttribute("user");
    	
        String cd = "";
        String name = "";
     
        Subject subject = new Subject();
        SubjectDao subjectDao = new SubjectDao();

        // リクエストパラメーターの取得 2
        cd = req.getParameter("cd");
        name = req.getParameter("name");

        // DBからデータ取得 3
        // なし

        // studentに学生情報をセット
        subject.setCd(cd);
        subject.setName(name);
        
        subject.setSchool(teacher.getSchool());
       

        // 変更内容を保存
        subjectDao.save(subject); //SubjectDao

        // JSPへフォワード 7
        req.getRequestDispatcher("subject_update_done.jsp").forward(req, res);
    }

}