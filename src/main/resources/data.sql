insert into ads (title, price, horse_power, sell_or_search, year_of_manufact)
values ('Ad1', 20, 150, true, 1980);
insert into ads (title, price, horse_power, sell_or_search, year_of_manufact)
values ('Ad2', 30, 3, false, 2019);
insert into ads (title, price, horse_power, sell_or_search, year_of_manufact)
values ('Ad2', 220, 1150, true, 1994);

insert into users(email, enabled, password, fullname)
values('joe@doe.com', true, 'joepass', 'Joe Doe');
insert into users(email, enabled, password, fullname)
values('jane@doe.com', false, 'janepass', 'Jane Doe');
insert into users(email, enabled, password, fullname)
values('king@kong.com', true, 'kingkongpass', 'King Kong');

insert into categories(category_name) values ('Tractor');
insert into categories(category_name) values ('Tyre');
insert into categories(category_name) values ('Cultivator');
insert into categories(category_name) values ('Other');

insert into roles(role) values ('GLOBAL_ADMIN');
insert into roles(role) values ('LOGGED_IN_USER');
insert into roles(role) values ('NOT_LOGGET_IN_USER');
insert into roles(role) values ('ADMIN');