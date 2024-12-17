# System ERP wspomagający zarządzanie produkcją dla przedsiębiorstwa z sektora MŚP

## Opis:

W dzisiejszych czasach przedsiębiorstwa produkcyjne coraz częściej muszą mierzyć się
z konkurencją innych firm z branży. Ze względu na globalizację i rozwój technologiczny,
konieczność rywalizacji z przedsiębiorstwami zagranicznymi staje się coraz bardziej powszechna.
Również na naszym rynku jak pokazuje raport Głównego Urzędu statystycznego liczba
przedsiębiorstw niefinansowych w Polsce w latach 2010 do 2021 zwiększyła się o około 36,4%.
Aby nie zostać w tyle, przedsiębiorcy wymyślają różne sposoby na poprawę wydajności
i zmniejszenie kosztów produkcji.

Jednym z efektywnych rozwiązań są systemy wspomagające zarządzanie produkcją, które
pomagają w planowaniu i monitorowaniu procesów produkcyjnych. Niemniej jednak,
wprowadzenie takiego systemu często napotyka na liczne trudności. Jednym z problemów jest
potrzeba indywidualnego wprowadzania takiego systemu dla każdej z firmy. Skutkiem tego jest
często wysoka cena, jaką trzeba przeznaczyć na tę inwestycję. Inna trudność, jaka się pojawia to
czas potrzebny na wprowadzenie takiego rozwiązania. Im większy i bardziej skomplikowany
system, tym więcej czasu straci przedsiębiorstwo.

Aby rozwiązać, chociaż część z tych problemów powstała ta praca, której celem jest
opracowanie projektu aplikacji wspomagającej zarządzanie produkcją w mniejszych i średnich
przedsiębiorstwach. Z założenia aplikacja ma być uniwersalna, prosta i intuicyjna w obsłudze.
Powinno to w znacznym stopniu przyspieszyć wdrażanie do firmy nowego systemu. Dane
rozwiązanie będzie także darmowe i w języku polskim, co dla wielu też będzie dużym atutem.
System będzie wykonany w formie aplikacji webowej, co pozwoli zwiększyć liczbę urządzeń, które
będą mogły z niego korzystać. Głównym zadaniem aplikacji będzie zarządzanie oraz
monitorowanie zleceń produkcyjnych. Osoba odpowiedzialna za konkretne zlecenie
w przedsiębiorstwie będzie mogła przydzielać wybrane zadania pracownikom. Kierownik
i pracownicy będą posiadali różne interfejsy, pozwalające wykonywać im różne czynności,
odpowiednie do stanowiska, jakie pełnią. Wszystkie istotne informacje potrzebne do działania
aplikacji będą przechowywane na serwerze w bazie danych.


## Typ aplikacji:
- back-end


## Zastosowane technologie:
- Java 17
- Spring Boot (wersja - 3.0.5)
- Baza Danych PostgreSql

## Jak uruchomić aplikację:
- Zainstalować Java 17
- Utworzyć baze danych PostgreSQL
- Dodać do projektu ścieżke do Javy
- Zaktualizować plik `application.yaml`, ścieżka `src->main->resources` o dane z DB, takie 
jak: url bazy, nazwe użytkownika oraz hasło:
  ```yaml
  url: jdbc:postgresql://localhost:5432/test_03
  username: myusername
  password: mypassword
  ```

## Uwagi:
- Brak komentarzy w kodzie na prośbę promotora
- Do uruchomienia bazy danych oraz aplikacji warto użyć `Dockera`
- Gdby występowały problemy z Javą, można spróbować na wersji Java 21
- Domyślny użytkownik:
  ```yaml
  username: admin
  password: admin
  ```