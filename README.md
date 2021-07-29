# cantico-be

## Requisiti
* CanticoIDM
* PostgreSQL (lo stesso che usa CanticoIDM)

## docker
L'immagine docker può essere personalizzata attraverso le seguenti variabili d'ambiente

* `SPRING_DATASOURCE_URL` Stringa di connessione al database (JDBC)
* `SPRING_DATASOURCE_USERNAME` Utente del database
* `SPRING_DATASOURCE_PASSWORD` Password del database
* `SPRING_MAIL_HOST` Indirizzo del server SMTP
* `SPRING_MAIL_PORT` Porta del server SMTP
* `SPRING_MAIL_USERNAME` Account (indirizzo email)
* `SPRING_MAIL_PASSWORD` Password dell'account email
* `CANTICOIDM_URL` URL di un'istanza di Cantico IDM

Inoltre possono essere passate opzioni alla JVM che esegue l'applicazione tramite la variabile d'ambiente `JAVA_OPTS`.

Oltre al `Dockerfile`, è fornito anche un `docker-compose.yml` per poter generare le immagini e avviare il container con
```
docker-compose up --force-recreate --build
```
Il comando legge le variabili di ambiente impostate nel file `.env`. Oltre a quelle usate per configurare l'applicazione, è possibile settare le seguenti variabili per configurare il deploy

* `BE_PORT` Porta esposta dall'applicazione

Viene fornito un file `.env` di esempio con i dati per il deploy sul server Innovaway.

## Note
Ai fini di test è necessario inserire manualmente delle anagrafiche nel database di IDM, visto che al momento non è deployato il front-end di IDM. Allo scopo è fornito lo script [canticoDML.sql](db/canticoDML.sql), che dovrà essere eseguito sul database configurato in `SPRING_DATASOURCE_URL`.

Sul database presente sul server di deploy 10.10.10.216 le anagrafiche sono già state inserite col suddetto script.

Le mail attive per poter compilare i profili legati alle anagrafiche sono le seguenti:

* luca-cantico@mailinator.com
* claudio-cantico@mailinator.com
* ale-cantico@mailinator.com
* vale-cantico@mailinator.com
* anto-cantico@mailinator.com
* nargi-cantico@mailinator.com
* parisi-cantico@mailinator.com
* stella-cantico@mailinator.com
* francesca-cantico@mailinator.com

Per accedere alle caselle di posta, collegarsi a [Mailinator](https://www.mailinator.com/) e inserire la casella di posta desiderata nel campo `Enter Public Mailinator Inbox` e cliccare su `GO`.
