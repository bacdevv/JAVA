package tranvietbac_24681721;
import java.time.LocalDate;

public class TestTheKhachHang {
    public static void main(String[] args) {
        // Khởi tạo quản lý với mảng ban đầu có 3 chỗ
        QuanLyTheKhachHang ql = new QuanLyTheKhachHang(3);

        // Tạo 5 đối tượng thẻ
        TheKhachHang the1 = new TheKhachHang("T001", "Nguyễn Văn A", "Bạch Kim", LocalDate.of(2023, 10, 25), 5000000, 500, true);
        TheKhachHang the2 = new TheKhachHang("T002", "Trần Thị B", "Vàng", LocalDate.of(2022, 5, 15), 2500000, 250, true);
        TheKhachHang the3 = new TheKhachHang("T003", "Lê Văn C", "Bạc", LocalDate.of(2023, 1, 30), 1500000, 150, true);
        TheKhachHang the4 = new TheKhachHang("T004", "Phạm Thị D", "Vàng", LocalDate.of(2021, 12, 1), 8000000, 800, false);
        TheKhachHang the5 = new TheKhachHang("T005", "Võ Văn E", "Bạch Kim", LocalDate.of(2023, 10, 1), 12000000, 1200, true);

        // --- Test chức năng thêm (sẽ có mở rộng mảng) ---
        System.out.println(">>> Thêm 5 thẻ vào danh sách (kích thước ban đầu là 3):");
        ql.themTheKhachHang(the1);
        ql.themTheKhachHang(the2);
        ql.themTheKhachHang(the3); // Mảng đầy
        ql.themTheKhachHang(the4); // Mảng sẽ tự mở rộng ở đây
        ql.themTheKhachHang(the5);
        System.out.println("\n--- Danh sách sau khi thêm: ---");
        ql.inDanhSach();

        // --- Test chức năng tính trung bình ---
        System.out.println("\n>>> Tính tổng tiền trung bình của thẻ Vàng và Bạc:");
        double avg = ql.tinhTrungBinhTongTien();
        System.out.printf("Kết quả: %.2f VND\n", avg);

        // --- Test chức năng sắp xếp ---
        System.out.println("\n>>> Sắp xếp danh sách tăng dần theo ngày cấp:");
        ql.sapXepTangDanTheoNgayCap();
        System.out.println("--- Danh sách sau khi sắp xếp: ---");
        ql.inDanhSach();
    }
}