--creare una tabella Articolo
--i dati da tener traccia sono: 

-- - codice: identificativo alfanumerico
-- - marca
-- -  modello/nome
-- - descrizione
-- - prezzo
-- - quantita

-- 1) CREARE LA TABELLA, INDIVIDUANDO TIPI, LUNGHEZZA DEI VARI TIPI E VINCOLI VARI TRAMITE IL COMANDO CREATE TABLE
CREATE TABLE articolo(  
  codice varchar(10),
  marca varchar(50),
  descrizione varchar(500),
  prezzo DOUBLE,
  quantita INTEGER,

  PRIMARY KEY(codice)
)

-- 2) INSERIRE LE RIGHE MEDIANTE COMANDO APPOSITO NELLA TABELLA, MIN 8 RIGHE
INSERT INTO articolo VALUES
("001", "AMD", "Ryzen 5" ,  200, 50),
("002", "AMD", "Ryzen 3" ,  120,  50), 
("003", "AMD", "Ryzen 7" ,  450, 50), 
("004", "INTEL", "i3" , 100, 1), 
("005", "INTEL", "i5" , 250, 12), 
("006", "INTEL", "i7" , 350, 12), 
("007", "INTEL", "i9", 600,  15), 
("008", "INTEL", "pentium",  60, 15)

-- 3) mostrare l'articolo con codice XXX
SELECT * FROM articolo WHERE codice = "001"

-- 4) mostrare gli articoli della marca XXX
SELECT * FROM articolo WHERE marca = "AMD"

-- 5) mostrare gli articoli della marca XXX con prezzo maggiore di XXX
SELECT * FROM articolo WHERE marca = "AMD" and prezzo > 150

-- 6) mostrare gli articoli della marca XXX con prezzo compreso tra X e Y
SELECT * FROM articolo WHERE marca = "AMD" and prezzo BETWEEN 150 and 250

-- 7) mostrare gli articoli della marca XXX con prezzo compreso tra X e Y e quantita minore di Z
SELECT * FROM articolo WHERE marca = "AMD" and prezzo BETWEEN 150 and 500 and quantita > 20

-- 8) mostrare gli articoli della marca X1 con prezzo maggiore di Y1 e gli articoli della marca X2 con quantita compresa tra Y2 e Y3
SELECT * FROM articolo WHERE marca LIKE "A%" and prezzo > 150 OR marca LIKE "I%" and prezzo > 800

-- 9 ) mostrare gli articoli con modello che inizia con XXX e prosegue in maniera arbitraria  
SELECT * FROM articolo WHERE marca LIKE "A%"
