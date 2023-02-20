import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Test {

	
	static ArrayList<SinhVien> arr = new ArrayList<>();
	
	public static void AddStudent() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ma sinh vien: ");
		int id = sc.nextInt();
		
		System.out.println("Ho va ten: ");
		sc.nextLine();
		String name = sc.nextLine();
		
		System.out.println("Tuoi sinh vien: ");
		int age = sc.nextInt();
		
		System.out.println("Dia chi sinh vien: ");
		sc.nextLine();
		String address = sc.nextLine();
		
		System.out.println("Diem trung binh sinh vien:  ");
		double gpa = sc.nextDouble();
		
		SinhVien sv= new SinhVien(id,name, age,address, gpa);
		
		arr.add(sv);
	}
	
	public static void Display() {
		for (SinhVien sv: arr) {
			System.out.println(sv.toString());
		}
	}
	
	public static void EditStudent() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma sinh vien can sua");
		int id = sc.nextInt();
		boolean tim= false;
		for(SinhVien sv : arr) {
			if(sv.getId()== id) {
				System.out.println("Ho va ten: ");
				sc.nextLine();
				String name = sc.nextLine();
				
				System.out.println("Tuoi sinh vien: ");
				int age = sc.nextInt();
				
				
				System.out.println("Dia chi sinh vien: ");
				sc.nextLine();
				String address = sc.nextLine();
				
				System.out.println("Diem trung binh sinh vien:  ");
				double gpa = sc.nextDouble();
				
				sv.setName(name);
				sv.setAge(age);
				sv.setAddress(address);
				sv.setGpa(gpa);
				
				tim = true;
				break;
			}
		}
		
		if(tim== false) {
			System.out.print("Khong tim thay sinh vien nao");
		}
	}
	
	public static void DeleteStudent() {
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		boolean tim = false;
		for (SinhVien sv : arr) {
			if(sv.getId()== id) {
				tim = true;
				arr.remove(sv);
				break;
			}
		}
		if(tim == false) {
			System.out.print("Khong tim thay sinh vien");
		}
	}
	
	public static void sortGPA() {
		arr.sort(Comparator.comparing(SinhVien::getGpa));
	}
	public static void sortName() {
		arr.sort(Comparator.comparing(SinhVien::getName));
	}
	public static void Exit() {
		System.out.println("Tam biet");
		System.exit(0);
	}
	
	public static void Menu() {
		System.out.println("1.Add Student");
		System.out.println("2.Edit Student");
		System.out.println("3.Delete Student By ID");
		System.out.println("4.Sort Student by GPA");
		System.out.println("5.Sort Student by Name");
		System.out.println("6.Show");
		
		System.out.println("7.Exit");
		
		System.out.println("Moi ban chon: ");
		Scanner sc = new Scanner(System.in);
		int chon = sc.nextInt();
		
		switch (chon) {
		case 1: {
			
			AddStudent();
			break;
		}
		case 2: {
			
			EditStudent();
			break;
		}
		case 3: {
			
			DeleteStudent();
			break;
		}
		case 4: {
			
			sortGPA();
			break;
		}
		case 5: {
			
			sortName();
			break;
		}
		case 6: {
			
			Display();
			break;
		}
		case 0: {
			
			Exit();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + chon);
		}
	}
	public static void main(String[] args) {
		while(true) {
			Menu();
		}
	}
	
}
