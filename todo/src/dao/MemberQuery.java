package dao;

public class MemberQuery {
	/*
	 * 사용하러 가져간 곳에서 수정 불가하도록 final
	 * 쿼리 분리 : 나중에 쿼리를 수정할 때 쿼리 클래스만 수정하면 되도록
	 */
	public static final String LOGIN;
	public static final String DELETE_MEMBER;
	static {
		LOGIN = "SELECT member_id memberId FROM member WHERE member_id=? AND member_pw=?";
		DELETE_MEMBER = "DELETE FROM member WHERE member_id=? AND member_pw=?";
	}
}
