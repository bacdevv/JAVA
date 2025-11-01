package LeTrongNghia_24672691_37;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TestHoiThao {
	static DanhSachT ds = new DanhSachT(5);
	static Scanner sc = new Scanner(System.in);
	
	// Nhập dữ liệu mẫu
	public static void nhapMau() {
		HoiThao t1 = new HoiThao("T001", "Ha Long", "Nguyen Van A;Le Thi B", 
				LocalDate.of(2025, 11, 15), 3, 2500000);
		HoiThao t2 = new HoiThao("T002", "Da Lat", "Tran Van C;Pham Thi D", 
				LocalDate.of(2025, 11, 20), 2, 1800000);
		HoiThao t3 = new HoiThao("T003", "Nha Trang", "Vo Van E;Dang Thi F", 
				LocalDate.of(2025, 11, 15), 4, 3200000);
		HoiThao t4 = new HoiThao("T004", "Phu Quoc", "Hoang Van G;Bui Thi H", 
				LocalDate.of(2025, 12, 10), 5, 4500000);
		HoiThao t5 = new HoiThao("T005", "Sa Pa", "Do Van I;Ly Thi K", 
				LocalDate.of(2025, 11, 20), 2, 2000000);
		
		ds.them(t1);
		ds.them(t2);
		ds.them(t3);
		ds.them(t4);
		ds.them(t5);
		
		System.out.println("Da them 5 tour mau!");
	}
	
	// Thêm tour mới
	public static void themTour() {
		System.out.print("Ma tour: ");
		String ma = sc.nextLine();
		
		System.out.print("Ten tour: ");
		String ten = sc.nextLine();
		
		System.out.print("Huong dan vien (vd: A;B): ");
		String hdv = sc.nextLine();
		
		System.out.print("Ngay khoi hanh (dd/MM/yyyy): ");
		String ngayStr = sc.nextLine();
		LocalDate ngay = LocalDate.parse(ngayStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		System.out.print("So ngay: ");
		int soNgay = sc.nextInt();
		
		System.out.print("Gia tour: ");
		long gia = sc.nextLong();
		sc.nextLine();
		
		HoiThao tour = new HoiThao(ma, ten, hdv, ngay, soNgay, gia);
		if(ds.them(tour)) {
			System.out.println("Them thanh cong!");
		} else {
			System.out.println("Loi: Ma tour da ton tai!");
		}
	}
	
	// Tìm tour theo mã
	public static void timTour() {
		System.out.print("Nhap ma tour can tim: ");
		String ma = sc.nextLine();
		
		HoiThao tour = ds.timKiem(ma);
		if(tour != null) {
			System.out.println("\nTim thay tour:");
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.printf("%-10s | %-15s | %-25s | %-12s | %5s | %12s\n",
					"Ma Tour", "Ten Tour", "Huong Dan Vien", "Ngay KH", "Ngay", "Gia Tour");
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println(tour);
			System.out.println("-------------------------------------------------------------------------------------");
		} else {
			System.out.println("Khong tim thay!");
		}
	}
	
	// Tìm tour theo ngày
	public static void timTheoNgay() {
		System.out.print("Nhap ngay can tim (dd/MM/yyyy): ");
		String ngayStr = sc.nextLine();
		LocalDate ngay = LocalDate.parse(ngayStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		HoiThao[] ketQua = ds.timTheoNgay(ngay);
		
		if(ketQua.length == 0) {
			System.out.println("Khong co tour nao trong ngay nay!");
		} else {
			System.out.println("\nCo " + ketQua.length + " tour trong ngay " + ngayStr + ":");
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.printf("%-10s | %-15s | %-25s | %-12s | %5s | %12s\n",
					"Ma Tour", "Ten Tour", "Huong Dan Vien", "Ngay KH", "Ngay", "Gia Tour");
			System.out.println("-------------------------------------------------------------------------------------");
			for(int i = 0; i < ketQua.length; i++) {
				System.out.println(ketQua[i]);
			}
			System.out.println("-------------------------------------------------------------------------------------");
		}
	}
	
	// Menu
	public static void menu() {
		System.out.println("\n========== QUAN LY HOI THAO ==========");
		System.out.println("1. Nhap du lieu mau");
		System.out.println("2. Them tour moi");
		System.out.println("3. Hien thi tat ca tour");
		System.out.println("4. Sap xep theo gia (Selection Sort)");
		System.out.println("5. Tinh tong chi phi");
		System.out.println("6. Tim tour theo ma");
		System.out.println("7. Tim tour theo ngay");
		System.out.println("0. Thoat");
		System.out.println("======================================");
	}
	
	// Main
	public static void main(String[] args) {
		int chon;
		do {
			menu();
			System.out.print("Chon chuc nang: ");
			chon = sc.nextInt();
			sc.nextLine();
			
			switch(chon) {
			case 1:
				nhapMau();
				break;
			case 2:
				themTour();
				break;
			case 3:
				System.out.println("\nDanh sach tat ca tour:");
				ds.inDanhSach();
				break;
			case 4:
				ds.sapXepTheoGia();
				System.out.println("\nDa sap xep theo gia tang dan:");
				ds.inDanhSach();
				break;
			case 5:
				System.out.println("\nTong chi phi: " + String.format("%,d VND", ds.tongChiPhi()));
				break;
			case 6:
				timTour();
				break;
			case 7:
				timTheoNgay();
				break;
			case 0:
				System.out.println("Tam biet!");
				break;
			default:
				System.out.println("Chon sai! Vui long chon lai.");
			}
			
		} while(chon != 0);
		
		sc.close();
	}
}
