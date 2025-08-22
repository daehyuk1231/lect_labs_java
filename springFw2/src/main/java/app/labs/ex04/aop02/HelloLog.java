package app.labs.ex04.aop02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class HelloLog {

	// class Method
	public static void log() {
		System.out.println(">>> Log:" + new java.util.Date());
	}
	
	public void resultLog(JoinPoint joinpoint, Object resultObject) {
		Signature signature = joinpoint.getSignature();
		String methodName = signature.getName();
		System.out.println(">>> RESULT 핵심코드 메서드명:" + methodName);
		System.out.println(">>> 핵심코드 반환값:" + resultObject.toString());
	}
	
	public void exceptionLog(JoinPoint joinpoint, Exception exception) {
		Signature signature = joinpoint.getSignature();
		String methodName = signature.getName();
		System.out.println(">>> RESULT 핵심코드 메서드명:" + methodName);
		System.out.println(">>> 예외메시지 :" + exception.toString());
	}
	
	public Object aroundLog(ProceedingJoinPoint joinpoint) {
		Object result = null;
		
		Signature signature = joinpoint.getSignature();
		String methodName = signature.getName();
		System.out.println(">>> RESULT 핵심코드 메서드명:" + methodName);
		Object[] args = joinpoint.getArgs(); // 매개변수
		
		try {
			result = joinpoint.proceed();
		}
		catch(Throwable e) {
			System.out.println(">>> Exception :" + e.getMessage());
		}
		finally {
			System.out.println(">>> Finally");
		}
		
		return result;
	}	
}
