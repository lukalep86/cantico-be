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
docker-compose --file DOCKER_COMPOSE_YML up --force-recreate --build
```
Dove `DOCKER_COMPOSE_YML` è un file di configurazione `.yml`. Sono disponibili due file di configurazione, `docker-compose_idm.yml` e `docker-compose_standalone.yml`.

* La variante `standalone` avvia un'istanza di PostgreSQL a cui l'applicazione si collega. Il database è esposto sulla porta `$DB_PORT`, mentre il server sulla porta `SERVER_PORT`, entrambe configurate nel file `.env`.

* La variante `idm` si connette a una rete di container di cantico-idm già deployata, e si collega allo stesso database di IDM. Il nome della rete è configurato tramite `IDM_NETWORK` nel file `.env`.

### File di configurazione

* `.env` Configurazione del deploy, contiene le variabili d'ambiente usate per configurare docker-compose
    * `SERVER_PORT` Porta esposta dall'applicazione
    * `DB_PORT` Porta esposta dal database
    * `IDM_NETWORK` Nome della rete creata da `cantico-idm` a cui connettersi
    
* `docker.env` Configurazione dell'applicazione, contiene le variabili d'ambiente usate per configurare l'immagine docker
