
import java.util.List;

public class Main2 {

    public static void main(String[] args) {

            Grafo.addVertice("Rato"); // Vertice 1
            Grafo.addVertice("Gato"); // Vertice 2
            Grafo.addVertice("Cachorro"); // Vertice 3
            Grafo.addVertice("Passarinho"); // Vertice 4
            Grafo.addVertice("cavalo"); //vertice 5
            
            Grafo.AddAresta(1, 2);
            Grafo.AddAresta(1, 5);
            Grafo.AddAresta(2, 3);
            Grafo.AddAresta(2, 4);
            Grafo.AddAresta(3, 4);
            Grafo.AddAresta(4, 5);
                
            
            //System.out.println(Grafo.coloracaoPorClasse());
            System.out.println(Grafo.coloracaoSequencial());
           
    }
    
}