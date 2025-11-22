package nhanvien;

import java.util.List;
import java.util.Map;

public interface INhanVienCaiDat {
	boolean themNhanVien(NhanVien nhanvien);
	List<NhanVien> getNhanVien();
	boolean capNhat(String maNhanVien, double heSoLuongMoi);
	NhanVien kiemTraNhanVien(String maNhanVien);
	List<NhanVien> sapXepNVBHCoThuNhapVaGiamDanDSBan();
	List<NhanVien> doanhSoBanLonNhat();
	Map<String, Double> thongKeLuongTrungBinh();
}
