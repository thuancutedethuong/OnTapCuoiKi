package bai1;

public class SanPhamDienTu extends SanPham{
    private int congSuat;

    public SanPhamDienTu(){
        this("", "", 0.0, 0, 0);
    }

    public SanPhamDienTu(String maSanPham, String tenSanPham, double donGia, int soLuongTonKho, int congSuat) {
        super(maSanPham, tenSanPham, donGia, soLuongTonKho);
        this.setCongSuat(congSuat);
    }

    public int getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(int congSuat) {
        if(congSuat < 0)
            throw new RuntimeException("Công suất >= 0");
        this.congSuat = congSuat;
    }

    @Override
    public double getGiaTriTonKho() {
        return donGia * soLuongTonKho;
    }

    @Override
    public String toString() {
        return super.toString() + congSuat;
    }
}

