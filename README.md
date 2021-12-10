# MessinaKchelfi
Progetto di Programmazione Ad Oggetti 2021/2022

Specifiche del progetto:
<MACRO TEMA>: 
DROPBOX - List Folder
<API REFERENCE>: https://www.dropbox.com/developers/documentation/http/documentation#files-list_folder ,
<OBIETTIVO>:
"Si implementi un servizio che effettui una ricerca per nome e tipo di file (utilizzando caratteri jolly come ad esempio *) e ritorni le caratteristiche del file, incluse le versioni e un link temporaneo (get_temporary_link). "
<STATS E FILTRI>:
Statistiche sui risultati della ricerca; filtri per data di modifica e accesso.
Esempi di Stats e Filtri sono disponibile al seguente indirizzo: https://learn.univpm.it/mod/page/view.php?id=260184 

chiamata a list_folder
https://api.dropboxapi.com/2/files/list_folder
input:
	{
	    "path": "/Homework/math",
	    "recursive": false,
	    "include_media_info": false,
	    "include_deleted": false,
	    "include_has_explicit_shared_members": false,
	    "include_mounted_folders": true,
	    "include_non_downloadable_files": true
	}
Esempio output:
	{
    	"entries": [
        {
        	".tag": "folder",
        	"name": "Prova cartella",
        	"path_lower": "/prova cartella",
		"path_display": "/Prova cartella",
		"id": "id:ZGyAD31kpxgAAAAAAAAACQ"
        },
	{
		".tag": "file",
		"name": "Get Started with Dropbox Paper.url",
		"path_lower": "/get started with dropbox paper.url",
		"path_display": "/Get Started with Dropbox Paper.url",
		"id": "id:ZGyAD31kpxgAAAAAAAAABg",
		"client_modified": "2021-01-18T13:13:43Z",
		"server_modified": "2021-01-18T13:13:43Z",
		"rev": "015b92c7dc60b840000000217fbf8b0",
		"size": 240,
		"is_downloadable": true,
		"has_explicit_shared_members": false,
		"content_hash": "f40c1228343d7e2a632281c986dbb7af3491b9b63ddfd0eb10fee2c913f6cfa7"
	},
	{
		".tag": "file",
		"name": "Get Started with Dropbox.pdf",
		"path_lower": "/get started with dropbox.pdf",
		"path_display": "/Get Started with Dropbox.pdf",
		"id": "id:ZGyAD31kpxgAAAAAAAAABw",
		"client_modified": "2021-01-18T13:13:43Z",
		"server_modified": "2021-01-18T13:13:43Z",
		"rev": "015b92c7dc60b850000000217fbf8b0",
		"size": 1102331,
		"is_downloadable": true,
		"has_explicit_shared_members": false,
		"content_hash": "f7ad488deb7d81790340ecd676fe6e47f0a6064fb99b982685b752d58611c1cb"
	},
	{
		".tag": "file",
		"name": "Maggio 2021 progetto.mp3",
		"path_lower": "/prova cartella/maggio 2021 progetto.mp3",
		"path_display": "/Prova cartella/Maggio 2021 progetto.mp3",
		"id": "id:ZGyAD31kpxgAAAAAAAAADg",
		"client_modified": "2021-12-08T15:50:53Z",
		"server_modified": "2021-12-08T15:50:53Z",
		"rev": "015d2a4746fc7d00000000217fbf8b0",
		"size": 770159,
		"is_downloadable": true,
		"has_explicit_shared_members": false,
		"content_hash": "e18e3e30548bb9fd5c2293fc799b4c47b0196812dd6e88f6d6b2c252f4a9b388"
	},
	{
		".tag": "file",
            	"name": "Dicembre 2021.mp3",
            	"path_lower": "/prova cartella/dicembre 2021.mp3",
            	"path_display": "/Prova cartella/Dicembre 2021.mp3",
            	"id": "id:ZGyAD31kpxgAAAAAAAAACA",
            	"client_modified": "2021-12-08T16:33:19Z",
            	"server_modified": "2021-12-08T16:33:20Z",
            	"rev": "015d2a50c393b310000000217fbf8b0",
            	"size": 904950,
            	"is_downloadable": true,
            	"has_explicit_shared_members": true,
            	"content_hash": "f9976c88b458a2a641091f4d52c8dcb1bf4fdf37a08f1905d942a7c991e50e2c"
        }
    	],
    	"cursor": "AAEFwZUeypgpXN6imQ1jqfWCjEmmPLSYXT21prHZup7apmY2NhcPCkhCH5jn3VDpqMg64Xwq8bO9l6LqXkuXEIreMxX0qpuFIZjL7sU5v99mkyc-MEXrpfHMKiqaUPMJBfqHY_Ii4RD4c1FJVZR0QFXLyNF818aXbnrnLMLpbtgLH2pL2A4ys8AdnYn_4QlkKyU",
    	"has_more": false
	}
  
chiamata a get_temporary_link
https://api.dropboxapi.com/2/files/get_temporary_link
input:
	{
	    "path": "/video.mp4"
	}
Esempio output:
  	{
    	"metadata":
	{
		"name": "Dicembre 2021.mp3",
		"path_lower": "/prova cartella/dicembre 2021.mp3",
		"path_display": "/Prova cartella/Dicembre 2021.mp3",
		"id": "id:ZGyAD31kpxgAAAAAAAAACA",
		"client_modified": "2021-12-08T16:33:19Z",
		"server_modified": "2021-12-08T16:33:20Z",
		"rev": "015d2a50c393b310000000217fbf8b0",
		"size": 904950,
        	"is_downloadable": true,
        	"content_hash": "f9976c88b458a2a641091f4d52c8dcb1bf4fdf37a08f1905d942a7c991e50e2c"
    	},
    	"link": "https://ucd027c1c8c14a9f4fbdea146068.dl.dropboxusercontent.com/cd/0/get/Bbl7XX8sF7JTEXwzehCpQJk47JMVd7mmMyPhTTYHHcp7epiDL0zvsF5SAGrddtrVL8U4c0mVgCPulj6GtOWu73Tf-O6FL-VLUOgcOVx0vxusDu8MCN2nUWCR83KNLF25Y9MZCpkC9g3OLKPcuC8T5hHp/file"
	}
  
chiamata a list_revisions
https://api.dropboxapi.com/2/files/list_revisions
input:
	{
		"path": "/root/word.docx",
		"mode": "path",
		"limit": 10
  	}
Esempio output:
	{
		"is_deleted": false,
		"entries": [
		{
			"name": "Dicembre 2021.mp3",
			"path_lower": "/prova cartella/dicembre 2021.mp3",
			"path_display": "/Prova cartella/Dicembre 2021.mp3",
			"id": "id:ZGyAD31kpxgAAAAAAAAACA",
			"client_modified": "2021-12-08T16:33:19Z",
			"server_modified": "2021-12-08T16:33:20Z",
			"rev": "015d2a50c393b310000000217fbf8b0",
			"size": 904950,
			"is_downloadable": true,
			"content_hash": "f9976c88b458a2a641091f4d52c8dcb1bf4fdf37a08f1905d942a7c991e50e2c"
        	},
        	{
			"name": "Dicembre 2021.mp3",
			"path_lower": "/prova cartella/dicembre 2021.mp3",
			"path_display": "/Prova cartella/Dicembre 2021.mp3",
			"id": "id:ZGyAD31kpxgAAAAAAAAACA",
			"client_modified": "2021-12-06T09:23:39Z",
			"server_modified": "2021-12-06T16:19:08Z",
			"rev": "015d27c9dc5d51d0000000217fbf8b0",
			"size": 4773162,
			"is_downloadable": true,
			"content_hash": "718e70f3bc690a4e0fc7e3c62c1d766a13ed60e73ce8832115541c2880a3c641"
		}
		]
	}
