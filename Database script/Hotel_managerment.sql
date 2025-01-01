/*==============================================================*/
/* DBMS name:      ORACLE Version 22c                           */
/* Created on:     4/6/2023 9:24:57 AM                          */
/*==============================================================*/


alter table CHITIETDATPHONG
   drop constraint FK_CHITIETD_CHITIETDA_PHONG;

alter table CHITIETDATPHONG
   drop constraint FK_CHITIETD_CHITIETDA_PHIEUDAT;

alter table HOADONDV
   drop constraint FK_HOADONDV_DATDVTUPH_PHONG;

alter table HOADONDV
   drop constraint FK_HOADONDV_GOMDV_DANHMUCD;

alter table HOADONDV
   drop constraint FK_HOADONDV_SUDUNGDV_PHIEUDAT;

alter table HOADONDV
   drop constraint FK_HOADONDV_THUCHIEN_NHANVIEN;

alter table PHIEUDATPHONG
   drop constraint FK_PHIEUDAT_DATPHONG_KHACHHAN;

alter table PHIEUDATPHONG
   drop constraint FK_PHIEUDAT_XACMINH_NHANVIEN;

alter table PHONG
   drop constraint FK_PHONG_THUOC_LOAIPHON;

alter table TAIKHOAN
   drop constraint FK_TAIKHOAN_CO_NHANVIEN;

alter table THANHTOAN
   drop constraint FK_THANHTOA_THUNGAN_NHANVIEN;

alter table THANHTOAN
   drop constraint FK_THANHTOA_TIENHANH_PHIEUDAT;

drop index CHITIETDATPHONG2_FK;

drop index CHITIETDATPHONG_FK;

drop table CHITIETDATPHONG cascade constraints;

drop table DANHMUCDICHVU cascade constraints;

drop table DANHMUCMONAN cascade constraints;

drop index DATDVTUPHONG_FK;

drop index SUDUNGDV_FK;

drop index THUCHIEN_FK;

drop index GOMDV_FK;

drop table HOADONDV cascade constraints;

drop table KHACHHANG cascade constraints;

drop table LOAIPHONG cascade constraints;

drop table NHANVIEN cascade constraints;

drop index XACMINH_FK;

drop index DATPHONG_FK;

drop table PHIEUDATPHONG cascade constraints;

drop index THUOC_FK;

drop table PHONG cascade constraints;

drop index CO_FK;

drop table TAIKHOAN cascade constraints;

drop index THUNGAN_FK;

drop index TIENHANH_FK;

drop table THANHTOAN cascade constraints;


drop sequence MAKH_SEQ;
drop sequence MADATPHONG_SEQ;
drop sequence MAMONAN_SEQ;
drop sequence MAHDDV_SEQ;
drop sequence MADV_SEQ;
drop sequence MANV_SEQ;
drop sequence MATHANHTOAN_SEQ;




/*==============================================================*/
/* Sequence: MAKH_SEQ                        */
/*==============================================================*/
create sequence MAKH_SEQ;



/*==============================================================*/
/* Sequence: MADATPHONG_SEQ                        */
/*==============================================================*/
create sequence MADATPHONG_SEQ;



/*==============================================================*/
/* Sequence: MAMONAN_SEQ                        */
/*==============================================================*/
create sequence MAMONAN_SEQ;



/*==============================================================*/
/* Sequence: MAHDDV_SEQ                        */
/*==============================================================*/
create sequence MAHDDV_SEQ;


/*==============================================================*/
/* Sequence: MADV_SEQ                        */
/*==============================================================*/
create sequence MADV_SEQ;



/*==============================================================*/
/* Sequence: MANV_SEQ                        */
/*==============================================================*/
create sequence MANV_SEQ;



/*==============================================================*/
/* Sequence: MATHANHTOAN_SEQ                        */
/*==============================================================*/
create sequence MATHANHTOAN_SEQ;

CREATE SEQUENCE BCDOANHTHUPHONG_SEQ;

CREATE SEQUENCE BCDOANHTHUDV_SEQ;


create table THAMSO
(
    MATS                 VARCHAR2(40)              not null,
    TENTS                VARCHAR2(80)           not null,          
    GIATRI              NUMBER(19,2)            default 0,
    ACTIVE               SMALLINT        DEFAULT 1,
   constraint PK_THAMSO primary key (MATS)
);


/*==============================================================*/
/* Table: CHITIETDATPHONG                                       */
/*==============================================================*/
create table CHITIETDATPHONG 
(
   MAPHG                VARCHAR2(8)          not null,
   MADATPHONG           NUMBER(9)            not null,
   DONGIAPHONG          NUMBER(19,0),
   constraint PK_CHITIETDATPHONG primary key (MAPHG, MADATPHONG)
);

/*==============================================================*/
/* Index: CHITIETDATPHONG_FK                                    */
/*==============================================================*/
create index CHITIETDATPHONG_FK on CHITIETDATPHONG (
   MAPHG ASC
);

/*==============================================================*/
/* Index: CHITIETDATPHONG2_FK                                   */
/*==============================================================*/
create index CHITIETDATPHONG2_FK on CHITIETDATPHONG (
   MADATPHONG ASC
);

/*==============================================================*/
/* Table: DANHMUCDICHVU                                         */
/*==============================================================*/
create table DANHMUCDICHVU 
(
   MADV                 NUMBER(9)            default MADV_SEQ.NEXTVAL           not null,
   TENDV                VARCHAR2(30),
   DONGIA               NUMBER(19,0),
   DONVI                VARCHAR2(10),
   ACTIVE               SMALLINT            DEFAULT 1,
   constraint PK_DANHMUCDICHVU primary key (MADV)
);

/*==============================================================*/
/* Table: HOADONDV                                              */
/*==============================================================*/
create table HOADONDV 
(
   MAHDDV               NUMBER(9)            default MAHDDV_SEQ.NEXTVAL            not null,
   MADATPHONG           NUMBER(9)            not null,
   MADV                 NUMBER(9)            not null,
   MANV                 NUMBER(9)            not null,
   MAPHG                VARCHAR2(8),
   THANHTIEN            NUMBER(19,0)        default 0,
   TINHTRANG            SMALLINT        default 0,
   THOIGIANDAT          DATE            default trunc(sysdate),
   SOLUONG              INTEGER,
   constraint PK_HOADONDV primary key (MAHDDV)
);

/*==============================================================*/
/* Index: GOMDV_FK                                              */
/*==============================================================*/
create index GOMDV_FK on HOADONDV (
   MADV ASC
);

/*==============================================================*/
/* Index: THUCHIEN_FK                                           */
/*==============================================================*/
create index THUCHIEN_FK on HOADONDV (
   MANV ASC
);

/*==============================================================*/
/* Index: SUDUNGDV_FK                                           */
/*==============================================================*/
create index SUDUNGDV_FK on HOADONDV (
   MADATPHONG ASC
);

/*==============================================================*/
/* Index: DATDVTUPHONG_FK                                       */
/*==============================================================*/
create index DATDVTUPHONG_FK on HOADONDV (
   MAPHG ASC
);

-- Create table LOAIKHACH
CREATE TABLE LOAIKHACH (
   MALOAIKHACH         VARCHAR2(10)         NOT NULL,
   TENLOAIKHACH        VARCHAR2(50)         NOT NULL,
   TYLEPHUTHU          NUMBER(19,2)         DEFAULT 0,
   CONSTRAINT PK_LOAIKHACH PRIMARY KEY (MALOAIKHACH)
);

/*==============================================================*/
/* Table: KHACHHANG                                             */
/*==============================================================*/
create table KHACHHANG 
(
   MAKH                 NUMBER(9)           default MAKH_SEQ.NEXTVAL            not null,
   TENKH                VARCHAR2(80),
   CCCD                 VARCHAR2(13),
   SDT                  VARCHAR2(13),
   GIOITINH             VARCHAR2(5),
   MALOAIKHACH            VARCHAR2(10),
   DOANHSO              NUMBER(19,0)            default 0,
   ACTIVE               SMALLINT        DEFAULT 1,
   CONSTRAINT PK_KHACHHANG PRIMARY KEY (MAKH),
   CONSTRAINT FK_KHACHHANG_LOAIKHACH FOREIGN KEY (MALOAIKHACH)
       REFERENCES LOAIKHACH (MALOAIKHACH)
       ON DELETE CASCADE 
);



/*==============================================================*/
/* Table: LOAIPHONG                                             */
/*==============================================================*/
create table LOAIPHONG 
(
   MALOAIPHG            VARCHAR2(8)          not null,
   KIEUPHONG            VARCHAR2(10),
   KIEUGIUONG           INTEGER,
   MOTA                 VARCHAR2(100),
   DONGIA               NUMBER(19,0),
   constraint PK_LOAIPHONG primary key (MALOAIPHG)
);

/*==============================================================*/
/* Table: NHANVIEN                                              */
/*==============================================================*/
create table NHANVIEN 
(
   MANV                 NUMBER(9)           default MANV_SEQ.NEXTVAL            not null,
   TENNV                VARCHAR2(40),
   CCCD                 VARCHAR2(13),
   SDT                  VARCHAR2(13),
   NGAYSINH             DATE,
   GIOITINH             VARCHAR2(5),
   NGAYVL               DATE,
   CHUCVU               VARCHAR2(20),
   ACTIVE               SMALLINT        DEFAULT 1,
   constraint PK_NHANVIEN primary key (MANV)
);

/*==============================================================*/
/* Table: PHIEUDATPHONG                                         */
/*==============================================================*/
create table PHIEUDATPHONG 
(
   MADATPHONG           NUMBER(9)           default MADATPHONG_SEQ.NEXTVAL            not null,
   MANV                 NUMBER(9)            not null,
   MAKH                 NUMBER(9)            not null,
   NGAYDAT              DATE            default sysdate,
   NGAYNHAN             DATE,
   NGAYTRA              DATE,
   TTNHANPHONG          SMALLINT           default 0,
   TIENPHONG                 NUMBER(19,0)           default 0,
   PHUPHI               NUMBER(19,0)           default 0,
   TIENTRATRUOC         NUMBER(19,0)           default 0,
   TIENCANTRA           NUMBER(19,0)           default 0,
   TIENDV               NUMBER(19,0)           default 0,
   constraint PK_PHIEUDATPHONG primary key (MADATPHONG)
);

/*==============================================================*/
/* Index: DATPHONG_FK                                           */
/*==============================================================*/
create index DATPHONG_FK on PHIEUDATPHONG (
   MAKH ASC
);

/*==============================================================*/
/* Index: XACMINH_FK                                            */
/*==============================================================*/
create index XACMINH_FK on PHIEUDATPHONG (
   MANV ASC
);

/*==============================================================*/
/* Table: PHONG                                                 */
/*==============================================================*/
create table PHONG 
(
   MAPHG                VARCHAR2(8)          not null,
   MALOAIPHG            VARCHAR2(8)          not null,
   MOTA                 VARCHAR2(100),
   TINHTRANG            SMALLINT                default 0,
   constraint PK_PHONG primary key (MAPHG)
);

/*==============================================================*/
/* Index: THUOC_FK                                              */
/*==============================================================*/
create index THUOC_FK on PHONG (
   MALOAIPHG ASC
);

/*==============================================================*/
/* Table: TAIKHOAN                                              */
/*==============================================================*/
create table TAIKHOAN 
(
   TENTAIKHOAN          VARCHAR2(20)         not null,
   MANV                 NUMBER(9)            not null,
   MATKHAU              VARCHAR2(20)         not null,
   QUYEN                VARCHAR2(10)         not null,
   constraint PK_TAIKHOAN primary key (TENTAIKHOAN)
);

/*==============================================================*/
/* Index: CO_FK                                                 */
/*==============================================================*/
create index CO_FK on TAIKHOAN (
   MANV ASC
);

/*==============================================================*/
/* Table: THANHTOAN                                             */
/*==============================================================*/
create table THANHTOAN 
(
   MATHANHTOAN          NUMBER(9)           default MATHANHTOAN_SEQ.NEXTVAL            not null,
   MADATPHONG           NUMBER(9)            not null,
   MANV                 NUMBER(9)            not null,
   THANHTIEN            NUMBER(19,0)            default 0,
   HINHTHUCTHANHTOAN    VARCHAR2(30),
   NGAYLAP              DATE            DEFAULT Trunc(sysdate),
   TIENKHACHDUA         NUMBER(19)            default 0,
   constraint PK_THANHTOAN primary key (MATHANHTOAN)
);

/*==============================================================*/
/* Index: TIENHANH_FK                                           */
/*==============================================================*/
create index TIENHANH_FK on THANHTOAN (
   MADATPHONG ASC
);

/*==============================================================*/
/* Index: THUNGAN_FK                                            */
/*==============================================================*/
create index THUNGAN_FK on THANHTOAN (
   MANV ASC
);

alter table CHITIETDATPHONG
   add constraint FK_CHITIETD_CHITIETDA_PHONG foreign key (MAPHG)
      references PHONG (MAPHG);

alter table CHITIETDATPHONG
   add constraint FK_CHITIETD_CHITIETDA_PHIEUDAT foreign key (MADATPHONG)
      references PHIEUDATPHONG (MADATPHONG);

alter table HOADONDV
   add constraint FK_HOADONDV_DATDVTUPH_PHONG foreign key (MAPHG)
      references PHONG (MAPHG);

alter table HOADONDV
   add constraint FK_HOADONDV_GOMDV_DANHMUCD foreign key (MADV)
      references DANHMUCDICHVU (MADV);

alter table HOADONDV
   add constraint FK_HOADONDV_SUDUNGDV_PHIEUDAT foreign key (MADATPHONG)
      references PHIEUDATPHONG (MADATPHONG);

alter table HOADONDV
   add constraint FK_HOADONDV_THUCHIEN_NHANVIEN foreign key (MANV)
      references NHANVIEN (MANV);

alter table PHIEUDATPHONG
   add constraint FK_PHIEUDAT_DATPHONG_KHACHHAN foreign key (MAKH)
      references KHACHHANG (MAKH);

alter table PHIEUDATPHONG
   add constraint FK_PHIEUDAT_XACMINH_NHANVIEN foreign key (MANV)
      references NHANVIEN (MANV);

alter table PHONG
   add constraint FK_PHONG_THUOC_LOAIPHON foreign key (MALOAIPHG)
      references LOAIPHONG (MALOAIPHG);

alter table TAIKHOAN
   add constraint FK_TAIKHOAN_CO_NHANVIEN foreign key (MANV)
      references NHANVIEN (MANV);

alter table THANHTOAN
   add constraint FK_THANHTOA_THUNGAN_NHANVIEN foreign key (MANV)
      references NHANVIEN (MANV);

alter table THANHTOAN
   add constraint FK_THANHTOA_TIENHANH_PHIEUDAT foreign key (MADATPHONG)
      references PHIEUDATPHONG (MADATPHONG);





/*==============================================================*/
/* Data define constraint                                           */
/*==============================================================*/

alter table HOADONDV
    add constraint CHK_HOADONDV_VALIDATE_SOLUONG check (SOLUONG >= 0);

alter table DANHMUCDICHVU
    add constraint CHK_DANHMUCDICHVU_VALIDATE_DONGIA check (DONGIA >= 0);

alter table HOADONDV
    add constraint CHK_HOADONDV_VALIDATE_THANHTIEN CHECK (THANHTIEN >= 0);

--alter table KHACHHANG
--    add constraint CHK_KHACHHANG_GIOITINH check (GIOITINH in ('Nam', ' nam', 'Nu','nu', 'N?', 'n?','Khác','Khác' ));

alter table LOAIPHONG
    add constraint CHK_PHONG_VALIDATE_DONGIA check (DONGIA >= 0);

--alter table NHANVIEN
--    add constraint CHK_NHANVIEN_VALIDATE_GIOITINH check( GIOITINH in ('Nam', 'Nu', 'nam', 'nu', 'n?', 'N?','Khac','Khác'));
--alter table PHIEUDATPHONG
--    add constraint CHK_PHIEUDATPHONG_VALIDATE_NGAYDAT_NGAYNHAN_NGAYTRA check (NGAYDAT - NGAYNHAN < 1 AND NGAYNHAN - NGAYTRA < 1);

alter table THANHTOAN
    add constraint CHK_THANHTOAN_VALIDATE_THANHTIEN CHECK (THANHTIEN >= 0);


CREATE TABLE BCDOANHTHUPHONG (
   MaBaoCaoPhong        NUMBER(9)           default BCDOANHTHUPHONG_SEQ.NEXTVAL            not null,
   SoLanDat           NUMBER(9)              NOT NULL, -- Number of bookings
   DoanhThu           NUMBER(19)           NOT NULL, -- Total revenue
   THANG              NUMBER(2)               NOT NULL, -- Month of the report
   NAM                NUMBER(4)               NOT NULL, -- Year of the report
   TyLe               NUMBER(5, 2),           -- Percentage (optional)
   MALOAIPHG          VARCHAR2(10),           -- Room type ID
   CONSTRAINT PK_BCDOANHTHUPHONG PRIMARY KEY (MaBaoCaoPhong), -- Primary key constraint
   CONSTRAINT FK_BCDOANHTHUPHONG_LOAIPHG FOREIGN KEY (MALOAIPHG) -- Foreign key constraint
      REFERENCES LOAIPHONG (MALOAIPHG) -- Referencing LOAIPHONG table
);

CREATE TABLE BCDOANHTHUDV (
   MaBaoCaoDichVu      NUMBER(9)                 default BCDOANHTHUDV_SEQ.NEXTVAL            not null,
   SoLanDat           NUMBER(9)               NOT NULL,
   DoanhThu           NUMBER(19)           NOT NULL, 
   THANG              NUMBER(2)               NOT NULL, 
   NAM                NUMBER(4)               NOT NULL, 
   TyLe               NUMBER(5, 2), 
   MaDV               NUMBER(9), 
   CONSTRAINT PK_BCDOANHTHUDV PRIMARY KEY (MaBaoCaoDichVu),
   CONSTRAINT FK_BCDOANHTHUDV_MADV FOREIGN KEY (MaDV)
      REFERENCES DANHMUCDICHVU (MaDV) 
);

/* END OF DDL                           */


/* START OF INSERT VALUES                           */

-- INSERT INTO THAMSO (MATS, TENTS, GIATRI, ACTIVE) VALUES ('SoLoaiPhong', 'Số Loại Phòng', 2, 1);
-- INSERT INTO THAMSO (MATS, TENTS, GIATRI, ACTIVE) VALUES ('SoKhachToiDa', 'Số khách tối đa', 3, 1);
INSERT INTO THAMSO (MATS, TENTS, GIATRI, ACTIVE) VALUES ('TiLePhuThuKhach', 'Tỉ lệ phụ thu khách vượt số lượng', 0.25, 1);
INSERT INTO THAMSO (MATS, TENTS, GIATRI, ACTIVE) VALUES ('TiLePhuThuKhachNN', 'Tỉ lệ phụ thu khách nước ngoài', 0.5, 1);
INSERT INTO THAMSO (MATS, TENTS, GIATRI, ACTIVE) VALUES ('TiLeTraTruoc', 'Tỉ lệ trả trước', 0.5, 1);
INSERT INTO THAMSO (MATS, TENTS, GIATRI, ACTIVE) VALUES ('SoLoaiKhach', 'Số loại khách', 3, 1);


INSERT INTO LOAIKHACH (MALOAIKHACH, TENLOAIKHACH) VALUES ('NN', 'Khách nước ngoài');
INSERT INTO LOAIKHACH (MALOAIKHACH, TENLOAIKHACH) VALUES ('ND', 'Khách nội địa');

insert into KhachHang (TenKH, CCCD, SDT, GioiTinh, MALOAIKHACH) values ( 'Nguyễn Văn An', '000000101', '012340201','Nam', 'NN');
insert into KhachHang (TenKH, CCCD, SDT, GioiTinh, MALOAIKHACH) values ('Phạm Băng Viên', '000002002', '014342104','Nam', 'NN');
insert into KhachHang (TenKH, CCCD, SDT, GioiTinh, MALOAIKHACH) values ( 'Trần Nguyên Chi', '000001609', '048390301','Nữ', 'NN');
insert into KhachHang (TenKH, CCCD, SDT, GioiTinh, MALOAIKHACH) values ( 'Ngô Thu', '000003105', '083440546','Nữ', 'NN');
insert into KhachHang (TenKH, CCCD, SDT, GioiTinh, MALOAIKHACH) values ( 'Mỹ Linh', '000500402', '058393261', 'Nữ', 'NN');
insert into KhachHang (TenKH, CCCD, SDT, GioiTinh, MALOAIKHACH) values ( 'Mai Anh Tuấn', '065589915', '0323195', 'Nam', 'NN');
insert into KhachHang (TenKH, CCCD, SDT, GioiTinh, MALOAIKHACH) values ( 'Nguyễn Thu Dung' ,'0989166582', '289166597', 'Nữ', 'NN');
insert into KhachHang (TenKH, CCCD, SDT, GioiTinh, MALOAIKHACH) values ( 'Huỳnh Ngọc Tâm' ,'0987654321', '28293031', 'Nam', 'ND');
insert into KhachHang (TenKH, CCCD, SDT, GioiTinh, MALOAIKHACH) values ( 'Lê Minh Khôi' ,'0989166582', '86327242', 'Nam', 'ND');
insert into KhachHang (TenKH, CCCD, SDT, GioiTinh, MALOAIKHACH) values ( 'Chế Viết Khôi' ,'0988844673', '123172636', 'Nam', 'ND');
insert into KhachHang (TenKH, CCCD, SDT, GioiTinh, MALOAIKHACH) values ( 'Nguyễn Thị Mai' ,'0120566877', '38967223', 'Nữ', 'ND');
insert into KhachHang (TenKH, CCCD, SDT, GioiTinh, MALOAIKHACH) values ( 'Lê Thị Diệu' ,'0957754221', '781789321', 'Nữ', 'ND');
insert into KhachHang (TenKH, CCCD, SDT, GioiTinh, MALOAIKHACH) values ( 'Huỳnh Vũ Thu' ,'087335218', '345456123', 'Nam', 'ND');
insert into KhachHang (TenKH, CCCD, SDT, GioiTinh, MALOAIKHACH) values ( 'Kang Seung Lok' ,'666777888', '999000345', 'Nam', 'ND');
insert into KhachHang (TenKH, CCCD, SDT, GioiTinh, MALOAIKHACH) values ( 'Kim Chae Won' ,'0292003029', '32333435', 'Nữ', 'ND');

insert into NhanVien (TenNV, CCCD, SDT, NGAYSINH, GioiTinh, NGAYVL, ChucVu) values ( 'Trần Ngọc Mai', '0540041801','014380245',TO_DATE('2003/05/03', 'yyyy/mm/dd ') ,'NỮ',TO_DATE('2023/05/03', 'yyyy/mm/dd '),'Tiếp tân');
insert into NhanVien (TenNV, CCCD, SDT, NGAYSINH, GioiTinh, NGAYVL, ChucVu) values ('Thanh Tuyên', '0841021350','044588292',TO_DATE('2003/05/03', 'yyyy/mm/dd '),'NỮ',TO_DATE('2023/05/03', 'yyyy/mm/dd '),'Tiếp tân');
insert into NhanVien (TenNV, CCCD, SDT, NGAYSINH, GioiTinh, NGAYVL, ChucVu) values ( 'Quốc Trung', '0020543899','097380284',TO_DATE('2003/05/03', 'yyyy/mm/dd '),'Nam',TO_DATE('2023/05/03', 'yyyy/mm/dd '),'Quản lí');
insert into NhanVien (TenNV, CCCD, SDT, NGAYSINH, GioiTinh, NGAYVL, ChucVu) values ( 'Quỳnh Nga', '023050002','078720655',TO_DATE('2003/05/03', 'yyyy/mm/dd '),'NỮ',TO_DATE('2023/05/03', 'yyyy/mm/dd '),'Kế toán');
insert into NhanVien (TenNV, CCCD, SDT, NGAYSINH, GioiTinh, NGAYVL, ChucVu) values ( 'Châu Tuệ', '0250049004','091250622',TO_DATE('2003/05/03', 'yyyy/mm/dd '),'Nam',TO_DATE('2023/05/03', 'yyyy/mm/dd '),'Kế toán');
insert into NhanVien (TenNV, CCCD, SDT, NGAYSINH, GioiTinh, NGAYVL, ChucVu) values ( 'Kim Giang', '0250049004','091250622',TO_DATE('2003/05/03', 'yyyy/mm/dd '),'Nam',TO_DATE('2023/05/03', 'yyyy/mm/dd '),'Tiếp tân');
insert into NhanVien (TenNV, CCCD, SDT, NGAYSINH, GioiTinh, NGAYVL, ChucVu) values ( 'Lý Nhân', '0250049004','091250622',TO_DATE('2003/05/03', 'yyyy/mm/dd '),'Nam',TO_DATE('2023/05/03', 'yyyy/mm/dd '),'Tiếp tân');


insert into DANHMUCDICHVU(TENDV,DONGIA) values ( 'Dọn phòng', 20000);
insert into DANHMUCDICHVU(TENDV,DONGIA) values ('Giặt ủi', 30000);
insert into DANHMUCDICHVU(TENDV,DONGIA) values ( 'Trông trẻ', 50000);
insert into DANHMUCDICHVU(TENDV,DONGIA) values ( 'Thuê xe tự lái', 200000);
insert into DANHMUCDICHVU(TENDV,DONGIA) values ( 'Chăm sóc thú cưng', 100000);
insert into DANHMUCDICHVU(TENDV,DONGIA) values ( 'Spa', 300000);
insert into DANHMUCDICHVU(TENDV,DONGIA) values ( 'Trả đón sân bay', 150000);
insert into DANHMUCDICHVU(TENDV,DONGIA) values ( 'Karaoke', 100000);
insert into DANHMUCDICHVU(TENDV,DONGIA) values ( 'Gym', 100000);
insert into DANHMUCDICHVU(TENDV,DONGIA) values ( 'Sử dụng hồ bơi', 20000);

insert into LOAIPHONG(MALOAIPHG, KIEUPHONG, KIEUGIUONG, MOTA,  DONGIA) values ('LP-STD01','Standard', 1, 'Phong tieu chuan - Giuong don', 300000);
insert into LOAIPHONG(MALOAIPHG, KIEUPHONG, KIEUGIUONG, MOTA,  DONGIA) values ('LP-STD02','Standard', 2, 'Phong tieu chuan - Giuong doi nho', 400000);
insert into LOAIPHONG(MALOAIPHG, KIEUPHONG, KIEUGIUONG, MOTA,  DONGIA) values ('LP-STD03','Standard', 4, 'Phong tieu chuan - Giuong doi lon', 500000);
insert into LOAIPHONG(MALOAIPHG, KIEUPHONG, KIEUGIUONG, MOTA,  DONGIA) values ('LP-SUP01','Superior', 1, 'Phong cao cap Superior - Giuong don', 1000000);
insert into LOAIPHONG(MALOAIPHG, KIEUPHONG, KIEUGIUONG, MOTA,  DONGIA) values ('LP-SUP02','Superior', 4, 'Phong cao cap Superior - Giuong doi lon', 1200000);
insert into LOAIPHONG(MALOAIPHG, KIEUPHONG, KIEUGIUONG, MOTA,  DONGIA) values ('LP-DLX01','Deluxe', 2, 'Phong cao cap Deluxe - Giuong don nho', 1500000);
insert into LOAIPHONG(MALOAIPHG, KIEUPHONG, KIEUGIUONG, MOTA,  DONGIA) values ('LP-DLX02','Deluxe', 4, 'Phong cao cap Deluxe - Giuong doi lon', 1800000);
insert into LOAIPHONG(MALOAIPHG, KIEUPHONG, KIEUGIUONG, MOTA,  DONGIA) values ('LP-SUT01','Suite', 1, 'Phong cao cap Suite - Giuong don lon', 2000000);
insert into LOAIPHONG(MALOAIPHG, KIEUPHONG, KIEUGIUONG, MOTA,  DONGIA) values ('LP-SUT02','Suite', 2, 'Phong cao cap Suite - Giuong doi lon', 2500000);

insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('01-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('02-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 0);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('03-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('04-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('05-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('06-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('07-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('08-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('09-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('10-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('11-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('12-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('13-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('14-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('15-STD', 'LP-STD01', 'Phong tieu chuan - Giuong don - Tang 1', 1);

insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('16-STD', 'LP-STD02', 'Phong tieu chuan - Giuong doi nho - Tang 1', 0);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('17-STD', 'LP-STD02', 'Phong tieu chuan - Giuong doi nho - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('18-STD', 'LP-STD02', 'Phong tieu chuan - Giuong doi nho - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('19-STD', 'LP-STD02', 'Phong tieu chuan - Giuong doi nho - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('20-STD', 'LP-STD02', 'Phong tieu chuan - Giuong doi nho - Tang 1', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('21-STD', 'LP-STD02', 'Phong tieu chuan - Giuong doi nho - Tang 2', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('22-STD', 'LP-STD02', 'Phong tieu chuan - Giuong doi nho - Tang 2', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('23-STD', 'LP-STD02', 'Phong tieu chuan - Giuong doi nho - Tang 2', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('24-STD', 'LP-STD02', 'Phong tieu chuan - Giuong doi nho - Tang 2', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('25-STD', 'LP-STD02', 'Phong tieu chuan - Giuong doi nho - Tang 2', 1);

insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('26-STD', 'LP-STD03', 'Phong tieu chuan - Giuong doi lon - Tang 2', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('27-STD', 'LP-STD03', 'Phong tieu chuan - Giuong doi lon - Tang 2', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('28-STD', 'LP-STD03', 'Phong tieu chuan - Giuong doi lon - Tang 2', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('29-STD', 'LP-STD03', 'Phong tieu chuan - Giuong doi lon - Tang 2', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('30-STD', 'LP-STD03', 'Phong tieu chuan - Giuong doi lon - Tang 2', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('31-STD', 'LP-STD03', 'Phong tieu chuan - Giuong doi lon - Tang 2', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('32-STD', 'LP-STD03', 'Phong tieu chuan - Giuong doi lon - Tang 2', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('33-STD', 'LP-STD03', 'Phong tieu chuan - Giuong doi lon - Tang 2', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('34-STD', 'LP-STD03', 'Phong tieu chuan - Giuong doi lon - Tang 2', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('35-STD', 'LP-STD03', 'Phong tieu chuan - Giuong doi lon - Tang 2', 1);

insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('01-SUP', 'LP-SUP01', 'Phong cao cap Superior - Giuong don - Tang 3',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('02-SUP', 'LP-SUP01', 'Phong cao cap Superior - Giuong don - Tang 3',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('03-SUP', 'LP-SUP01', 'Phong cao cap Superior - Giuong don - Tang 3',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('04-SUP', 'LP-SUP01', 'Phong cao cap Superior - Giuong don - Tang 3',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('05-SUP', 'LP-SUP01', 'Phong cao cap Superior - Giuong don - Tang 3',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('06-SUP', 'LP-SUP01', 'Phong cao cap Superior - Giuong don - Tang 3',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('07-SUP', 'LP-SUP01', 'Phong cao cap Superior - Giuong don - Tang 3',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('08-SUP', 'LP-SUP01', 'Phong cao cap Superior - Giuong don - Tang 3',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('09-SUP', 'LP-SUP01', 'Phong cao cap Superior - Giuong don - Tang 3',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('10-SUP', 'LP-SUP01', 'Phong cao cap Superior - Giuong don - Tang 3',1);

insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('11-SUP', 'LP-SUP02', 'Phong cao cap Superior - Giuong doi lon - Tang 4',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('12-SUP', 'LP-SUP02', 'Phong cao cap Superior - Giuong doi lon - Tang 4',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('13-SUP', 'LP-SUP02', 'Phong cao cap Superior - Giuong doi lon - Tang 4',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('14-SUP', 'LP-SUP02', 'Phong cao cap Superior - Giuong doi lon - Tang 4',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('15-SUP', 'LP-SUP02', 'Phong cao cap Superior - Giuong doi lon - Tang 4',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('16-SUP', 'LP-SUP02', 'Phong cao cap Superior - Giuong doi lon - Tang 4',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('17-SUP', 'LP-SUP02', 'Phong cao cap Superior - Giuong doi lon - Tang 4',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('18-SUP', 'LP-SUP02', 'Phong cao cap Superior - Giuong doi lon - Tang 4',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('19-SUP', 'LP-SUP02', 'Phong cao cap Superior - Giuong doi lon - Tang 4',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('20-SUP', 'LP-SUP02', 'Phong cao cap Superior - Giuong doi lon - Tang 4',1);

insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('01-DLX', 'LP-DLX01', 'Phong cao cap Deluxe - Giuong don lon - Tang 5', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('02-DLX', 'LP-DLX01', 'Phong cao cap Deluxe - Giuong don lon - Tang 5', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('03-DLX', 'LP-DLX01', 'Phong cao cap Deluxe - Giuong don lon - Tang 5', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('04-DLX', 'LP-DLX01', 'Phong cao cap Deluxe - Giuong don lon - Tang 5', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('05-DLX', 'LP-DLX01', 'Phong cao cap Deluxe - Giuong don lon - Tang 5', 1);

insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('06-DLX', 'LP-DLX02', 'Phong cao cap Deluxe - Giuong doi lon - Tang 6',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('07-DLX', 'LP-DLX02', 'Phong cao cap Deluxe - Giuong doi lon - Tang 6',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('08-DLX', 'LP-DLX02', 'Phong cao cap Deluxe - Giuong doi lon - Tang 6',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('09-DLX', 'LP-DLX02', 'Phong cao cap Deluxe - Giuong doi lon - Tang 6',1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('10-DLX', 'LP-DLX02', 'Phong cao cap Deluxe - Giuong doi lon - Tang 6',1);

insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('01-SUT', 'LP-SUT01', 'Phong cao cap Suite - Giuong don lon - Tang 7', 1);
insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('02-SUT', 'LP-SUT01', 'Phong cao cap Suite - Giuong don lon - Tang 7', 1);

insert into PHONG (MAPHG, MALOAIPHG,MOTA,TINHTRANG) values ('VIP-SUT', 'LP-SUT02', 'Phong cao cap Suite - Giuong doi lon - Tang 8',0);

-- insert into PHIEUDATPHONG (MANV, MAKH, NGAYNHAN, NGAYTRA, TTNHANPHONG) VALUES (3,4,TO_DATE('2023/6/2', 'yyyy/mm/dd '),TO_DATE('2023/6/4', 'yyyy/mm/dd '),1);

-- insert into CHITIETDATPHONG(MADATPHONG,MAPHG) VALUES (1,'21-STD');
-- insert into CHITIETDATPHONG(MADATPHONG,MAPHG) VALUES (1,'02-SUT');
-- insert into CHITIETDATPHONG(MADATPHONG,MAPHG) VALUES (1,'19-SUP');
-- insert into CHITIETDATPHONG(MADATPHONG,MAPHG) VALUES (1,'20-STD');
-- SELECT * FROM PHIEUDATPHONG;
-- INSERT INTO HOADONDV (MADATPHONG, MAKH, MANV, MAPHG) VALUES (1,2,1,'02-SUT');
-- SELECT * FROM HOADONDV;
-- select * from chitietdondv;
-- SELECT * FROM DANHMUCDICHVU;
-- INSERT INTO CHITIETDONDV (MAHDDV, MADV, SOLUONG) VALUES (1,1,3);
/* END OF INSERT VALUES*/
--select current_date - to_date('2023/6/2', 'yyyy/mm/dd ') from dual;


--------add values----------
--insert into Phieudatphong(manv, makh, ngaydat, ngaynhan, ngaytra, ttnhanphong, tienphong) 
--values (2, 6, to_date('2023/04/23', 'yyyy/mm/dd'), to_date('2023/04/23', 'yyyy/mm/dd'), to_date('2023/04/27', 'yyyy/mm/dd'), 1, 0);
--insert into Phieudatphong(manv, makh, ngaydat, ngaynhan, ngaytra, ttnhanphong, tienphong) 
--values (2, 5, to_date('2023/04/23', 'yyyy/mm/dd'), to_date('2023/04/23', 'yyyy/mm/dd'), to_date('2023/04/27', 'yyyy/mm/dd'), 1, 0);
--
--insert into Phieudatphong(manv, makh, ngaydat, ngaynhan, ngaytra, ttnhanphong, tienphong) 
--values (2, 1, to_date('2023/06/23', 'yyyy/mm/dd'), to_date('2023/06/23', 'yyyy/mm/dd'), to_date('2023/06/27', 'yyyy/mm/dd'), 1, 0);
--insert into Phieudatphong(manv, makh, ngaydat, ngaynhan, ngaytra, ttnhanphong, tienphong) 
--values (4, 2, to_date('2023/06/23', 'yyyy/mm/dd'), to_date('2023/06/23', 'yyyy/mm/dd'), to_date('2023/06/30', 'yyyy/mm/dd'), 1, 0);
--insert into Phieudatphong(manv, makh, ngaydat, ngaynhan, ngaytra, ttnhanphong, tienphong) 
--values (5, 3, to_date('2023/06/23', 'yyyy/mm/dd'), to_date('2023/06/23', 'yyyy/mm/dd'), to_date('2023/07/01', 'yyyy/mm/dd'), 1, 0);
--insert into Phieudatphong(manv, makh, ngaydat, ngaynhan, ngaytra, ttnhanphong, tienphong) 
--values (1, 4, to_date('2023/06/15', 'yyyy/mm/dd'), to_date('2023/07/01', 'yyyy/mm/dd'), to_date('2023/07/03', 'yyyy/mm/dd'), 0, 0);
--insert into Phieudatphong(manv, makh, ngaydat, ngaynhan, ngaytra, ttnhanphong, tienphong) 
--values (4, 1, to_date('2023/06/15', 'yyyy/mm/dd'), to_date('2023/07/15', 'yyyy/mm/dd'), to_date('2023/07/18', 'yyyy/mm/dd'), 0, 0);
--insert into Phieudatphong(manv, makh, ngaydat, ngaynhan, ngaytra, ttnhanphong, tienphong) 
--values (3, 5, to_date('2023/06/15', 'yyyy/mm/dd'), to_date('2023/07/20', 'yyyy/mm/dd'), to_date('2023/07/22', 'yyyy/mm/dd'), 0, 0);
--insert into Phieudatphong(manv, makh, ngaydat, ngaynhan, ngaytra, ttnhanphong, tienphong) 
--values (4, 4, to_date('2023/06/15', 'yyyy/mm/dd'), to_date('2023/08/02', 'yyyy/mm/dd'), to_date('2023/08/03', 'yyyy/mm/dd'), 0, 0);
--insert into Phieudatphong(manv, makh, ngaydat, ngaynhan, ngaytra, ttnhanphong, tienphong) 
--values (1, 2, to_date('2023/06/15', 'yyyy/mm/dd'), to_date('2023/08/08', 'yyyy/mm/dd'), to_date('2023/08/09', 'yyyy/mm/dd'), 0, 0);
--
--
--insert into chitietdatphong(MAPHG, MADATPHONG) values ('02-STD', 1);
--insert into chitietdatphong(MAPHG, MADATPHONG) values ('16-STD', 2);
--insert into chitietdatphong(MAPHG, MADATPHONG) values ('VIP-SUT', 3);
--insert into chitietdatphong(MAPHG, MADATPHONG) values ('26-STD', 4);
--insert into chitietdatphong(MAPHG, MADATPHONG) values ('03-STD', 5);
--insert into chitietdatphong(MAPHG, MADATPHONG) values ('01-SUP', 6);
--insert into chitietdatphong(MAPHG, MADATPHONG) values ('02-SUP', 7);
--insert into chitietdatphong(MAPHG, MADATPHONG) values ('01-SUP', 8);
--insert into chitietdatphong(MAPHG, MADATPHONG) values ('02-SUP', 8);
--insert into chitietdatphong(MAPHG, MADATPHONG) values ('01-SUP', 1);
--insert into chitietdatphong(MAPHG, MADATPHONG) values ('02-SUP', 1);


--insert into hoadondv(madatphong, manv, maphg, madv, soluong, thanhtien, tinhtrang, thoigiandat)
--values (1, 2, '02-STD', 1,2, 0, 0, to_date('2023/06/16', 'yyyy/mm/dd'));
--insert into hoadondv(madatphong, manv, maphg, madv, soluong, thanhtien, tinhtrang, thoigiandat)
--values (3, 5, 'VIP-SUT', 3,1, 0, 0, to_date('2023/06/20', 'yyyy/mm/dd'));
--insert into hoadondv(madatphong, manv, maphg, madv, soluong, thanhtien, tinhtrang, thoigiandat)
--values (7, 4, '02-SUP', 4,3, 0, 0, to_date('2023/06/02', 'yyyy/mm/dd'));
--
--insert into thanhtoan(madatphong, manv, hinhthucthanhtoan, tienkhachdua) values (1, 2, 'truc tiep',GET_TONGTIEN_THANHTOAN(1));
--exec XacNhanThanhToan(1);
--exec XacNhanThanhToan(2);
--exec XacNhanThanhToan(3);
--exec XacNhanThanhToan(4);
--exec XacNhanThanhToan(5);
--exec XacNhanThanhToan(6);
--exec XacNhanThanhToan(7);
--exec XacNhanThanhToan(8);
--
--insert into thanhtoan(madatphong, manv, thanhtien, hinhthucthanhtoan, ngaylap, tienkhachdua)
--values (1, 2, GET_TONGTIEN_THANHTOAN(1), 'truc tiep', to_date('2023/06/17', 'yyyy/mm/dd'), 0);
--insert into thanhtoan(madatphong, manv, thanhtien, hinhthucthanhtoan, ngaylap, tienkhachdua)
--values (2, 4, GET_TONGTIEN_THANHTOAN(2), 'truc tiep', to_date('2023/06/18', 'yyyy/mm/dd'), 0);
--insert into thanhtoan(madatphong, manv, thanhtien, hinhthucthanhtoan, ngaylap, tienkhachdua)
--values (3, 5, GET_TONGTIEN_THANHTOAN(3), 'truc tiep', to_date('2023/06/21', 'yyyy/mm/dd'), 0);
--insert into thanhtoan(madatphong, manv, thanhtien, hinhthucthanhtoan, ngaylap, tienkhachdua)
--values (4, 1, GET_TONGTIEN_THANHTOAN(4), 'onl', to_date('2023/05/03', 'yyyy/mm/dd'), 0);
--insert into thanhtoan(madatphong, manv, thanhtien, hinhthucthanhtoan, ngaylap, tienkhachdua)
--values (5, 4, GET_TONGTIEN_THANHTOAN(5), 'onl', to_date('2023/05/18', 'yyyy/mm/dd'), 0);
--insert into thanhtoan(madatphong, manv, thanhtien, hinhthucthanhtoan, ngaylap, tienkhachdua)
--values (6, 3, GET_TONGTIEN_THANHTOAN(6), 'onl', to_date('2023/05/22', 'yyyy/mm/dd'), 0);
--insert into thanhtoan(madatphong, manv, thanhtien, hinhthucthanhtoan, ngaylap, tienkhachdua)
--values (7, 4, GET_TONGTIEN_THANHTOAN(7), 'onl', to_date('2023/05/03', 'yyyy/mm/dd'), 0);
--insert into thanhtoan(madatphong, manv, thanhtien, hinhthucthanhtoan, ngaylap, tienkhachdua)
--values (8, 1, GET_TONGTIEN_THANHTOAN(8), 'onl', to_date('2023/05/09', 'yyyy/mm/dd'), 0);



insert into taikhoan(tentaikhoan,manv,matkhau,quyen) values ('admin',1,'admin','admin');
insert into taikhoan(tentaikhoan,manv,matkhau,quyen) values ('user',2,'user','user');


/* START OF TRIGGER                           */
-- 
-- CREATE OR REPLACE TRIGGER trg_check_distinct_kieuphong
-- BEFORE INSERT ON LOAIPHONG
-- FOR EACH ROW
-- DECLARE
--     v_distinct_count NUMBER; 
--     v_max_limit NUMBER;
-- BEGIN
--     SELECT GIATRI
--     INTO v_max_limit
--     FROM THAMSO
--     WHERE MATS = 'SoLoaiPhong';
-- 
--     SELECT COUNT(DISTINCT KIEUPHONG)
--     INTO v_distinct_count
--     FROM LOAIPHONG
--     WHERE KIEUPHONG IS NOT NULL;
-- 
--     IF :NEW.KIEUPHONG IS NOT NULL THEN
--         SELECT COUNT(*)
--         INTO v_distinct_count
--         FROM (
--             SELECT DISTINCT KIEUPHONG FROM LOAIPHONG
--             UNION
--             SELECT :NEW.KIEUPHONG FROM DUAL
--         );
--     END IF;
-- 
--     IF v_distinct_count > v_max_limit THEN
--         RAISE_APPLICATION_ERROR(-20004, 'Ko dc vươt qua gia tri quy dinh');
--     END IF;
-- END trg_check_distinct_kieuphong;
-- /


CREATE OR REPLACE TRIGGER trg_check_distinct_kieukhach
BEFORE INSERT ON LOAIKHACH
FOR EACH ROW
DECLARE
    v_distinct_count NUMBER; 
    v_max_limit NUMBER;
BEGIN
    SELECT GIATRI
    INTO v_max_limit
    FROM THAMSO
    WHERE MATS = 'SoLoaiKhach';
    
    SELECT COUNT(DISTINCT TENLOAIKHACH)
    INTO v_distinct_count
    FROM LOAIKHACH
    WHERE TENLOAIKHACH IS NOT NULL;

    IF :NEW.TENLOAIKHACH IS NOT NULL THEN
        SELECT COUNT(*)
        INTO v_distinct_count
        FROM (
            SELECT DISTINCT TENLOAIKHACH FROM LOAIKHACH
            UNION
            SELECT :NEW.TENLOAIKHACH FROM DUAL
        );
    END IF;

    IF v_distinct_count > v_max_limit THEN
        RAISE_APPLICATION_ERROR(-20004, 'Ko dc vươt qua gia tri quy dinh');
    END IF;
END trg_check_distinct_kieukhach;
/


/*==============================================================*/
/* Trigger:   TRG_CHITIETDATPHONG_ON_INSERT                                   */
/*==============================================================*/
create or replace trigger TRG_CHITIETDATPHONG_ON_INSERT
before insert on CHITIETDATPHONG
referencing old as old new as new
for each row
declare
    dongia_v LOAIPHONG.DONGIA%TYPE;
    tongtien_v PHIEUDATPHONG.TIENPHONG%TYPE;
    songayluutru_v number;
    ngaynhan_v PHIEUDATPHONG.NGAYNHAN%TYPE;
    ngaytra_v PHIEUDATPHONG.NGAYTRA%TYPE;
BEGIN
    SELECT LOAIPHONG.DONGIA INTO dongia_v 
    FROM (SELECT MALOAIPHG FROM PHONG WHERE MAPHG = :NEW.MAPHG) A
    JOIN LOAIPHONG ON A.MALOAIPHG = LOAIPHONG.MALOAIPHG; 
    :NEW.DONGIAPHONG := dongia_v;
    SELECT TIENPHONG,NGAYNHAN, NGAYTRA into tongtien_v,ngaynhan_v, ngaytra_v from PHIEUDATPHONG where MADATPHONG = :new.MADATPHONG;
    songayluutru_v := GET_NGAYLUUTRU(ngaynhan_v,ngaytra_v);
    
    UPDATE PHIEUDATPHONG
    SET TIENPHONG = tongtien_v + :NEW.DONGIAPHONG * songayluutru_v
    WHERE PHIEUDATPHONG.MADATPHONG = :new.MADATPHONG;

END TRG_CHITIETDATPHONG_ON_INSERT;
/





/*==============================================================*/
/* Trigger:TRG_AUTO_UPDATE_THANHTIEN_HDDV                                  */
/*==============================================================*/
create or replace trigger TRG_AUTO_UPDATE_THANHTIEN_HDDV
before insert or update of SOLUONG, THANHTIEN on HOADONDV
referencing old as old new as new
for each row
declare
    dongia_v DANHMUCDICHVU.dongia%type;
begin            
    SELECT DONGIA INTO dongia_v FROM DANHMUCDICHVU WHERE MADV = :NEW.MADV;

    CASE
        WHEN INSERTING THEN
            :NEW.THANHTIEN := :NEW.SOLUONG * dongia_v;
            UPDATE PHIEUDATPHONG SET TIENDV = TIENDV + :NEW.THANHTIEN WHERE MADATPHONG = :new.MADATPHONG;
            
        WHEN UPDATING THEN
            :NEW.THANHTIEN := :OLD.THANHTIEN - (:NEW.SOLUONG - :OLD.SOLUONG) * dongia_v;
            UPDATE PHIEUDATPHONG SET TIENDV = TIENDV + :NEW.THANHTIEN - :OLD.THANHTIEN WHERE MADATPHONG = :new.MADATPHONG;
    END CASE;
    EXCEPTION 
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('NO DONGIA FOUNDED');
end TRG_AUTO_UPDATE_THANHTIEN_HDDV ;
/


/*==============================================================*/
/* Trigger:TRG_HDDV_ON_DELETE                                */
/*==============================================================*/
create or replace trigger TRG_HDDV_ON_DELETE
before DELETE on HOADONDV
referencing old as old new as new
for each row
declare
    dongia_v DANHMUCDICHVU.dongia%type;
begin            
    UPDATE PHIEUDATPHONG SET TIENDV = TIENDV - :OLD.THANHTIEN WHERE MADATPHONG = :old.MADATPHONG;
    EXCEPTION 
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('CO LOI XAY RA');
end TRG_HDDV_ON_DELETE ;
/


/*==============================================================*/
/* Trigger: TRG__PHIEUDATPHONG_ON_UPDATE_OF_NGAYNHAN_NGAYTRA                                   */
/*==============================================================*/
create or replace trigger TRG_PHIEUDATPHONG_ON_UPDATE_OF_NGAYNHAN_NGAYTRA
before update of NGAYNHAN, NGAYTRA on PHIEUDATPHONG
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
DECLARE
    tongtien_v PHIEUDATPHONG.TIENPHONG%type;
    tongdongia_v PHIEUDATPHONG.TIENPHONG%type;
    songay_v number;
BEGIN
-- LAY TONG DON GIA CUA TAT CA CAC PHONG TRONG PHIEU DAT PHONG
    SELECT SUM(DONGIAPHONG)
    INTO tongdongia_v
    FROM CHITIETDATPHONG
    WHERE MADATPHONG = :NEW.MADATPHONG;
--    LAY SO NGAY O TRONG PHIEU NHAN PHONG
    songay_v := GET_NGAYLUUTRU(:new.NGAYTRA ,:NEW.NGAYNHAN);
    :NEW.TIENPHONG := songay_v * tongdongia_v;
END TRG__PHIEUDATPHONG_ON_UPDATE_OF_NGAYNHAN_NGAYTRA;
/



/*==============================================================*/
/* Trigger: TRG_CHITIETDATPHONG_ON_DELETE_UPDATE_OF_DONGIAPHONG              */
/*==============================================================*/
create or replace trigger TRG_CHITIETDATPHONG_ON_DELETE_UPDATE_OF_DONGIAPHONG
before delete or update of DonGiaPhong on CHITIETDATPHONG
referencing old as old new as new
for each row
declare
    tongtien_v PHIEUDATPHONG.TIENPHONG%type;
    tongdongia_v PHIEUDATPHONG.TIENPHONG%type;
    songayluutru_v number;
begin
    SELECT Get_ngayluutru(NGAYTRA,NGAYNHAN)
    INTO songayluutru_v 
    FROM PHIEUDATPHONG
    WHERE MADATPHONG =:old.MADATPHONG;
    SELECT TIENPHONG into tongtien_v from PHIEUDATPHONG where MADATPHONG = :old.MADATPHONG;
    CASE
        WHEN UPDATING THEN
            UPDATE PHIEUDATPHONG
            SET TIENPHONG = tongtien_v + :new.DONGIAPHONG * songayluutru_v - :old.DONGIAPHONG * songayluutru_v
            where PHIEUDATPHONG.MADATPHONG = :new.MADATPHONG;
        WHEN DELETING THEN
            UPDATE PHIEUDATPHONG
            SET TIENPHONG = tongtien_v - :old.DONGIAPHONG * songayluutru_v
            where PHIEUDATPHONG.MADATPHONG = :old.MADATPHONG;
    END CASE;
end TRG_CHITIETDATPHONG_ON_DELETE_UPDATE_OF_DONGIAPHONG;
/


/*==============================================================*/
/* Trigger: TRG_THANHTOAN_AUTO_TONGTIEN_ON_INSERT              */
/*==============================================================*/
create or replace trigger TRG_THANHTOAN_AUTO_TONGTIEN_ON_INSERT
before insert on THANHTOAN
referencing old as old new as new
for each row
declare
    makh_v KHACHHANG.MAKH%TYPE;
begin
    SELECT MAKH INTO makh_v FROM PHIEUDATPHONG WHERE MADATPHONG = :NEW.MADATPHONG;
    :new.THANHTIEN := get_TongTien_ThanhToan(:NEW.MADATPHONG);
end TRG_THANHTOAN_AUTO_TONGTIEN_ON_INSERT;
/


/* END OF TRIGGER                           */






/*START OF PL/SQL                            */



create or replace function get_NgayLuuTru(ngaynhan_i in date, ngaytra_i in date)
return number
as
    result number;
begin
    result := trunc(ngaytra_i) - trunc(ngaynhan_i); 
    if result = 0
    then return 1;
    else if result < 0
        then return 0;
        else 
            return result;
        end if;
    end if;
end;
/


/*==============================================================*/
/* function : get_TongTien_ThanhToan                           */
/*==============================================================*/
CREATE OR REPLACE FUNCTION get_TongTien_ThanhToan(MADATPHONG_v in PHIEUDATPHONG.MADATPHONG%TYPE)
return THANHTOAN.THANHTIEN%TYPE
AS
    tienphong_v PHIEUDATPHONG.TIENPHONG%TYPE;
    tienhddv_v HOADONDV.THANHTIEN%TYPE;
BEGIN
    SELECT TIENPHONG+PHUPHI-TIENTRATRUOC INTO tienphong_v FROM PHIEUDATPHONG WHERE MADATPHONG = MADATPHONG_v;
    SELECT SUM(THANHTIEN) INTO tienhddv_v FROM HOADONDV WHERE MADATPHONG = MADATPHONG_v AND TINHTRANG = 0 ;
    IF (tienhddv_v IS NULL ) THEN RETURN tienphong_v;
    END IF;
    return tienphong_v + tienhddv_v;
END get_TongTien_ThanhToan;
/



/*==============================================================*/
/* PROCEDURE: INSERT_LUUTRU                           */
/*==============================================================*/
CREATE OR REPLACE PROCEDURE INSERT_LUUTRU
    (tenkh_v in KHACHHANG.TENKH%TYPE,
    cccd_v in KHACHHANG.CCCD%TYPE,
    id_datphong in PHIEUDATPHONG.MADATPHONG%TYPE,
    maphg_v in PHONG.MAPHG%TYPE
    )
AS
    makh_v KHACHHANG.MAKH%TYPE;
    temp KHACHHANG.MAKH%TYPE;
BEGIN
    select MAKH INTO makh_v FROM KHACHHANG WHERE TENKH = tenkh_v AND CCCD = cccd_v;
    if SQL%NOTFOUND
    THEN
        LOOP
            SELECT MAKH_SEQ.NEXTVAL INTO makh_v from dual;
            SELECT MAKH INTO temp FROM KHACHHANG WHERE MAKH = makh_v;
            EXIT WHEN SQL%NOTFOUND;
        END LOOP;
        INSERT INTO KHACHHANG (MAKH, TENKH, CCCD) VALUES (makh_v, tenkh_v,cccd_v);
    END IF;
    INSERT INTO LUUTRU (MADATPHONG, MAKH, MAPHG) VALUES (id_datphong, makh_v, maphg_v);
END INSERT_LUUTRU;
/
/*==============================================================*/
/* PROCEDURE: HuyPhieuDatPhong                           */
/*==============================================================*/

CREATE OR REPLACE PROCEDURE HuyPhieuDatPhong(madatphong_i IN PHIEUDATPHONG.MADATPHONG%TYPE)
as
    ttNhanPhong_v PHIEUDATPHONG.TTNHANPHONG%TYPE;
BEGIN
    SELECT TTNHANPHONG INTO ttNhanPhong_v FROM PHIEUDATPHONG WHERE MADATPHONG = madatphong_i;
    IF ttNhanPhong_v = 1 or ttNhanPhong_v = 2
    THEN
        DBMS_OUTPUT.PUT_LINE('PHIEU DAT PHONG DA NHAN PHONG, KHONG THE HUY');
    ELSE
        DELETE FROM CHITIETDATPHONG WHERE MADATPHONG = madatphong_i;
        UPDATE PHIEUDATPHONG SET TTNHANPHONG = -1 WHERE MADATPHONG = madatphong_i;
        COMMIT;
    END IF;
END;
/


/*==============================================================*/
/* function: getAvailableRoom()                           */
/*==============================================================*/
create or replace type room as object(
    MaPHG varchar2(8)
);
/
create or replace type room_t as table of room;
/
CREATE OR REPLACE FUNCTION getAvailableRoom
    (ngaynhan_i in date,
    ngaytra_i in date)
return room_t
as
    result room_t;
begin
    select Room(MAPHG)
    BULK COLLECT
    INTO result
    from PHONG
    WHERE MAPHG IN
        (SELECT MAPHG FROM PHONG
        MINUS
        SELECT MAPHG FROM 
                (SELECT MADATPHONG 
                    FROM PHIEUDATPHONG 
                    WHERE 
--                    TRUNC(NGAYTRA) < TRUNC(SYSDATE) 
--                        OR 
                        ( TRUNC(ngaynhan_i) <= TRUNC(NGAYNHAN) AND TRUNC(NGAYNHAN) <= TRUNC(ngaytra_i))
                        OR ( TRUNC(ngaynhan_i) <= TRUNC(NGAYTRA) AND TRUNC(NGAYTRA) <= TRUNC(ngaytra_i) ) 
                    ) A
                JOIN CHITIETDATPHONG B
                on A.MADATPHONG = B.MADATPHONG
        );
    RETURN result;
end getAvailableRoom;
/
/*==============================================================*/
/* function: getCurrentLuuTru()                           */
/*==============================================================*/
create or replace type ThongTinLuuTru as object (
    MaDatPhong number(9),
    MaKH number(9),
    MaPHG varchar2(8),
    TENKH   VARCHAR2(80),
   CCCD  VARCHAR2(13)
);
/
create or replace type ThongTinLuuTru_t as table of ThongTinLuuTru;
/
CREATE OR REPLACE FUNCTION getCurrentLuuTru
return ThongTinLuuTru_t
as
    result ThongTinLuuTru_t;
begin
    select ThongTinLuuTru ( lt.MaDatPhong, k.MaKH, lt.MaPHG, TenKH, CCCD)
    bulk collect
    into result
    from LUUTRU lt,  PHIEUDATPHONG p, KHACHHANG k
    where k.MaKH = lt.MaKH
    and p.MaDatPhong = lt.MaDatPhong
    and p.NgayTra >= trunc(sysdate);
    return result;
end getCurrentLuuTru;
/
--
--CREATE OR REPLACE PROCEDURE UPDATE_DONGIAPHONG_IN_DAY(maloaiphg_i LOAIPHONG.MALOAIPHG%TYPE, dongia_i CHITIETDATPHONG.DONGIA%TYPE)
--AS
--    cursor madatphong_cur as select madatphong from phieudatphong where trunc(ngaydat) = trunc(sysdate)
--BEGIN
--    open madatphong_cur;
--    loop
--        UPDATE CHITIETPHONG SET DONGIAPHONG = dongia_i
--        WHERE MAPHG = 
--END UPDATE_DONGIAPHONG;
--/
    
    
-- CREATE OR REPLACE PROCEDURE INSERT_DON_DV(maphg_i IN PHONG.MAPHG%TYPE, madv_i IN DANHMUCDICHVU.MADV%TYPE, soluong_i IN HOADONDV.SOLUONG%TYPE, manv_i NHANVIEN.MANV%TYPE )
-- AS
--     madatphong_v PHIEUDATPHONG.MADATPHONG%TYPE;
-- BEGIN
--     SELECT b.MADATPHONG INTO madatphong_v FROM PHIEUDATPHONG 
--     JOIN ( SELECT MADATPHONG, MAPHG FROM CHITIETDATPHONG WHERE MAPHG = maphg_i)  b
--     on PHIEUDATPHONG.MADATPHONG = b.MADATPHONG
--     WHERE TRUNC(SYSDATE) <= TRUNC(NGAYTRA) AND TTNHANPHONG = 1;
--     IF SQL%NOTFOUND
--     THEN
--         DBMS_OUTPUT.PUT_LINE('MA PHONG HIEN KHONG DUOC THUE ');
--     ELSE
--         INSERT INTO HOADONDV (MADATPHONG, MAPHG, MANV, MADV, SOLUONG) VALUES (madatphong_v, maphg_i, manv_i, madv_i, soluong_i);
--         COMMIT;
--     END IF;
-- END INSERT_DON_DV;
-- /    



--Procedure Xoa don dv
-- create or replace PROCEDURE DELETE_DON_DV(maphg_i IN PHONG.MAPHG%TYPE, madv_i IN DANHMUCDICHVU.MADV%TYPE)
-- AS
--     madatphong_v PHIEUDATPHONG.MADATPHONG%TYPE;
-- BEGIN
--     SELECT b.MADATPHONG INTO madatphong_v FROM PHIEUDATPHONG 
--     JOIN ( SELECT MADATPHONG, MAPHG FROM CHITIETDATPHONG WHERE MAPHG = maphg_i)  b
--     on PHIEUDATPHONG.MADATPHONG = b.MADATPHONG
--     WHERE TRUNC(SYSDATE) <= TRUNC(NGAYTRA) AND TTNHANPHONG = 1;
--     IF SQL%NOTFOUND
--     THEN
--         DBMS_OUTPUT.PUT_LINE('MA PHONG HIEN KHONG DUOC THUE ');
--     ELSE
--         DELETE FROM HOADONDV WHERE MADATPHONG = madatphong_v 
--         and MADV = madv_i;
--         COMMIT;
--     END IF;
-- END DELETE_DON_DV;
-- /


--Procedure lay danh sach dv tu don dv
create or replace PROCEDURE GET_LIST_DON_DV(maphg_i IN PHONG.MAPHG%TYPE)
AS
    madatphong_v PHIEUDATPHONG.MADATPHONG%TYPE;
BEGIN
    SELECT b.MADATPHONG INTO madatphong_v FROM PHIEUDATPHONG 
    JOIN ( SELECT MADATPHONG, MAPHG FROM CHITIETDATPHONG WHERE MAPHG = maphg_i)  b
    on PHIEUDATPHONG.MADATPHONG = b.MADATPHONG
    WHERE TRUNC(SYSDATE) <= TRUNC(NGAYTRA) AND TTNHANPHONG = 1;
    IF SQL%NOTFOUND
    THEN
        DBMS_OUTPUT.PUT_LINE('MA PHONG HIEN KHONG DUOC THUE ');
    ELSE
        SELECT DMDV.TENDV, HDDV.THOIGIANDAT, HDDV.SOLUONG, DMDV.DONGIA FROM HOADONDV HDDV, DANHMUCDICHVU DMDV
            WHERE DMDV.MADV = HDDV.MADV AND HDDV.MADATPHONG = madatphong_v; 
        COMMIT;
    END IF;
END GET_LIST_DON_DV;
/


CREATE OR REPLACE PROCEDURE XacNhanNhanPhong(madatphong_i in PHIEUDATPHONG.MADATPHONG%TYPE)
AS
    CURSOR phongdat_cur IS SELECT MAPHG FROM CHITIETDATPHONG WHERE MADATPHONG = madatphong_i;
    maphg_v PHONG.MAPHG%TYPE;
    madatphong_v PHIEUDATPHONG.MADATPHONG%TYPE;
BEGIN
    SELECT MADATPHONG INTO madatphong_v FROM PHIEUDATPHONG WHERE MADATPHONG = madatphong_i AND TTNHANPHONG = 0;
    IF SQL%NOTFOUND
    THEN 
        RAISE_APPLICATION_ERROR(-2000,'XAC NHAN NHAN PHONG THAT BAI');
    END IF;
    OPEN phongdat_cur;
    LOOP
        FETCH phongdat_cur into maphg_v;
        EXIT WHEN phongdat_cur%notfound;
        if (phongdat_cur%found)
        then 
            UPDATE PHONG
            SET TINHTRANG = 1
            WHERE MAPHG = maphg_v;
        end if;
    END LOOP;
    UPDATE PHIEUDATPHONG SET TTNHANPHONG = 1 WHERE MADATPHONG = madatphong_i;
    COMMIT;
    EXCEPTION 
        WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('MADATPHONG NOT FOUNDED');
END;
/



CREATE OR REPLACE PROCEDURE XacNhanThanhToan(madatphong_i IN PHIEUDATPHONG.MADATPHONG%TYPE)
IS
    tientra_v THANHTOAN.TIENKHACHDUA%TYPE;
    thanhtien_v THANHTOAN.THANHTIEN%TYPE;
    tongtien_v KHACHHANG.DOANHSO%TYPE;
    makh_v KHACHHANG.MAKH%TYPE;
BEGIN
    UPDATE PHIEUDATPHONG SET TTNHANPHONG  = 2 WHERE MADATPHONG = madatphong_i; 
    DECLARE
        CURSOR phongdat_cur IS SELECT MAPHG FROM CHITIETDATPHONG WHERE MADATPHONG = madatphong_i;
        maphg_v PHONG.MAPHG%TYPE;
    BEGIN
        OPEN phongdat_cur;
        LOOP
            FETCH phongdat_cur into maphg_v;
            EXIT WHEN phongdat_cur%notfound;
            if (phongdat_cur%found)
            then 
                UPDATE PHONG
                SET TINHTRANG = 0
                WHERE MAPHG = maphg_v;
            end if;
        END LOOP;
    END;
    UPDATE HOADONDV SET TINHTRANG = 1 WHERE MADATPHONG = madatphong_i;
    select makh, (tienphong + tiendv) into makh_v, tongtien_v from phieudatphong where madatphong = madatphong_i;
    update khachhang set doanhso = doanhso + tongtien_v WHERE MAKH = makh_v; 
    COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('CO LOI XAY RA');
END;
/

drop PROCEDURE DELETE_DON_DV;
CREATE OR REPLACE PROCEDURE DELETE_DON_DV(maphg_i IN PHONG.MAPHG%TYPE, madv_i IN DANHMUCDICHVU.MADV%TYPE)
AS
    madatphong_v PHIEUDATPHONG.MADATPHONG%TYPE;
    v_thang NUMBER(2);
    v_nam NUMBER(4);
    v_doanh_thu NUMBER(19);
    v_tong_doanh_thu NUMBER(19);
BEGIN
    -- Lấy tháng và năm hiện tại
    v_thang := EXTRACT(MONTH FROM SYSDATE);
    v_nam := EXTRACT(YEAR FROM SYSDATE);

    -- Lấy mã đặt phòng cho phòng đã cho
    SELECT b.MADATPHONG INTO madatphong_v 
    FROM PHIEUDATPHONG 
    JOIN ( 
        SELECT MADATPHONG, MAPHG 
        FROM CHITIETDATPHONG 
        WHERE MAPHG = maphg_i
    ) b ON PHIEUDATPHONG.MADATPHONG = b.MADATPHONG
    WHERE TRUNC(SYSDATE) <= TRUNC(NGAYTRA) 
      AND TTNHANPHONG = 1;

    -- Nếu không tìm thấy mã đặt phòng
    IF SQL%NOTFOUND THEN
        DBMS_OUTPUT.PUT_LINE('MA PHONG HIEN KHONG DUOC THUE ');
    ELSE
        -- Xóa các hóa đơn dịch vụ liên quan đến mã đặt phòng và dịch vụ
        DELETE FROM HOADONDV 
        WHERE MADATPHONG = madatphong_v 
          AND MADV = madv_i;

        -- Cập nhật lại doanh thu và tỷ lệ trong bảng BCDOANHTHUDV
        -- Tính toán doanh thu cho dịch vụ đã xóa
        SELECT NVL(SUM(THANHTIEN), 0)
        INTO v_doanh_thu
        FROM HOADONDV
        WHERE MADV = madv_i
          AND EXTRACT(MONTH FROM THOIGIANDAT) = v_thang
          AND EXTRACT(YEAR FROM THOIGIANDAT) = v_nam;

        -- Tính tổng doanh thu cho tháng và năm
        SELECT NVL(SUM(THANHTIEN), 0)
        INTO v_tong_doanh_thu
        FROM HOADONDV
        WHERE EXTRACT(MONTH FROM THOIGIANDAT) = v_thang
          AND EXTRACT(YEAR FROM THOIGIANDAT) = v_nam;

        -- Cập nhật doanh thu và tỷ lệ trong bảng BCDOANHTHUDV
        MERGE INTO BCDOANHTHUDV b
        USING (SELECT madv_i AS MADV, v_thang AS THANG, v_nam AS NAM FROM DUAL) src
        ON (b.MaDV = src.MADV AND b.THANG = src.THANG AND b.NAM = src.NAM)
        WHEN MATCHED THEN
            UPDATE SET 
                b.SoLanDat = b.SoLanDat - 1,
                b.DoanhThu = NVL(b.DoanhThu, 0) - v_doanh_thu,
                b.TyLe = CASE 
                            WHEN v_tong_doanh_thu > 0 THEN 
                                ROUND((NVL(b.DoanhThu, 0) - v_doanh_thu) * 100 / v_tong_doanh_thu, 2)
                            ELSE 0
                         END;

 DELETE FROM BCDOANHTHUDV
        WHERE SoLanDat = 0
          AND MADV = madv_i
          AND THANG = v_thang
          AND NAM = v_nam;
        -- Cập nhật lại tỷ lệ tổng doanh thu của dịch vụ trong tháng
        UPDATE BCDOANHTHUDV b
        SET TyLe = CASE 
                        WHEN (SELECT SUM(DoanhThu) 
                              FROM BCDOANHTHUDV 
                              WHERE THANG = b.THANG AND NAM = b.NAM) > 0 THEN 
                            ROUND(b.DoanhThu * 100 / 
                                  (SELECT SUM(DoanhThu) 
                                   FROM BCDOANHTHUDV 
                                   WHERE THANG = b.THANG AND NAM = b.NAM), 2)
                        ELSE 0
                    END
        WHERE THANG = v_thang AND NAM = v_nam;

        -- Commit thay đổi
        COMMIT;
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        -- Xử lý lỗi nếu có lỗi xảy ra
        DBMS_OUTPUT.PUT_LINE('Lỗi: ' || SQLERRM);
END DELETE_DON_DV;
/


-- cái PROCEDURE INSERT_DON_DV cũ thay bằng cái này
drop PROCEDURE INSERT_DON_DV;
create or replace NONEDITIONABLE PROCEDURE INSERT_DON_DV(
    maphg_i IN PHONG.MAPHG%TYPE, 
    madv_i IN DANHMUCDICHVU.MADV%TYPE, 
    soluong_i IN HOADONDV.SOLUONG%TYPE, 
    manv_i IN NHANVIEN.MANV%TYPE 
)
AS
    madatphong_v PHIEUDATPHONG.MADATPHONG%TYPE;
    v_thang NUMBER(2);
    v_nam NUMBER(4);
     v_doanh_thu NUMBER(19);
     v_tong_doanh_thu NUMBER(19);
BEGIN
    -- Attempt to find a valid MADATPHONG
    SELECT b.MADATPHONG 
    INTO madatphong_v 
    FROM PHIEUDATPHONG 
    JOIN ( 
        SELECT MADATPHONG, MAPHG 
        FROM CHITIETDATPHONG 
        WHERE MAPHG = maphg_i
    ) b ON PHIEUDATPHONG.MADATPHONG = b.MADATPHONG
    WHERE TRUNC(SYSDATE) <= TRUNC(NGAYTRA) 
    AND TTNHANPHONG = 1;

    -- Insert into HOADONDV if a valid MADATPHONG was found
    INSERT INTO HOADONDV (MADATPHONG, MAPHG, MANV, MADV, SOLUONG) 
    VALUES (madatphong_v, maphg_i, manv_i, madv_i, soluong_i);

    -- Get the month and year for the report
    v_thang := EXTRACT(MONTH FROM SYSDATE);
    v_nam := EXTRACT(YEAR FROM SYSDATE);

    -- Update or insert into the report table
     SELECT NVL(SUM(THANHTIEN), 0)
    INTO v_doanh_thu
    FROM HOADONDV
    WHERE MADV = madv_i
      AND EXTRACT(MONTH FROM THOIGIANDAT) = v_thang
      AND EXTRACT(YEAR FROM THOIGIANDAT) = v_nam;

         SELECT NVL(SUM(THANHTIEN), 0)
    INTO v_tong_doanh_thu
    FROM HOADONDV
    WHERE EXTRACT(MONTH FROM THOIGIANDAT) = v_thang
      AND EXTRACT(YEAR FROM THOIGIANDAT) = v_nam;

    -- Update or insert into the report table
    MERGE INTO BCDOANHTHUDV b
    USING (SELECT madv_i AS MADV, v_thang AS THANG, v_nam AS NAM FROM DUAL) src
    ON (b.MaDV = src.MADV AND b.THANG = src.THANG AND b.NAM = src.NAM)
    WHEN MATCHED THEN
        UPDATE SET 
            b.SoLanDat = b.SoLanDat + 1,
            b.DoanhThu = NVL(b.DoanhThu, 0) + v_doanh_thu,
            b.TyLe = CASE 
                        WHEN v_tong_doanh_thu > 0 THEN 
                            ROUND((NVL(b.DoanhThu, 0) + v_doanh_thu) * 100 / v_tong_doanh_thu, 2)
                        ELSE 0
                     END
    WHEN NOT MATCHED THEN
        INSERT (MaBaoCaoDichVu, SoLanDat, DoanhThu, THANG, NAM, TyLe, MaDV)
        VALUES (BCDOANHTHUDV_SEQ.NEXTVAL, 1, v_doanh_thu, v_thang, v_nam, 
                CASE 
                    WHEN v_tong_doanh_thu > 0 THEN 
                        ROUND(v_doanh_thu * 100 / v_tong_doanh_thu, 2)
                    ELSE 0
                END, 
                madv_i);
   UPDATE BCDOANHTHUDV b
SET TyLe = CASE 
            WHEN (SELECT SUM(DoanhThu) 
                    FROM BCDOANHTHUDV 
                    WHERE THANG = b.THANG AND NAM = b.NAM) > 0 THEN 
                ROUND(b.DoanhThu * 100 / 
                        (SELECT SUM(DoanhThu) 
                         FROM BCDOANHTHUDV 
                         WHERE THANG = b.THANG AND NAM = b.NAM), 2)
            ELSE 0
          END
WHERE THANG = v_thang AND NAM = v_nam;

    -- Commit the transaction
    COMMIT;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('MA PHONG HIEN KHONG DUOC THUE ');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Loi: ' || SQLERRM);
END INSERT_DON_DV;
/



CREATE OR REPLACE TRIGGER trg_update_baocao
AFTER INSERT OR UPDATE ON THANHTOAN
FOR EACH ROW
DECLARE
   v_doanh_thu        NUMBER(19,2);
   v_so_lan_dat       NUMBER(9);
   v_ty_le            NUMBER(5,2);
   v_thang            NUMBER(2);
   v_nam              NUMBER(4);
   v_maloaiphg        VARCHAR2(10);
   v_doanh_thu_total  NUMBER(19,2);
   v_mabao_cao        NUMBER;     
BEGIN
   -- Lấy THANG, NAM, MALOAIPHG từ PHIEUDATPHONG theo MADATPHONG
   SELECT EXTRACT(MONTH FROM p.NGAYDAT), EXTRACT(YEAR FROM p.NGAYDAT), ph.MALOAIPHG
   INTO v_thang, v_nam, v_maloaiphg
   FROM PHIEUDATPHONG p
   JOIN CHITIETDATPHONG ct ON p.MADATPHONG = ct.MADATPHONG
   JOIN PHONG ph ON ct.MAPHG = ph.MAPHG
   LEFT JOIN HOADONDV hd ON hd.MADATPHONG = p.MADATPHONG AND hd.TINHTRANG = 1
   WHERE p.MADATPHONG = :NEW.MADATPHONG;

   -- Tính doanh thu cho loại phòng (Doanh thu = Tổng tiền thanh toán + phụ phí - giảm trừ)
   SELECT NVL(SUM(:NEW.ThanhTien + p.PHUPHI + p.TIENTRATRUOC - NVL(hd.THANHTIEN, 0)), 0)
   INTO v_doanh_thu
   FROM PHIEUDATPHONG p
   JOIN CHITIETDATPHONG ct ON p.MADATPHONG = ct.MADATPHONG
   JOIN PHONG ph ON ct.MAPHG = ph.MAPHG
   JOIN LOAIPHONG lp ON lp.MALOAIPHG = ph.MALOAIPHG
   LEFT JOIN HOADONDV hd ON hd.MADATPHONG = p.MADATPHONG AND hd.TINHTRANG = 1
   WHERE EXTRACT(MONTH FROM p.NGAYDAT) = v_thang
   AND EXTRACT(YEAR FROM p.NGAYDAT) = v_nam
   AND lp.MALOAIPHG = v_maloaiphg;

   -- Tính số lần đặt phòng cho loại phòng
   SELECT NVL(COUNT(*), 0)
   INTO v_so_lan_dat
   FROM PHIEUDATPHONG p
   JOIN CHITIETDATPHONG ct ON p.MADATPHONG = ct.MADATPHONG
   JOIN PHONG ph ON ct.MAPHG = ph.MAPHG
   WHERE EXTRACT(MONTH FROM p.NGAYDAT) = v_thang
   AND EXTRACT(YEAR FROM p.NGAYDAT) = v_nam
   AND ph.MALOAIPHG = v_maloaiphg;

   -- Tính tổng doanh thu cho tất cả các loại phòng trong tháng và năm
   SELECT NVL(SUM(:NEW.ThanhTien + p.PHUPHI + p.TIENTRATRUOC - NVL(hd.THANHTIEN, 0)), 0)
   INTO v_doanh_thu_total
   FROM PHIEUDATPHONG p
   JOIN CHITIETDATPHONG ct ON p.MADATPHONG = ct.MADATPHONG
   JOIN PHONG ph ON ct.MAPHG = ph.MAPHG
   JOIN LOAIPHONG lp ON lp.MALOAIPHG = ph.MALOAIPHG
   LEFT JOIN HOADONDV hd ON hd.MADATPHONG = p.MADATPHONG AND hd.TINHTRANG = 1
   WHERE EXTRACT(MONTH FROM p.NGAYDAT) = v_thang
   AND EXTRACT(YEAR FROM p.NGAYDAT) = v_nam;

   -- Tính tỷ lệ doanh thu theo loại phòng
   IF v_doanh_thu_total > 0 THEN
      v_ty_le := ROUND((v_doanh_thu * 100) / v_doanh_thu_total, 2);
   ELSE
      v_ty_le := 0;
   END IF;

   -- Lấy giá trị cho mã báo cáo
   v_mabao_cao := BCDOANHTHUPHONG_SEQ.NEXTVAL;

   -- Cập nhật hoặc chèn vào bảng BCDOANHTHUPHONG
   MERGE INTO BCDOANHTHUPHONG b
   USING (SELECT v_mabao_cao AS MaBaoCaoPhong, 
                 v_so_lan_dat AS SoLanDat, 
                 v_doanh_thu AS DoanhThu, 
                 v_thang AS THANG, 
                 v_nam AS NAM, 
                 v_ty_le AS TyLe, 
                 v_maloaiphg AS MALOAIPHG 
          FROM DUAL) src
   ON (b.THANG = src.THANG AND b.NAM = src.NAM AND b.MALOAIPHG = src.MALOAIPHG)
   WHEN MATCHED THEN
       UPDATE SET b.SoLanDat = src.SoLanDat,
                  b.DoanhThu = src.DoanhThu,
                  b.TyLe = src.TyLe
   WHEN NOT MATCHED THEN
       INSERT (MaBaoCaoPhong, SoLanDat, DoanhThu, THANG, NAM, TyLe, MALOAIPHG)
       VALUES (src.MaBaoCaoPhong, src.SoLanDat, src.DoanhThu, src.THANG, src.NAM, src.TyLe, src.MALOAIPHG);
END;
/



CREATE OR REPLACE TRIGGER trg_update_ty_le_baocao
AFTER INSERT OR UPDATE ON THANHTOAN
FOR EACH ROW
DECLARE
   v_thang    NUMBER(2);
   v_nam      NUMBER(4);
   v_tong_doanh_thu NUMBER;
BEGIN
   -- Lấy tháng và năm từ bản ghi vừa được thêm hoặc cập nhật
   SELECT EXTRACT(MONTH FROM p.NGAYDAT),
          EXTRACT(YEAR FROM p.NGAYDAT)
   INTO v_thang, v_nam
   FROM PHIEUDATPHONG p
   JOIN CHITIETDATPHONG ct ON p.MADATPHONG = ct.MADATPHONG
   JOIN PHONG ph ON ct.MAPHG = ph.MAPHG
   WHERE p.MADATPHONG = :NEW.MADATPHONG;

   -- Tính tổng doanh thu của tháng và năm
   SELECT NVL(SUM(DoanhThu), 0)
   INTO v_tong_doanh_thu
   FROM BCDOANHTHUPHONG
   WHERE THANG = v_thang AND NAM = v_nam;

   -- Cập nhật tỷ lệ cho tất cả các bản ghi trong tháng và năm đó
   UPDATE BCDOANHTHUPHONG b
   SET b.TyLe = CASE
                  WHEN v_tong_doanh_thu > 0 THEN 
                     ROUND(b.DoanhThu * 100 / v_tong_doanh_thu, 2)
                  ELSE 0
                END
   WHERE b.THANG = v_thang AND b.NAM = v_nam;

END;
/









