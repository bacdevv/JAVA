package collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class QuanLyPhongHoc implements QuanLyImpl{
	
	private List<PhongHoc> danhSach;
	
	public QuanLyPhongHoc() {
		this.danhSach = new ArrayList<PhongHoc>();
	}

	@Override
	public PhongHoc them(PhongHoc phong) {
        if (!danhSach.contains(phong)) {
            danhSach.add(phong);
            return phong;
        }
		return null;
	}

	@Override
	public PhongHoc xoa(String maPhong) {
		PhongHoc phong = timKiemPhongHoc(maPhong);
        if (phong != null) {
            danhSach.remove(phong);
            return phong;
        }
        return null;
	}

	@Override
	public PhongHoc capNhat(String maPhong, int soMayTinh) {
        PhongHoc phong = timKiemPhongHoc(maPhong);
        if (phong != null && phong instanceof PhongMayTinh pmt) {
            pmt.setSoMayTinh(soMayTinh);
            return pmt;
        }
        return null;
	}

	@Override
	public PhongHoc timKiemPhongHoc(String maPhong) {
        return danhSach.stream().filter(p -> p.getMaPhong.equals(maPhong)).findFirst().orElse(null);
    }

	@Override
	public List<PhongHoc> sapXepTangDanTheoDayNha() {
		return danhSach.stream().sorted(Comparator.comparing(PhongHoc::getDayNha)).collect(Collectors.toList());
	}

	@Override
	public List<PhongHoc> sapXepGiamDanTheoDienTich() {
		return danhSach.stream().sorted(Comparator.comparingDouble(PhongHoc::getDienTich).reversed()).collect(Collectors.toList());
	}

	@Override
	public List<PhongHoc> sapXepTangDanTheoSoBongDenGiamDanTheoDayNha() {
        return danhSach.stream()
        .sorted(
                // Tiêu chí 1: Tăng dần theo số bóng đèn
                Comparator.comparingInt(PhongHoc::getSoBongDen)
                // Tiêu chí 2 (Nếu tiêu chí 1 bằng nhau): Giảm dần theo dãy nhà
                .thenComparing(PhongHoc::getDayNha, Comparator.reverseOrder())
        )
        .collect(Collectors.toList());
    }

	@Override
	public int soLuongPhongHoc() {
		return danhSach.size();
	}

	@Override
	public int tinhTongSoBongDen() {
		return 0;
	}

	@Override
	public double tinhTrungBinhDienTich() {
		return 0;
	}

	@Override
	public List<PhongHoc> layDanhSachPhongHocDatChuan() {
		return null;
	}

	@Override
	public List<PhongHoc> layDanhSachPhongMayTinh(int soMay) {
		return null;
	}

	@Override
	public List<PhongHoc> layDanhSachPhongHocCoDienTichLonNhat(int n) {
		return null;
	}

	@Override
	public Map<String, List<PhongHoc>> gomNhom1() {
		return null;
	}

	@Override
	public Map<DayNha, Integer> gomNhom2() {
		return null;
	}

	@Override
	public Map<String, List<PhongHoc>> gomNhom3() {
		return null;
	}

	@Override
	public Map<String, Set<DayNha>> gomNhom4() {
		return null;
	}

	@Override
	public Map<String, PhongHoc> gomNhom5() {
		return null;
	}

	@Override
	public Map<DayNha, List<PhongHoc>> gomNhom6() {
		return null;
	}

}
