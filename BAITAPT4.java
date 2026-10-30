import java.util.Scanner;
import java.time.LocalDate;

public class BAITAPT4 {
    public static void main(String[] args) {
        // In và nhập tiếng Việt có dấu
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));
        Scanner sc = new Scanner(System.in, "UTF-8");

        // ===== Nhập thông tin sách (như Tuần 3) =====
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

        // ===== Bài 1: Kiểm tra giá > 0, số lượng >= 0, năm xuất bản hợp lệ =====
        System.out.println();
        System.out.println("=== BÀI 1: KIỂM TRA SÁCH CÓ HỢP LỆ KHÔNG ===");
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

        // ===== Bài 2: Phân loại giá =====
        System.out.println();
        System.out.println("=== BÀI 2: PHÂN LOẠI GIÁ ===");
        if (donGia < 50000) {
            System.out.println("Sách giá thấp");
        } else if (donGia <= 100000) {
            System.out.println("Sách giá trung bình");
        } else if (donGia <= 200000) {
            System.out.println("Sách giá cao");
        } else {
            System.out.println("Sách giá đặc biệt");
        }

        // ===== Bài 3: Phân loại tồn kho =====
        System.out.println();
        System.out.println("=== BÀI 3: PHÂN LOẠI TỒN KHO ===");
        if (soLuong == 0) {
            System.out.println("Hết sách");
        } else if (soLuong <= 5) {
            System.out.println("Sắp hết");
        } else if (soLuong <= 20) {
            System.out.println("Còn ít");
        } else {
            System.out.println("Còn nhiều");
        }

        // ===== Bài 4: Dùng switch chọn loại sách =====
        System.out.println();
        System.out.println("=== BÀI 4: CHỌN LOẠI SÁCH ===");
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