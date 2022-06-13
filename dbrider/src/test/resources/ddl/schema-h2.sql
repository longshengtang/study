CREATE TABLE IF NOT EXISTS `system_log` (
`id` int NOT NULL AUTO_INCREMENT,
`menu_id` int DEFAULT NULL,
`operation_id` int DEFAULT NULL,
`content` varchar(255) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8mb4;

create table if not exists eoa_task
(
    id               int auto_increment
        primary key,
    task_name        varchar(255) not null ,
    task_detail_list varchar(255) null,
    status           int          null,
    created_by       varchar(255) null,
    created_date     datetime     null
);

