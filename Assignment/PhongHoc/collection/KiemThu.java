package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KiemThu {
	
	// Hàm trợ giúp để in danh sách cho đẹp
	private static void printList(String title, List<PhongHoc> ds) {
		System.out.println("\n--- " + title + " ---");
		if (ds.isEmpty()) {
			System.out.println("Không có phòng nào.");
			return;
		}
		ds.forEach(System.out::println); // Dùng method reference
	}
	
	// Hàm trợ giúp để in Map (Tổng quát)
	private static <K, V> void printMap(String title, Map<K, V> map) {
		System.out.println("\n--- " + title + " ---");
		if (map.isEmpty()) {
			System.out.println("Map rỗng.");
			return;
		}
		// Dùng forEach của Map
		map.forEach((key, value) -> {
			System.out.println(">> Nhóm: " + key);
			// In value (có thể là List, Set, Integer, hoặc PhongHoc)
			System.out.println(value.toString()); 
		});
	}

	public static void main(String[] args) {
		QuanLyPhongHoc ql = new QuanLyPhongHoc();
		
		// 1. Thêm (Test 'them')
		System.out.println("--- Bắt đầu thêm phòng ---");
		List<PhongHoc> duLieuMau = taoDuLieuMau();
		for (PhongHoc ph : duLieuMau) {
			ql.them(ph);
		}
		// Test thêm trùng
		System.out.println("Thử thêm trùng LT101: " + ql.them(new PhongLyThuyet("LT101", DayNha.A, 75.0, 8, true))); // Phải trả về null
		
		// 2. In toàn bộ danh sách (Test 'toString')
		System.out.println("\n--- Danh sách phòng học ban đầu (" + ql.soLuongPhongHoc() + " phòng) ---");
		System.out.println(ql); // Gọi hàm toString() đã override

		// 3. Sắp xếp
		printList("Sắp xếp tăng dần theo Dãy nhà", ql.sapXepTangDanTheoDayNha());
		printList("Sắp xếp giảm dần theo Diện tích", ql.sapXepGiamDanTheoDienTich());
		printList("Sắp xếp tăng theo Bóng đèn, giảm theo Dãy nhà", ql.sapXepTangDanTheoSoBongDenGiamDanTheoDayNha());

		// 4. Tìm kiếm (Test 'timKiemPhongHoc')
		System.out.println("\n--- Tìm kiếm ---");
		System.out.println("Tìm phòng 'MT203': " + ql.timKiemPhongHoc("MT203"));
		System.out.println("Tìm phòng 'XXX': " + ql.timKiemPhongHoc("XXX"));

		// 5. Cập nhật (Test 'capNhat')
		System.out.println("\n--- Cập nhật ---");
		System.out.println("Cập nhật phòng 'MT201' thành 99 máy: ");
		ql.capNhat("MT201", 99);
		System.out.println(ql.timKiemPhongHoc("MT201"));

		// 6. Xóa (Test 'xoa')
		System.out.println("\n--- Xóa ---");
		System.out.println("Xóa phòng 'TN307': " + ql.xoa("TN307"));
		System.out.println("Số lượng phòng còn lại: " + ql.soLuongPhongHoc());
		
		// 7. Tính toán
		System.out.println("\n--- Tính toán ---");
		System.out.println("Tổng số bóng đèn: " + ql.tinhTongSoBongDen());
		System.out.printf("Diện tích trung bình: %.2f m2\n", ql.tinhTrungBinhDienTich());
		
		// 8. Lọc
		printList("Danh sách phòng Đạt chuẩn", ql.layDanhSachPhongHocDatChuan());
		printList("Danh sách phòng máy có 60 máy", ql.layDanhSachPhongMayTinh(60));
		printList("Top 3 phòng có diện tích lớn nhất", ql.layDanhSachPhongHocCoDienTichLonNhat(3));
		
		// 9. Gom nhóm
		printMap("Gom nhóm theo Loại phòng (gomNhom1)", ql.gomNhom1());
		printMap("Gom nhóm theo Dãy nhà & Đếm số lượng (gomNhom2)", ql.gomNhom2());
		printMap("Gom nhóm theo Diện tích (gomNhom3)", ql.gomNhom3());
		printMap("Gom nhóm theo Loại phòng & Lấy Set Dãy nhà (gomNhom4)", ql.gomNhom4());
		printMap("Map Mã phòng -> Phòng học (Sắp xếp giảm theo diện tích) (gomNhom5)", ql.gomNhom5());
		printMap("Gom nhóm theo Dãy nhà & List phòng (Sắp xếp giảm theo diện tích) (gomNhom6)", ql.gomNhom6());
	}

	// Dữ liệu mẫu (Giữ nguyên)
	private static List<PhongHoc> taoDuLieuMau() {
		List<PhongHoc> danhSach = new ArrayList<>();
		danhSach.add(new PhongLyThuyet("LT101", DayNha.A, 75.0, 8, true));
		danhSach.add(new PhongLyThuyet("LT102", DayNha.B, 60.0, 6, false));
		danhSach.add(new PhongLyThuyet("LT103", DayNha.C, 90.5, 10, true));
		danhSach.add(new PhongLyThuyet("LT104", DayNha.D, 55.5, 5, false));
		danhSach.add(new PhongLyThuyet("LT105", DayNha.V, 100.0, 12, true));
		danhSach.add(new PhongLyThuyet("LT106", DayNha.X, 65.0, 7, true));
		danhSach.add(new PhongLyThuyet("LT107", DayNha.A, 80.0, 9, false));
		danhSach.add(new PhongMayTinh("MT201", DayNha.A, 65.0, 6, 45));
		danhSach.add(new PhongMayTinh("MT202", DayNha.B, 80.0, 8, 50));
		danhSach.add(new PhongMayTinh("MT203", DayNha.C, 100.0, 10, 60));
		danhSach.add(new PhongMayTinh("MT204", DayNha.D, 70.0, 7, 48));
		danhSach.add(new PhongMayTinh("MT205", DayNha.V, 90.0, 9, 55));
		danhSach.add(new PhongMayTinh("MT206", DayNha.X, 85.0, 8, 58));
		danhSach.add(new PhongMayTinh("MT207", DayNha.B, 95.0, 11, 62));
		danhSach.add(new PhongThiNghiem("TN301", DayNha.A, 70.0, 6, "Hóa học", 35, true));
		danhSach.add(new PhongThiNghiem("TN302", DayNha.B, 90.0, 9, "Sinh học", 40, true));
		danhSach.add(new PhongThiNghiem("TN303", DayNha.C, 85.0, 8, "Vật lý", 38, false));
		danhSach.add(new PhongThiNghiem("TN304", DayNha.D, 110.0, 12, "Công nghệ thực phẩm", 50, true));
		danhSach.add(new PhongThiNghiem("TN305", DayNha.V, 60.0, 5, "Hóa phân tích", 30, false));
		danhSach.add(new PhongThiNghiem("TN306", DayNha.X, 100.0, 10, "Môi trường", 45, true));
		danhSach.add(new PhongThiNghiem("TN307", DayNha.A, 75.0, 7, "Kỹ thuật điện", 42, false));
		return danhSach;
	}
}