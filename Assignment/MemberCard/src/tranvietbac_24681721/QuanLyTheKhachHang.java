package tranvietbac_24681721;
// File: QuanLyTheKhachHang.java
public class QuanLyTheKhachHang {
    private TheKhachHang[] dsThe;
    private int soLuongHienTai;

    public QuanLyTheKhachHang(int n) {
        this.dsThe = new TheKhachHang[n > 0 ? n : 10]; // Đảm bảo n > 0
        this.soLuongHienTai = 0;
    }

    // In danh sách để kiểm tra
    public void inDanhSach() {
        for (int i = 0; i < soLuongHienTai; i++) {
            System.out.println(dsThe[i]);
        }
    }

    public void themTheKhachHang(TheKhachHang the) {
        // Xử lý mở rộng mảng khi đầy
        if (soLuongHienTai == dsThe.length) {
            int newSize = (int) (dsThe.length * 1.7);
            TheKhachHang[] dsMoi = new TheKhachHang[newSize];
            System.arraycopy(dsThe, 0, dsMoi, 0, dsThe.length); // Cách copy hiệu quả hơn
            dsThe = dsMoi;
            System.out.println("--- Đã mở rộng mảng lên kích thước: " + newSize + " ---");
        }
        dsThe[soLuongHienTai] = the;
        soLuongHienTai++;
    }

    public double tinhTrungBinhTongTien() {
        double tong = 0;
        int dem = 0;
        for (int i = 0; i < soLuongHienTai; i++) {
            String loaiThe = dsThe[i].getLoaiThe();
            if (loaiThe.equals("Vàng") || loaiThe.equals("Bạc")) {
                tong += dsThe[i].getTongTien(); // Giả sử tongTien là thuộc tính public hoặc có getter
                dem++;
            }
        }
        return (dem == 0) ? 0 : tong / dem;
    }

    public void sapXepTangDanTheoNgayCap() {
        for (int i = 0; i < soLuongHienTai - 1; i++) {
            for (int j = i + 1; j < soLuongHienTai; j++) {
                // Nếu ngày của thẻ i > ngày của thẻ j -> hoán đổi
                if (dsThe[i].getNgayCap().compareTo(dsThe[j].getNgayCap()) > 0) {
                    TheKhachHang temp = dsThe[i];
                    dsThe[i] = dsThe[j];
                    dsThe[j] = temp;
                }
            }
        }
    }
}
