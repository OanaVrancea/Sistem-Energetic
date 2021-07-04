Vrancea Oana Roxana, 322 CD

------------------------Etapa 1 --------------------------------------------

In prima etapa a proiectului am construit mai multe pachete ce contin clase
auxiliare pentru citire, prelucrare de date si afisare. 
Primul pachet este "inputloader" ce contine clase de input in care voi salva
datele citite din fisier.Acestea sunt:
Consumer: clasa care contine datele preluate din input despre un consumator
Distributor: clasa care contine datele preluate din input despre un distribuitor
CostChanges:clasa care contine datele preluate din input despre
	    schimbarile care au loc pentru costurile un distribuitor
MonthlyUpdates: clasa ce contine updateurile ce au loc in fiecare luna
		contine o lista de consumatori si una de CostChanges
Entity: contine o lista de Consumer si una de Distributor pentru
	a retine toate datele din initial data
Input: clasa principala de citire, contine numarul de runde al jocului,
	initial data si monthly updates.

Pentru prelucrarea datelor am folosit clasele din pachetul "outclasses".
Commmon: acesta este o clasa abstracta parinte pentru ConsumerOut si
	DistributorOut utilizata pentru implementarea de Singleton
	si FactoryPattern
ConsumerOut: o clasa cu campuri ce reprezinta datele din input ale
	     unui consumator dar si unele auxiliare care 
	    ma ajuta in implemetarea algoritmului
DistributorOut: o clasa cu campuri ce reprezinta datele din input 
	     dar si unele auxiliare care ma ajuta in implemetarea
	     algoritmului
FactoryOutClasses: aici se afla implementarea pentru Singleton si
		Factory din tema. Functia createEntity imi
		construieste una dintre cele doua entitati

In pachetul "action", in clasa Action se afla implementarea algoritmului
care imi modifica datele primite.Acest pachet contine functii auxiliare
pentru citirea de noi consumatori si noi modificari, calcularea de rate
si bugete etc, si funtia auxiliara algorithm care imi prelucreaza datele.

Pentru afisare am folosit clasele din pachetul "results"
ConsumerResult: contine datele pentru consumatori care vor fi afisate
		in output
DistributorResult: contine datele pentru distribuitori care vor fi afisate
		in output
ConsumerDatesInContracts: contine datele pentru consumatori din contractul
			unui distribuitor
CreateOutput : clasa ce contine un array de ConsumerResult si unul de
		DistributorResult , toate datele ce trebuie afisate 
		in output

In functia main am realizat citirea, prelucrarea si afisarea datelor.

-------------------------Etapa 2----------------------------------------
Pentru etapa 2 a proiectului in pachetul "inputloader" am modificat
clasele Distributor, Entity si MonthlyUpdates corespunzator noilor date de intrare,
am renuntat la functionalitatea clasei CostChanges care nu mai era necesara
dar am adaugat si clase noi precum:
DistributorChanges: contine schimbarile care au loc pentru un distribuitor
		   intr-o anumita luna, preluate din input
Prodcer: clasa care contine datele preluate din input despre un producator
ProducerChanges: contine schimbarile care au loc pentru un producator
		   intr-o anumita luna, preluate din input

In pachetul outclasses am modificat clasa DistributorOut, dar am adaugat si
altele precum:
ProducerOut: o clasa cu campuri ce reprezinta datele din input 
	     dar si unele auxiliare care ma ajuta in implemetarea
	     algoritmului pentru producatori
Interfata Strategy: contine metoda selectBestProducers care va 
		  fi implementata de alte 3 clase noi adaugate
		  pentru a sorta producatorii in functie de strategia
		  pe care o are un distribuitor
Clasa GreenStrategy: sorteaza producatorii (implementand metoda
                      selectBestProducers din interfata Strategy)
		     pentru un distribuitor care
		    are startegia GREEN in functie de tipul energiei,
		    pret si cantitate
Clasa PriceStrategy:sorteaza producatorii 
                    (implementand metoda
                      selectBestProducers din interfata Strategy)
		    pentru un distribuitor care
		    are startegia PRICE in functie de pret si cantitate
Clasa QuantityStrategy:sorteaza producatorii
			(implementand metoda
                      selectBestProducers din interfata Strategy)
		     pentru un distribuitor care
		     are startegia QUANTITY in functie de cantitate
In clasa DistributorOut am adaugat un camp de tipul Strategy, 
dar si functia sortedProducers care imi intoarce o lista cu
distribuitorii sortati in functie de tipul strategiei. Aceasta 
reprezinta implementarea pentru Strategy Pattern.
In pachetul "results" am modificat clasa CreateOutput pentru
a contine si datele pentru producatori, dar am adaugat si 
clasa:
ProducerResult: contine datele pentru producatori care vor fi afisate
		in output












