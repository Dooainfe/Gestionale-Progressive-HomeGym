public class Cliente {
    String cognomeNome;
    int eta;
    double altezza, pesoAttuale, pesoIniziale;
    String dataIscrizione, scadenzaIscrizione;
    double mese1=0.0, mese2=0.0,   mese3=0.0;
    double[] variazioniKgMensili = {mese1,mese2,mese3};

    public double calcolaBMI(){
        return pesoAttuale/((altezza/100)*(altezza/100));
    }

    public double calcolaMedia(){
        double mediaParziale = 0.0;
        for (double v : variazioniKgMensili) {

            mediaParziale += v;
        }
        return mediaParziale / variazioniKgMensili.length;
    }

    Cliente (String cognomeNome){
        this.cognomeNome = cognomeNome;
    }

    Cliente(String cognomeNome, double peso, double altezza, int eta, String dataIscrizione, String scadenzaIscrizione){
        this.pesoIniziale = peso;
        this.pesoAttuale = pesoIniziale;
        this.cognomeNome = cognomeNome;
        this.altezza = altezza;
        this.eta = eta;
        this.dataIscrizione = dataIscrizione;
        this.scadenzaIscrizione = scadenzaIscrizione;
    }


}
