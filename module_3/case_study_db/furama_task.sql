use furama_resort;

-- task1 Thêm mới thông tin cho tất cả các bảng có trong CSDL để có thể thoả mãn các yêu cầu bên dưới.

-- task 2 Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select* from nhan_vien where ho_ten like 'H%' or  ho_ten like 'T%' or  ho_ten like 'K%' and char_length(15);

-- task 3 Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * from khach_hang where tuoi between 18 and 50 and (dia_chi like '%Đà Nẵng%'or dia_chi like '%Quảng Trị%');

-- task 4 Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select k.ho_ten, h.ma_khach_hang, count(h.ma_khach_hang) as so_luong_dat_phong
from khach_hang k 
join hop_dong h on k.ma_khach_hang = h.ma_khach_hang 
join loai_khach l on k.ma_loai_khach = l.ma_loai_khach
where l.ten_loai_khach = 'Diamond'
group by h.ma_khach_hang
order by so_luong_dat_phong;

-- task 5 Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien 
-- (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, 
-- hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select kh.ma_khach_hang,kh.ho_ten,lk.ten_loai_khach,hd.ma_hop_dong,dv.ten_dich_vu,hd.ngay_lam_hop_dong,hd.ngay_ket_thuc,
    (ifnull(dv.chi_phi_thue,0) + ifnull(hdct.so_luong,0)  * ifnull(dvdk.gia,0)) as tong_tien
	from khach_hang kh 
	left join loai_khach lk on lk.ma_loai_khach = kh.ma_loai_khach 
	left join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
	left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
	left join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu 
	left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
	group by  hd.ma_hop_dong, kh.ma_khach_hang
	order by ma_khach_hang ;
    
    -- task 6 Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, 
    -- ten_loai_dich_vu của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
    select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, ldv.ten_loai_dich_vu, hd.ngay_lam_hop_dong
    from loai_dich_vu ldv
    join dich_vu dv on dv.ma_loai_dich_vu= ldv.ma_loai_dich_vu
    left join hop_dong hd on hd.ma_dich_vu= dv.ma_dich_vu
    where hd.ma_dich_vu not in (
    select hd.ma_dich_vu from hop_dong hd where (month(hd.ngay_lam_hop_dong) in(1,2,3)and year(hd.ngay_lam_hop_dong)=2021)
    )
	group by dv.ma_dich_vu;
    
    -- task 7 Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu 
    -- của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
    select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.so_nguoi_toi_da, dv.chi_phi_thue, ldv.ten_loai_dich_vu
    from loai_dich_vu ldv
    join dich_vu dv on dv.ma_loai_dich_vu=ldv.ma_loai_dich_vu
	left join hop_dong hd on hd.ma_dich_vu= dv.ma_dich_vu
	where hd.ma_dich_vu not in (select hd.ma_dich_vu from hop_dong hd where (year(hd.ngay_lam_hop_dong)=2021))
    and year(hd.ngay_lam_hop_dong)=2020
    group by dv.ma_dich_vu;
    

    -- task 8	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
	-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên
    -- Cách 1:
    select DISTINCT  ho_ten 
    from khach_hang;
    
    -- Cách 2
    select ho_ten
    from khach_hang
    group by ho_ten;
    
    -- Cách 3
    select ho_ten from khach_hang
    union
    select ho_ten from khach_hang;
    

-- task 9 Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select month(hd.ngay_lam_hop_dong) as thang, count(hd.ma_hop_dong)as so_luong_dat_phong
from hop_dong hd
 where (year(hd.ngay_lam_hop_dong)=2021)
 group by month(hd.ngay_lam_hop_dong)
 order by month(hd.ngay_lam_hop_dong);
 
 -- task 10 Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm.
 -- Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
    select hd.ma_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc, sum(hdct.so_luong) as so_luong_dich_vu_di_kem
from hop_dong hd 
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
group by hd.ma_hop_dong
order by hd.ma_hop_dong;

-- task 11 Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
    select dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, dvdk.gia, dvdk.don_vi, dvdk.trang_thai
    from dich_vu_di_kem dvdk 
    left join hop_dong_chi_tiet hdct on hdct.ma_dich_vu_di_kem=dvdk.ma_dich_vu_di_kem
    left join hop_dong hd on hd.ma_hop_dong=hdct.ma_hop_dong
    left join khach_hang kh on kh.ma_khach_hang=hd.ma_khach_hang
    left join loai_khach lk on lk.ma_loai_khach=kh.ma_loai_khach
    where lk.ten_loai_khach='Diamond' and ((kh.dia_chi like'%Vinh%')or (kh.dia_chi like '%Quảng Ngãi%'));
    
    -- task 12	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu, 
    -- so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem),
    -- tien_dat_coc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.
    select hd.ma_hop_dong, nv.ho_ten, kh.ho_ten, kh.so_dien_thoai, dv.ten_dich_vu, 
    ifnull(sum(hdct.so_luong),0) as so_luong_dich_vu_di_kem,
    hd.tien_dat_coc
    from hop_dong_chi_tiet hdct
     join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem=dvdk.ma_dich_vu_di_kem
    right join hop_dong hd on hd.ma_hop_dong=hdct.ma_hop_dong
     join dich_vu dv on dv.ma_dich_vu=hd.ma_dich_vu
     join khach_hang kh on kh.ma_khach_hang=hd.ma_khach_hang
     join nhan_vien nv on nv.ma_nhan_vien=hd.ma_nhan_vien
    where hd.ma_dich_vu not in( select dv.ma_dich_vu from dich_vu dv
     where quarter(ngay_lam_hop_dong)in(1,2)and year(ngay_lam_hop_dong)=2021)
     and quarter(ngay_lam_hop_dong)=4 and year(ngay_lam_hop_dong)=2020
	group by hd.ma_hop_dong;
    
    
 -- TASK 13	13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng.
 -- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
select dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, sum(hdct.so_luong) as so_luong_dich_vu_di_kem from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem 
join hop_dong hd on hd.ma_hop_dong = hdct.ma_hop_dong
group by  ma_dich_vu_di_kem
having (so_luong_dich_vu_di_kem)>= all(select  sum(hdct.so_luong) from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem 
join hop_dong hd on hd.ma_hop_dong = hdct.ma_hop_dong
group by  hdct.ma_dich_vu_di_kem
);


-- Task 14 Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).
select hd.ma_hop_dong, ldv.ten_loai_dich_vu, dvdk.ten_dich_vu_di_kem, count(dvdk.ma_dich_vu_di_kem) as so_lan_su_dung
from hop_dong hd
 join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
 join loai_dich_vu ldv on ldv.ma_loai_dich_vu = dv.ma_loai_dich_vu
 join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = hd.ma_hop_dong
 join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
 group by dvdk.ma_dich_vu_di_kem
having count(dvdk.ma_dich_vu_di_kem) = 1
order by hd.ma_hop_dong;

-- Task 15.	Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, 
-- so_dien_thoai, dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.
select nhan_vien.ma_nhan_vien, nhan_vien.ho_ten, trinh_do.ten_trinh_do, bo_phan.ten_bo_phan, nhan_vien.so_dien_thoai, nhan_vien.dia_chi, count(hop_dong.ma_nhan_vien) as so_lan_lam_hop_dong
from nhan_vien join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien 
join trinh_do on trinh_do.ma_trinh_do = nhan_vien.ma_trinh_do
join bo_phan on bo_phan.ma_bo_phan = nhan_vien.ma_bo_phan
where year(hop_dong.ngay_lam_hop_dong) in (2020,2021)
group by hop_dong.ma_nhan_vien
having count(hop_dong.ma_nhan_vien) <= 3
order by nhan_vien.ma_nhan_vien;
    
    
    -- Task 16 Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
    select nv.ma_nhan_vien, nv.ho_ten 
    from nhan_vien nv 
    left join hop_dong hd on hd.ma_nhan_vien=nv.ma_nhan_vien
    where nv.ma_nhan_vien not in (select nv.ma_nhan_vien 
    from nhan_vien nv 
    left join hop_dong hd on hd.ma_nhan_vien=nv.ma_nhan_vien 
    where  year(hd.ngay_lam_hop_dong) in (2019,2020,2021));

-- Task 17	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ
select kh.ma_khach_hang, kh.ho_ten, kh.ma_loai_khach, sum(dv.chi_phi_thue + hdct.so_luong * dvdk.gia) as tong_tien_thanh_toan
from loai_khach lk  
left join khach_hang kh on lk.ma_loai_khach=kh.ma_loai_khach
left join hop_dong hd on hd.ma_khach_hang=kh.ma_khach_hang
left join hop_dong_chi_tiet hdct on hdct.ma_hop_dong=hd.ma_hop_dong
left join dich_vu dv on dv.ma_dich_vu=hd.ma_dich_vu
left join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem=hdct.ma_dich_vu_di_kem  
where year(hd.ngay_lam_hop_dong)=2021 and lk.ten_loai_khach ='Platinium'
group by hd.ma_hop_dong
having sum(dv.chi_phi_thue + hdct.so_luong * dvdk.gia)>10000000;

-- Task 18 Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
select kh.ma_khach_hang, kh.ho_ten
from khach_hang kh
join hop_dong hd on hd.ma_khach_hang=kh.ma_khach_hang
where year(hd.ngay_lam_hop_dong) < 2021;

-- Task 19 Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
select dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, sum(hdct.so_luong) as so_lan_su_dung 
from dich_vu_di_kem dvdk
left join hop_dong_chi_tiet hdct on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
left join hop_dong hd on hd.ma_hop_dong=hdct.ma_hop_dong
where year(hd.ngay_lam_hop_dong)=2020
group by dvdk.ma_dich_vu_di_kem
having sum(hdct.so_luong)>10;

-- Task 20 Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, 
-- thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi
select nv.ma_nhan_vien, nv.ho_ten, nv.email, nv.so_dien_thoai, nv.ngay_sinh, nv.dia_chi 
from nhan_vien nv
union all
select kh.ma_khach_hang, kh.ho_ten, kh.email, kh.so_dien_thoai, kh.ngay_sinh, kh.dia_chi 
from khach_hang kh;

-- Task 21 Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Đà Nẵng” 
-- và đã từng lập hợp đồng cho một hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “04/2021”.
create view v_nhan as 
select nv.ma_nhan_vien, nv.ho_ten, nv.ngay_sinh, nv.so_cmnd, nv.so_dien_thoai, nv.email, nv.dia_chi, nv.ma_vi_tri, nv.ma_trinh_do, nv.ma_bo_phan
from nhan_vien nv
join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
where nv.dia_chi like '% Đà Nẵng' and (year(hd.ngay_lam_hop_dong)=2021 and month(hd.ngay_lam_hop_dong)=04);

select * from v_nhan_vien;


-- Task 22 Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn này.
SET SQL_SAFE_UPDATES = 0;
update v_nhan_vien vnv set  vnv.dia_chi = 'Liên Chiểu' ;
select * from v_nhan_vien vnv;

-- Task 23 Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của một khách hàng nào đó với 
-- ma_khach_hang được truyền vào như là 1 tham số của sp_xoa_khach_hang.
delimiter //
create procedure p_xoa_khach_hang(in p_code int)
begin
delete from khach_hang kh where kh.ma_khach_hang = p_code;
end //
delimiter ;

SET SQL_SAFE_UPDATES = 0;
call p_xoa_khach_hang(2);

-- Task 24	Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới vào bảng hop_dong với yêu cầu sp_them_moi_hop_dong 
-- phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.
delimiter //
create procedure p_them_khach_hang(in p_id int, p_ho_ten varchar(45), p_ngay_sinh date, p_gioi_tinh bit(1), p_so_cmnd varchar(45), 
p_so_dien_thoai varchar(45), p_email varchar(45), p_dia_chi varchar(45), p_ma_loai_khach int, p_tuoi int)
begin
insert into khach_hang value(p_id, p_ho_ten, p_ngay_sinh, p_gioi_tinh, p_so_cmnd, p_so_dien_thoai, p_dia_chi, p_email, p_ma_loai_khach, p_tuoi) ;
end //
delimiter ;
call p_them_khach_hang(11,'Nguyễn Hoàng Long','1980-10-22',0,'328631213',
		'0945403265','hoanglong02@gmail.com',
		'24 Nguyễn Hoàng, Đà Nẵng',4,25);
        
  -- Task 25 Tạo Trigger có tên tr_xoa_hop_dong khi xóa bản ghi trong bảng hop_dong thì hiển thị tổng 
  -- số lượng bản ghi còn lại có trong bảng hop_dong ra giao diện console của database.
 SET SQL_SAFE_UPDATES = 0;
 delete from khach_hang kh where kh.ma_khach_hang = 11 ;
 DELIMITER //
CREATE TRIGGER tr_khach_hang 
AFTER DELETE ON hop_dong 
FOR EACH ROW
BEGIN
insert into `history`(old_ma_hop_dong, old_ma_nhan_vien, old_ma_khach_hang, old_ma_dich_vu) 
values ( old.`ma_hop_dong`, old.`ma_nhan_vien`,old.`ma_khach_hang`, old.`ma_dich_vu`);
END //
DELIMITER ;
  select *, count(kh.ma_khach_hang) as so_luong, sum(kh.so_luong) as tong
  from khach_hang kh
  group by kh.ma_khach_hang;
  
  
  -- 26 Tạo Trigger có tên tr_cap_nhat_hop_dong khi cập nhật ngày kết thúc hợp đồng,
  -- cần kiểm tra xem thời gian cập nhật có phù hợp hay không, với quy tắc sau: Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày. Nếu dữ liệu hợp lệ thì 
  -- cho phép cập nhật, nếu dữ liệu không hợp lệ thì in ra thông báo “Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày” trên console của database.
 -- Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc ghi ở console.

SELECT DATE_SUB('2019-03-29', INTERVAL 2019-03-17 DAY);
SELECT DATEDIFF(year, '2017/08/25', '2011/08/25') AS DateDiff;

