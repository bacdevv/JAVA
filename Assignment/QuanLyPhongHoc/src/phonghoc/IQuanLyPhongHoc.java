package phonghoc;

import java.util.List;

public interface IQuanLyPhongHoc {
    // Các phương thức thêm/xóa/sửa
    boolean themPhongHoc(PhongHoc p);
    boolean xoaPhongHoc(String maPhong);
    boolean capNhatSoMayTinh(String maPhong, int soMayMoi);

    // Các phương thức tìm kiếm/lấy thông tin
    PhongHoc timPhongHoc(String maPhong);
    void inDanhSach();
    int tongSoPhong();

    // Các phương thức lọc danh sách
    List<PhongHoc> layDsDatChuan();
    List<PhongMayTinh> layDsMayTinh60May();

    // Các phương thức sắp xếp
    void sapXepTheoDayNha();
    void sapXepTheoDienTich();
    void sapXepTheoBongDen();
}