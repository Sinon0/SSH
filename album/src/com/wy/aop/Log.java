package com.wy.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Sinon
 *首先需要将log类变成一个切面类
 *类上添加@Aspect将该类变成一个切面
 *添加@Component表示该类也需要由Spring初始化成一个对象组件
 */
@Aspect
@Component(value="log")
public class Log {
	//@PointCut为切入点取名字，简化代码
	@Pointcut("execution(* com.wy.service.impl.*.*(..))")
	public void myPoint(){}
	
	@Before("myPoint()")
	public void mybefore(JoinPoint jp){
		System.out.println(jp.getSignature());
		System.out.println("方法执行开始......");
	}
	
	@AfterReturning("myPoint()")
	public void myend(){
		System.out.println("方法执行结束.....");
	}
}
