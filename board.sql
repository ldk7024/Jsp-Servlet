create table tbl_board(
	idx int not null auto_increment, -- 자동증가컬럼(1,2,3....)
	title varchar (100) not null,
	contents varchar (4000) not null,
	writer varchar (50) not null,
	count int default 0,
	indate datetime not null default now(),
	primary key(idx)
);
create table tbl_user(
	user_id varchar(30) not null,
	user_name varchar(30) not null,
	password varchar(30) not null,
	primary key(user_id)
);

insert into tbl_user values('admin','관리자', 'admin');
insert into tbl_user values('ldk7024','이대교', '0000');
insert into tbl_user values('guest','박형민', '1234');
insert into tbl_user values('adad','남세영', '5555');
insert into tbl_user values('gwangohu','이명진', '1234');
select * from tbl_user
-- 저장
insert into tbl_board (title, contents, writer) 
values('게시판 테스트','게시판 테스트','관리자');
insert into tbl_board (title, contents, writer) 
values('게시판 테스트','게시판 테스트','홍길동');
insert into tbl_board (title, contents, writer) 
values('게시판 테스트','게시판 테스트','이대교');

select * from tbl_board;

select idx, title, contents,writer, DATE_FORMAT(indate,'%Y-%m-%d') AS indate from tbl_board; 