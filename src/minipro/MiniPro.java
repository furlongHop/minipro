package minipro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MiniPro {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		List<Person> pList = new ArrayList<Person>();
		
		Reader fr = new FileReader("C:\\javaStudy\\miniProject\\phoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		
		System.out.println("*******************************************");
		System.out.println("*            전화번호 관리 프로그램              *");
		System.out.println("*******************************************");
		
		
		while(true) {
			System.out.print("메뉴번호: ");
			String num = sc.nextLine();
			
			if(num.equals("5")) {
				System.out.println("*******************************************");
				System.out.println("*                 감사합니다                  *");
				System.out.println("*******************************************");
				break;
			}
			
			while(true) {
				String list = br.readLine();
				
				if(list==null) {
					break;
				}
				String[] pArray = list.split(",");
				Person person = new Person(pArray[0],pArray[1],pArray[2]);
				pList.add(person);
			}
			
			switch(num) {
			case "1" :
				System.out.println("<1.리스트>");
				listPrint(pList);
				break;
			case "2" :
				System.out.println("<2.등록>");
					
				System.out.print(">이름: ");
				String addName = sc.nextLine();
				System.out.print(">휴대전화: ");
				String addHp = sc.nextLine();
				System.out.print(">회사전화: ");
				String addCompany = sc.nextLine();
				
				Person friend = new Person(addName,addHp,addCompany);
				pList.add(friend);
				System.out.println("[등록되었습니다.]");
				break;
				
			case "3" :
				System.out.println("<3.삭제>");
				System.out.print(">번호: ");
				String removeNum = sc.nextLine();
				
				int rnum = Integer.parseInt(removeNum);
				pList.remove(rnum-1);
				
				System.out.println("[삭제되었습니다.]");
				break;
				
			case "4" :
				System.out.println("<4.검색>");
				System.out.print(">이름: ");
				String nameSe = sc.nextLine();
				
				for(int i=0;i<pList.size();i++) {
					if(pList.get(i).getName().contains(nameSe)) {
						System.out.println(i+1+". "+pList.get(i).toString());
					}
				}
				break;
				
			default :
				System.out.println("[다시 입력해 주세요.]");	
				break;
			}//switch~case
			System.out.println("");
			System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
			System.out.println("-------------------------------------------");
		}//while
		
	
		Writer fw = new FileWriter("C:\\javaStudy\\miniProject\\phoneDB.txt");
		BufferedWriter bw = new BufferedWriter(fw);
	
		for(int i=0;i<pList.size();i++) {
			String str = pList.get(i).info();
			bw.write(str);
			bw.newLine();
		}
		
		bw.close();
		br.close();
		
		sc.close();

	}

	public static void listPrint(List<Person> personList) {
		for(int i=0;i<personList.size();i++) {
			System.out.println(i+1+". "+personList.get(i).getName()+" "+personList.get(i).getHp()+" "+personList.get(i).getCompany());
		}
	}
}
