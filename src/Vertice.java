
import java.util.LinkedList;

public class Vertice {
        private int posição;
        private String rotulo;
        private LinkedList arestas = new LinkedList();

    public Vertice(int posição, String rotulo) {
        this.posição = posição;
        this.rotulo = rotulo;
    }
    
    public void addAresta(int aresta){
        this.arestas.add(aresta);
    }
    
    public int getPosição() {
        return posição;
    }
    
    public void setPosição(int posição) {
        this.posição = posição;
    }

    public String getRotulo() {
        return rotulo;
    }

    public void setRotulo(String rotulo) {
        this.rotulo = rotulo;
    }

    public LinkedList getArestas() {
        return arestas;
    }        
}
