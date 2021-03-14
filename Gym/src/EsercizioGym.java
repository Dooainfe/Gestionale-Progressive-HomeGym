public class EsercizioGym {
    int serie, ripetizioni, peso;
    String nome;

    EsercizioGym(String nome, int serie, int ripetizioni) {
        this.nome = nome;
        this.serie = serie;
        this.ripetizioni = ripetizioni;

    }
    EsercizioGym(String nome, int serie, int ripetizioni, int peso) {
        this.nome = nome;
        this.serie = serie;
        this.ripetizioni = ripetizioni;
        this.peso = peso;
    }
    public String toString(){
        if(peso>0) {
            return nome + " " + serie + "x" + ripetizioni + " " + peso + "kg";
        }else{
            return nome + " " + serie + "x" + ripetizioni;
            }
         }
    }
