package bai2.hanghoa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangThucPham extends HangHoa{
    private String nhaCungCap;
    private LocalDate ngaySanXuat;
    private LocalDate ngayHetHan;

    public HangThucPham(){
        this("", "xxx", 0.0, 0,"", LocalDate.now(), LocalDate.now());
    }

    public HangThucPham(String maHang, String tenHang, double donGia, int soLuong, String nhaCungCap, LocalDate ngaySanXuat, LocalDate ngayHetHan) {
        super(maHang, tenHang, donGia, soLuong);
        this.setNgaySanXuat(ngaySanXuat);
        this.setNgayHetHan(ngayHetHan);
        this.setNhaCungCap(nhaCungCap);
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        if(nhaCungCap == null || nhaCungCap.trim().length()==0)
            throw new RuntimeException("Nhà cung cấp not null");
        this.nhaCungCap = nhaCungCap;
    }

    public LocalDate getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(LocalDate ngaySanXuat) {
        if(ngaySanXuat.compareTo(LocalDate.now()) > 0)
            throw new RuntimeException("Ngày sản xuất phải trước ngày hiện tại");
        this.ngaySanXuat = ngaySanXuat;
    }

    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(LocalDate ngayHetHan) {
        if(ngayHetHan.compareTo(ngaySanXuat) < 0)
            throw new RuntimeException("Ngày hết hạn phải sau ngày sản xuất");
        this.ngayHetHan = ngayHetHan;
    }

    @Override
    public String danhGiaMucBanBuong() {
        if(soLuong > 0 && ngayHetHan.isBefore(LocalDate.now()))
            return "khó bán";
        return "dễ bán";
    }

    @Override
    public double getTienThue() {
        return donGia*soLuong*5/100;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return super.toString() + " | " + nhaCungCap + " | " + dtf.format(ngaySanXuat) + " | " + dtf.format(ngayHetHan);
    }
}
