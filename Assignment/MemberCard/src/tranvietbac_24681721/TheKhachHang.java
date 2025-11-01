package tranvietbac_24681721;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TheKhachHang {
    private final String maThe; // final để không thể thay đổi sau khi khởi tạo
    private String tenKH;
    private String loaiThe;
    private LocalDate ngayCap;
    private double tongTien;
    private int diemTichLuy;
    private boolean hieuLuc;

    public TheKhachHang() {
        // Constructor mặc định
        this.maThe = "000-DEFAULT"; // Phải khởi tạo biến final
    }

    public TheKhachHang(String maThe, String tenKH, String loaiThe, LocalDate ngayCap, double tongTien, int diemTichLuy, boolean hieuLuc) {
        if (maThe == null || maThe.trim().isEmpty()) {
            throw new IllegalArgumentException("Mã thẻ không được rỗng.");
        }
        this.maThe = maThe;

        setTenKH(tenKH);
        setLoaiThe(loaiThe);
        setNgayCap(ngayCap);
        setTongTien(tongTien);
        setDiemTichLuy(diemTichLuy);
        setHieuLuc(hieuLuc);
    }

    // --- Getters & Setters với validation ---
    public String getMaThe() { return maThe; }
    public String getTenKH() { return tenKH; }
    public void setTenKH(String tenKH) {
        if (tenKH == null || tenKH.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên khách hàng không được rỗng.");
        }
        this.tenKH = tenKH;
    }
    public String getLoaiThe() { return loaiThe; }
    public void setLoaiThe(String loaiThe) {
        if (!loaiThe.equals("Vàng") && !loaiThe.equals("Bạc") && !loaiThe.equals("Bạch Kim")) {
            throw new IllegalArgumentException("Loại thẻ phải là Vàng, Bạc hoặc Bạch Kim.");
        }
        this.loaiThe = loaiThe;
    }
    public LocalDate getNgayCap() { return ngayCap; }
    public void setNgayCap(LocalDate ngayCap) {
        if (ngayCap.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Ngày cấp không được sau ngày hiện tại.");
        }
        this.ngayCap = ngayCap;
    }
    // ... các getters/setters còn lại tương tự với validation

    // --- Các phương thức nghiệp vụ ---
    public double tinhTienChietKhau() {
        switch (this.loaiThe) {
            case "Bạch Kim":
                return this.tongTien * 0.10; // 10%
            case "Vàng":
            case "Bạc":
                return this.tongTien * 0.05; // 5%
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("Thẻ[Mã: %s, Tên: %s, Loại: %s, Ngày cấp: %s, Tổng tiền: %.2f VND, Điểm: %d, Hiệu lực: %b]",
                maThe, tenKH, loaiThe, ngayCap.format(formatter), tongTien, diemTichLuy, hieuLuc);
    }
}