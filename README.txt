Nell'ambito della realizzazione di uno scadenziario per un software di fatturazione, è disponibile un file così composto:
 
NrFattura; DataFattura; ModalitaDiPagamento
 
Modalità di Pagamento serve per calcolare la data di scadenza pagamento (DSP) in base alla dataFattura;  può assumere i seguenti valori:
 
DF (Data Fattura) - DSP=DataFattura
DFFM(Data Fattura Fine Mese) - DSP=la fine del mese in cui è stata emessa la fattura. Es. Se DataFattura=23/03/2013 e ModalitàPagamento DFFM, allora data scadenza 31/03/2013
DF60(Data Fattura +60gg) - DSP=data fattura + 2 mesi solari Es. Se DataFattura=23/03/2013 e ModalitàPagamento DF60, allora data scadenza 23/05/2013
 
 
Si vuole un file che presenti le fatture ordinate per data di scadenza di pagamento, con i seguenti tre campi,
NrFattura; DataFattura; DataScadenzaPagamento
 
Realizzare quindi un modulo software che
a) legga il file in input
b) calcoli per ogni fattura la data di scadenza di pagamento
c) ordini le fatture per data di scadenza di pagamento crescente
d) scriva il file in output
 
con i seguenti vincoli:
1) non utilizzare il metodo getActualMaximum di Calendar o delle sue sottoclassi
2) non ulizzare il metodo sort di Collection o delle sue sottoclassi