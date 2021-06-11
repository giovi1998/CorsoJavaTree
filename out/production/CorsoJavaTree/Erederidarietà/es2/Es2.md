#esercizio 2
Esercizio Gestore Veicoli 🛴

Scrivere un programma in grado di modellare la gestione di diversi tipi di veicoli: automobili e autocarri. In particolare, create le classi Autocarro e Automobile entrambe con le seguenti caratteristiche:
Ogni veicolo è caratterizzato da:
- Targa
- Marca
- Modello
- Numero di posti

Gli autocarri hanno una proprietà aggiuntiva: la capacità massima di carico (espressa in quintali). Le automobili, invece, il costo di porte.
Il metodo toString degli oggetti Automobile deve ritornare il costo di targa e il costo di porte, separati dal carattere «:».
Il metodo toString degli oggetti Autocarro, invece, deve ritornare il costo di targa e la massima capacità in quintali, separati dal carattere «:».

Deve essere possibile eseguire il seguente codice:

```
Automobile automobile = new AutoMobile("cf123rm", 4, 4);
AutoCarro autoCarro = new AutoCarro("ca133sm", 4, 2);
```

Suggerimento: usate l’ereditarietà

