package miniproject;

public class Person {

	//필드
	private String name;
	private String hp;
	private String company;
	
	//생성자
	public Person() {
		
	}
	
	public Person(String name, String hp, String company) {
		super();
		this.name = name;
		this.hp = hp;
		this.company = company;
	}

	
	//메소드g/s
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	//메소드 일반
	@Override
	public String toString() {
		return "Person [name=" + name + ", hp=" + hp + ", company=" + company + "]";
	}
	public void list() {
		System.out.println("");
        System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
        System.out.println("-----------------------------------");
		System.out.print(">메뉴번호:");
	}
	
	public void showInfo() {
		System.out.println("***********************************");
		System.out.println("*        전화번호 관리 프로그램        *");
		System.out.println("***********************************");
        System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
        System.out.println("-----------------------------------");
		System.out.print(">메뉴번호:");
	}
	
	public String addinfo() {
		return name + "," + hp + "," + company;
	}
	

}
