package bai1;

import java.text.DecimalFormat;

public abstract class SanPham {
    protected final String maSanPham;
    protected String tenSanPham;
    protected double donGia;
    protected int soLuongTonKho;

    public SanPham(){
        this("", "", 0.0, 0);
    }

    public SanPham(String maSanPham, String tenSanPham, double donGia, int soLuongTonKho) {
        this.maSanPham = maSanPham;
        this.setTenSanPham(tenSanPham);
        this.setDonGia(donGia);
        this.setSoLuongTonKho(soLuongTonKho);
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        if(tenSanPham == null || tenSanPham.trim().length()==0)
            throw new RuntimeException("Tên sản phẩm not null");
        this.tenSanPham = tenSanPham;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        if(donGia < 0.0)
            throw new RuntimeException("Đơn giá >= 0.0");
        this.donGia = donGia;
    }

    public int getSoLuongTonKho() {
        return soLuongTonKho;
    }

    public void setSoLuongTonKho(int soLuongTonKho) {
        if(soLuongTonKho < 0)
            throw new RuntimeException("Số lượng tồn kho >= 0");
        this.soLuongTonKho = soLuongTonKho;
    }

    public abstract double getGiaTriTonKho();

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0 VNĐ");
        return String.format("| %s | %-20s | %-10s | %-5d |", maSanPham, tenSanPham, df.format(donGia), soLuongTonKho);
    }
}
