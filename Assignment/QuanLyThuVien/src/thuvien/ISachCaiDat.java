package thuvien;

import java.util.List;
import java.util.Map;

public interface ISachCaiDat {
	// tim kiem theo ma sach va tra ve sach
	Sach timSach(String maSach);
	int soLuongSach();
	List<Sach> traVeDanhSachMoi();
	
	// them
	void them1(Sach sach);
	boolean them2(Sach sach);
	Sach them3(Sach sach);
	
	// xoa
	void xoa1(String maSach);
	boolean xoa2(String maSach);
	Sach xoa3(String maSach);
	
	// cap nhat
	void capnhat1(String maSach, double thueMoi);
	boolean capnhat2(String maSach, double thueMoi);
	Sach capnhat3(String maSach, double thueMoi);
	
	// tim kiem
	List<Sach> cacSachTrongThang(int month);
	List<Sach> cacSachHonMotThang();
	List<Sach> cacSachGiaoKhoaCu();
	
	// sap xep
	List<Sach> sapXepTheoDonGiaGiam();
	List<Sach> sapXepDaCapNXBTangVaDonGiaGiam();
	List<Sach> sapXepDaCapLoaiSachTangVaDonGiaGiam();
	
	double donGiaCaoNhat();
	int tongSoLuongSachTheoNam(int nam);
	double tongThanhTienTungLoai();
	double trungBinhCongDonGiaSach(int nam);
	double tongThanhTienToanBoVoiReduce();
	
	Map<String, Integer> gomTheoNhomVaDemSoLuongSach();
	Map<String, List<Sach>> gomTheoNhomCaoVaThapSapXepGiamDan();
	

}
