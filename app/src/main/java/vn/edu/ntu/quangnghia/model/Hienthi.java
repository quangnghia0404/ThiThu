package vn.edu.ntu.quangnghia.model;

public class Hienthi {
    int id;
    String name;
    String ngaydi;
    String ngayden;
    String loai;
    String thoidiem;

    public Hienthi() {
    }

    public Hienthi(int id, String name, String ngaydi, String ngayden, String loai, String thoidiem) {
        this.id = id;
        this.name = name;
        this.ngaydi = ngaydi;
        this.ngayden = ngayden;
        this.loai = loai;
        this.thoidiem = thoidiem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNgaydi() {
        return ngaydi;
    }

    public void setNgaydi(String ngaydi) {
        this.ngaydi = ngaydi;
    }

    public String getNgayden() {
        return ngayden;
    }

    public void setNgayden(String ngayden) {
        this.ngayden = ngayden;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getThoidiem() {
        return thoidiem;
    }

    public void setThoidiem(String thoidiem) {
        this.thoidiem = thoidiem;
    }
}
