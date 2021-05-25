package kr.smhrd.model;

import java.util.List;
// JDBC(my sql) -> X -> MyBatis Framework
import java.sql.*; //java sql 임포트
import java.util.ArrayList;

public class BoardDAO {

   private PreparedStatement ps;
   private ResultSet rs;

   private static Connection getConnect() throws Exception {

      String URL = "jdbc:mysql://localhost:3306/mysql";
      String user = "root";
      String password = "12345";
      // MySQL Driver Loading(jar)
      Class.forName("com.mysql.jdbc.Driver");

      Connection conn = DriverManager.getConnection(URL, user, password);
      return conn;
   }
   //가지고 오는 메소드 boardList()
   public List<BoardVO> boardList() throws Exception{
      List<BoardVO> list = new ArrayList<BoardVO>(); //캐스팅
      Connection conn = getConnect();
      String SQL = "select idx,title,count,contents,writer, DATE_FORMAT(indate,'%Y-%m-%d') AS indate from tbl_board;";
      ps = conn.prepareStatement(SQL);
      rs = ps.executeQuery();
      // while + VO + List
      while(rs.next()) {
         int idx = rs.getInt("idx");
         String title = rs.getString("title");
         String contents = rs.getString("contents");
         String writer = rs.getString("writer");
         int count = rs.getInt("count");
          String indate = rs.getString("indate");
          BoardVO vo = new BoardVO();
          vo.setIdx(idx);
          vo.setTitle(title);
          vo.setContents(contents);
          vo.setWriter(writer);
          vo.setCount(count);
          vo.setIndate(indate);
          list.add(vo);
      }      
      return list;
   }
   // boardInsert()
   public int boardInsert(BoardVO vo) throws Exception{
      Connection conn = getConnect();
      String SQL = "insert into tbl_board(title, contents, writer) values(?, ?, ?)";
      ps = conn.prepareStatement(SQL);
      ps.setString(1, vo.getTitle());
      ps.setString(2, vo.getContents());
      ps.setString(3, vo.getWriter());
      int cnt = ps.executeUpdate();
      return cnt;
   }
   //boardDelete()
   public int boardDelete(int idx) throws Exception {
	Connection conn = getConnect();
	String SQL ="delete from tbl_board where idx =?";
    ps = conn.prepareStatement(SQL); // 전송객체를 만듬
	ps.setInt(1, idx);
	int cnt = ps.executeUpdate();
	return cnt;
   
   }
   
   //boardcontent()
   public BoardVO boardContent (int idx) throws Exception{
	    Connection conn = getConnect();
	    String SQL ="select idx,title,count, contents,writer, DATE_FORMAT(indate,'%Y-%m-%d') AS indate from tbl_board " + 
	    		"where idx=?";
	    ps = conn.prepareStatement(SQL); // 전송객체를 만듬
	    ps.setInt(1, idx);
	    rs = ps.executeQuery();
	    BoardVO vo = null;
	    if (rs.next()) {
	    	// vo에 묶는다
	    	   idx = rs.getInt("idx");
	           String title = rs.getString("title");
	           String contents = rs.getString("contents");
	           String writer = rs.getString("writer");
	           int count = rs.getInt("count");
	            String indate = rs.getString("indate");
	            vo = new BoardVO();
	            vo.setIdx(idx);
	            vo.setTitle(title);
	            vo.setContents(contents);
	            vo.setWriter(writer);
	            vo.setCount(count);
	            vo.setIndate(indate);
	    	
	    }
		return vo;
   }
   
   //boardUpdate()
   public int boardUpdate(BoardVO vo) throws Exception {
	   Connection conn = getConnect();
	   String SQL ="update tbl_board set title =?, contents = ? where idx =?";
	   ps = conn.prepareStatement(SQL);
	   ps.setString(1, vo.getTitle());
	   ps.setString(2, vo.getContents());
	   ps.setInt(3, vo.getIdx());
	   int cnt = ps.executeUpdate();
	   return cnt;
	   
   }
   
   
   
}
/*
 * JDBC -> (JAVA + SQL) : 유지보수가 어렵다.(SQL문장 수정) -> (JAVA)<---분리--->(SQL:파일
 * (메퍼파일-XML))
 * 
 */