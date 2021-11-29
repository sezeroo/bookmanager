-- call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (1, 'Jay', 'sezero@innotree.com', now(), now());

-- call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (2, 'rose', 'rose@naver.com', now(), now());

-- call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (3, 'gyuri', 'gyuri@daum.net', now(), now());

-- call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (4, 'dohyeon', 'sky@naver.com', now(), now());

-- call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (5, 'Jay', 'Jay@instagram.com', now(), now());

insert into publisher(`id`,`name`) values (1,'패스트캠퍼스');

insert into book(`id`,`name`,`publisher_id`,`deleted`,`status`) values (1,'JPA 초격차패키지',1,false,100);

insert into book( `id`,`name`,`publisher_id`,`deleted`,`status`) values (2, 'Spring Security 초격차 패키지',1,false,200);

insert into book(`id`,`name`,`publisher_id`,`deleted`,`status`) values (3, 'SpringBoot 올인원 패키지',1,true,100);

insert into review(`id`,`title`,`content`,`score`,`user_id`,`book_id`) values (1,'재미있읍니다','꼭 보세요!!',5.0,1,1);

insert into review(`id`,`title`,`content`,`score`,`user_id`,`book_id`) values (2,'진도가너무 빨라요','조금별로였어요',3.0,2,2);

insert into comment(`id`,`comment`,`review_id`)values(1,'저도 좋았읍니다.',1);

insert into comment(`id`,`comment`,`review_id`)values(2,'저는 별로였는데요.',1);

insert into comment(`id`,`comment`,`review_id`)values(3,'저도 그냥그랬어요.',2);
