package thuvien;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.text.NumberFormat;
import java.time.LocalDate;

public class KiemThu {
	public static void main(String[] args) {
		SachGiaoKhoa sgk1 = new SachGiaoKhoa("SGK1", LocalDate.of(2025, 7, 30), 150000, 10, "Kim Dong", TinhTrangSach.MOI);
		SachGiaoKhoa sgk2 = new SachGiaoKhoa("SGK2", LocalDate.of(2025, 6, 19), 1250000, 20, "Kim Long", TinhTrangSach.CU);
		SachGiaoKhoa sgk3 = new SachGiaoKhoa("SGK3", LocalDate.of(2023, 5, 22), 2150000, 50, "Ho Huu Thanh", TinhTrangSach.MOI);
		SachGiaoKhoa sgk4 = new SachGiaoKhoa("SGK4", LocalDate.of(2022, 4, 2), 120000, 80, "Kim Dang Do", TinhTrangSach.CU);
		SachGiaoKhoa sgk5 = new SachGiaoKhoa("SGK5", LocalDate.of(2017, 12, 10), 10000, 1000, "Dong Do Thanh Nguyen", TinhTrangSach.CU);
		
		SachThamKhao stk1 = new SachThamKhao("STK1", LocalDate.of(2025, 7, 30), 150000, 10, "Kim Dong", 10);
		SachThamKhao stk2 = new SachThamKhao("STK2", LocalDate.of(2025, 8, 19), 2150000, 8, "Kim Long", 5);
		SachThamKhao stk3 = new SachThamKhao("STK3", LocalDate.of(2012, 11, 22), 120000, 100, "Ho Huu Thanh", 8);
		SachThamKhao stk4 = new SachThamKhao("STK4", LocalDate.of(2025, 12, 2), 1250000, 150, "Kim Dang Do", 6.5);
		SachThamKhao stk5 = new SachThamKhao("STK5", LocalDate.of(2019, 9, 10), 10000, 9, "Dong Do Thanh Nguyen", 3);

		QuanLyThuVien ql = new QuanLyThuVien();
		ql.them2(sgk1);
		ql.them2(sgk2);
		ql.them2(sgk3);
		ql.them2(sgk4);
		ql.them2(sgk5);
		ql.them2(stk1);
		ql.them2(stk2);
		ql.them2(stk3);
		ql.them2(stk4);
		ql.them2(stk5);
		
		inDanhSach("Danh sach ban dau", ql.traVeDanhSachMoi());
		System.out.println("So luong sach: " + ql.soLuongSach());
			
		ql.xoa1("SGK1");
		System.out.println(ql.xoa2("SGK2"));
		System.out.println(ql.xoa3("SGK3"));
		
		inDanhSach("Danh sach sau khi xoa", ql.traVeDanhSachMoi());
		
		ql.capnhat1("STK1", 100);
		System.out.println(ql.capnhat2("STK2", 200) ? "Cap nhat thanh cong" : "Khong thanh cong");
		System.out.println(ql.capnhat3("STK3", 300));
		
		inDanhSach("Danh sach sau khi cap nhat", ql.traVeDanhSachMoi());
		
		inDanhSach("Cac sach trong thang 12", ql.cacSachTrongThang(12));
		
		inDanhSach("Cac sach hon 1 thang", ql.cacSachHonMotThang());
		
		inDanhSach("Cac sach giao khoa cu", ql.cacSachGiaoKhoaCu());
		
		inDanhSach("Danh sach don gia giam", ql.sapXepTheoDonGiaGiam());
		
		inDanhSach("Danh sach nxb tang don gia giam", ql.sapXepDaCapNXBTangVaDonGiaGiam());
		
		inDanhSach("Danh sach loai sach va don gia giam", ql.sapXepDaCapLoaiSachTangVaDonGiaGiam());
		
		System.out.println("Don gia cao nhat: " + moneyFormat(ql.donGiaCaoNhat()));
		
		System.out.println("Tong so luong sach theo nam: " + ql.tongSoLuongSachTheoNam(2025));
		
		System.out.println("Trung binh cong don gia sach: " + moneyFormat(ql.trungBinhCongDonGiaSach(2025)));
		
		System.out.println("Tong thanh tien toan bo voi reduce: " + moneyFormat(ql.tongThanhTienToanBoVoiReduce()));
		
		System.out.println("Gom theo nhom va dem so luong sach: " + ql.gomTheoNhomVaDemSoLuongSach());
		Map<String, Integer> gomNhom = ql.gomTheoNhomVaDemSoLuongSach();
		gomNhom.forEach((type, amount) -> {
			System.out.println(type + ": " + amount);
		});
	}
	
	public static void inDanhSach(String text, List<Sach> dsSach) {
		int doDai = 110;
		System.out.println();
		System.out.println(text.toUpperCase());
		
		if (dsSach == null || dsSach.isEmpty()) return;
		
		System.out.println("-".repeat(doDai));
		System.out.println(Sach.inTieuDe());
		System.out.println("-".repeat(doDai));
		for (Sach s : dsSach) {
			System.out.println(s);
		}
		System.out.println("-".repeat(doDai));
		System.out.println("So luong sach: " + dsSach.size());

	}
	
	public static String moneyFormat(double money) {
		NumberFormat nb = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("vi-VN"));
		return nb.format(money);
	}
}
