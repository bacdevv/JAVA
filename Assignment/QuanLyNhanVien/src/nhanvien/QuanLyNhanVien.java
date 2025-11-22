package nhanvien;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class QuanLyNhanVien implements INhanVienCaiDat {
	private List<NhanVien> dsNhanVien;
	
	public QuanLyNhanVien() {
		this.dsNhanVien = new ArrayList<NhanVien>();
	}

	@Override
	public boolean themNhanVien(NhanVien nhanvien) {
		NhanVien tonTaiNhanVien = kiemTraNhanVien(nhanvien.getMaNhanVien());
		if (nhanvien == null || nhanvien == tonTaiNhanVien)
			return false;
		else {
			return dsNhanVien.add(nhanvien);
		}
	}

	@Override
	public boolean capNhat(String maNhanVien, double heSoLuongMoi) {
		NhanVien nv = kiemTraNhanVien(maNhanVien);
		if (nv != null && nv.getMaNhanVien() != null) {
			((NhanVienVanPhong) nv).setHeSoLuong(heSoLuongMoi);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public NhanVien kiemTraNhanVien(String maNhanVien) {
		return dsNhanVien.stream()
				.filter(nv -> maNhanVien.equals(nv.getMaNhanVien()))
				.findFirst()
				.orElse(null);
	}

	@Override
	public List<NhanVien> sapXepNVBHCoThuNhapVaGiamDanDSBan() {
		return dsNhanVien.stream()
				.sorted(Comparator.comparing(
				
				))
				.toList();
	}

	@Override
	public List<NhanVien> doanhSoBanLonNhat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Double> thongKeLuongTrungBinh() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NhanVien> getNhanVien() {
		return new ArrayList<>(dsNhanVien);
	}
	
	
}
