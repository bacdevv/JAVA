package nhanvien;

import java.util.List;

public class KiemThu {
	public static void main(String[] args) {
		NhanVienBanHang nvbh1 = new NhanVienBanHang("NVBH1", "Khuu Dai Han", "0969401600", 20000000, 21000000);
		NhanVienBanHang nvbh2 = new NhanVienBanHang("NVBH2", "Le Ho Khoa", "0987888200", 1800000, 20000000);
		NhanVienBanHang nvbh3 = new NhanVienBanHang("NVBH3", "Dang Tam Nhu", "0987669910", 1800000, 10000000);
		
		NhanVienVanPhong nvvp1 = new NhanVienVanPhong("NVVP1", "Tran Viet Bac", "0987882021", 12300000, 3);
		NhanVienVanPhong nvvp2 = new NhanVienVanPhong("NVVP2", "Ngoc Thien Phuong", "0969401440", 1200000, 2);
		NhanVienVanPhong nvvp3 = new NhanVienVanPhong("NVVP3", "Nguyen Minh Anh", "0949120232", 3200000, 1.99);
		
		System.out.println(nvbh1);
		System.out.println(nvbh2);
		System.out.println(nvbh3);
		System.out.println(nvvp1);
		System.out.println(nvvp2);
		System.out.println(nvvp3);
		
		QuanLyNhanVien ql = new QuanLyNhanVien();
		
		ql.themNhanVien(nvvp3);
		ql.themNhanVien(nvvp2);
		ql.themNhanVien(nvvp3);
		
		ql.capNhat("NVVP3", 2.88);
		
		inNhanVien("Nhan Vien", ql.getNhanVien());
	}
	
	public static void inNhanVien(String text, List<NhanVien> dsNhanVien) {
		System.out.println(text);
		for (NhanVien nv : dsNhanVien) {
			System.out.println(nv);
		}
	}
}
