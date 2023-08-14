package com.DI;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		//IOC- Inverse of Controller which is responsible for bean life cycle
		//To types of Container- BeanFactory, ApplicationContext
		
		
		
		//Second Way- ApplicationContext
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
		TextEditor editor=(TextEditor)context.getBean("editor");
		editor.spellcheck();
		
		
		
		
	}

}