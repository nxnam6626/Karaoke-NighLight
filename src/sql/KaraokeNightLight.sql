create database KaraokeNightLight

go 
use KaraokeNightLight
go

---- Table NhanVien-----

create table NHANVIEN
(
	maNV nvarchar(12) NOT NULL PRIMARY KEY,
	hoTenNV NVARCHAR(30) NOT NULL,
	soDienThoai NVARCHAR(10) NOT NULL,
	ngaySinh DateTime NOT NULL,
	CCCD NVARCHAR(12) NOT NULL,
	diaChi NVARCHAR(50) NOT NULL,
	email NVARCHAR(50) NOT NULL,
	trangThai int check(trangThai between 1 and 3),
	caLam int check(caLam between 1 and 3),
	ngayVaoLam DateTime NOT NULL
)

---------KHÁCH HÀNG------------

create table KHACHHANG 
(
	maKH NVARCHAR(10) NOT NULL PRIMARY KEY,
	tenKH NVARCHAR(30) NOT NULL,
	gioiTinh int check (gioiTinh between 0 and 1),
	soDienThoai NVARCHAR(10) NOT NULL,
	loaiKhachHang int check (loaiKhachHang between 1 and 3),
	ngaySinh DateTime NOT NULL
)

---------TÀI KHOẢN------------
DROP TABLE IF EXISTS TAIKHOAN
create table TAIKHOAN
(
    maTaiKhoan int not null IDENTITY primary key,
    tenDangNhap nvarchar(255) not NULL,
    matKhau nvarchar(20) not NULL,
	loaiTK nvarchar(20) check (loaiTK in ('TT', 'QL')) not null,
)
---------PHÒNG------------
DROP TABLE IF EXISTS PHONG
create table PHONG
(
    maPhong nvarchar(12) not null primary key,
    nhomPhong int check(nhomPhong between 0 and 3),
	--1 nhỏ , 2 trung, 3 lớn
    --loaiPhong nvarchar(10) check (loaiPhong in ('VIP', 'Thuong')) not null,
	loaiPhong int check(loaiPhong between 1 and 2),
    giaPhong money not null,
    trangThaiPhong int check(trangThaiPhong between 1 and 3) not null
	--1 phong trong, 2 phong dang su dung, 3 phong da dat
)
 insert into PHONG
 values 
('SS001', 1, 1,320000,1),
('SS002', 1, 1,320000,1),
('SS003', 1, 1,320000,1),
('SS004', 1, 1,320000,1),
('SS005', 1, 1,320000,1),
('SS006', 1, 1,320000,1),
('SS007', 1, 1,320000,1),
('SS008', 1, 1,320000,1),
('SS009', 1, 1,320000,1),
('SS010', 1, 1,320000,1),

('SM001', 2, 1,390000,1),
('SM002', 2, 1,390000,1),
('SM003', 2, 1,390000,1),
('SM004', 2,1,390000,1),
('SM005', 2, 1,390000,1),
('SM006', 2, 1,390000,1),
('SM007', 2, 1,390000,1),
('SM008', 2, 1,390000,1),
('SM009', 2, 1,390000,1),
('SM010', 2, 1,390000,1),

('SL001', 3, 1,590000,1),
('SL002', 3, 1,590000,1),
('SL003', 3, 1,590000,1),
('SL004', 3, 1,590000,1),
('SL005', 3, 1,590000,1),
('SL006', 3, 1,590000,1),
('SL007', 3, 1,590000,1),
('SL008', 3, 1,590000,1),
('SL009', 3, 1,590000,1),
('SL010', 3, 1,590000,1),

('V001', 0 ,2 ,799000,1),
('V002', 0 ,2 ,799000,1),
('V003', 0 ,2 ,799000,1),
('V004', 0 ,2,799000,1),
('V005', 0 ,2 ,799000,1),
('V006', 0 ,2 ,799000,1),
('V007', 0 ,2 ,799000,1),
('V008', 0 , 2,799000,1),
('V009', 0 ,2 ,799000,1),
('V010', 0 , 2,799000,1)


---------PHIẾU ĐẶT PHÒNG------------
create table PHIEUDATPHONG
(
    maPDP NVARCHAR(12) NOT NULL PRIMARY KEY,
    thoiGianDat DateTime NOT NULL,
    thoiGianNhan DateTime NOT NULL,
    maNV nvarchar(12) NOT NULL,
    maKH NVARCHAR(10) NOT NULL,
    maPhong nvarchar(12) not null
)

-------- HÓA ĐƠN -------------
create table HOADON
(
	maHD nvarchar(20) not null primary key,
	ngayLapHD datetime not null,
	maKH NVARCHAR(10) not null,
	maNV nvarchar(12) not null,
	chietKhau int not null,
	thue int not null,
	tongTienDV money not null,
	tongTienPhong money not null,
	tongTienHD money not null,
	tongTienThua money not null
)

---------CHI TIẾT HÓA ĐƠN PHÒNG------------

create table CHITIETHOADONPHONG
(

     maHD nvarchar(20) not null,
	 maPhong nvarchar(12) not null,
	 maPDP NVARCHAR(12) NOT NULL,
	 thoiGianTraPhong datetime not null,
     thoiGianSuDung int not null,
	 tienPhong money not null
)


---------DỊCH VỤ------------

create table DICHVU
(
    maDichVu nvarchar(15) not null primary key,
	tenDichVu nvarchar(40) not null,
	soLuong int not null,
	hinhAnh nvarchar not null,
	giaBan money not null
)

---------CHI TIẾT HÓA ĐƠN DỊCH VỤ------------

create table CHITIETHOADONDICHVU
(
	 maHD nvarchar(20) not null,
	 maDichVu nvarchar(15) not null,
	 soLuong int not null,
	 giaBan money not null,
	 tienDichVu money not null
)

