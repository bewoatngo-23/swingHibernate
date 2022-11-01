create table ChucVu(
	MaCV int identity primary key,
	TenCV nvarchar(50)
)


create table NhanVien(
	MaNV int identity primary key,
	TenNV nvarchar(30),
	Tuoi int,
	GioiTinh bit,
	MaCV int,
	CONSTRAINT FK_NhanVien_ChucVu foreign key(MaCV) references ChucVu(MaCV)
)

insert into ChucVu(TenCV) values(N'Nhân viên'),
(N'Trưởng phòng'),
(N'Giám đốc'),
(N'Chủ tịch')


insert into NhanVien(TenNV,Tuoi,GioiTinh,MaCV) values(N'Dụng',19,1,4),
(N'Ngọc',19,0,3),
(N'Dương',19,0,2),
(N'Sơn',19,1,1),
(N'Tuấn',19,1,1)


select * from NhanVien join ChucVu on ChucVu.MaCV = NhanVien.MaCV

select * from ChucVu