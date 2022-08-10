package Diary;

import java.util.Scanner;
public class DiaryMain {
	public static void main(String[] args) {
		String id= null,pw;
			String  Title; 

	Scanner sc =new Scanner(System.in);
	Check check =new Check(); 

	
	System.out.println("!!!나의 일기장입니다.! ");
	System.out.println("1번 입장하기");
	int Diary = sc.nextInt();

	sc.nextLine();//숫자 입력후 엔터값 없애기
	System.out.println("입장 ");
	
	if(Diary ==1) {
		System.out.print("ID :");
		id = sc.nextLine();
		String trim = id.trim();
		System.out.print("PW :");
		pw = sc.nextLine();
		String trim1 = pw.trim();
		
		int flag=check.login(id,trim1);
		
		if(flag ==3) 
		{
			System.out.println("아이디가 틀립니다.");//  아이디가 틀립 했습니다.
		}
		else if(flag ==2)
		{
			System.out.println("비밀번호가틀립니다.");// 비밀번호가 틀립니다.	
		}
		else if(flag ==1) 
		{
		System.out.println("로그인성공");//로그인 성공
		}else 
		{
			
			
		}
	}
	System.out.print("날짜 입력: "  );
	int date = sc.nextInt();
	Title = sc.nextLine();
	System.out.println("******************************** "  );
	System.out.print("제목 :");
	Title = sc.nextLine();




		}// MAIN 함수
	} //class 함수
