-- we don't know how to generate schema taotao (class Schema) :(
create table tb_content
(
	id bigint auto_increment
		primary key,
	category_id bigint not null comment '内容类目ID',
	title varchar(200) null comment '内容标题',
	sub_title varchar(100) null comment '子标题',
	title_desc varchar(500) null comment '标题描述',
	url varchar(500) null comment '链接',
	pic varchar(300) null comment '图片绝对路径',
	pic2 varchar(300) null comment '图片2',
	content text null comment '内容',
	created datetime null,
	updated datetime null
)
charset=utf8
;

create index category_id
	on tb_content (category_id)
;

create index updated
	on tb_content (updated)
;

create table tb_content_category
(
	id bigint auto_increment comment '类目ID'
		primary key,
	parent_id bigint null comment '父类目ID=0时，代表的是一级的类目',
	name varchar(50) null comment '分类名称',
	status int(1) default '1' null comment '状态。可选值:1(正常),2(删除)',
	sort_order int(4) null comment '排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数',
	is_parent tinyint(1) default '1' null comment '该类目是否为父类目，1为true，0为false',
	created datetime null comment '创建时间',
	updated datetime null comment '创建时间'
)charset=utf8
;

create index parent_id
	on tb_content_category (parent_id, status)
;

create index sort_order
	on tb_content_category (sort_order)
;

create table tb_item
(
	id bigint not null comment '商品id，同时也是商品编号'
		primary key,
	title varchar(100) not null comment '商品标题',
	sell_point varchar(500) null comment '商品卖点',
	price bigint not null comment '商品价格，单位为：分',
	num int(10) not null comment '库存数量',
	barcode varchar(30) null comment '商品条形码',
	image varchar(500) null comment '商品图片',
	cid bigint(10) not null comment '所属类目，叶子类目',
	status tinyint default '1' not null comment '商品状态，1-正常，2-下架，3-删除',
	created datetime not null comment '创建时间',
	updated datetime not null comment '更新时间'
)
charset=utf8
;


create table tb_item_cat
(
	id bigint auto_increment comment '类目ID'
		primary key,
	parent_id bigint null comment '父类目ID=0时，代表的是一级的类目',
	name varchar(50) null comment '类目名称',
	status int(1) default '1' null comment '状态。可选值:1(正常),2(删除)',
	sort_order int(4) null comment '排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数',
	is_parent tinyint(1) default '1' null comment '该类目是否为父类目，1为true，0为false',
	created datetime null comment '创建时间',
	updated datetime null comment '创建时间'
) charset=utf8
;


create table tb_item_desc
(
	item_id bigint not null comment '商品ID'
		primary key,
	item_desc text null comment '商品描述',
	created datetime null comment '创建时间',
	updated datetime null comment '更新时间'
)
charset=utf8
;

create table tb_item_param
(
	id bigint auto_increment
		primary key,
	item_cat_id bigint null comment '商品类目ID',
	param_data text null comment '参数数据，格式为json格式',
	created datetime null,
	updated datetime null
)
 charset=utf8
;


create table tb_item_param_item
(
	id bigint auto_increment
		primary key,
	item_id bigint null comment '商品ID',
	param_data text null comment '参数数据，格式为json格式',
	created datetime null,
	updated datetime null
)
 charset=utf8
;



create table tb_order
(
	order_id varchar(50) default '' not null comment '订单id'
		primary key,
	payment varchar(50) null comment '实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分',
	payment_type int(2) null comment '支付类型，1、在线支付，2、货到付款',
	post_fee varchar(50) null comment '邮费。精确到2位小数;单位:元。如:200.07，表示:200元7分',
	status int(10) null comment '状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭',
	create_time datetime null comment '订单创建时间',
	update_time datetime null comment '订单更新时间',
	payment_time datetime null comment '付款时间',
	consign_time datetime null comment '发货时间',
	end_time datetime null comment '交易完成时间',
	close_time datetime null comment '交易关闭时间',
	shipping_name varchar(20) null comment '物流名称',
	shipping_code varchar(20) null comment '物流单号',
	user_id bigint null comment '用户id',
	buyer_message varchar(100) null comment '买家留言',
	buyer_nick varchar(50) null comment '买家昵称',
	buyer_rate int(2) null comment '买家是否已经评价'
)charset=utf8
;


create table tb_order_item
(
	id varchar(20) not null
		primary key,
	item_id varchar(50) not null comment '商品id',
	order_id varchar(50) not null comment '订单id',
	num int(10) null comment '商品购买数量',
	title varchar(200) null comment '商品标题',
	price bigint(50) null comment '商品单价',
	total_fee bigint(50) null comment '商品总金额',
	pic_path varchar(200) null comment '商品图片地址'
)
charset=utf8
;

create table tb_order_shipping
(
	order_id varchar(50) not null comment '订单ID'
		primary key,
	receiver_name varchar(20) null comment '收货人全名',
	receiver_phone varchar(20) null comment '固定电话',
	receiver_mobile varchar(30) null comment '移动电话',
	receiver_state varchar(10) null comment '省份',
	receiver_city varchar(10) null comment '城市',
	receiver_district varchar(20) null comment '区/县',
	receiver_address varchar(200) null comment '收货地址，如：xx路xx号',
	receiver_zip varchar(6) null comment '邮政编码,如：310001',
	created datetime null,
	updated datetime null
)
charset=utf8
;

create table tb_user
(
	id bigint auto_increment
		primary key,
	username varchar(50) not null comment '用户名',
	password varchar(32) not null comment '密码，加密存储',
	phone varchar(20) null comment '注册手机号',
	email varchar(50) null comment '注册邮箱',
	created datetime not null,
	updated datetime not null,
	constraint username
		unique (username),
	constraint phone
		unique (phone),
	constraint email
		unique (email)
)
charset=utf8
;

