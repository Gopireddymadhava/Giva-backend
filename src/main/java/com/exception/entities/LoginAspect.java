package com.exception.entities;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.exception.exceptions.LoginResponse;
@Component
@Aspect
public class LoginAspect {
	
	 @Pointcut("execution(* com.exception.service.User1Service.loginEmployee(..))")
	    public void loginPointcut() {
	    }

	    @Before("execution(* com.exception.service.User1Service.loginEmployee(..))")
	    public void beforeLogin() {
	      
	        System.out.println("Before login");
	    }
	    @Pointcut("execution(* com.exception.service.User1Service.saveUser(..))")
	    public void signupPointcut() {
	    }
	    
	    
	    
	    @Before("execution(* com.exception.service.User1Service.saveUser(..))")
	    public void beforesignup() {
	      
	        System.out.println(" Before signup  ");
	    }
	    @After("execution(* com.exception.service.User1Service.saveUser(..))")
	    public void Aftersignup() {
	    	System.out.println("After Signup");
	    }



	    @AfterReturning(pointcut = "loginPointcut()", returning = "result")
	    public void logAfterLogin(JoinPoint joinPoint, Object result) {
	        System.out.println(" after login: " + joinPoint.getSignature().getName());
	        System.out.println("Result: " + result);
	    }
	    
	    
	    

}
