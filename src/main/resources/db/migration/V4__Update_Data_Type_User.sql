alter table user
    modify overview varchar(1000) charset utf8mb3 null;

alter table user
    modify country nvarchar(20) null;

