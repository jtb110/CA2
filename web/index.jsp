<%-- 
    Document   : index
    Created on : 09-10-2015, 12:29:15
    Author     : Jonas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

     
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <br><br><br>
        Enter search by id, name, company etc.
        <input type="search" >
        <input type="button" value="Search"
        <br><br><br>
    </center>
        
     <center>
         <br><br><br><br><br><br><br><br><br>
         Login here to add, edit or delete persons/companies.
	  <form method="post" action="j_security_check">
            <input type="text" name="j_username" required>
            <input type="password" name="j_password" required>
            <input type="submit" value="Login" >
            <br>
            indledning:

Vi har desværre ikke kunnet nå at lave særlig meget, da vi kom dårligt fra start. vi havde valgt at oprette vores tabeller først
hvorefter vi omdannede dem til entiteter i java. Dette gav os mange problemer fremover, og da lærehjælpen var lav,
fandt vi først ud af dette sent i processen. Da anden dagen var gået, valgte vi derfor at starte forfra, 
og lave entiteterne i java og omdanne dem til tabeller. Dette gjorde at vi havde meget pres på og ikke kunne nå så meget.

Rest API og Jason:

Vi har lavet en klasse som skal håndtere vores objekter og omdanne dem til json objekter, og den anden vej rundt.
Klassen JSONConverter modtager objekter og Strenge og omdanner dem til henholdsvis json objekter eller java objekter.
Dette har vi gjort så vi kan adskille konvertering fra koden.
Vi har kun nået at lave et api over Person, da vi kom dårligt fra start. Vores api bruger mest vores JSONConverter til at,
omdanne det input den får om til json, og returnere det som json. Vi havde tænkt os at lave et api til Company, men det kunne vi ikke nå.

vi har også lavet en kontrol klasse, som her mest var til at lave test med, og senere også skulle bruges til at lave rest api
færdigt. denne kontrol klasse indeholder de metoder som går på databasen.

Hvem gjorde hvad:
Vi har været meget lige om det hele, og stort set arbejdet ved en computer hele forløbet. vi føler at alle burde få 5 point


Test:

Vi har ikke nået at lave test. Vi havde tænkt os at lave junit tests, hvor vi kunne teste på vores metoder i kontrol klassen¨
vi ville også bruge postman, til at teste om hjemmesiden fungere, og om vores api overholder Protokollen.


Arv:

Vi har valgt at bruge Joined arv på vores infoentity. da vi mente at det ville være det bedste, da company og person,
ikke har spor mange relationer i forhold til attributter. dette gør at vi kan tilgå dem uden at få alt for mange null kolonner,
og at vi samtidig nemt kan skælne mellem person og company.
infoentity har et id og en email, som både person og company arver.

hvordan i tester systemet:

Vi har desværre ikke nået at lave et færdigt program at teste på, så det er ikke muligt at teste programmet.
Vi beklager selvfølgelig dette meget, men vi har ikke kunne nå at lave det færdig og brugbart, eftersom vi ikke havde en database før 3 dagen.

     </center>
      
        </form>
    </body>
</html>
