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

		String url =
			"/scoremanager/main/test_regist.jsp";

		req.getRequestDispatcher(url)
			.forward(req, res);
	}
}