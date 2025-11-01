# Quản Lý Hội Thảo (Tour Management System)

## Mô tả

Chương trình quản lý hội thảo được viết bằng Java, sử dụng các khái niệm cơ bản như constructor, array, getter, setter mà không sử dụng collection framework.

## Cấu trúc dự án

### 1. HoiThao.java

**Lớp đại diện cho một hội thảo/tour du lịch**

**Thuộc tính:**

-   `maTour`: Mã tour (String) - không được rỗng
-   `tenTour`: Tên tour (String) - không được rỗng
-   `huongDanVien`: Danh sách hướng dẫn viên (String) - phải có ít nhất 2 HDV, cách nhau bởi dấu `;`
-   `ngayKH`: Ngày khởi hành (LocalDate)
-   `soNgay`: Số ngày tour (int) - phải > 0
-   `giaTour`: Giá tour (long) - phải > 0

**Constructor:**

-   `HoiThao()`: Constructor mặc định
-   `HoiThao(String maTour, String tenTour, String huongDanVien, LocalDate ngayKH, int soNgay, long giaTour)`: Constructor đầy đủ

**Phương thức:**

-   Getter/Setter cho tất cả thuộc tính với validation
-   `toString()`: Hiển thị thông tin tour dạng bảng

### 2. DanhSachT.java

**Lớp quản lý danh sách các hội thảo sử dụng mảng**

**Thuộc tính:**

-   `ds`: Mảng HoiThao[] để lưu trữ danh sách tour
-   `count`: Số lượng tour hiện tại trong danh sách

**Phương thức chính:**

-   `tangKichThuoc()`: Tự động mở rộng mảng khi cần
-   `them(HoiThao tour)`: Thêm tour mới (kiểm tra trùng mã)
-   `timKiemVT(String maTour)`: Tìm vị trí tour theo mã
-   `timKiemDT(String maTour)`: Tìm đối tượng tour theo mã
-   `sortTangTheoGia()`: Sắp xếp tour theo giá tăng dần (Bubble Sort)
-   `tongChiPhi()`: Tính tổng chi phí tất cả tour
-   `getDSSapXep()`: Lấy danh sách đã sắp xếp (không thay đổi danh sách gốc)
-   `getDSTheoNgay(LocalDate ngay)`: Lọc tour theo ngày khởi hành
-   `getDs()`: Lấy toàn bộ danh sách hiện tại

### 3. TestHoiThao.java

**Lớp chính với giao diện menu để test chương trình**

**Chức năng:**

1. Nhập dữ liệu mẫu
2. Hiển thị tất cả tour
3. Thêm tour mới
4. Sắp xếp danh sách theo giá
5. Tính tổng chi phí
6. Tìm tour theo ngày

### 4. DemoHoiThao.java

**Lớp demo minh họa đầy đủ các tính năng**

## Các tính năng chính

### 1. Quản lý dữ liệu cơ bản

-   ✅ Sử dụng mảng thay vì Collection
-   ✅ Constructor có tham số và mặc định
-   ✅ Getter/Setter với validation đầy đủ
-   ✅ Tự động mở rộng mảng khi cần

### 2. Validation dữ liệu

-   ✅ Mã tour không được trùng và không rỗng
-   ✅ Tên tour không được rỗng
-   ✅ Phải có ít nhất 2 hướng dẫn viên
-   ✅ Số ngày và giá tour phải > 0
-   ✅ Xử lý exception với thông báo chi tiết

### 3. Tìm kiếm và sắp xếp

-   ✅ Tìm kiếm tour theo mã (trả về vị trí hoặc đối tượng)
-   ✅ Sắp xếp tour theo giá (Bubble Sort)
-   ✅ Lọc tour theo ngày khởi hành
-   ✅ Không sử dụng Arrays.sort() hay Comparator

### 4. Tính toán

-   ✅ Tính tổng chi phí tất cả tour
-   ✅ Đếm số lượng tour theo tiêu chí

## Cách chạy chương trình

### Chạy demo:

```bash
javac LeTrongNghia_24672691_37/*.java
java LeTrongNghia_24672691_37.DemoHoiThao
```

### Chạy chương trình chính với menu:

```bash
java LeTrongNghia_24672691_37.TestHoiThao
```

## Ví dụ sử dụng

### Tạo tour bằng constructor:

```java
LocalDate ngayKH = LocalDate.of(2025, 3, 15);
HoiThao tour = new HoiThao("HT001", "Ha Long Bay",
                           "Nguyen Van A;Tran Thi B",
                           ngayKH, 3, 2500000);
```

### Tạo tour bằng setter:

```java
HoiThao tour = new HoiThao();
tour.setMaTour("HT002");
tour.setTenTour("Sa Pa");
tour.setHuongDanVien("Le Van C;Pham Thi D");
tour.setNgayKH(LocalDate.of(2025, 4, 10));
tour.setSoNgay(2);
tour.setGiaTour(1800000);
```

### Quản lý danh sách:

```java
DanhSachT danhSach = new DanhSachT(10);
danhSach.them(tour1);
danhSach.them(tour2);

// Sắp xếp và hiển thị
HoiThao[] dsSapXep = danhSach.getDSSapXep();
for(int i = 0; i < dsSapXep.length; i++) {
    System.out.println(dsSapXep[i]);
}

// Tìm tour theo ngày
LocalDate ngayTim = LocalDate.of(2025, 3, 15);
HoiThao[] dsTheoNgay = danhSach.getDSTheoNgay(ngayTim);
```

## Lưu ý kỹ thuật

1. **Không sử dụng Collection Framework**: Chỉ dùng mảng cơ bản
2. **Tự động mở rộng mảng**: Khi mảng đầy, tự động tăng gấp đôi kích thước
3. **Bubble Sort**: Sắp xếp thủ công thay vì Arrays.sort()
4. **Sao chép mảng thủ công**: Không dùng Arrays.copyOf()
5. **Validation nghiêm ngặt**: Kiểm tra tất cả input
6. **Exception handling**: Xử lý lỗi đầy đủ với thông báo rõ ràng

## Kết quả mong đợi

Khi chạy demo, bạn sẽ thấy:

-   Tạo và quản lý danh sách tour
-   Sắp xếp theo giá tăng dần
-   Tìm kiếm tour theo mã và ngày
-   Tính tổng chi phí
-   Tự động mở rộng mảng
-   Validation dữ liệu đầu vào
