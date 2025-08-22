package app.labs.ex03.di04;

public class MemberController {

	IMemberService memberService;
	
	public void setMemberService(IMemberService memberService) {
		this.memberService = memberService;
	}
	
	public void printInfo() {
		Member member = memberService.getMemberInfo();
		System.out.println(member);		
	}
}
