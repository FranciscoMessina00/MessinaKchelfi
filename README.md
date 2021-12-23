# MessinaKchelfi
Progetto di Programmazione Ad Oggetti 2021/2022, Università Politecnica delle Marche.

# Specifiche del progetto:
Il progetto è un Web Service che permette tramite un client (es. Postman) di accedere alle API di Dropbox tramite diverse rotte per visualizzare:

1) Tutti i file e cartelle in Dropbox;
2) File filtrati per peso e/o data modifica;
3) Statistiche di tutti i file;
4) Statistiche di file filtrati per peso e/o data modifica;

## Caratteristiche di file e cartelle
### File
- Nome;
- Estensione;
- Percorso di Dropbox;
- ID del file in Dropbox;
- Codice che identifica la versione del file;
- Peso del file;
- Indicazione s e il file è condiviso;
- Data di ultima modifica;
- Url per scaricare il file;

### Cartella
- Nome;
- Percorso di Dropbox;
- ID della cartella in Dropbox;

# Funzionamento dell'applicazione
Attraverso [SpringBoot](https://spring.io/projects/spring-boot), il framework utilizzato, si può avviare l'applicazione tramite un IDE e questa alloca un server TomCat alla porta 8080. 
## Richieste e rotte

| Richiesta | Rotta | Descrizione |
|:---:|:---:|:---:|
| `GET` | /files | Restituisce tutti i file e cartelle con le loro caratteristiche |
| `POST` | /files | Restituisce i file filtrati per peso e/o data modifica |
| `GET` | /stats | Restituisce le statistiche di tutti i file |
| `POST` | /stats | Restituisce le statistiche dei file filtrati per peso e/o data modifica |

## Esempi di chiamate
Esempio di chiamata alla rotta `GET` `/files`:

	[
    {
        "name": "Prova cartella",
        "path": "/prova cartella",
        "tag": "Folder",
        "id": "id:ZGyAD31kpxgAAAAAAAAACQ"
    },
    {
        "name": "Get Started with Dropbox Paper",
        "path": "/get started with dropbox paper.url",
        "tag": "File",
        "id": "id:ZGyAD31kpxgAAAAAAAAABg",
        "extension": "url",
        "size": 240,
        "shared": false,
        "version": "015b92c7dc60b840000000217fbf8b0",
        "url": "https://uca5ae29c6fa1687db545767746b.dl.dropboxusercontent.com/cd/0/get/BcFU8zizU3_b8-4azXfNvyJ2gE4la9of0rXoNjCNx748T3gvPjBZGG0PJkrM91yN3_7-iExGrz0VFpnItSme0Dje5k-pnbyUHGY4W9wGgEWZF7QY9qlDu2ZGXgkksy5hpzkbdQC9MQzFPrdV_eL2Kxtu/file",
        "modification_Date": "2021-01-18T12:13:43.000+00:00"
    },
    {
        "name": "Get Started with Dropbox",
        "path": "/get started with dropbox.pdf",
        "tag": "File",
        "id": "id:ZGyAD31kpxgAAAAAAAAABw",
        "extension": "pdf",
        "size": 1102331,
        "shared": false,
        "version": "015b92c7dc60b850000000217fbf8b0",
        "url": "https://uceb13ec0f6d59d06c77d69f1ec5.dl.dropboxusercontent.com/cd/0/get/BcEBqckA3GC82A5c8VvLehWqB3cEEF8a-h1tpIZG_13lVB4A_3zPWBGWlJpe6PWIBhRHtUAjbCk50ou54AD8nPBe3wFjd77Rv7PiB9mU4Rfpml4RkaSA5TOi0sY4zS0iNDxIsEcK9_krMMj4DVaPM40h/file",
        "modification_Date": "2021-01-18T12:13:43.000+00:00"
    }
	]

Esempio di chiamata alla rotta `GET` `/stats`:
	
	{
    "Stats type": {
        "jpg": 1,
        "mp3": 4,
        "folders": 3,
        "pdf": 1,
        "exe": 2,
        "url": 1
    },
    "Stats size": {
        "Number of files": 9,
        "Total size": 286292587,
        "Average size": 31810287
    }
	}

Nelle chiamate `POST` `/files` e `POST` `/stats`, oltre a filtrare i file per peso e/o data modifica (i filtri sono spiegati più avanti), è anche possibile fare una ricerca per nome (ricerca se esiste un file che *contiene* quel nome) e/o tipo di file (utilizzando caratteri *jolly*  "*") come nei seguenti esempi:
- `https://localhost:8080/files?fullName=name.*`
- `https://localhost:8080/files?fullName=*.txt`
- `https://localhost:8080/files?fullName=name.txt`
- `https://localhost:8080/files?fullName=*.*`
## Filtri
I filtri vengono implementati nel body delle chiamate `POST`.
| Richiesta | Descizione | Esempio |
|:---:|:---:|:---:|
| `size` | Restituisce tutti i file filtrati per grandezza| { "filter":{"size":{ "sizeFile":500, "logic":"greater"} }|
| `date` |  Restituisce tutti i file filtrati per data| { "filter":{ "date":{ "dateParam":"2021-12-10 12:12:00", "logic":"lower"}|

`sizeFile` rappresenta il peso in bytes, `dateParam` rappresenta la data (AAA-MM-GG hh:mm:ss) in formato Timestamp, mentre `logic` può assumere i valori `lower` (minore del parametro) e `greater` (maggiore del parametro). 

È possibile concatenare più filtri attraverso gli operatori condizionali `and` e `or` ad esempio :

	{
    "filter":
	    {
	        "size":{"sizeFile":500,"logic":"greater"},
	        "date":{"dateParam":"2021-12-10 12:12:00","logic":"lower"}
    	},
    	"operator":"and"
	}



## Autori
**Messina Francisco** : https://github.com/FranciscoMessina00

**Kchelfi Mohamed Amine** : https://github.com/aminekchelfi
