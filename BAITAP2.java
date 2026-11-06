import java.util.Scanner;

public class BAITAP2 {
    public static void main(String[] args) {
        // In và nhập tiếng Việt có dấu
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));
        Scanner sc = new Scanner(System.in, "UTF-8");

        // Các mảng lưu thông tin n cuốn sách
        int n = 0;
        String[] maSach = null;
        String[] tenSach = null;
        String[] tacGia = null;
        int[] namXuatBan = null;
        double[] donGia = null;
        int[] soLuong = null;

        int chon;

        // ===== Bài 3: Menu lặp đến khi chọn Thoát =====
        do {
            System.out.println();
            System.out.println("========== QUẢN LÝ SÁCH ==========");
            System.out.println("1. Nhập n cuốn sách");
            System.out.println("2. Hiển thị danh sách sách");
            System.out.println("3. Tính tổng số lượng và tổng giá trị sách");
            System.out.println("4. Tìm sách theo mã");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            chon = sc.nextInt();
            sc.nextLine(); // bỏ dòng trống còn lại sau khi nhập số

            switch (chon) {
                case 1: {
                    // ===== Bài 1: Nhập n sách bằng vòng lặp =====
                    // Nhập n cho đến khi n > 0
                    do {
                        System.out.print("Nhập số cuốn sách n: ");
                        n = sc.nextInt();
                        sc.nextLine();
                        if (n <= 0) {
                            System.out.println("n phải lớn hơn 0, nhập lại!");
                        }
                    } while (n <= 0);

                    maSach = new String[n];
                    tenSach = new String[n];
                    tacGia = new String[n];
                    namXuatBan = new int[n];
                    donGia = new double[n];
                    soLuong = new int[n];

                    for (int i = 0; i < n; i++) {
                        System.out.println("--- Sách thứ " + (i + 1) + " ---");

                        System.out.print("Nhập mã sách: ");
                        maSach[i] = sc.nextLine();

                        System.out.print("Nhập tên sách: ");
                        tenSach[i] = sc.nextLine();

                        System.out.print("Nhập tác giả: ");
                        tacGia[i] = sc.nextLine();

                        System.out.print("Nhập năm xuất bản: ");
                        namXuatBan[i] = sc.nextInt();

                        // Nhập đơn giá cho đến khi > 0
                        do {
                            System.out.print("Nhập đơn giá: ");
                            donGia[i] = sc.nextDouble();
                            if (donGia[i] <= 0) {
                                System.out.println("Đơn giá phải lớn hơn 0, nhập lại!");
                            }
                        } while (donGia[i] <= 0);

                        // Nhập số lượng cho đến khi >= 0
                        do {
                            System.out.print("Nhập số lượng: ");
                            soLuong[i] = sc.nextInt();
                            if (soLuong[i] < 0) {
                                System.out.println("Số lượng phải lớn hơn hoặc bằng 0, nhập lại!");
                            }
                        } while (soLuong[i] < 0);

                        sc.nextLine(); // bỏ dòng trống còn lại
                    }
                    System.out.println("Đã nhập xong " + n + " cuốn sách.");
                    break;
                }

                case 2: {
                    // Hiển thị danh sách sách
                    if (n == 0) {
                        System.out.println("Chưa có sách, hãy chọn 1 để nhập.");
                    } else {
                        System.out.println("=== DANH SÁCH SÁCH ===");
                        System.out.printf("%-4s %-8s %-25s %-18s %-6s %12s %8s%n",
                                "STT", "Mã", "Tên sách", "Tác giả", "Năm", "Đơn giá", "SL");
                        for (int i = 0; i < n; i++) {
                            System.out.printf("%-4d %-8s %-25s %-18s %-6d %,12.0f %8d%n",
                                    i + 1, maSach[i], tenSach[i], tacGia[i],
                                    namXuatBan[i], donGia[i], soLuong[i]);
                        }
                    }
                    break;
                }

                case 3: {
                    // ===== Bài 2: Tính tổng số lượng và tổng giá trị sách =====
                    if (n == 0) {
                        System.out.println("Chưa có sách, hãy chọn 1 để nhập.");
                    } else {
                        int tongSoLuong = 0;
                        double tongGiaTri = 0;
                        for (int i = 0; i < n; i++) {
                            tongSoLuong = tongSoLuong + soLuong[i];
                            tongGiaTri = tongGiaTri + donGia[i] * soLuong[i];
                        }
                        System.out.println("Tổng số lượng sách : " + tongSoLuong);
                        System.out.printf("Tổng giá trị sách  : %,.0f VND%n", tongGiaTri);
                    }
                    break;
                }

                case 4: {
                    // ===== Bài 4: Tìm sách theo mã =====
                    if (n == 0) {
                        System.out.println("Chưa có sách, hãy chọn 1 để nhập.");
                    } else {
                        System.out.print("Nhập mã sách cần tìm: ");
                        String maTim = sc.nextLine();
                        boolean timThay = false;
                        for (int i = 0; i < n; i++) {
                            if (maSach[i].equalsIgnoreCase(maTim)) {
                                System.out.println("Tìm thấy sách:");
                                System.out.println("Mã sách      : " + maSach[i]);
                                System.out.println("Tên sách     : " + tenSach[i]);
                                System.out.println("Tác giả      : " + tacGia[i]);
                                System.out.println("Năm xuất bản : " + namXuatBan[i]);
                                System.out.printf("Đơn giá      : %,.0f VND%n", donGia[i]);
                                System.out.println("Số lượng     : " + soLuong[i]);
                                timThay = true;
                            }
                        }
                        if (!timThay) {
                            System.out.println("Không tìm thấy sách có mã " + maTim);
                        }
                    }
                    break;
                }

                case 0:
                    System.out.println("Thoát chương trình. Tạm biệt!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        } while (chon != 0);

        sc.close();
    }
}