import java.util.Scanner;

public class BAITAPT3 {
    public static void main(String[] args) {
        // In và nhập tiếng Việt có dấu
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));
        Scanner sc = new Scanner(System.in, "UTF-8");

        // ===== Bài 1: Nhập thông tin sách và hiển thị lại =====
        System.out.println("=== NHAP THONG TIN SACH ===");

        System.out.print("Nhap ma sach: ");
        String maSach = sc.nextLine();

        System.out.print("Nhap ten sach: ");
        String tenSach = sc.nextLine();

        System.out.print("Nhap tac gia: ");
        String tacGia = sc.nextLine();

        System.out.print("Nhap nam xuat ban: ");
        int namXuatBan = sc.nextInt();

        System.out.print("Nhap don gia: ");
        double donGia = sc.nextDouble();

        System.out.print("Nhap so luong: ");
        int soLuong = sc.nextInt();

        System.out.println();
        System.out.println("=== THONG TIN SACH VUA NHAP ===");
        System.out.println("Ma sach     : " + maSach);
        System.out.println("Ten sach    : " + tenSach);
        System.out.println("Tac gia     : " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.printf("Don gia     : %,.0f VND%n", donGia);
        System.out.println("So luong    : " + soLuong);

        // ===== Bài 2: Thành tiền = đơn giá x số lượng =====
        double thanhTien = donGia * soLuong;

        // ===== Bài 3: Phí vận chuyển = 5% giá trị sách =====
        double phiVanChuyen = thanhTien * 5 / 100;

        // ===== Bài 4: Tổng tiền nhập = thành tiền + phí vận chuyển =====
        double tongTienNhap = thanhTien + phiVanChuyen;

        System.out.println();
        System.out.println("=== TINH TIEN ===");
        System.out.printf("Thanh tien      : %,.0f VND%n", thanhTien);
        System.out.printf("Phi van chuyen  : %,.0f VND%n", phiVanChuyen);
        System.out.printf("Tong tien nhap  : %,.0f VND%n", tongTienNhap);

        sc.close();
    }
}