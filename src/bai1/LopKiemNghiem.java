package bai1;

import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LopKiemNghiem {
    public static void main(String[] args) {
        QuanLiSanPham dssp = new QuanLiSanPham();

        SanPham tp1 = new SanPhamThucPham("TP001", "Gạo Jasmine", 15000, 100, LocalDate.of(2023, 10, 1), LocalDate.of(2024, 12, 1));
        SanPham tp2 = new SanPhamThucPham("TP002", "Sữa Vinamilk", 30000, 50, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 3, 1));
        SanPham tp3 = new SanPhamThucPham("TP003", "Thịt bò đông lạnh", 2500000, 10, LocalDate.of(2023, 11, 1), LocalDate.of(2024, 11, 25));

        SanPham dt1 = new SanPhamDienTu("DT001", "Tivi Samsung 55 inch", 12000000, 20, 250);
        SanPham dt2 = new SanPhamDienTu("DT002", "Máy giặt LG 8kg", 10000000, 15, 500);
        SanPham dt3 = new SanPhamDienTu("DT003", "Điện thoại iPhone 14 Pro", 28000000, 5, 20);

        dssp.themSanPham(tp1);
        dssp.themSanPham(tp2);
        dssp.themSanPham(tp3);
        dssp.themSanPham(dt1);
        dssp.themSanPham(dt2);
        dssp.themSanPham(dt3);

        System.out.println("\nDanh sách các sản phẩm: ");
        dssp.getDs().forEach(h1-> System.out.println(h1));

        Map<String, Double> temp = dssp.thongKeGiaTriTonKhoTrungBinh();
        System.out.println("\nGiá trị tồn kho trung bình của thực phẩm là: " + temp.get("Giá trị tồn kho trung bình của thực phẩm"));
        System.out.println("Giá trị tồn kho trung bình của điện tử là: " + temp.get("Giá trị tồn kho trung bình của điện tử"));

        System.out.println("\nDanh sách các thực phẩm hết hạn: ");
        dssp.getDSThucPhamHetHan().forEach(h1-> System.out.println(h1));

        System.out.println("\nSản phẩm điện tử có công xuất lớn nhất là: ");
        dssp.getDSSanPhamCongSuatLonNhat().forEach(h1-> System.out.println(h1));

        System.out.println("\nCập nhật đơn giá mới cho sản phẩm có mã TP002: ");
        boolean kq = dssp.capNhapGiaSanPham("TP002", 50000);
        System.out.println(kq);

        System.out.println("\nDanh sách sản phẩm sau khi cập nhật: ");
        dssp.getDs().forEach(h1-> System.out.println(h1));

        System.out.println("\nSố lượng sản phẩm theo từng loại: ");
        Map<String, Integer> kq1 = dssp.demSanPhamTheoTungLoai();
        System.out.println("Số lượng sản phẩm thực phẩm là: " + kq1.get("Số lượng sản phẩm thực phẩm"));
        System.out.println("Số lượng sản phẩm điện tử là: " + kq1.get("Số lượng sản phẩm điện tử"));

        System.out.println("\nSố lượng sản phẩm theo từng loại: ");
        dssp.demSanPhamTheoTungLoai2().forEach(h1-> System.out.println(h1));

        System.out.println("\nSản phẩm có giá trị tồn kho cao nhất theo từng loại: ");
        dssp.timkiemSanPhamGiaTriTonKhoCaoNhat().forEach(h1-> System.out.println(h1));

        System.out.println("Xóa sản phẩm có mã DT002: ");
        System.out.println(dssp.xoaSanPham("DT002"));

        System.out.println("\nDanh sách sau khi xóa: ");
        dssp.getDs().forEach(h1-> System.out.println(h1));


    }

}
