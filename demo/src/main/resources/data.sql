INSERT INTO tb_user(id, name, email) VALUES (1, 'Lady Dimitrescu', 'Dimitrescu@ig.com' );
INSERT INTO tb_user(id, name, email) VALUES (2, 'Ada Wong', 'AdaWong@gmail.com');
INSERT INTO tb_user(id, name, email) VALUES (3, 'Leon S. Kennedy', 'LeonSKennedy@hotmail.com');
INSERT INTO tb_user(id, name, email) VALUES (4, 'Ethan Winthers', 'EthanWin@ig.com' );
INSERT INTO tb_user(id, name, email) VALUES (5, 'Albert Wesker', 'Albertinho@gmail.com');
INSERT INTO tb_user(id, name, email) VALUES (6, 'Salazar', 'SalazarPrince@hotmail.com');


INSERT INTO tb_admin(user_id, phone_number) VALUES (1, '5000-5500' );
INSERT INTO tb_admin(user_id, phone_number) VALUES (2, '5000-5000' );
INSERT INTO tb_admin(user_id, phone_number) VALUES (3, '5000-6000' );


INSERT INTO tb_attend(user_id, balance) VALUES (4, 1300.00 );
INSERT INTO tb_attend(user_id, balance) VALUES (5, 1000.00 );
INSERT INTO tb_attend(user_id, balance) VALUES (6, 2000.00 );

INSERT INTO tb_event( id, name, descp, email, std, end_date, amount_free_tickets, amount_pay_tickets, price_ticket, start_time, end_time, admin_user_id) VALUES (1, 'Rosemary baby', 'Village ritual', 'Aniver@gmail.com', '2022-03-30', '2022-03-04', 20, 30, 100.00, '06:30:00', '10:00:00', 1);
INSERT INTO tb_event( id, name, descp, email, std, end_date, amount_free_tickets, amount_pay_tickets, price_ticket, start_time, end_time, admin_user_id) VALUES (2, 'Lollapalooza', 'Music Festival', 'lolla@gmail.com', '2023-05-30', '2023-05-04', 100, 1000, 500.00, '06:30:00', '23:59:00', 2);
INSERT INTO tb_event( id, name, descp, email, std, end_date, amount_free_tickets, amount_pay_tickets, price_ticket, start_time, end_time, admin_user_id) VALUES (3, 'Rock in Rio', 'Music Festival', 'RockRio@gmail.com', '2024-05-30', '2024-05-04', 100, 1000, 500.00, '06:30:00', '23:59:00', 3);

INSERT INTO tb_place(id, name, address) VALUES (1, 'Palacio da alvorada', 'Rua Alvared - 35');
INSERT INTO tb_place(id, name, address) VALUES (2, 'Autodromo Interlargos', 'Rua Interlagos - 100');
INSERT INTO tb_place(id, name, address) VALUES (3, 'Vila Olimpica', 'Rua Olipiadas - 100');

INSERT INTO tb_ticket(id, type, date, price) VALUES (1, 1, '2022-03-30', 100.00);
INSERT INTO tb_ticket(id, type, date, price) VALUES (2, 1, '2022-03-30', 100.00);
INSERT INTO tb_ticket(id, type, date, price) VALUES (3, 1, '2022-03-30', 100.00);
