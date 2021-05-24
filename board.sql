create table tbl_board(
	idx int not null auto_increment, -- 자동증가컬럼(1,2,3....)
	title varchar (100) not null,
	contents varchar (4000) not null,
	writer varchar (50) not null,
	count int default 0,
	indate datetime not null default now(),
	primary key(idx)
);
-- 저장
insert into tbl_board (title, contents, writer) 
values('게시판 테스트','게시판 테스트','관리자');
insert into tbl_board (title, contents, writer) 
values('게시판 테스트','게시판 테스트','홍길동');
insert into tbl_board (title, contents, writer) 
values('게시판 테스트','게시판 테스트','이대교');

select idx, title, contents,writer, DATE_FORMAT(indate,'%Y-%m-%d') AS indate from tbl_board; 