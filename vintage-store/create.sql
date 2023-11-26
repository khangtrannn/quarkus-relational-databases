create sequence t_artists_SEQ start with 1 increment by 50;
create sequence t_customers_SEQ start with 1 increment by 50;
create sequence t_items_SEQ start with 1 increment by 50;
create sequence t_publishers_SEQ start with 1 increment by 50;
create sequence t_purchase_order_line_SEQ start with 1 increment by 50;
create sequence t_purchase_orders_SEQ start with 1 increment by 50;
create sequence t_tracks_SEQ start with 1 increment by 50;
create table t_artists (created_date timestamp(6) with time zone, id bigint not null, name varchar(100) not null, bio varchar(3000), primary key (id));
create table t_customers (created_date timestamp(6) with time zone not null, id bigint not null, first_name varchar(50) not null, last_name varchar(50) not null, e_mail varchar(255) not null, primary key (id));
create table t_items (nb_of_pages integer, price numeric(38,2) not null, publication_date date, artist_fk bigint, created_date timestamp(6) with time zone not null, id bigint not null, publisher_fk bigint, isbn varchar(15), language varchar(20) check (language in ('ENGLISH','FRENCH','SPANISH','PORTUGUESE')), DTYPE varchar(31) not null, genre varchar(100), title varchar(100) not null, description varchar(3000), music_company varchar(255), primary key (id));
create table t_publishers (created_date timestamp(6) with time zone not null, id bigint not null, name varchar(50) not null, primary key (id));
create table t_purchase_order_line (quantity integer not null, created_date timestamp(6) with time zone not null, id bigint not null, item_fk bigint, purchase_order_fk bigint, primary key (id));
create table t_purchase_orders (purchase_order_date date not null, created_date timestamp(6) with time zone not null, customer_fk bigint, id bigint not null, primary key (id));
create table t_tracks (duration numeric(21,0) not null, cd_fk bigint, created_date timestamp(6) with time zone not null, id bigint not null, title varchar(255) not null, primary key (id));
alter table if exists t_items add constraint FKr3152tukbog585dik5qwonldg foreign key (artist_fk) references t_artists;
alter table if exists t_items add constraint FKi6lqpcqfnc4dtsp9w473p5kkj foreign key (publisher_fk) references t_publishers;
alter table if exists t_purchase_order_line add constraint FKk5o0lynwj3vddwn397a24kwqj foreign key (item_fk) references t_items;
alter table if exists t_purchase_order_line add constraint FKffbfk27356l55yt28wd7w8mwp foreign key (purchase_order_fk) references t_purchase_orders;
alter table if exists t_purchase_orders add constraint FK93wd2w995ng3vyj51y4fur1hg foreign key (customer_fk) references t_customers;
alter table if exists t_tracks add constraint FK23u6r10m0dkp0m8t5hr40ilux foreign key (cd_fk) references t_items;