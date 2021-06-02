package kr.smhrd.model;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDAOMybatis {
	private static SqlSessionFactory sqlSessionFactory;
	static {
		try {
			String resource = "kr/smhrd/mybatis/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
	
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}//_static
	}
}
