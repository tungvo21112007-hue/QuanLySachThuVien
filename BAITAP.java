import java.util.Scanner;
import java.time.LocalDate;

public class BAITAP {
    public static void main(String[] args) {
        // In và nhập tiếng Việt có dấu
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));
        Scanner sc = new Scanner(System.in, "UTF-8");

        /* =====================================================
           TUẦN 3: BIẾN, KIỂU DỮ LIỆU VÀ TOÁN TỬ
        ===================================================== */

        // ----- Bài 1: Nhập thông tin sách và hiển thị lại -----
        System.out.println("=== NHẬP THÔNG TIN SÁCH ===");

        System.out.print("Nhập mã sách: ");
        String maSach = sc.nextLine();

        System.out.print("Nhập tên sách: ");
        String tenSach = sc.nextLine();

        System.out.print("Nhập tác giả: ");
        String tacGia = sc.nextLine();

        System.out.print("Nhập năm xuất bản: ");
        int namXuatBan = sc.nextInt();

        System.out.print("Nhập đơn giá: ");
        double donGia = sc.nextDouble();

        System.out.print("Nhập số lượng: ");
        int soLuong = sc.nextInt();

        System.out.println();
        System.out.println("=== THÔNG TIN SÁCH VỪA NHẬP ===");
        System.out.println("Mã sách      : " + maSach);
        System.out.println("Tên sách     : " + tenSach);
        System.out.println("Tác giả      : " + tacGia);
        System.out.println("Năm xuất bản : " + namXuatBan);
        System.out.printf("Đơn giá      : %,.0f VND%n", donGia);
        System.out.println("Số lượng     : " + soLuong);

        // ----- Bài 2: Thành tiền = đơn giá x số lượng -----
        double thanhTien = donGia * soLuong;

        // ----- Bài 3: Phí vận chuyển = 5% giá trị sách -----
        double phiVanChuyen = thanhTien * 5 / 100;

        // ----- Bài 4: Tổng tiền nhập = thành tiền + phí vận chuyển -----
        double tongTienNhap = thanhTien + phiVanChuyen;

        System.out.println();
        System.out.println("=== TÍNH TIỀN ===");
        System.out.printf("Thành tiền      : %,.0f VND%n", thanhTien);
        System.out.printf("Phí vận chuyển  : %,.0f VND%n", phiVanChuyen);
        System.out.printf("Tổng tiền nhập  : %,.0f VND%n", tongTienNhap);

        /* =====================================================
           TUẦN 4: CÂU LỆNH ĐIỀU KIỆN
        ===================================================== */

        // ----- Bài 1: Kiểm tra giá > 0, số lượng >= 0, năm xuất bản hợp lệ -----
        System.out.println();
        System.out.println("=== TUẦN 4 - BÀI 1: KIỂM TRA SÁCH CÓ HỢP LỆ KHÔNG ===");
        int namHienTai = LocalDate.now().getYear();
        boolean hopLe = true;

        if (donGia <= 0) {
            System.out.println("Lỗi: đơn giá phải lớn hơn 0");
            hopLe = false;
        }
        if (soLuong < 0) {
            System.out.println("Lỗi: số lượng phải lớn hơn hoặc bằng 0");
            hopLe = false;
        }
        if (namXuatBan < 1900 || namXuatBan > namHienTai) {
            System.out.println("Lỗi: năm xuất bản phải từ 1900 đến " + namHienTai);
            hopLe = false;
        }

        if (hopLe) {
            System.out.println("Sách hợp lệ");
        } else {
            System.out.println("Sách không hợp lệ, dừng chương trình");
            sc.close();
            return;
        }

        // ----- Bài 2: Phân loại giá -----
        System.out.println();
        System.out.println("=== TUẦN 4 - BÀI 2: PHÂN LOẠI GIÁ ===");
        if (donGia < 50000) {
            System.out.println("Sách giá thấp");
        } else if (donGia <= 100000) {
            System.out.println("Sách giá trung bình");
        } else if (donGia <= 200000) {
            System.out.println("Sách giá cao");
        } else {
            System.out.println("Sách giá đặc biệt");
        }

        // ----- Bài 3: Phân loại tồn kho -----
        System.out.println();
        System.out.println("=== TUẦN 4 - BÀI 3: PHÂN LOẠI TỒN KHO ===");
        if (soLuong == 0) {
            System.out.println("Hết sách");
        } else if (soLuong <= 5) {
            System.out.println("Sắp hết");
        } else if (soLuong <= 20) {
            System.out.println("Còn ít");
        } else {
            System.out.println("Còn nhiều");
        }

        // ----- Bài 4: Dùng switch chọn loại sách -----
        System.out.println();
        System.out.println("=== TUẦN 4 - BÀI 4: CHỌN LOẠI SÁCH ===");
        System.out.println("1. Sách giáo khoa");
        System.out.println("2. Sách tham khảo");
        System.out.println("3. Sách chuyên ngành");
        System.out.println("4. Sách khác");
        System.out.print("Chọn loại sách (1-4): ");
        int chon = sc.nextInt();

        switch (chon) {
            case 1:
                System.out.println("Loại sách: Sách giáo khoa");
                break;
            case 2:
                System.out.println("Loại sách: Sách tham khảo");
                break;
            case 3:
                System.out.println("Loại sách: Sách chuyên ngành");
                break;
            case 4:
                System.out.println("Loại sách: Sách khác");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ");
        }

        sc.close();
    }
}