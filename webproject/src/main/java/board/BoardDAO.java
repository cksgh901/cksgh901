package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;

public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();
	private BoardDAO() {}
	public static BoardDAO getInstance() {
		return instance;
	}
	
	
	public BoardVO selectOne(Connection conn, int boardno) {
		Statement stmt = null;
		ResultSet rs = null;
		BoardVO vo = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from board where boardno="+boardno);
			if (rs.next()) {
				vo = new BoardVO();
				vo.setBoardno(rs.getInt("boardno"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setReadcnt(rs.getInt("readcnt"));
				vo.setRegdate(rs.getTimestamp("regdate"));
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(stmt);
			JdbcUtil.close(rs);
		}
		return vo;
	}
	
	public int insert(Connection conn, BoardVO vo) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(
					"insert into board (title, content, readcnt, regdate) values (?,?,?,now())");
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getReadcnt());
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt);
		}
		return result;
	}
	
	
	public int update(Connection conn, BoardVO vo) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(
					"update board set title=?, content=? where boardno=?");
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getBoardno());
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt);
		}
		return result;
	}
	
	public int delete(Connection conn, BoardVO vo) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(
					"delete from board where boardno=?");
			pstmt.setInt(1, vo.getBoardno());
			
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt);
		}
		return result;
	}
	
	public List<BoardVO> select(Connection conn) {
		Statement stmt = null;
		ResultSet rs = null;
		BoardVO vo = null;
		List<BoardVO>list = new ArrayList<BoardVO>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from board ");
			
			while (rs.next()) {
				vo = new BoardVO();
				vo.setBoardno(rs.getInt("boardno"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setReadcnt(rs.getInt("readcnt"));
				vo.setRegdate(rs.getTimestamp("regdate"));
				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(stmt);
			JdbcUtil.close(rs);
		}
		return list;
	}
	
	public int updateReadcnt(Connection conn, int boardno) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(
					"update board set readcnt=readcnt+1 where boardno=?");
			pstmt.setInt(1, boardno);
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt);
		}
		return result;
	}
	
}


