package com.perscholas.java;

import java.io.IOException;
import java.util.Scanner;

public class ClubMemberApp {

	public static void main(String[] args) throws IOException {
	
		SoftwareDevelopmentClub members = new SoftwareDevelopmentClub("names.txt");
		
		boolean memberFlag = true;
		
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Select from the following menu:\n"
					+ "1. Display Members\n"
					+ "2. Remove Member\n"
					+ "3. Add Member\n"
					+ "4. Quit");
			
			int option = sc.nextInt();
			
			switch(option) {
			case 1:
				members.showMembers();
				break;
			case 2:
				System.out.println("Which member would you like to remove?");
				members.listByName();
				int memberToDelete = sc.nextInt();
				members.removeMember(memberToDelete);
				break;
			case 3:
				sc.nextLine();
				
				System.out.println("Enter name of member:");
				String memberName = sc.nextLine();
				
				System.out.println("Enter city of member:");
				String memberCity = sc.nextLine();
				
				System.out.println("Enter state of member:");
				String memberState = sc.nextLine();
				
				System.out.println("Enter favorite language of member:");
				String memberLang = sc.nextLine();
				System.out.println("\n");
				
				members.addMember(memberName, memberCity, memberState, memberLang);
				break;
			case 4:
				System.out.println("Have a great day!");
				memberFlag = false;
				break;
			default:
				memberFlag = false;
				break;
			}
			
		}while(memberFlag);
		
		sc.close();

	}

}
