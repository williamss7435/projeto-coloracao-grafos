
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Grafo {
    public static LinkedList <Vertice> vertices = new LinkedList<Vertice>();
    private static  int  qntVertices = 0;
    
    public static void addVertice(String rotulo){
        qntVertices++;
        Vertice vertice =  new Vertice(qntVertices, rotulo);   
        vertices.add(vertice);
    }
    
    public static void AddAresta(int vertice1, int vertice2){
        vertices.get(vertice1-1).addAresta(vertice2);
        vertices.get(vertice2-1).addAresta(vertice1);
    }
    
    public static String coloracaoSequencial(){ 
         sort1();
         LinkedList c[] = new LinkedList[qntVertices];
         Vertice v;
         for (int i=0; i<qntVertices; ++i)
            c[i] = new LinkedList();
         int j;
         
        while(!vertices.isEmpty()){
            v = vertices.pop();
            j = 0;
            
           while(v!=null){
               
                if(intersercao(v.getArestas(), c[j])){
                   j++;
               }else{
                   c[j].add(v.getPosição());
                   v = null;
               }

           }  
         
        }
        String resposta = "";
        for (int i = 0; i < c.length; i++) {
            if(c[i].size()>0){
                resposta += "C" + (i+1) + "->" + c[i].toString() + "\n";
            }
        }
        
         return resposta;
    }
    
    public static String coloracaoPorClasse(){
         sort1();
         LinkedList c[] = new LinkedList[qntVertices];
         Vertice v;
         for (int i=0; i<qntVertices; ++i)
            c[i] = new LinkedList();
         int j=0;
         int count = 0;
         int qt = qntVertices;
         
         while(!vertices.isEmpty()){
             for(int i=0; i<qt; i++){
                 v=vertices.pop();
                 if(intersercao(v.getArestas(), c[j])){
                     vertices.addLast(v);
                 }else{
                     c[j].add(v.getPosição());
                     count++;
                 }
             }
             j++;
             qt=qt-count;
             count=0;
         }
         
         String resposta = "";
        for (int i = 0; i < c.length; i++) {
            if(c[i].size()>0){
                resposta += "C" + (i+1) + "->" + c[i].toString() + "\n";
            }
        }
         return resposta;
    }
    
    private static boolean intersercao(LinkedList arestas, LinkedList c){
        for (int i = 0; i < arestas.size(); i++) {
           
            if( c.contains(arestas.get(i)))
                return true;
        }
        
        return false;
    }
    
   //Arruma Metodo Sort
  public static void sort() {
        Vertice temp = null;
        for (int i = 0; i < qntVertices - 1; i++) {
 
            for (int j = 1; j < qntVertices - i; j++) {
                if(vertices.get(j-1).getArestas().size() < vertices.get(j).getArestas().size())
                temp = vertices.get(j-1);
                vertices.set(j-1, vertices.get(j));
                vertices.set(j, temp);
            }
            
        }
}
  
  public static void sort1(){
      Vertice temp = null;
      for(int i=0; i<qntVertices; i++){
          for(int j=0; j<qntVertices-1; j++){
              if(vertices.get(j).getArestas().size() < vertices.get(j+1).getArestas().size()){
                  temp = vertices.get(j);
                  vertices.set(j, vertices.get(j+1));
                  vertices.set(j+1, temp);
              }
          }
      }
  }
    
    public static int getQntVertices() {
        return qntVertices;
    }
    
    
    public static String list(int i){
        return "Posicao:" + vertices.get(i).getPosição()+ "\nRotulo:" + vertices.get(i).getRotulo() + "\nAresta:" + vertices.get(i).getArestas().toString();
    }
}
