# Aplikacja do zarządzania produkcją back-end

## Jak uruchomić aplikację:
- Zainstalować Java 17
- Utworzyć baze danych PostgreSQL
- Dodać do projektu ścieżke do Javy
- Zaktualizować plik application.yaml, ścieżka src->main->resources o dane z bazy takie 
jak url bazy, nazwe użytkownika oraz hasło

### url: jdbc:postgresql://localhost:5432/test_03
### username: myusername
### password: mypassword

## Uwagi:
### Ja do uruchomienia bazy danych użyłem aplikacji Docker
### Gdby występowały problemy z Javą, można spróbować na wersji Java 21