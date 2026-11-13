import java.nio.charset.StandardCharsets;
import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

// Quản lý sách trong thư viện.
public class BAITAP3 {
    public static void main(String[] args) {
        Test.main(args);
    }
}

class Test {
    public static void main(String[] args) {
        System.setOut(new java.io.PrintStream(System.out, true, StandardCharsets.UTF_8));
        Scanner sc = new Scanner(System.in, "UTF-8");
        ArrayList<Sach> danhSachSach = new ArrayList<>();

        int chon;
        do {
            System.out.println("\n========== QUẢN LÝ SÁCH THƯ VIỆN ==========");
            System.out.println("1. Thêm sách");
            System.out.println("2. Hiển thị danh sách sách");
            System.out.println("3. Tìm sách theo mã");
            System.out.println("4. Cập nhật số lượng");
            System.out.println("5. Xóa sách theo mã");
            System.out.println("6. Tính tổng số lượng sách");
            System.out.println("7. Bài thực hành tuần 8 (tính đóng gói)");
            System.out.println("0. Thoát");
            chon = nhapSoNguyen(sc, "Chọn chức năng: ");

            switch (chon) {
                case 1:
                    themSach(sc, danhSachSach);
                    break;
                case 2:
                    hienThiDanhSach(danhSachSach);
                    break;
                case 3:
                    timSach(sc, danhSachSach);
                    break;
                case 4:
                    capNhatSoLuong(sc, danhSachSach);
                    break;
                case 5:
                    xoaSach(sc, danhSachSach);
                    break;
                case 6:
                    tinhTongSoLuong(danhSachSach);
                    break;
                case 7:
                    baiTapTuan8(sc);
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        } while (chon != 0);

        sc.close();
    }

    private static void themSach(Scanner sc, ArrayList<Sach> danhSachSach) {
        System.out.print("Nhập mã sách: ");
        String ma = sc.nextLine().trim();
        if (timTheoMa(danhSachSach, ma) != null) {
            System.out.println("Mã sách đã tồn tại, không thể thêm!");
            return;
        }

        System.out.print("Nhập tiêu đề sách: ");
        String tieuDe = sc.nextLine().trim();
        System.out.print("Nhập tác giả: ");
        String tacGia = sc.nextLine().trim();
        int namXB = nhapNamXuatBan(sc);
        int soLuong = nhapSoLuong(sc);

        danhSachSach.add(new Sach(ma, tieuDe, tacGia, namXB, soLuong));
        System.out.println("Đã thêm sách thành công!");
    }

    private static void hienThiDanhSach(ArrayList<Sach> danhSachSach) {
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sách sách đang trống!");
            return;
        }

        inTieuDeBang();
        for (Sach sach : danhSachSach) {
            sach.hienThiThongTin();
        }
    }

    private static void timSach(Scanner sc, ArrayList<Sach> danhSachSach) {
        System.out.print("Nhập mã sách cần tìm: ");
        String ma = sc.nextLine().trim();
        Sach sach = timTheoMa(danhSachSach, ma);
        if (sach == null) {
            System.out.println("Không tìm thấy sách có mã: " + ma);
            return;
        }

        inTieuDeBang();
        sach.hienThiThongTin();
    }

    private static void capNhatSoLuong(Scanner sc, ArrayList<Sach> danhSachSach) {
        System.out.print("Nhập mã sách cần cập nhật số lượng: ");
        String ma = sc.nextLine().trim();
        Sach sach = timTheoMa(danhSachSach, ma);
        if (sach == null) {
            System.out.println("Không tìm thấy sách có mã: " + ma);
            return;
        }

        sach.setSoLuong(nhapSoLuong(sc));
        System.out.println("Đã cập nhật số lượng thành công!");
    }

    private static void xoaSach(Scanner sc, ArrayList<Sach> danhSachSach) {
        System.out.print("Nhập mã sách cần xóa: ");
        String ma = sc.nextLine().trim();
        Sach sach = timTheoMa(danhSachSach, ma);
        if (sach == null) {
            System.out.println("Không tìm thấy sách có mã: " + ma);
            return;
        }

        danhSachSach.remove(sach);
        System.out.println("Đã xóa sách có mã: " + ma);
    }

    private static void tinhTongSoLuong(ArrayList<Sach> danhSachSach) {
        int tongSoLuong = 0;
        for (Sach sach : danhSachSach) {
            tongSoLuong += sach.getSoLuong();
        }
        System.out.println("Tổng số lượng sách trong thư viện: " + tongSoLuong + " cuốn.");
    }

    private static void baiTapTuan8(Scanner sc) {
        ArrayList<Sach> danhSachTuan8 = new ArrayList<>();
        danhSachTuan8.add(new Sach("S01", "Lập Trình Hướng Đối Tượng", "Nguyễn Văn A", 2022, 12));
        danhSachTuan8.add(new Sach("S02", "Cấu Trúc Dữ Liệu & Giải Thuật", "Trần Thị B", 2020, 8));

        int chon;
        do {
            System.out.println("\n========== BÀI THỰC HÀNH TUẦN 8 ==========");
            System.out.println("1. Thêm sách bằng constructor");
            System.out.println("2. Hiển thị danh sách sách");
            System.out.println("3. Cập nhật năm xuất bản bằng setter");
            System.out.println("4. Cập nhật số lượng bằng setter");
            System.out.println("0. Quay lại menu chính");
            chon = nhapSoNguyen(sc, "Chọn chức năng: ");

            switch (chon) {
                case 1:
                    themSach(sc, danhSachTuan8);
                    break;
                case 2:
                    hienThiDanhSach(danhSachTuan8);
                    break;
                case 3:
                    capNhatNamXuatBan(sc, danhSachTuan8);
                    break;
                case 4:
                    capNhatSoLuong(sc, danhSachTuan8);
                    break;
                case 0:
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        } while (chon != 0);
    }

    private static void capNhatNamXuatBan(Scanner sc, ArrayList<Sach> danhSachSach) {
        System.out.print("Nhập mã sách cần cập nhật năm xuất bản: ");
        String ma = sc.nextLine().trim();
        Sach sach = timTheoMa(danhSachSach, ma);
        if (sach == null) {
            System.out.println("Không tìm thấy sách có mã: " + ma);
            return;
        }

        int namMoi = nhapSoNguyen(sc, "Nhập năm xuất bản mới: ");
        try {
            sach.setNamXuatBan(namMoi);
            System.out.println("Đã cập nhật năm xuất bản thành công!");
        } catch (IllegalArgumentException e) {
            System.out.println("Không thể cập nhật: " + e.getMessage());
        }
    }

    private static Sach timTheoMa(ArrayList<Sach> danhSachSach, String ma) {
        for (Sach sach : danhSachSach) {
            if (sach.getMaSach().equalsIgnoreCase(ma)) {
                return sach;
            }
        }
        return null;
    }

    private static int nhapSoNguyen(Scanner sc, String thongBao) {
        while (true) {
            System.out.print(thongBao);
            String duLieu = sc.nextLine().trim();
            try {
                return Integer.parseInt(duLieu);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số nguyên hợp lệ!");
            }
        }
    }

    private static int nhapNamXuatBan(Scanner sc) {
        int namHienTai = Year.now().getValue();
        while (true) {
            int nam = nhapSoNguyen(sc, "Nhập năm xuất bản (1 - " + namHienTai + "): ");
            if (nam > 0 && nam <= namHienTai) {
                return nam;
            }
            System.out.println("Năm xuất bản phải nằm trong khoảng 1 - " + namHienTai + "!");
        }
    }

    private static int nhapSoLuong(Scanner sc) {
        while (true) {
            int soLuong = nhapSoNguyen(sc, "Nhập số lượng (>= 0): ");
            if (soLuong >= 0) {
                return soLuong;
            }
            System.out.println("Số lượng phải lớn hơn hoặc bằng 0!");
        }
    }

    private static void inTieuDeBang() {
        System.out.println("\n=== DANH SÁCH SÁCH ===");
        System.out.printf("%-10s | %-28s | %-20s | %-8s | %-8s%n",
                "Mã sách", "Tiêu đề", "Tác giả", "Năm XB", "Số lượng");
        System.out.println("----------------------------------------------------------------------------------");
    }
}

class Sach {
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;

    public Sach() {
    }

    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        setNamXuatBan(namXuatBan);
        setSoLuong(soLuong);
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        int namHienTai = Year.now().getValue();
        if (namXuatBan <= 0 || namXuatBan > namHienTai) {
            throw new IllegalArgumentException(
                    "Năm xuất bản phải nằm trong khoảng 1 - " + namHienTai + ".");
        }
        this.namXuatBan = namXuatBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        if (soLuong < 0) {
            throw new IllegalArgumentException("Số lượng không được âm.");
        }
        this.soLuong = soLuong;
    }

    public void hienThiThongTin() {
        System.out.printf("%-10s | %-28s | %-20s | %-8d | %-8d%n",
                maSach, tieuDe, tacGia, namXuatBan, soLuong);
    }
}
