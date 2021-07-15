# cantico-be

## Docker
L'immagine docker può essere personalizzata attraverso le seguenti variabili d'ambiente

* `SPRING_DATASOURCE_URL` Stringa di connessione al database (JDBC)
* `SPRING_DATASOURCE_USERNAME` Utente del database
* `SPRING_DATASOURCE_PASSWORD` Password del database
* `SPRING_MAIL_HOST` Indirizzo del server SMTP
* `SPRING_MAIL_PORT` Porta del server SMTP
* `SPRING_MAIL_USERNAME` Account (indirizzo email)
* `SPRING_MAIL_PASSWORD` Password dell'account email

Inoltre possono essere passate opzioni alla JVM che esegue l'applicazione tramite la variabile d'ambiente `JAVA_OPTS`.

## docker-compose
Per generare le immagini, creare i container e avviare il servizio
```
docker-compose up --force-recreate --build
```
Questa modalità di deploy prevede che siano già avviati i servizi di Cantico IDM e il relativo PostgreSQL, connessi alla rete `IDM_NETWORK` a cui si attaccherà anche `cantico-profile-be`.

### File di configurazione
Il file `.env` contiene le variabili d'ambiente per configurare l'applicazione, descritte nella sezione precedente, e quelle per configurare il deploy con `docker-compose`

* `SERVER_PORT` Porta esposta dall'applicazione
* `DB_PORT` Porta esposta dal database
* `IDM_NETWORK` Nome della rete creata da `cantico-idm` a cui connettersi
