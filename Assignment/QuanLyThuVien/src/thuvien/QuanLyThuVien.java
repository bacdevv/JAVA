package thuvien;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;

public class QuanLyThuVien implements ISachCaiDat{
	private List<Sach> dsSach;
	
	public QuanLyThuVien() {
		this.dsSach = new ArrayList<Sach>();
	}

	@Override
	public Sach timSach(String maSach) {
		if (maSach == null) return null;
		return dsSach.stream()
				.filter(sach -> maSach.equals(sach.getMaSach()))
				.findFirst()
				.orElse(null);
	}

	@Override
	public int soLuongSach() {
		return dsSach.size();
	}

	@Override
	public List<Sach> traVeDanhSachMoi() {
		return new ArrayList<>(dsSach);
	}

	@Override
	public void them1(Sach sach) {
		if (sach != null) {
			dsSach.add(sach);
			System.out.println("Them thanh cong");
		}
	}

	@Override
	public boolean them2(Sach sach) {
		Sach sachDaTonTai = timSach(sach.getMaSach());
		if (sach == null || sachDaTonTai != null) {
			return false;
		}
		return dsSach.add(sach);
	}

	@Override
	public Sach them3(Sach sach) {
		Sach sachDaTonTai = timSach(sach.getMaSach());
		if (sach != null && sachDaTonTai == null) {
			dsSach.add(sach);
			return sach;
		}
		return null;
	}

	@Override
	public void xoa1(String maSach) {
		if (maSach == null) return;
		Sach sach = timSach(maSach);
		if (sach != null) {
			dsSach.remove(sach);
			System.out.println("Xoa thanh cong sach: " + sach.getMaSach());
		}
	}

	@Override
	public boolean xoa2(String maSach) {
		if (maSach == null) return false;
		Sach sach = timSach(maSach);
		if (sach != null) {
			return dsSach.remove(sach);
		}
		return false;
	}

	@Override
	public Sach xoa3(String maSach) {
		if (maSach == null) return null;
		Sach sach = timSach(maSach);
		if (sach != null) {
			dsSach.remove(sach);
			System.out.println("Xoa thanh cong sach: " + sach.getMaSach());
			return sach;
		}
		return null;
	}

	@Override
	public void capnhat1(String maSach, double thueMoi) {
		if (maSach == null) return;
		Sach sach = timSach(maSach);
		if (sach != null && sach instanceof SachThamKhao) {
			((SachThamKhao) sach).setThue(thueMoi);
			System.out.println("Cap nhat thanh cong sach: " + sach.getMaSach());
		}
	}

	@Override
	public boolean capnhat2(String maSach, double thueMoi) {
		if (maSach == null) return false;
		Sach sach = timSach(maSach);
		if (sach != null && sach instanceof SachThamKhao) {
			((SachThamKhao) sach).setThue(thueMoi);
			return true;
		}
		return false;
	}

	@Override
	public Sach capnhat3(String maSach, double thueMoi) {
		if (maSach == null) return null;
		Sach sach = timSach(maSach);
		if (sach != null && sach instanceof SachThamKhao) {
			((SachThamKhao) sach).setThue(thueMoi);
			return sach;
		}
		return null;
	}

	@Override
	public List<Sach> cacSachTrongThang(int month) {
		return dsSach.stream()
				.filter(sach -> sach.getNgayNhap().getMonthValue() == month)
				.toList();
	}

	@Override
	public List<Sach> cacSachHonMotThang() {
		LocalDate today = LocalDate.now();
		return dsSach.stream()
				.filter(sach -> ChronoUnit.MONTHS.between(sach.getNgayNhap(), today) > 1)
				.toList();
	}

	@Override
	public List<Sach> cacSachGiaoKhoaCu() {
		return dsSach.stream()
				.filter(sach -> sach instanceof SachGiaoKhoa && ((SachGiaoKhoa) sach).getTinhTrang() == TinhTrangSach.CU)
				.toList();
	}

	@Override
	public List<Sach> sapXepTheoDonGiaGiam() {
		return dsSach.stream()
				.sorted(Comparator.comparing(Sach::getDonGia).reversed())
				.toList();
	}

	@Override
	public List<Sach> sapXepDaCapNXBTangVaDonGiaGiam() {
		return dsSach.stream()
				.sorted(Comparator.comparing(Sach::getNhaXuatBan)
						.thenComparing(Sach::getDonGia, Comparator.reverseOrder()))
				.toList();
	}

	@Override
	public List<Sach> sapXepDaCapLoaiSachTangVaDonGiaGiam() {
		return dsSach.stream()
				.sorted(Comparator.comparing((Sach sach) -> sach.getClass().getSimpleName()).thenComparing(Sach::getDonGia, Comparator.reverseOrder()))
				.toList();
	}

	@Override
	public double donGiaCaoNhat() {
		return dsSach.stream()
				.mapToDouble(Sach::getDonGia)
				.max()
				.orElse(0.0);
	}

	@Override
	public int tongSoLuongSachTheoNam(int nam) {
		return dsSach.stream()
				.filter(sach -> sach.getNgayNhap().getYear() == nam)
				.mapToInt(Sach::getSoLuong)
				.sum();
	}

	
	@Override
	public double trungBinhCongDonGiaSach(int nam) {
		return dsSach.stream()
				.filter(sach -> sach.getNgayNhap().getYear() == nam)
				.mapToDouble(Sach::getDonGia)
				.average()
				.orElse(0.0);
	}

	@Override
	public double tongThanhTienToanBoVoiReduce() {
		return dsSach.stream()
				.mapToDouble(Sach::getDonGia)
				.reduce(0.0, Double::sum);
	}
	
	@Override
	public double tongThanhTienTungLoai() {
		return 0;
	}
	
	@Override
	public Map<String, Integer> gomTheoNhomVaDemSoLuongSach() {
		return dsSach.stream()
				.collect(Collectors.groupingBy(book -> book.getClass().getSimpleName(), Collectors.summingInt(book -> 1)));
	}

	@Override
	public Map<String, List<Sach>> gomTheoNhomCaoVaThapSapXepGiamDan() {
		// TODO Auto-generated method stub
		return null;
	}


}
