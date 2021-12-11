package miniproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class PersonApp {

	public static void main(String[] args) throws IOException{

		Person form = new Person();
		form.showInfo();
		
		Scanner sc = new Scanner(System.in);
        //int number = sc.nextInt();
        //String number = sc.nextLine();
        //int inum = Integer.parseInt(number);
        
        while(true) { //스위치(1~5) 반복문
		
	    	int number = sc.nextInt();
	    	
	    	if(number==5) { //탈출코드
		    	System.out.println("");
	    		System.out.println("***********************************");
	    		System.out.println("*             감사합니다             *");
	    		System.out.println("***********************************");
	    	    break;
	    	}
	    	
		    switch(number) {
		    case 1:
		    	System.out.println("<1.리스트>");
		    	
		    	List<Person> pList = new ArrayList<Person>();
		    	
		    	Reader fr = new FileReader("D:\\javaStudy\\file\\miniproject\\PhoneDB.txt");
		    	BufferedReader br = new BufferedReader(fr);
		    	
		    	while(true) {
		    		String line = br.readLine();
		    		if(line==null) {
		    			break;
		    		}
		    		String[] dataArray = line.split(",");//phonedb 파일의 문자열 데이터를 ,로 나눠 dataArray배열에 넣기
		    		Person p01 = new Person(dataArray[0],dataArray[1],dataArray[2]);
		    		pList.add(p01);
		    	}
		    	
		    	int count = 0;
		    	for(int i=0; i<pList.size(); i++) {
		    	    count=count+1;
		    		System.out.println(count+"."+"  "+pList.get(i).getName()+"   "+pList.get(i).getHp()+"   "+pList.get(i).getCompany());
		    	}
		    	
		    	br.close();
		    	form.list();
		    	break;
		    	
		    case 2:
		    	System.out.println("<2.등록>"); //ArrayList사용해보기
		    	
		    	//String info = String.valueOf(number);
		    	
		    	String[] nhcform = new String[3];
		    	nhcform[0]=">이름:";
		    	nhcform[1]=">휴대전화:";
		    	nhcform[2]=">회사전화:";
		    	
		    	String[] nhcArray = new String[3];//박명수,010-777,02-333을 넣어 놓을 배열 만들기

		    	for(int i=0; i<nhcArray.length;i++) {
		    		Scanner sct = new Scanner(System.in);
		    		System.out.print(nhcform[i]);
		    		String info = sct.nextLine();
		    		nhcArray[i]=info;
			    	//Person nhc = new Person(nhcArray[0],nhcArray[1],nhcArray[2]);
		    	}
		    	System.out.println("[등록되었습니다.]");
		    	
		    	/*
	    		System.out.println(">이름: " + nhcArray[0]);
	        	System.out.println(">휴대전화: " + nhcArray[1]);
	            System.out.println(">회사전화: " + nhcArray[2]);
	        	System.out.println("[등록되었습니다.]");
		    	*/
		    	
		    	form.list();
		    	break;
		    	
		    case 3:
		    	
		    	form.list();
		    	break;
		    	
		    case 4:
		    	
		    	form.list();
		    	break;
		    	
		    default:
			    System.out.println("[다시 입력해 주세요.]");
			    form.list();
			    break;
			
	        } 
	    
	    
	    
	    
	    }
	
	
	
	
	}

}
