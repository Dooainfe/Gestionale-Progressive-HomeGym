//Creare metodo che analizzi file Info nella cartella  del cliente e che ne modifichi quindi i valori.
import java.io.*;
import java.util.*;

public class Gym {
    Scanner input = new Scanner(System.in);

    String filePath;
    String filePath2;
    String filePath3;

    static int sceltaUtente=0;

    ArrayList<Cliente> utenti = new ArrayList<>();
    ArrayList<EsercizioGym> Giorno1 = new ArrayList<>();
    ArrayList<EsercizioGym> Giorno2 = new ArrayList<>();
    ArrayList<EsercizioGym> Giorno3 = new ArrayList<>();
    ArrayList <String> Giorno2_1 = new ArrayList<>();
    ArrayList <String> Giorno2_2 = new ArrayList<>();
    ArrayList <String> Giorno2_3 = new ArrayList<>();
    String[][] esercizi = new String[10][15];

    public static void main(String[] args){
        boolean ancora=true;
        int sceltaOperazione;

        Scanner input = new Scanner(System.in);
        Gym miaGym = new Gym();

        Cliente KevinFarella = new Cliente("FarellaKevin");
        miaGym.add(KevinFarella);

	Cliente SperandeoValentino = new Cliente("SperandeoValentino");
        miaGym.add(SperandeoValentino);

	Cliente CarrellSteve = new Cliente("CarrellSteve");
        miaGym.add(CarrellSteve);

	Cliente RonaldoCristiano = new Cliente("RonaldoCristiano");
        miaGym.add(RonaldoCristiano);

	Cliente LavigneAvril = new Cliente("LavigneAvril");
        miaGym.add(LavigneAvril);

	Cliente GabibboIl = new Cliente("GabibboIl");
        miaGym.add(GabibboIl);

	Cliente RossettiMoreno = new Cliente("RossettiMoreno");
        miaGym.add(RossettiMoreno);

        Cliente AntonioGiannotte = new Cliente("GiannotteAntonio");
        miaGym.add(AntonioGiannotte);

        Cliente SimoneLenoci = new Cliente("LenociSimone");
        miaGym.add(SimoneLenoci);



        System.out.println("Benvenuto Simone ;)");

        while(ancora){
            do{
                miaGym.displayNomiClienti();
                System.out.println("\nCon chi vuoi lavorare oggi? (Id)");
                System.out.println("Premi ed invia un tasto qualsiasi se invece vuoi chiudere il programma.");
        try{sceltaUtente = input.nextInt();
            miaGym.aggiornaPath(sceltaUtente);
        }catch(InputMismatchException ex){System.exit(1);}

        //Controlla che l'utente esista.
        miaGym.controllaUtente();

        //Chiede che operazione si voglia effettuare sull'utente
        miaGym.sceltaOperazione();
        sceltaOperazione = input.nextInt();

        //Effettua l'operazione.
        miaGym.effettuaOperazione(sceltaOperazione,sceltaUtente);
        }while(sceltaOperazione < 0 || sceltaOperazione > 4); } //fine primo do
    } //fine main


    public void controllaUtente(){
        File f = new File(filePath);
        File f1 = new File(filePath2);
        File f3 = new File(filePath3);
        if(!f.exists() && !f1.exists() && !f3.exists()){System.exit(1);}
    }

    public void aggiornaPath(int scelta){
        String utente="null";
		utente = utenti.get(scelta-1).cognomeNome;
		//final int sceltaCostante = scelta;
        //switch(scelta){
            //case sceltaCostante: utente=utenti.get(sceltaCostante-1).cognomeNome;
            //break;
            //case 2: utente=utenti.get(1).cognomeNome;
            //break;
            //case 3: utente= utenti.get(2).cognomeNome;
            //break;
            //default:
                //System.out.println("scelta non valida.");
               //break;
        //}
        filePath = "C:\\Users\\Ryzen\\Desktop\\UtentiGym\\"+utente+"\\Settimana.txt";
        filePath2 = "C:\\Users\\Ryzen\\Desktop\\UtentiGym\\"+utente+"\\Settimana2.txt";
        filePath3 = "C:\\Users\\Ryzen\\Desktop\\UtentiGym\\"+utente+"\\Info.txt";
    }

    public void add(Cliente utente){
        utenti.add(utente);    }

    public void creaEsercizio(ArrayList<EsercizioGym> Giorno){
            System.out.println("Nome esercizio?: ");
        String nome = input.nextLine();
            System.out.println("Numero delle serie esercizio?: ");
        int serie = input.nextInt();
            System.out.println("Ripetizioni per serie?: ");
        int ripetizioni = input.nextInt();
            System.out.println("Peso esercizio?: ");
        int peso = input.nextInt();
        EsercizioGym nuovoExercise = new EsercizioGym(nome, serie, ripetizioni, peso);
        Giorno.add(nuovoExercise);
    }

    public void displayNomiClienti(){
        System.out.println("\n ---LISTA ATTUALE CLIENTI--- \n");
        for(int i=0; i<utenti.size();i++) {
            System.out.println(i+1+". "+utenti.get(i).cognomeNome);
        }
    }

    //METODO 1
    public void stampaAzioni(){
        System.out.println("------LEGENDA AZIONI------");
        System.out.println("s+/s-  Aumenta/Diminuisce le serie di 1");
        System.out.println("r+/r-  Aumenta/Diminuisce le ripetizioni di 2");
        System.out.println("p+/p-  Aumenta/Diminuisce il peso di 2");
        System.out.println("m   inserisci i valori manualmente");
        System.out.println(".   non effettua alcun cambiamento e prosegue col programma");
        System.out.println(" ");
    }
    public void analizzaFile(){
        try{
            String x;
            boolean giorno2 = false, giorno3 = false;
            Scanner settimana = new Scanner(new File(filePath));    //Legge ciò che c'è scritto nel file
            do{

            x = settimana.nextLine();
            if(x.isEmpty()){
                x = settimana.nextLine();
            }
            switch(x){
                case "Giorno 1" : x = settimana.nextLine();
                                    break;
                case "Giorno 2" : x = settimana.nextLine();
                                    giorno2 = true;
                                    break;
                case "Giorno 3" :   x = settimana.nextLine();
                                    giorno2 = false;
                                    giorno3 = true;
                                    break;
                case "" : x = settimana.nextLine();
                                    break;
            }//x = la prima linea
            int peso = 0;
            int indexOfX = x.indexOf("x");
            String nome = x.substring(0,indexOfX-2);
            int serie = Integer.parseInt(x.substring(indexOfX-1, indexOfX));            //Qui uso la "x" ed il suo indice per muovermi ed estrapolare le serie e le ripetizioni
            int ripetizioni=0;
            if(x.substring(indexOfX+1).length()>2){
                try{
                    ripetizioni=Integer.parseInt(x.substring(indexOfX+1,indexOfX+3));
                }catch(Exception e){
                    System.out.println("Loading jojo reference...");
                }
                if(ripetizioni == 0){
                    ripetizioni = Integer.parseInt(x.substring(indexOfX+1,indexOfX+2));
                    peso = Integer.parseInt(x.substring(indexOfX+3, x.length()-2));
                }else{
                    peso = Integer.parseInt(x.substring(indexOfX+4, x.length()-2));
                }

            }else{
                ripetizioni = Integer.parseInt(x.substring(indexOfX+1));
            }
            EsercizioGym nuovoExercise;
            if(peso > 0){
            nuovoExercise = new EsercizioGym(nome, serie, ripetizioni, peso);}
            else {nuovoExercise = new EsercizioGym(nome, serie, ripetizioni);}
            if(!giorno2 && !giorno3){Giorno1.add(nuovoExercise);}
            if(giorno2){Giorno2.add(nuovoExercise);}
            if(giorno3){Giorno3.add(nuovoExercise);}
            }while(settimana.hasNextLine());
       }catch(Exception e){
            System.out.println("Qualcosa non e' andato a buon fine");
        }
    }
    public void scriviFile(){
        try {
            PrintWriter writer = new PrintWriter("C:\\Users\\Ryzen\\Desktop\\UtentiGym\\"+utenti.get(sceltaUtente-1).cognomeNome+"\\Scheda.txt");       //Serve a scrivere nel file .txt
            System.out.println("Nuovo peso del cliente? ");
            double peso;
            peso = input.nextDouble();

            writer.println(utenti.get(sceltaUtente-1).pesoAttuale + "->" + peso);
            //aggiornaPeso(peso);
            writer.println();
            writer.println("Giorno 1:\n");
            for (EsercizioGym esercizioGym : Giorno1) {
                writer.println(esercizioGym.toString());
            }
            writer.println("\nGiorno 2:\n");
            for (EsercizioGym esercizioGym : Giorno2) {
                writer.println(esercizioGym.toString());
            }
            writer.println("\nGiorno 3:\n");
            for (EsercizioGym esercizioGym : Giorno3) {
                writer.println(esercizioGym.toString());
            }
            System.out.println("Sovrascrivo il file di testo.");
            Giorno1.clear();
            Giorno2.clear();
            Giorno3.clear();
            Giorno2_1.clear();
            Giorno2_2.clear();
            Giorno2_3.clear();
        writer.close();
        }catch(Exception e) {
            System.out.println("Qualcosa non è andato a buon fine.");
            System.out.println(e.getClass().getName());
        }
    }
    public void modificaSettimana(){
        for (EsercizioGym esercizioGym : Giorno1) {
            modificaEsercizio(esercizioGym);
        }
        for (EsercizioGym esercizioGym : Giorno2) {
            modificaEsercizio(esercizioGym);
        }
        for (EsercizioGym esercizioGym : Giorno3) {
            modificaEsercizio(esercizioGym);
        }
    }
    public void modificaEsercizio(EsercizioGym EsercizioDaModificare) {
        System.out.println("L'esercizio da modificare attualmente e': "+ EsercizioDaModificare.toString());
        System.out.print("Digita l'input: ");

        boolean continua;
        do{
            String decisione = input.next();
            switch (decisione) {
                case "s+":
                    EsercizioDaModificare.serie++;
                    System.out.println("Aumento le serie di 1");
                    break;
                case "s-":
                    EsercizioDaModificare.serie--;
                    System.out.println("Diminuisco la serie di 1");
                    break;
                case "r+":
                    EsercizioDaModificare.ripetizioni++;
                    EsercizioDaModificare.ripetizioni++;
                    System.out.println("Aumento le ripetizioni di 2");
                    break;
                case "r-":
                    EsercizioDaModificare.ripetizioni--;
                    EsercizioDaModificare.ripetizioni--;
                    System.out.println("Diminuisco le ripetizioni di 2");
                    break;
                case "p+":
                    EsercizioDaModificare.peso++;
                    EsercizioDaModificare.peso++;
                    System.out.println("Aumento il peso di 2kg");
                    break;
                case "p-":
                    EsercizioDaModificare.peso--;
                    EsercizioDaModificare.peso--;
                    System.out.println("Diminuisco il peso di 2kg");
                    break;
                case "m":
                    System.out.print("Serie?: ");
                    EsercizioDaModificare.serie = input.nextInt();
                    System.out.print("Ripetizioni?: ");
                    EsercizioDaModificare.ripetizioni = input.nextInt();
                    if(EsercizioDaModificare.peso>0){
                    System.out.print("Peso?: ");
                    EsercizioDaModificare.peso = input.nextInt();}
                    break;
                case ".":
                    System.out.println("Non cambio nulla");
                    break;
                default:
                    System.out.print("Codice non valido, immetti un nuovo input: ");
                    continua = true;
                    continue;
                }continua = false;
        }while(continua);
        }

    //METODO 2
    public void impostaEsercizi(){
        esercizi[0][0]= "Piegamenti 2x2"; esercizi[0][1]= "Piegamenti 2x3"; esercizi[0][2]= "Piegamenti 2x4"; esercizi[0][3]= "Piegamenti 3x3";
        esercizi[0][4]= "Piegamenti 3x4"; esercizi[0][5]= "Piegamenti 4x3"; esercizi[0][6]= "Piegamenti 4x4"; esercizi[0][7]= "Piegamenti 4x5";
        esercizi[0][8]= "Piegamenti 4x6"; esercizi[0][9]= "Piegamenti 4x7"; esercizi[0][10]= "Piegamenti 5x5"; esercizi[0][11]= "Piegamenti 5x6";
        esercizi[0][12]= "Piegamenti 6x6";

        esercizi[1][0]= "Piegamenti rialzati 4x3"; esercizi[1][1]= "Piegamenti rialzati 4x4"; esercizi[1][2]= "Piegamenti rialzati 4x5"; esercizi[1][3]= "Piegamenti rialzati 4x6";
        esercizi[1][4]= "Piegamenti rialzati 4x7"; esercizi[1][5]= "Piegamenti rialzati 5x5"; esercizi[1][6]= "Piegamenti rialzati 5x6"; esercizi[1][7]= "Piegamenti rialzati 5x7";
        esercizi[1][8]= "Piegamenti rialzati 5x8"; esercizi[1][9]= "Piegamenti rialzati 6x6"; esercizi[1][10]= "Piegamenti rialzati 6x7"; esercizi[1][11]= "Piegamenti rialzati 6x8";
        esercizi[1][12]= "Piegamenti rialzati 6x9";

    }
    public void scriviFile2(){
        try {
            System.out.println("Nuovo peso del cliente? ");
            double peso;
            peso = input.nextDouble();
            PrintWriter writer = new PrintWriter("C:\\Users\\Ryzen\\Desktop\\UtentiGym\\"+utenti.get(sceltaUtente-1).cognomeNome+"\\Scheda.txt");
            writer.println(utenti.get(sceltaUtente-1).pesoAttuale + "->" + peso);
            utenti.get(sceltaUtente-1).pesoAttuale = peso;
            writer.println("Giorno 1:\n");
            for (String s : Giorno2_1) {
                writer.println(s);
            }
            writer.println("\nGiorno 2:\n");
            for (String s : Giorno2_2) {
                writer.println(s);
            }
            writer.println("\nGiorno 3:\n");
            for (String s : Giorno2_3) {
                writer.println(s);
            }
            System.out.println("Sovrascrivo il file di testo.");
            Giorno1.clear();
            Giorno2.clear();
            Giorno3.clear();
            Giorno2_1.clear();
            Giorno2_2.clear();
            Giorno2_3.clear();
            writer.close();
        }catch(Exception e) {
            System.out.println("Qualcosa non è andato a buon fine.");
            System.out.println(e.getClass().getName());
        }
    }
    public void analizzaFile2(){
        try{
        Scanner reader = new Scanner(new File(filePath2));
        boolean giorno2 = false, giorno3 = false;
            System.out.println("\n' + ' se vuoi aumentare, ' - ' se vuoi diminuire, ' . ' se non vuoi effettuare alcuna modifica.");
            do {
            String esercizio = reader.nextLine();
                switch(esercizio){
                    case "Giorno 1" : esercizio = reader.nextLine();
                        break;
                    case "Giorno 2" : esercizio = reader.nextLine();
                        giorno2 = true;
                        break;
                    case "Giorno 3" :   esercizio = reader.nextLine();
                        giorno2 = false;
                        giorno3 = true;
                        break;
                    case "" : esercizio = reader.nextLine();
                        break;
                }
            for (int i = 0; i < esercizi.length; i++) {
                for (int j = 0; j < esercizi[i].length ; j++) {
                    if (esercizio.equalsIgnoreCase(esercizi[i][j]) && (!Giorno2_1.contains(esercizio) && !Giorno2_2.contains(esercizio) && !Giorno2_3.contains(esercizio))) {
                        esercizio = modificaEsercizio2(esercizio, i, j);
                        if(!giorno2 && !giorno3){Giorno2_1.add(esercizio);}
                        if(giorno2){Giorno2_2.add(esercizio);}
                        if(giorno3){Giorno2_3.add(esercizio);}

                    }
                }
            }
        }while(reader.hasNextLine());

        }catch(Exception pluto){
            System.out.println("Si è verificato un'errore, sii sicuro che l'esercizio presente nella scheda sia presente nel db di esercizi o contattami.");
        }
    }
    public String modificaEsercizio2(String esercizioDaModificare, int indice, int colonna){
        Scanner tasto = new Scanner(System.in);
        System.out.println("L'esercizio da modificare e' "+ esercizioDaModificare);
        String decisione = tasto.next();
        switch(decisione){
            case "+": return esercizi[indice][colonna+1];

            case "-": return esercizi[indice][colonna-1];

            default : return esercizi[indice][colonna];
        }
    }

    //File Info
    public void analizzaFileInfoCliente(Cliente nuovoCliente){
        try{
        Scanner reader = new Scanner(new File(filePath3));
        String x;
        do {
            x = reader.nextLine();

            int indexOfY=x.indexOf(":");
            nuovoCliente.cognomeNome = x.substring(indexOfY+2);

            x = reader.nextLine();
            indexOfY=x.indexOf(":");

            nuovoCliente.eta = Integer.parseInt(x.substring(indexOfY+2));

            x = reader.nextLine();
            indexOfY=x.indexOf(":");

            nuovoCliente.altezza = Integer.parseInt(x.substring(indexOfY+2));
            x = reader.nextLine();
            indexOfY=x.indexOf(":");

            nuovoCliente.pesoAttuale=Double.parseDouble(x.substring(indexOfY+2));
            x = reader.nextLine();
            indexOfY=x.indexOf(":");

            nuovoCliente.pesoIniziale=Double.parseDouble(x.substring(indexOfY+2));
            x = reader.nextLine();
            indexOfY=x.indexOf(":");

            nuovoCliente.dataIscrizione=x.substring(indexOfY+2);
            x = reader.nextLine();
            indexOfY=x.indexOf(":");

            nuovoCliente.scadenzaIscrizione=x.substring(indexOfY+2);
            x = reader.nextLine();
            indexOfY=x.indexOf(":");

            nuovoCliente.variazioniKgMensili[0]=Double.parseDouble(x.substring(indexOfY+2));
            x = reader.nextLine();
            indexOfY=x.indexOf(":");

            nuovoCliente.variazioniKgMensili[1]=Double.parseDouble(x.substring(indexOfY+2));
            x = reader.nextLine();
            indexOfY=x.indexOf(":");

            nuovoCliente.variazioniKgMensili[2]=Double.parseDouble(x.substring(indexOfY+2));
        }while(reader.hasNextLine());
    reader.close();
        }catch(Exception pluto){

            System.out.println(pluto.getClass().getName());
        System.out.println("Si è verificato un'errore, sii sicuro che il file "+"Info"+" sia scritto bene o contattami.");
        }
    }
    public void sceltaOperazione(){
        System.out.println("1. Modifica scheda settimanale col primo metodo.");
        System.out.println("2. Modifica scheda settimanale col secondo metodo.");
        System.out.println("3. Mostrami le informazioni del cliente.");
        System.out.println("4. Torna indietro.");
    }
    public void effettuaOperazione(int scelta, int sceltaUtente){
        analizzaFileInfoCliente(utenti.get(sceltaUtente-1));
        if(scelta == 1){
            stampaAzioni();
            analizzaFile();     //Leggo il file di testo e ne estrapolo il contenuto nell'array Giorno
            modificaSettimana();   //Modifico l'intero array Giorno in base alle modifiche
            System.out.println();
            scriviFile();       //Sovrascrivo il file di testo con l'array nuovo e modificato.
        }else if(scelta==2) {
            impostaEsercizi();
            analizzaFile2();
            scriviFile2();
            aggiornaInfo(sceltaUtente-1);
        }else if(scelta==3) {
            //analizzaFileInfoCliente(utenti.get(sceltaUtente-1));
            displayInfo(sceltaUtente-1);
        }
    }

    public void displayInfo(int indiceUtente) {
        System.out.println("Cliente: " + utenti.get(indiceUtente).cognomeNome);
        System.out.println();
        System.out.println("Eta': " + utenti.get(indiceUtente).eta);
        System.out.println("Altezza: " + (int) utenti.get(indiceUtente).altezza);
        System.out.println("Peso: " + utenti.get(indiceUtente).pesoAttuale);
        System.out.println("Iscritto il: " + utenti.get(indiceUtente).dataIscrizione);
        System.out.println("Scadenza sottoscrizione: " + utenti.get(indiceUtente).scadenzaIscrizione);
        System.out.println("BMI: " + utenti.get(indiceUtente).calcolaBMI());
        System.out.println("Media kg persi/mese: "+ utenti.get(indiceUtente).calcolaMedia());
        }
    public void aggiornaInfo(int indiceUtente){
        try {
            PrintWriter writer = new PrintWriter(filePath3);
            writer.println("Cliente: " + utenti.get(indiceUtente).cognomeNome);
            writer.println("Eta': " + utenti.get(indiceUtente).eta);
            writer.println("Altezza: " + (int) utenti.get(indiceUtente).altezza);
            writer.println("Peso attuale: " + utenti.get(indiceUtente).pesoAttuale);
            writer.println("Peso iniziale: " + utenti.get(indiceUtente).pesoIniziale);
            writer.println("Iscritto il: " + utenti.get(indiceUtente).dataIscrizione);
            writer.println("Scadenza sottoscrizione: " + utenti.get(indiceUtente).scadenzaIscrizione);
            writer.println("Kg persi 3 mesi fa: "+ utenti.get(indiceUtente).mese1);
            writer.println("Kg persi 2 mesi fa: "+ utenti.get(indiceUtente).mese2);
            writer.println("Kg persi 1 mese fa: "+ utenti.get(indiceUtente).mese3);
            writer.close();
        }catch(Exception ex){
            System.out.println("aggiorna info");
        }
    }

    }



//Creare metodo che analizzi file Info nella cartella  del cliente e che ne modifichi quindi i valori.

