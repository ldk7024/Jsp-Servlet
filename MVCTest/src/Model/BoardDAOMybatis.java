package Model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDAOMybatis {
   private static SqlSessionFactory sqlSessionFactory;  //프레임워크에서는 변수이름 쓸때 똑같이 불러와서 첫글자만 소문자로
   
   static { // static 은 초기화 블럭
      try {
         String resource = "kr/smhrd/mybatis/config.xml";
         InputStream inputStream = Resources.getResourceAsStream(resource);
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }//_static

  
   public LoginVO loginMember(LoginVO vo) {
	   SqlSession sqlSession= sqlSessionFactory.openSession();
	   vo = sqlSession.selectOne("loginMember", vo);
	   sqlSession.close();
	   return vo;
	   
   }
   
   
   
   
}