-- INSERT INTO tb_admin(name, email, phone_number)
-- VALUES
-- (
--         "Lady Dimitrescu",
--         "Dimitrescu@ig.com",
--         "5000-5500"
-- );
-- INSERT INTO tb_attend(name, email, balance)
-- VALUES
-- (
--         "Ada",
--         "AdaWaller@gmail.com",
--         10000.00
-- );
INSERT INTO tb_event(
        name, descp, email, std, endate, amount_free_tickets, amount_pay_tickets, price_ticket, start_time, end_time
) 
VALUES 
(
        'Rosemary baby',
        'Village ritual',
        'Aniver@gmail.com',
        '2022-03-30',
        '2022-03-04',
        20,
        30,
        100.00,
        '06:30:00',
        '10:00:00'
);

INSERT INTO tb_event(
        name, descp, email, std, endate, amount_free_tickets, amount_pay_tickets, price_ticket, start_time, end_time
) 
VALUES 
(
        'Lollapalooza',
        'Music Festival',
        'lolla@gmail.com',
        '2023-05-30',
        '2023-05-04',
        100,
        1000,
        500.00,
        '06:30:00',
        '23:59:00'
);

INSERT INTO tb_place(name, address)
VALUES
(
        'Palacio da alvorada',
        'Rua Alvared - 35'

);
