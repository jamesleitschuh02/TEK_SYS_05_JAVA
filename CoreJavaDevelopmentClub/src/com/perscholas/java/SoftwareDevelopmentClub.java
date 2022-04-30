package com.perscholas.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SoftwareDevelopmentClub {
	
	private File textFile;
	List<ClubMember> memberList = new ArrayList<>();
	
	List<String> strList = new ArrayList<>();
	
	List<String> nameList = new ArrayList<>();
	List<String> cityList = new ArrayList<>();
	List<String> stateList = new ArrayList<>();
	List<String> langList = new ArrayList<>();


	public SoftwareDevelopmentClub(String file) throws IOException {
		textFile = new File(file);
		readFile(textFile);
		sortList(strList);
		createMembers();
	}
	
	private void readFile(File textFile) throws IOException {

		try {
			BufferedReader reader = new BufferedReader(new FileReader(textFile));
			String line;
			int counter = 1;
			while((line = reader.readLine()) != null) {
				if (counter > 1) {
					String[] ar = line.split("\\*\\*");
					for (int i = 0; i < ar.length; i++) {
						if (ar[i] == null) {
							break;
						}
						strList.add(ar[i]);
					}
				} counter++;
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private void sortList(List<String> str) {
		int temp = 0;
		for (String i : str) {

			if (temp == 4) {
				temp = 0;
			}
			
			switch(temp) {
			case 0:
				nameList.add(i);
				temp++;
				break;
			case 1:
				cityList.add(i);
				temp++;
				break;
			case 2:
				stateList.add(i);
				temp++;
				break;
			case 3:
				langList.add(i);
				temp++;
			default:
				break;
			}
		}
	}
	
	private void createMembers() {
		int size = nameList.size();
		for (int i = 0; i < size; i++) {
			memberList.add(new ClubMember(
					nameList.get(i), 
					cityList.get(i), 
					stateList.get(i), 
					langList.get(i))
			);
		}
	}
	
	public void showMembers() {
		for (ClubMember i : memberList) {
			System.out.println("Member Name: " + i.getMemberName());
			System.out.println("Location: " + i.getCity() + ", " + i.getState());
			System.out.println("Favorite Language: " + i.getLang() + "\n");
		}
		
		
	}
	
	public void listByName() {
		for (ClubMember i : memberList) {
			System.out.println((memberList.indexOf(i)+1) + ". " + i.getMemberName());
		}
	}
	
	public void removeMember(int id) {
		memberList.remove(id-1);
	}
	
	public void addMember(String name, String city, String state, String lang) {
		memberList.add(new ClubMember(name, city, state, lang));
	}
	
}
