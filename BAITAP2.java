import java.util.ArrayList;
import java.util.Scanner;

public class BAITAP2 {
    public static void main(String[] args) {
        // In và nhập tiếng Việt có dấu.
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));
        Scanner sc = new Scanner(System.in, "UTF-8");

        // Khai báo các mảng lưu thông tin sách.
        int n = 0;
        String[] maSach = null;
        String[] tenSach = null;
        String[] tacGia = null;
        int[] namXuatBan = null;
        double[] donGia = null;
        int[] soLuong = null;

        int chon;

        // Bài 3: Lặp menu đến khi chọn thoát.
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
            sc.nextLine(); // Bỏ dòng trống còn lại sau khi nhập số.

            switch (chon) {
                case 1: {
                    // Bài 1: Nhập n sách bằng vòng lặp.
                    // Nhập lại cho đến khi n lớn hơn 0.
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

                        // Nhập lại đơn giá cho đến khi lớn hơn 0.
                        do {
                            System.out.print("Nhập đơn giá: ");
                            donGia[i] = sc.nextDouble();
                            if (donGia[i] <= 0) {
                                System.out.println("Đơn giá phải lớn hơn 0, nhập lại!");
                            }
                        } while (donGia[i] <= 0);

                        // Nhập lại số lượng cho đến khi lớn hơn hoặc bằng 0.
                        do {
                            System.out.print("Nhập số lượng: ");
                            soLuong[i] = sc.nextInt();
                            if (soLuong[i] < 0) {
                                System.out.println("Số lượng phải lớn hơn hoặc bằng 0, nhập lại!");
                            }
                        } while (soLuong[i] < 0);

                        sc.nextLine(); // Bỏ dòng trống còn lại.
                    }
                    System.out.println("Đã nhập xong " + n + " cuốn sách.");
                    break;
                }

                case 2: {
                    // Hiển thị danh sách sách.
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
                    // Bài 2: Tính tổng số lượng và tổng giá trị sách.
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
                    // Bài 4: Tìm sách theo mã.
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
    }


    // Tuần 6 - Bài 1.
    static void tuan6Bai1(Scanner sc) {
        int[] soLuong = new int[5];
 
        // Nhập số lượng của 5 cuốn sách.
        for (int i = 0; i < soLuong.length; i++) {
            do {
                System.out.print("Nhập số lượng cuốn sách thứ " + (i + 1) + ": ");
                soLuong[i] = sc.nextInt();
                if (soLuong[i] < 0) {
                    System.out.println("Số lượng phải lớn hơn hoặc bằng 0, nhập lại!");
                }
            } while (soLuong[i] < 0);
        }
        sc.nextLine();
 
        // Hiển thị số lượng.
        System.out.println("--- Số lượng các cuốn sách ---");
        for (int i = 0; i < soLuong.length; i++) {
            System.out.println("Sách thứ " + (i + 1) + ": " + soLuong[i]);
        }
 
        // Tính tổng số lượng.
        int tong = 0;
        for (int i = 0; i < soLuong.length; i++) {
            tong = tong + soLuong[i];
        }
        System.out.println("Tổng số lượng: " + tong);
 
        // Tìm số lượng lớn nhất.
        int max = soLuong[0];
        int viTriMax = 0;
        for (int i = 1; i < soLuong.length; i++) {
            if (soLuong[i] > max) {
                max = soLuong[i];
                viTriMax = i;
            }
        }
        System.out.println("Số lượng lớn nhất: " + max + " (sách thứ " + (viTriMax + 1) + ")");
    }
 
    // Tuần 6 - Bài 2.
    static void tuan6Bai2(Scanner sc) {
        ArrayList<String> dsMaSach = new ArrayList<String>();
        int chon;
 
        do {
            System.out.println();
            System.out.println("--- MENU MÃ SÁCH ---");
            System.out.println("1. Thêm mã sách");
            System.out.println("2. Hiển thị mã sách");
            System.out.println("3. Tìm mã sách");
            System.out.println("4. Xóa mã sách");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            chon = sc.nextInt();
            sc.nextLine();
 
            switch (chon) {
                case 1: {
                    System.out.print("Nhập mã sách cần thêm: ");
                    String ma = sc.nextLine();
                    if (dsMaSach.contains(ma)) {
                        System.out.println("Mã sách đã tồn tại, không thêm!");
                    } else {
                        dsMaSach.add(ma);
                        System.out.println("Đã thêm mã sách " + ma);
                    }
                    break;
                }
                case 2: {
                    if (dsMaSach.size() == 0) {
                        System.out.println("Danh sách mã sách đang trống.");
                    } else {
                        System.out.println("Có " + dsMaSach.size() + " mã sách:");
                        for (int i = 0; i < dsMaSach.size(); i++) {
                            System.out.println((i + 1) + ". " + dsMaSach.get(i));
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.print("Nhập mã sách cần tìm: ");
                    String ma = sc.nextLine();
                    if (dsMaSach.contains(ma)) {
                        System.out.println("Tìm thấy mã " + ma + " ở vị trí " + (dsMaSach.indexOf(ma) + 1));
                    } else {
                        System.out.println("Không tìm thấy mã " + ma);
                    }
                    break;
                }
                case 4: {
                    System.out.print("Nhập mã sách cần xóa: ");
                    String ma = sc.nextLine();
                    if (dsMaSach.remove(ma)) {
                        System.out.println("Đã xóa mã sách " + ma);
                    } else {
                        System.out.println("Không có mã " + ma + " để xóa");
                    }
                    break;
                }
                case 0:
                    System.out.println("Thoát phần mã sách.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        } while (chon != 0);
    }
 
    // Tuần 6 - Bài 3 và Bài 4.
    static void tuan6Bai3Va4(Scanner sc) {
        ArrayList<String> danhSachSach = new ArrayList<String>();
        int chon;
 
        do {
            System.out.println();
            System.out.println("========== QUẢN LÝ SÁCH (ArrayList) ==========");
            System.out.println("1. Thêm sách");
            System.out.println("2. Hiển thị sách");
            System.out.println("3. Tìm sách");
            System.out.println("4. Xóa sách");
            System.out.println("5. Sửa sách");
            System.out.println("6. Tính tổng số lượng");
            System.out.println("7. Tính tổng giá trị");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng: ");
            chon = sc.nextInt();
            sc.nextLine();
 
            switch (chon) {
                case 1: {
                    // Thêm sách.
                    System.out.print("Nhập mã sách: ");
                    String ma = sc.nextLine();
                    if (timViTri(danhSachSach, ma) != -1) {
                        System.out.println("Mã sách đã tồn tại, không thêm!");
                    } else {
                        String sach = nhapSach(sc, ma);
                        danhSachSach.add(sach);
                        System.out.println("Đã thêm sách có mã " + ma);
                    }
                    break;
                }
 
                case 2: {
                    // Hiển thị sách.
                    if (danhSachSach.size() == 0) {
                        System.out.println("Danh sách sách đang trống.");
                    } else {
                        System.out.println("=== DANH SÁCH SÁCH ===");
                        System.out.printf("%-4s %-8s %-25s %-18s %-6s %12s %8s%n",
                                "STT", "Mã", "Tên sách", "Tác giả", "Năm", "Đơn giá", "SL");
                        for (int i = 0; i < danhSachSach.size(); i++) {
                            String[] t = danhSachSach.get(i).split(";");
                            System.out.printf("%-4d %-8s %-25s %-18s %-6d %,12.0f %8d%n",
                                    i + 1, t[0], t[1], t[2],
                                    Integer.parseInt(t[3]), Double.parseDouble(t[4]), Integer.parseInt(t[5]));
                        }
                    }
                    break;
                }
 
                case 3: {
                    // Tìm sách theo mã.
                    System.out.print("Nhập mã sách cần tìm: ");
                    String ma = sc.nextLine();
                    int vt = timViTri(danhSachSach, ma);
                    if (vt == -1) {
                        System.out.println("Không tìm thấy sách có mã " + ma);
                    } else {
                        String[] t = danhSachSach.get(vt).split(";");
                        System.out.println("Tìm thấy sách:");
                        System.out.println("Mã sách      : " + t[0]);
                        System.out.println("Tên sách     : " + t[1]);
                        System.out.println("Tác giả      : " + t[2]);
                        System.out.println("Năm xuất bản : " + t[3]);
                        System.out.printf("Đơn giá      : %,.0f VND%n", Double.parseDouble(t[4]));
                        System.out.println("Số lượng     : " + t[5]);
                    }
                    break;
                }
 
                case 4: {
                    // Xóa sách theo mã.
                    System.out.print("Nhập mã sách cần xóa: ");
                    String ma = sc.nextLine();
                    int vt = timViTri(danhSachSach, ma);
                    if (vt == -1) {
                        System.out.println("Không tìm thấy sách có mã " + ma);
                    } else {
                        danhSachSach.remove(vt);
                        System.out.println("Đã xóa sách có mã " + ma);
                    }
                    break;
                }
 
                case 5: {
                    // Giữ nguyên mã và nhập lại thông tin còn lại của sách.
                    System.out.print("Nhập mã sách cần sửa: ");
                    String ma = sc.nextLine();
                    int vt = timViTri(danhSachSach, ma);
                    if (vt == -1) {
                        System.out.println("Không tìm thấy sách có mã " + ma);
                    } else {
                        System.out.println("Nhập thông tin mới cho sách có mã " + ma);
                        String sachMoi = nhapSach(sc, ma);
                        danhSachSach.set(vt, sachMoi);
                        System.out.println("Đã sửa sách có mã " + ma);
                    }
                    break;
                }
 
                case 6: {
                    // Tính tổng số lượng sách.
                    int tongSoLuong = 0;
                    for (int i = 0; i < danhSachSach.size(); i++) {
                        String[] t = danhSachSach.get(i).split(";");
                        tongSoLuong = tongSoLuong + Integer.parseInt(t[5]);
                    }
                    System.out.println("Tổng số lượng sách: " + tongSoLuong);
                    break;
                }
 
                case 7: {
                    // Tính tổng giá trị bằng đơn giá nhân số lượng.
                    double tongGiaTri = 0;
                    for (int i = 0; i < danhSachSach.size(); i++) {
                        String[] t = danhSachSach.get(i).split(";");
                        tongGiaTri = tongGiaTri + Double.parseDouble(t[4]) * Integer.parseInt(t[5]);
                    }
                    System.out.printf("Tổng giá trị sách: %,.0f VND%n", tongGiaTri);
                    break;
                }
 
                case 8:
                    System.out.println("Thoát chương trình. Tạm biệt!");
                    break;
 
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        } while (chon != 8);
    }
 
    // Tìm sách theo mã và trả về vị trí, hoặc -1 nếu không tìm thấy.
    static int timViTri(ArrayList<String> danhSachSach, String ma) {
        for (int i = 0; i < danhSachSach.size(); i++) {
            String[] t = danhSachSach.get(i).split(";");
            if (t[0].equalsIgnoreCase(ma)) {
                return i;
            }
        }
        return -1;
    }
 
    // Nhập thông tin sách rồi ghép thành chuỗi với mã đã có.
    static String nhapSach(Scanner sc, String ma) {
        System.out.print("Nhập tên sách: ");
        String ten = sc.nextLine();
 
        System.out.print("Nhập tác giả: ");
        String tacGia = sc.nextLine();
 
        System.out.print("Nhập năm xuất bản: ");
        int nam = sc.nextInt();
 
        double gia;
        do {
            System.out.print("Nhập đơn giá: ");
            gia = sc.nextDouble();
            if (gia <= 0) {
                System.out.println("Đơn giá phải lớn hơn 0, nhập lại!");
            }
        } while (gia <= 0);
 
        int sl;
        do {
            System.out.print("Nhập số lượng: ");
            sl = sc.nextInt();
            if (sl < 0) {
                System.out.println("Số lượng phải lớn hơn hoặc bằng 0, nhập lại!");
            }
        } while (sl < 0);
        sc.nextLine(); // Bỏ dòng trống còn lại.
 
        return ma + ";" + ten + ";" + tacGia + ";" + nam + ";" + gia + ";" + sl;
    }
}
 
        