package miniproject;

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



public class PersonApp {

	public static void main(String[] args) throws IOException{

		Person form = new Person();
		form.showInfo();
		List<Person> pList = new ArrayList<Person>();
		
		Scanner sc = new Scanner(System.in);
        //int number = sc.nextInt();
        //String number = sc.nextLine();
        //int inum = Integer.parseInt(number);
        
        while(true) { //스위치(1~5) 반복문
		
	    	String strnum = sc.nextLine();//sc.nextInt였을때 case2 -string info를 string형으로 바꾼후 String info =sc.nextLine이 불가능해서 처음부터 String으로 받고 int형필요한 부분만 int형으로 바꿔서 써줌 
	    	int number = Integer.parseInt(strnum);
	    	
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
		    	
		    	//List<Person> pList = new ArrayList<Person>();
		    	
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
		    	
		    	String[] formtwo = new String[3]; //반복출력양식 배열 만들기
		    	formtwo[0]=">이름: "; //반복출력양식 배열에 넣기
		    	formtwo[1]=">휴대전화: ";
		    	formtwo[2]=">회사전화: ";
		    	
		    	String[] iArray = new String[3]; //입력값(info)이 순서대로 들어갈 배열 만들기(순서대로 들어가 있어야 각각 값지정 가능) 
		    	
		    	for(int i=0; i<formtwo.length; i++) {
		    		System.out.print(formtwo[i]);
		    		String info = sc.nextLine();//*
                    iArray[i]=info; //입력값 각 배열에 순서대로 들어가도록 넣어주기
		    	}
		    	
		    	Person addInfo = new Person(iArray[0],iArray[1],iArray[2]);
		    	pList.add(addInfo);//addpList에(arrayList) addInfo객체 주소 넣기 주소 추가
		    	
		    	System.out.println("[등록되었습니다.]");
		    	
		    	Writer addfw = new FileWriter("D:\\javaStudy\\file\\miniproject\\PhoneDB.txt");
		    	BufferedWriter addbw = new BufferedWriter(addfw);
		    	
		        for(int i=0; i<pList.size(); i++) {
		        	/*
		        	addbw.write(addpList.get(i).getName());
		        	addbw.write(addpList.get(i).getHp());
		        	addbw.write(addpList.get(i).getCompany());
		            */
		        	String addLine = pList.get(i).addinfo();//Person에 정의한 메소드 사용
		        	addbw.write(addLine);
		            addbw.newLine();
		        }
		        
		    	addbw.close();
		    	form.list();
		    	break;
		    	
		    case 3:
		    	System.out.println("<3.삭제>");
		    	System.out.print(">번호 : ");
		    	
		    	Reader rfr = new FileReader("D:\\javaStudy\\file\\miniproject\\PhoneDB.txt");
		    	BufferedReader rbr = new BufferedReader(rfr);
		    	
		    	while(true) {
		    		String rLine = rbr.readLine();
		    		if(rLine == null) {
		    			break;
		    		}
		    		String[] rArray = rLine.split(",");
		    		Person p01 = new Person(rArray[0],rArray[1],rArray[2]);
		    		pList.add(p01);
		    		
		    	}

		    	Scanner ic = new Scanner(System.in);
		    	int removeNum = ic.nextInt();
		    	removeNum = removeNum-1;
		    	pList.remove(removeNum);
		    	
		    	System.out.println("[삭제되었습니다.]");
		    	
		    	Writer rfw = new FileWriter("D:\\javaStudy\\file\\miniproject\\PhoneDB.txt");
		    	BufferedWriter rbw = new BufferedWriter(rfw);
		    	
		    	/*
		    	for(int i=0; i<pList.size();i++) {
		    	System.out.println(pList.get(i).getName()+"   "+pList.get(i).getHp()+"   "+pList.get(i).getCompany());
		    	}
		    	*/
		    	
		    	for(int i=0; i<pList.size();i++) {
		    	rbw.write(pList.get(i).addinfo());
		    	rbw.newLine();
		    	/*
		    	rbw.write(pList.get(i).getName()); 
		    	rbw.write(pList.get(i).getHp());
		    	rbw.write(pList.get(i).getCompany());
		    	*/
		    	}
		    	
		    	rbr.close();
		    	rbw.close();
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
