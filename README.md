# PP1_project

Zadatak koji nam je dat sa ovim projektom jeste da se napravi funkcionalni kompajler za jezik MicroJava. To se radi implementiranjem, dole navedenih 4 faza:

1.	Leksička analiza – U ovoj fazi je potrebno da se neki ulazni tekstualni kod iz nekog fajla (npr. primer_test.mj) procesuira tako da se iz njega mogu izvući takozvani tokeni
koji moraju da budu realizovani u sklopu sa leksikom našeg kompajlera koja je definisana u fajlu mjlexer.lex
2.	Sintaksna analiza – Ovi tokeni se dalje šalju na sintaksnu analizu u kojoj je potrebno da se utvrdi da li su oni poređani po pravom redosledu tj. gramatici koja je data u specifikaciji ovog kompajlera.
Ova provera se izvršava u mjparser.cup fajlu i rezultat ovog fajla jeste apstraktno sintaksno stablo
3.	Semantička analiza – Obilaskom tog apstraktnog sintaksnog stabla dalje je potrebno da proverimo semantičku korektnost izvornog koda samim tim da generišemo tabelu simbola uz pomoć biblioteke symboltable.jar.
Semantika kompajlera mora da bude realizovana po zahtevima iz teksta zadatka i sve te stvari se proveravaju u klasi SemanticAnalyzer.java
4.	Generisanje koda – Ako je kod ispunio sve zahteve iz klase SemanticAnalyzer.java taj kod je spreman za generisanje tako što ćemo ponovo da prolazimo sintaksno stablo, ali ovog puta uz korišćenje
novogenerisane tabe simbola. U novoj klasi CodeGenerator.java potrebno je da uspešno generišemo bajtkod koji kasnije možemo izvršiti tako da njegov ispis ima smisla

Za povezivanje svega ovoga se koristi build.xml fajl.
