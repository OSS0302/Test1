package Diary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Check {
	private Connection conn() throws Exception {
		String url = "jdbc:oracle:thin:@192.168.0.45:1521:xe";
		Class.forName("oracle.jdbc.driver.OracleDriver");//데이터베이스 드라이버를 로딩한다.
		return DriverManager.getConnection(url, "scott", "tiger");// 2.연결한다.
	}
	private void connClose(ResultSet rs,PreparedStatement stmt,Connection con) {
		try {if(rs!=null) rs.close();   } catch (Exception e) {}
		try {if(stmt!=null) stmt.close();  } catch (Exception e) {}
		try {if(con!=null) con.close();   } catch (Exception e) {}
	}
	public int login(String id, String pw) {// 로그인 아이디와 패스워드 입력 생성자
 		// db에접속후 id와 pw가지고 확인해서 //1~3까지의 값을 return주면된다
 		
 		ResultSet rs =null;
 		PreparedStatement stmt= null;
 		Connection con= null;
		try {
			con = conn();
			System.out.println("DB접속 성공");
		 stmt =con.prepareStatement("select * from tbl_user where id =?");
		//삽입,삭제,갱신시에는 .excuteupate() 리턴이 정수 (정수가 의미하는 몇개가 처리되었는지)
		 stmt.setString(1,id);
		 rs = stmt.executeQuery();
	 //rs =	stmt.executeQuery("select * from tbl_user where id ='"+id+"'"); //sql문 (select)실행하기
		 if(rs.next()) {// 한행이 있다면 (즉 아이디가 있다면)
	
			 String dbPw=rs.getString("pw");//db의 결과중 컬럼이 pw인 값을 읽는다.
			 if(pw.equals(dbPw))
				 return 3;
			 else 
				 return 2;
		 }else
			 return 1;
	

	
	
		} catch (Exception e) {
			System.out.println("예외 발생");
			e.printStackTrace();
		}finally {
			connClose(rs,stmt,con);
			
			
			}
			 //finally 예외 사항에서 꼭 수행해야 할 명령문을 적어준다.
			
			
		
		return 0;
	}//1~3까지 값을 리턴해준다.

}
