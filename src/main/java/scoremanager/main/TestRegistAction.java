package scoremanager.main;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class TestRegistAction extends Action {

    @Override
    public void execute(
        HttpServletRequest req,
        HttpServletResponse res
    ) throws Exception {

        // リクエストパラメータ取得
        String studentNo =
            req.getParameter("studentNo");

        String subjectCd =
            req.getParameter("subjectCd");

        String point =
            req.getParameter("point");

        // 確認用
        System.out.println(studentNo);
        System.out.println(subjectCd);
        System.out.println(point);

        // 遷移先
        String url =
            "/scoremanager/main/test_regist.jsp";

        // フォワード
        req.getRequestDispatcher(url)
            .forward(req, res);
    }
}