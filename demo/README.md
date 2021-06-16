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
    "idAdmin": 1, 
    "idPlace": 1,
    "name": "Rock Festival",
    "descp": "Festival full of old school rock",
    "email": "RockFestival@ig.com",
    "std": "2070-06-21",
    "endate": "2080-06-29",
    "startTime": "09:30:00",
    "endTime":  "19:30:00",
    "amountPayTickets": 500,
    "amountFreeTickets": 100,
    "priceTicket": 100
}
{
    "idAdmin": 1,
    "idPlace": 1,
    "name": "Casamento ",
    "descp": "Casamento dos backers",
    "email": "SalãoCas@ig.com",
    "std": "2023-03-30",
    "endate": "2023-04-04",
    "startTime": "06:30:00.000",
    "endTime":  "22:30:00.000",
    "amountPayTickets": 50,
    "amountFreeTickets": 100,
    "priceTicket": 50
}
{
    "idAdmin": 3,
    "idPlace": 2,
    "name": "Aniversario ",
    "descp": "Aniversario infantil do Ethan",
    "email": "SalãoAni@ig.com",
    "std": "2024-03-30",
    "endate": "2024-04-04",
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
