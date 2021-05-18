package board;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.JdbcUtil;
import mvc.CommonController;

public class BoardListController implements CommonController {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			Connection conn = JdbcUtil.getConnection();
			BoardDAO dao = BoardDAO.getInstance();
			List<BoardVO> list = dao.select(conn);
			req.setAttribute("list", list);
		}catch(Exception e) {
			
		}
		return "/board/list.jsp";
	}

}
