package bai2.hanghoa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangSanhSu extends HangHoa{
    private String nhaSanXuat;
    private LocalDate ngayNhapKho;

    public HangSanhSu(){

    }

    public HangSanhSu(String maHang, String tenHang, double donGia, int soLuong, String nhaSanXuat, LocalDate ngayNhapKho) {
        super(maHang, tenHang, donGia, soLuong);
        this.nhaSanXuat = nhaSanXuat;
        this.ngayNhapKho = ngayNhapKho;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        if(nhaSanXuat==null || nhaSanXuat.trim().length()==0)
            throw new RuntimeException("Nhà sản xuất not null");
        this.nhaSanXuat = nhaSanXuat;
    }

    public LocalDate getNgayNhapKho() {
        return ngayNhapKho;
    }

    public void setNgayNhapKho(LocalDate ngayNhapKho) {
        if(ngayNhapKho.compareTo(LocalDate.now()) > 0)
            throw new RuntimeException("Ngày nhập kho trước ngày hiện tại");
        this.ngayNhapKho = ngayNhapKho;
    }

    @Override
    public String danhGiaMucBanBuong() {
        if(soLuong > 50 && LocalDate.now().compareTo(ngayNhapKho) > 10)
            return "bán chậm";
        return "bán được";
    }

    @Override
    public double getTienThue() {
        return donGia*soLuong*0.1;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return super.toString() +String.format(" %-15s", nhaSanXuat) + " | " + dtf.format(ngayNhapKho);
    }
}
