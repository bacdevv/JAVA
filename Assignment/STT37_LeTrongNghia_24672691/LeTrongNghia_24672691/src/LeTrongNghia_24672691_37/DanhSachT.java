package LeTrongNghia_24672691_37;

import java.time.LocalDate;

public class DanhSachT {
	private HoiThao[] ds;
	private int count;
	
	// Constructor
	public DanhSachT(int size) {
		ds = new HoiThao[size];
		count = 0;
	}
	
	// Getter
	public int getCount() {
		return count;
	}
	
	public HoiThao[] getDs() {
		return ds;
	}
	
	// Thêm tour vào danh sách
	public boolean them(HoiThao tour) {
		// Kiểm tra trùng mã
		for(int i = 0; i < count; i++) {
			if(ds[i].getMaTour().equals(tour.getMaTour())) {
				return false; // Mã trùng
			}
		}
		
		// Mở rộng mảng nếu đầy
		if(count == ds.length) {
			HoiThao[] temp = new HoiThao[ds.length * 2];
			for(int i = 0; i < count; i++) {
				temp[i] = ds[i];
			}
			ds = temp;
		}
		
		// Thêm tour
		ds[count] = tour;
		count++;
		return true;
	}
	
	// Tìm kiếm tour theo mã
	public HoiThao timKiem(String maTour) {
		for(int i = 0; i < count; i++) {
			if(ds[i].getMaTour().equals(maTour)) {
				return ds[i];
			}
		}
		return null;
	}
	
	// Sắp xếp tăng theo giá (Selection Sort)
	public void sapXepTheoGia() {
		for(int i = 0; i < count - 1; i++) {
			int minIndex = i;
			for(int j = i + 1; j < count; j++) {
				if(ds[j].getGiaTour() < ds[minIndex].getGiaTour()) {
					minIndex = j;
				}
			}
			// Hoán đổi
			HoiThao temp = ds[i];
			ds[i] = ds[minIndex];
			ds[minIndex] = temp;
		}
	}
	
	// Tính tổng chi phí
	public long tongChiPhi() {
		long tong = 0;
		for(int i = 0; i < count; i++) {
			tong += ds[i].getGiaTour();
		}
		return tong;
	}
	
	// Tìm tour theo ngày
	public HoiThao[] timTheoNgay(LocalDate ngay) {
		// Đếm số lượng
		int dem = 0;
		for(int i = 0; i < count; i++) {
			if(ds[i].getNgayKH().equals(ngay)) {
				dem++;
			}
		}
		
		// Tạo mảng kết quả
		HoiThao[] ketQua = new HoiThao[dem];
		int index = 0;
		for(int i = 0; i < count; i++) {
			if(ds[i].getNgayKH().equals(ngay)) {
				ketQua[index] = ds[i];
				index++;
			}
		}
		return ketQua;
	}
	
	// In danh sách
	public void inDanhSach() {
		if(count == 0) {
			System.out.println("Danh sach rong!");
			return;
		}
		
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.printf("%-10s | %-15s | %-25s | %-12s | %5s | %12s\n",
				"Ma Tour", "Ten Tour", "Huong Dan Vien", "Ngay KH", "Ngay", "Gia Tour");
		System.out.println("-------------------------------------------------------------------------------------");
		for(int i = 0; i < count; i++) {
			System.out.println(ds[i]);
		}
		System.out.println("-------------------------------------------------------------------------------------");
	}
}
