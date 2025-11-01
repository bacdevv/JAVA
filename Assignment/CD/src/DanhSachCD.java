import java.text.NumberFormat;
import java.util.Locale;

public class DanhSachCD {
    // Thuộc tính
    private CD[] danhSach;
    private int soLuongHienTai;
    
    // Constructor
    public DanhSachCD(int kichThuoc) {
        this.danhSach = new CD[kichThuoc];
        this.soLuongHienTai = 0;
    }
    
    // Phương thức thêm CD vào danh sách
    public boolean themCD(CD cd) {
        // Kiểm tra xem mảng còn chỗ không
        if (soLuongHienTai >= danhSach.length) {
            System.out.println("Danh sach da day, khong the them CD!");
            return false;
        }
        
        // Kiểm tra trùng mã CD
        if (timCDTheoMa(cd.getMaCD()) != null) {
            System.out.println("Ma CD " + cd.getMaCD() + " da ton tai!");
            return false;
        }
        
        // Thêm CD vào danh sách
        danhSach[soLuongHienTai] = cd;
        soLuongHienTai++;
        System.out.println("Them CD thanh cong!");
        return true;
    }
    
    // Phương thức tìm CD theo mã
    private CD timCDTheoMa(int maCD) {
        for (int i = 0; i < soLuongHienTai; i++) {
            if (danhSach[i].getMaCD() == maCD) {
                return danhSach[i];
            }
        }
        return null;
    }
    
    // Tính số lượng CD trong danh sách
    public int getSoLuongCD() {
        return soLuongHienTai;
    }
    
    // Tính tổng giá thành của các CD
    public double tinhTongGiaThanh() {
        double tong = 0;
        for (int i = 0; i < soLuongHienTai; i++) {
            tong += danhSach[i].getGiaThanh();
        }
        return tong;
    }
    
    // Sắp xếp danh sách giảm dần theo giá thành
    public void sapXepGiamDanTheoGia() {
        for (int i = 0; i < soLuongHienTai - 1; i++) {
            for (int j = i + 1; j < soLuongHienTai; j++) {
                if (danhSach[i].getGiaThanh() < danhSach[j].getGiaThanh()) {
                    // Hoán đổi
                    CD temp = danhSach[i];
                    danhSach[i] = danhSach[j];
                    danhSach[j] = temp;
                }
            }
        }
        System.out.println("Da sap xep giam dan theo gia thanh!");
    }
    
    // Sắp xếp danh sách tăng dần theo tựa CD
    public void sapXepTangDanTheoTua() {
        for (int i = 0; i < soLuongHienTai - 1; i++) {
            for (int j = i + 1; j < soLuongHienTai; j++) {
                if (danhSach[i].getTuaCD().compareToIgnoreCase(danhSach[j].getTuaCD()) > 0) {
                    // Hoán đổi
                    CD temp = danhSach[i];
                    danhSach[i] = danhSach[j];
                    danhSach[j] = temp;
                }
            }
        }
        System.out.println("Da sap xep tang dan theo tua CD!");
    }
    
    // Trả thông tin toàn bộ CD trong danh sách
    public void xuatDanhSach() {
        if (soLuongHienTai == 0) {
            System.out.println("Danh sach trong!");
            return;
        }
        
        System.out.println("=".repeat(85));
        System.out.println("DANH SACH CD");
        System.out.println("=".repeat(85));
        System.out.printf("%-10s %-30s %-15s %-20s%n", "Ma CD", "Tua CD", "So bai hat", "Gia thanh");
        System.out.println("-".repeat(85));
        
        for (int i = 0; i < soLuongHienTai; i++) {
            System.out.println(danhSach[i].toString());
        }
        
        System.out.println("-".repeat(85));
        System.out.println("Tong so CD: " + soLuongHienTai);
        
        // Định dạng tiền tệ cho tổng giá thành
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(localeVN);
        String formattedTotal = currencyFormatter.format(tinhTongGiaThanh());
        System.out.println("Tong gia thanh: " + formattedTotal);
        System.out.println("=".repeat(85));
    }
}