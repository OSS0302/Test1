package login;

public enum CheckType {
// 0:db error,1:아이디가 틀리다.,2:패스워드 틀리다. ,3로그인 성공,
	DB_ERROR(0),ID_ERROR(1),PW_ERROR(2),SUCCESS(3);
	
	private int num;
	CheckType(int num){
		this.num = num;
	}
	public int value() {
		return num; 
	}
}
