create table if not exists eoa_task
(
    id               int auto_increment
        primary key,
    task_name        varchar(255) null,
    task_detail_list varchar(255) null,
    status           int          null,
    created_by       varchar(255) null,
    created_date     datetime     null
);