package miniproject;

import java.util.Scanner;

public class PersonApp {

	public static void main(String[] args) {

		Person form = new Person();
		form.showInfo();
		
		Scanner sc = new Scanner(System.in);
        //int number = sc.nextInt();
        //String number = sc.nextLine();
        //int inum = Integer.parseInt(number);
        
        while(true) {
		
        	int number = sc.nextInt();
        	
		    switch(number) {
		    case 1:
		    	System.out.println("<1.리스트>");
		    	System.out.println("phonedb읽어온데이터");
		    	form.list();
		    	break;
		    case 2:
		    	break;
		    case 3:
		    	break;
		    case 4:
		    	break;
		    	
		    /*case 5:
		    	System.out.println("***********************************");
        		System.out.println("*             감사합니다             *");
        		System.out.println("***********************************");
		    	break;*/
		    	
		    default:
			    	System.out.println("[다시 입력해 주세요.]");
			    	break;
			
		   /* 	     	
	       if(number==5) {
	    	   System.out.println(".");
	       }break;
	       */
	    } 
	    
	    
	    
	    
	    }
	
	
	
	
	}

}
