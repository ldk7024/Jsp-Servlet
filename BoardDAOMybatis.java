package kr.smhrd.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDAOMybatis {       // Connection pool
   private static SqlSessionFactory sqlSessionFactory;  //프레임워크에서는 변수이름 쓸때 풀네임 그대로 불러와서 첫글자만 소문자로
                  //JDBC Connection => mybatis SqlSessionFactory
   static { // static 은 초기화 블럭
      try {
         String resource = "kr/smhrd/mybatis/config.xml";
         InputStream inputStream = Resources.getResourceAsStream(resource); //읽어드리는 클래스
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }//_static
   // 게시판 리스트
   public List<BoardVO> boardList(){
       SqlSession sqlsession = sqlSessionFactory.openSession();
      //String sql = "select idx,title,count,contents,writer, DATE_FORMAT(indate,'%Y-%m-%d') AS indate from tbl_board;";
       List<BoardVO> list = sqlsession.selectList("boardList"); // Mapper에 id값을 가지고온다.
       sqlsession.close();//반납
      return list;
   }
   public int boardInsert(BoardVO vo) {
	   SqlSession sqlSession = sqlSessionFactory.openSession();
	   int cnt = sqlSession.insert("boardInsert",vo);
	   sqlSession.commit(); // 완료
	   sqlSession.close(); // 반납
	   return cnt;
   }
   public int boardDelete(int idx) {
	   SqlSession sqlSession = sqlSessionFactory.openSession();
	   int cnt = sqlSession.delete("boardDelete",idx);
	   sqlSession.commit(); // 완료
	   sqlSession.close(); // 반납
	   return cnt;
   }
   public BoardVO boardContent (int idx) {
	   SqlSession sqlSession = sqlSessionFactory.openSession();
	   BoardVO vo=sqlSession.selectOne("boardContent", idx);
	   sqlSession.close(); // 반납
	   return vo;
   }
   public int boardUpdate (BoardVO vo) {
	   SqlSession sqlSession = sqlSessionFactory.openSession();
	   int cnt=sqlSession.update("boardupdate",vo);
	   sqlSession.commit();
	   sqlSession.close(); // 반납
	   return cnt;
   }
   
   
}
