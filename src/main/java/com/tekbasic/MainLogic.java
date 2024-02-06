package com.tekbasic;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainLogic {

	public static void main(String[] args) {
		// with spring.xml
		//ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		
		// with SpringUtil
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringUtil.class);
		
		SpringDAO sd = ac.getBean(SpringDAO.class);
		

		
		
		
		Scanner scanner = new Scanner(System.in);
		
		do {
            System.out.println("Enter the choice (1.Insert 2.Update 3.Delete 4.Select):");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                	sd.insert();
                    break;
                case 2:
                    sd.update();
                    break;
                case 3:
                    sd.delete();
                    break;
                case 4:
                    sd.select();
                    break;
                default:
                    System.out.println("Invalid choice");
            }

            System.out.println("Do you want to continue (y/n)?");
        } while (scanner.next().equalsIgnoreCase("y"));

        scanner.close();
    
		
        
		

	}

}
