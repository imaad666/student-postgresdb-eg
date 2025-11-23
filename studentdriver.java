package Student;

import java.util.Scanner;

public class studentdriver {
	public static void main(String[] args) {
		studentservice service = new studentservice();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Imaad's Atelier");
		boolean flag = true;
		while(flag) {
			System.out.println("enter 1 to save student data");
			System.out.println("enter 2 to update student data");
			System.out.println("enter 3 to fetch student data");
			System.out.println("enter 4 to delete student data");
			System.out.println("enter 5 to close application");
			
			System.out.println("enter your choice: ");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("enter your id");
				int id = sc.nextInt();
				System.out.println("enter your name");
				String name = sc.nextLine();
				System.out.println("enter your age");
				int age = sc.nextInt();
				
				student st = new student(id,name,age);
				service.save(st);
				break;
			}
		}
	}
}
