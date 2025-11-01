package LeTrongNghia_24672691_37;

import java.time.LocalDate;

public class DemoHoiThao {
	
	public static void main(String[] args) {
		System.out.println("========== DEMO QUAN LY HOI THAO ==========\n");
		
		// Tạo danh sách với kích thước 3
		DanhSachT ds = new DanhSachT(3);
		System.out.println("1. Tao danh sach voi kich thuoc: 3\n");
		
		// Tạo các tour
		System.out.println("2. Tao cac tour:");
		HoiThao t1 = new HoiThao("T001", "Ha Long", "A;B", LocalDate.of(2025, 11, 15), 3, 2500000);
		HoiThao t2 = new HoiThao("T002", "Da Lat", "C;D", LocalDate.of(2025, 11, 20), 2, 1800000);
		HoiThao t3 = new HoiThao("T003", "Nha Trang", "E;F", LocalDate.of(2025, 11, 15), 4, 3200000);
        HoiThao t5 = new HoiThao("T005", "Da Nang", "G;H", LocalDate.of(2025, 11, 25), 3, 2000000);
		HoiThao t4 = new HoiThao("T004", "Phu Quoc", "G;H", LocalDate.of(2025, 12, 10), 5, 4500000);
		System.out.println("   Da tao 4 tour\n");
		
		// Thêm tour
		System.out.println("3. Them tour vao danh sach:");
		ds.them(t1);
		ds.them(t2);
		ds.them(t3);
		ds.them(t4); // Mảng sẽ tự động mở rộng
		System.out.println("   Da them " + ds.getCount() + " tour (mang tu dong mo rong)\n");
		
		// Hiển thị danh sách
		System.out.println("4. Hien thi danh sach:");
		ds.inDanhSach();
		
		// Tìm tour theo mã
		System.out.println("\n5. Tim tour T002:");
		HoiThao tim = ds.timKiem("T002");
		if(tim != null) {
			System.out.println("   Tim thay: " + tim.getTenTour() + " - Gia: " + tim.getGiaTour());
		}
		
		// Sắp xếp theo giá (Selection Sort)
		System.out.println("\n6. Sap xep theo gia (Selection Sort):");
		ds.sapXepTheoGia();
		ds.inDanhSach();
		
		// Tính tổng chi phí
		System.out.println("\n7. Tong chi phi: " + String.format("%,d VND", ds.tongChiPhi()));
		
		// Tìm tour theo ngày
		System.out.println("\n8. Tim tour ngay 15/11/2025:");
		HoiThao[] ketQua = ds.timTheoNgay(LocalDate.of(2025, 11, 15));
		System.out.println("   Co " + ketQua.length + " tour:");
		for(int i = 0; i < ketQua.length; i++) {
			System.out.println("   - " + ketQua[i].getTenTour());
		}
		
		System.out.println("\n========== KET THUC DEMO ==========");
	}
}