package app.labs.ex03.di04;

public class MemberService implements IMemberService {

	@Override
	public Member getMemberInfo() {
	    Member member = new Member();
	    member.setMemberId("1234");
	    member.setName("홍길동");
	    member.setAge(20);
	    member.setEmail("a@b.com");
	    
		return member;
	}

}
