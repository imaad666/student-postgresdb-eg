package Student;

import java.util.List;
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
			
			case 2:
				System.out.println("enter your id to be updated");
				int id1 = sc.nextInt();
				System.out.println("enter your name to be updated");
				String name1=sc.next();
				System.out.println("enter your age to be updated");
				int age1=sc.nextInt();
				student stud = new student(id1,name1,age1);
				int update = service.update(stud);
				if(update!=0) System.out.println("Updated");
				break;
				
			case 3:
				List<student> sts = service.getAll();
				if(sts!=null) {
					for(student stds : sts) {
						System.out.println(stds);
					}
				}
				else {
					System.out.println("data not found");
				}
				break;
				
			case 4:
				System.out.println("enter id to be deleted");
				int id2=sc.nextInt();
				int delete = service.delete(id2);
				if(delete!=0) {
					System.out.println("data deleted");
				}else {
					System.out.println("id invalid");
				}
				break;
			
			case 5:
				boolean exit = service.exit();
				if(exit) {
					flag = false;
					System.out.println("app closed");
				}else {
					System.out.println("app still running");
				}
				break;
				
			default:
				System.out.println("invalid I/P");
				break;
				
			}
		}
	}
}
