package bai1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SanPhamThucPham extends SanPham{
    private LocalDate ngaySanXuat;
    private LocalDate hanSuDung;

    public SanPhamThucPham(){
        this("", "", 0.0, 0, LocalDate.now(), LocalDate.now());
    }

    public SanPhamThucPham(String maSanPham, String tenSanPham, double donGia, int soLuongTonKho, LocalDate ngaySanXuat, LocalDate hanSuDung) {
        super(maSanPham, tenSanPham, donGia, soLuongTonKho);
        this.setNgaySanXuat(ngaySanXuat);
        this.setHanSuDung(hanSuDung);
    }

    public LocalDate getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(LocalDate ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public LocalDate getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(LocalDate hanSuDung) {
        this.hanSuDung = hanSuDung;
    }

    @Override
    public double getGiaTriTonKho() {
        return donGia * soLuongTonKho;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return super.toString() + dtf.format(ngaySanXuat) + " | "+ dtf.format(hanSuDung);
    }
}
