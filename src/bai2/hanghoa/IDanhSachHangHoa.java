package bai2.hanghoa;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IDanhSachHangHoa {
    //khởi tao danh sách hàng hóa
//    DanhSachHangHoa khoiTao();

    // Thêm hàng hóa vào danh sách
    boolean themHangHoa(HangHoa hangHoa);

    // Lấy toàn bộ danh sách hàng hóa
    List<HangHoa> layDanhSachHangHoa();

    // Lấy danh sách hàng hóa theo loại
    List<HangHoa> layTheoLoaiHang(String tenLoaiHang);

    // Tìm kiếm hàng hóa theo mã
    HangHoa timHangHoaTheoMa(String maHang);

    // Sắp xếp danh sách hàng hóa theo tên
    List<HangHoa> sapXepTheoTen();

    // Sắp xếp danh sách hàng hóa theo số lượng tồn
    List<HangHoa> sapXepTheoSoLuongTon();

    // Lấy danh sách hàng thực phẩm khó bán
    Set<HangHoa> layHangThucPhamKhoBan();

    // Đếm số lượng hàng thực phẩm khó bán
    Map<String, Integer> demHangThucPhamKhoBanTheoLoai();

    // Xóa hàng hóa theo mã
    boolean xoaHangHoa(String maHang);

    // Cập nhật đơn giá của hàng hóa theo mã
    boolean capNhatDonGia(String maHang, double donGia);

    // Tính VAT cho toàn bộ hàng hóa trong danh sách
    Map<String, Double> tinhVAT();

    // Lấy danh sách hàng điện máy bán được
    List<HangHoa> layHangDienMayBanDuoc();

    // Lấy danh sách hàng sành sứ bán chậm
    List<HangHoa> layHangSanhSuBanCham();

    // Lọc hàng hóa tồn kho theo số lượng tối thiểu
    List<HangHoa> locHangHoaTonKho(int soLuongToiThieu);


}
