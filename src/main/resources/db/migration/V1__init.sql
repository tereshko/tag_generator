create table sections (
                          id             BIGSERIAL primary key,
                          sections       varchar(255)
);

create table tags (
                          id             BIGSERIAL primary key,
                          tag            varchar(255),
                          sections       bigint not null references sections(id)
);