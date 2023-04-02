CREATE DATABASE IF NOT EXISTS LAYER_SHOP;

USE LAYER_SHOP;

drop table if exists users cascade;
drop table if exists orders cascade;
drop table if exists product cascade;
drop table if exists shipment_courier cascade;
drop table if exists shipment_region cascade;

create table users
(
    id         serial,
    username   varchar(255) not null,
    password   varchar(255) not null,
    is_enabled boolean      not null,
    primary key (id)
);

create table orders
(
    id                    serial,
    shipment_courier_name varchar(255)   not null,
    shipment_region       varchar(255)   not null,
    total_price           numeric(38, 2) not null,
    username              varchar(255)   not null,
    primary key (id)
);

create table product
(
    id       serial,
    name     varchar(255)   not null,
    price    numeric(38, 2) not null,
    quantity integer        not null,
    primary key (id)
);

create table shipment_courier
(
    id             serial,
    courier        varchar(255)   not null,
    courier_margin numeric(38, 2) not null,
    primary key (id)
);

create table shipment_region
(
    id              serial,
    region          varchar(255)   not null,
    shipment_margin numeric(38, 2) not null,
    primary key (id)
);

