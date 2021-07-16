# cantico-be

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

Il file `.env` contiene le variabili d'ambiente usate per configurare l'applicazione, descritte nella sezione precedente, e quelle per configurare il deploy con `docker-compose`

* `BE_PORT` Porta esposta dall'applicazione
