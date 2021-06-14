create table userTbl(
	user_id varchar(30) not null,
	user_name varchar(30) not null,
	password varchar(30) not null,
	primary key(user_id)
);

insert into userTbl values('admin','관리자', 'admin');
insert into userTbl values('bitcocom','홍길동', '12345');
insert into userTbl values('guest','사용자', '12345');


select * from userTbl;