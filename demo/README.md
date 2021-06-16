# POOB2_AC1Lab
#Author:  João Henrique de Freitas 
#RA: 190706 

JSON requirement for injection <POST>
    
    "Admins"

{ 
    "name": "Jojis",
    "email": "jojis@ig.com", 
    "phoneNumber": "6666-4445"
}

{ 
    "name": "Eren",
    "email": "Jaeger@ig.com", 
    "phoneNumber": "5555-4445"
}

{ 
    "name": "Levi",
    "email": "Levi@ig.com", 
    "phoneNumber": "9999-4445"
}

    "Attendees"

{ 
    "name": "Martin",
    "email": " martin@ig.com", 
    "balance": 5555.44
}
{ 
    "name": "Ethan",
    "email": "ethan@ig.com", 
    "balance": 5555.44
}
{ 
    "name": "Mia",
    "email": "mia@ig.com", 
    "balance": 100.44
}

    "Event"

{ 
    "idAdmin": 2,
    "name": "Rock Festival",
    "descp": "Festival full of old school rock",
    "email": "RockFestival@ig.com",
    "std": "2070-06-21",
    "endDate": "2080-06-29",
    "startTime": "09:30:00",
    "endTime":  "19:30:00",
    "amountPayTickets": 500,
    "amountFreeTickets": 100,
    "priceTicket": 300
}
{
    "idAdmin": 3,
    "name": "Casamento ",
    "descp": "Casamento dos backers",
    "email": "SalãoCas@ig.com",
    "std": "2022-03-30",
    "endDate": "2030-03-04",
    "startTime": "06:30:00.000",
    "endTime":  "22:30:00.000",
    "amountPayTickets": 50,
    "amountFreeTickets": 100,
    "priceTicket": 50
}

{
    "idAdmin": 3,
    "name": "Aniversario ",
    "descp": "Aniversario infantil do Ethan",
    "email": "SalãoAni@ig.com",
    "std": "2022-03-30",
    "endDate": "2030-03-04",
    "startTime": "06:30:00.000",
    "endTime":  "22:30:00.000",
    "amountPayTickets": 0,
    "amountFreeTickets": 200,
    "priceTicket": 50
}

    "PLACES"

{
    "idEvent": 1,
    "name": "Salão Redfield",
    "address": "Raccon City - 188"
}
{
    "idEvent": 1,
    "name": "Dimetrescu Castle",
    "address": "Romenia - 666"
}
{
    "idEvent": 2,
    "name": "Ultra Fest",
    "address": "Belgium - 111" 
}

    "TICKETS"
{
    "idAttend": 4,
    "type": "FREE"
}
{
    "idAttend": 4,
    "type": "PAID"
}
{
    "idAttend": 5,
    "type": "FREE"
}
    
{
    "idAttend": 5,
    "type": "PAID"
}
    
{
    "idAttend": 6,
    "type": "FREE"
}
    
{
    "idAttend": 6,
    "type": "PAID"
}
