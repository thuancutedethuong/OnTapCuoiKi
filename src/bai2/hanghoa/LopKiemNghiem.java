package bai2.hanghoa;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class LopKiemNghiem {
    public static void main(String[] args) {
        DanhSachHangHoa dshh = new DanhSachHangHoa();

        HangHoa hh1 = new HangDienMay("DM001", "Máy giặt", 10000000, 5, 12, 20);
        HangHoa hh2 = new HangDienMay("DM002", "Máy lạnh", 15000000, 3, 12, 30);
        HangHoa hh3 = new HangDienMay("DM003", "Máy quạt", 350000, 6, 6, 15);

        HangHoa hh4 = new HangSanhSu("SS001", "Bình thủy tinh", 500000, 4, "Điện máy xanh", LocalDate.of(2023, 11, 1));
        HangHoa hh5 = new HangSanhSu("SS002", "Bình thủy tinh", 250000, 3, "Thế giới di dộng", LocalDate.of(2024, 11, 15));
        HangHoa hh6 = new HangSanhSu("SS003", "Kính thủy tinh", 1000000, 2, "Điện máy xanh", LocalDate.of(2024, 10, 6));

        HangHoa hh7 = new HangThucPham("TP001", "Thịt ba rọi", 50000, 10, "Bách hóa xanh", LocalDate.of(2024, 11, 1), LocalDate.of(2024, 11, 24));
        HangHoa hh8 = new HangThucPham("TP002", "Uức gà có da", 60000, 8, "Bách hóa xanh", LocalDate.of(2024, 10, 25), LocalDate.of(2024, 11, 26));
        HangHoa hh9 = new HangThucPham("TP003", "Cá ba sa", 80000, 9, "Bách hóa xanh", LocalDate.of(2024, 11, 23), LocalDate.of(2024, 11, 28));


        dshh.themHangHoa(hh1);
        dshh.themHangHoa(hh2);
        dshh.themHangHoa(hh3);
        dshh.themHangHoa(hh4);
        dshh.themHangHoa(hh5);
        dshh.themHangHoa(hh6);
        dshh.themHangHoa(hh7);
        dshh.themHangHoa(hh8);
        dshh.themHangHoa(hh9);

        System.out.println("Danh sách các hàng hóa: ");
        dshh.layDanhSachHangHoa().forEach(h1-> System.out.println(h1));

        System.out.println("\nDanh sách các hàng hóa loại thực phẩm: ");
        dshh.layTheoLoaiHang("thuc pham").forEach(h1-> System.out.println(h1));

        System.out.println("\nHang hoa co ma TP001: ");
        System.out.println(dshh.timHangHoaTheoMa("TP001"));

        System.out.println("\nDanh sach duoc sap xep theo ten: ");
        dshh.sapXepTheoTen().forEach(h1-> System.out.println(h1));

        System.out.println("\nDanh sach duoc sap xep theo so luong ton: ");
        dshh.sapXepTheoSoLuongTon().forEach(h1-> System.out.println(h1));

        System.out.println("\nCac mat hang kho ban: ");
        dshh.layHangThucPhamKhoBan().forEach(h1-> System.out.println(h1));

        System.out.println("\nSo luong cac hang hoa theo loại: ");
        Map<String, Integer> temp = dshh.demHangThucPhamKhoBanTheoLoai();
        System.out.println("Hang thuc pham: " + temp.get("So san pham thuc pham"));
        System.out.println("Hang dien may: " + temp.get("So san pham dien may"));
        System.out.println("Hang sanh su: " + temp.get("So san pham sanh su"));

        System.out.println("\nXoa hang hoa co ma DM002");
        System.out.println(dshh.xoaHangHoa("DM002"));

        System.out.println("\nDanh sach sau khi xoa: ");
        dshh.layDanhSachHangHoa().forEach(h1-> System.out.println(h1));

        System.out.println("\nCap nhat DON GIA cua hang hoa có ma SS002: ");
        dshh.capNhatDonGia("SS002", 260000);

        System.out.println("\nDanh sach sau khi cap nhat: ");
        dshh.layDanhSachHangHoa().forEach(h1-> System.out.println(h1));

        System.out.println("\nTinh VAT cua tung loai hang hoa: ");
        Map<String,Double>  kq = dshh.tinhVAT();
        System.out.println("Tong VAT cua hang thuc pham: " + kq.get("Tong vat hang thuc pham"));
        System.out.println("Tong VAT cua hang dien may: " + kq.get("Tong vat hang dien may"));
        System.out.println("Tong VAT cua hang sanh su: " + kq.get("Tong vat hang sanh su"));

        System.out.println("\nCac hang dien may ban duoc: ");
        dshh.layHangDienMayBanDuoc().forEach(h1-> System.out.println(h1));

        System.out.println("\nCac hang sanh su ban cham: ");
        dshh.layHangSanhSuBanCham().forEach(h1-> System.out.println(h1));

        System.out.println("\nCac mat hang co so luong ton toi thieu la 2: ");
        dshh.locHangHoaTonKho(50).forEach(h1-> System.out.println(h1));

        System.out.println("\nSap xep theo 2 tieu chi: ");
        dshh.sx2tieuchi().forEach(h1-> System.out.println(h1));

    }


}
