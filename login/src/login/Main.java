package login;

import java.util.List;
import java.util.Scanner;

public class Main {
 
	public static void main(String[] args) {
		Check check =new Check();
		String id= null, pw ,pw2;
		Scanner sc =new Scanner(System.in);
		
		for(;;) 
		{
		System.out.println("로그인할려면1번,회원가입을 하려면 2 회원 삭제(3)를 입력하세요.");
		int menu = sc.nextInt();
		sc.nextLine();//숫자 입력후 엔터값 없애기
		
		if(menu==1) 
		{
			System.out.println("아이디를 입력해주세요");
			id = sc.nextLine();
			String trim = id.trim();//아이디 입력시 공백 제거
			
			System.out.println("패스워드를 입력해주세요");
			pw = sc.nextLine();
			String trim1 = pw.trim();//비밀 번호 입력시 공백 제거
		
		  // 객체(Check)의 메소드 (login) string id, string pw :int():db 접속오류1: 아이디가 틀리다.
		//2.패스워드가틀리다. 3.로그인성공) 를  통해서 로그인 여부를 확인해줌
			
			//CheckType flag =CheckType.login(id,pw);
			//int flag = check.login(id.trim(),pw.trim());
			CheckType flag=check.login(id,pw);
			// int flag = check.loin(id,pw);
			
			if(flag ==CheckType.ID_ERROR) {
				System.out.println("아이디가 틀립니다.");//  아이디가 틀립 했습니다.
			}
			else if(flag ==CheckType.PW_ERROR){
				System.out.println("비밀번호가틀립니다.");// 비밀번호가 틀립니다.	
			}
			else if(flag ==CheckType.SUCCESS) {
			System.out.println("로그인성공");//로그인 성공
			}
		}	
		
			
		else if(menu ==2) 
		{ 
			
			 
		
			System.out.println("회원가입 시작합니다 .");
			for(int i =0; i<100; i++){ 
			
			System.out.print("아이디를 입력해주세요");
			id = sc.nextLine();//아이디 입력시 공백 제거
			String trim_id = id.trim();
			
			if(trim_id.equals(check.ID_DUPLICATION(trim_id)))
			{
				System.out.println("아이디가 중복입니다. 다른아이디를 입력해주세요.");// 아이디가 중복시 다른아이디를 써야합니다.
				id = sc.nextLine();//아이디 입력시 공백 제거
				String trim3 = id.trim();
			}
		
			
			System.out.print("패스워드를 입력해주세요");
			pw = sc.nextLine();
			String trim1 = pw.trim();//비밀 번호 입력시 공백 제거
			System.out.print("패스워드를 한번더 입력해주세요");
			pw = sc.nextLine();
			String trim2 =pw.trim();
			
			check.signUp(id,pw);
			System.out.println("회원가입 완료");
		}
		
		}
		
		else if(menu ==3) {
			
			System.out.println("회원 삭제를 입력하세요.");
			System.out.print("삭제 할 아이디를 입력해주세요");
			id = sc.nextLine();
			String trim = id.trim();//아이디 입력시 공백 제거
			System.out.println("회원 삭제 완료");
			check.delete(id);
			
		}
		else {//4번 회원목록보기
			List <User> list =check.list();
			for(User temp :list) {
				System.out.println(temp.id+"     ");
				System.out.println(temp.pw);
			}
		}
		
	     } //for

	}// main
	
} //class
	

