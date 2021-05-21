# POOB2_AC1Lab
#Author:  João Henrique de Freitas 
#RA: 190706 

JSON requirement for injection <POST>
    
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

"Event"

{ 
    "idAdmin": 1, 
    "idPlace": 1,
    "name": "Rock Festival",
    "desc": "Festival full of old school rock",
    "email": "RockFestival@ig.com",
    "startDate": "2022-03-20",
    "endDate": "2022-03-30",
    "startTime": "20:44:00.000",
    "endTime":  "06:30:00.000",
    "amountPayTickets": 500,
    "amountFreeTickets": 100,
    "priceTicket": 100
}
{
    "idAdmin": 3,
    "idPlace": 1,
    "name": "Casamento ",
    "descp": "Casamento dos backers",
    "email": "SalãoCas@ig.com",
    "std": "2022-03-30",
    "endate": "2030-03-04",
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
    "std": "2022-03-30",
    "endate": "2022-04-04",
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
