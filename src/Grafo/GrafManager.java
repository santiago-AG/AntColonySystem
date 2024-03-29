/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import EDD.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class GrafManager {
    protected VertexLista vertices;
    protected boolean subido;

    /**
     * @return the subido
     */
    public boolean getSubido() {
        return subido;
    }

    /**
     * @param subido the subido to set
     */
    public void setSubido(boolean subido) {
        this.subido = subido;
    }

    /**
     * @return the vertices
     */
    public VertexLista getVertices() {
        return vertices;
    }

    /**
     * @param vertices the vertices to set
     */
    public void setVertices(VertexLista vertices) {
        this.vertices = vertices;
    }
    
    
    //Funcion para importar el archivo TXT y leer toda la data del archivo 
    public VertexLista read_text(File file){
        VertexLista vl = new VertexLista();
        
        String read="";
        String line="";
        try{
                   
            if(!file.exists()){
                file.createNewFile();
            }else{
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while((line=br.readLine())!=null){
                    if (!line.isEmpty()){
                        read+=line+"\n";
                    }
                }
                br.close();
                if(!read.isEmpty()){
                    String[] lines = read.split("\n");
                    
                    int readingOp = 0;
                    for(int i=0; i < lines.length ;i++){  
                        if(lines[i].trim().equals("ciudad")){
                            readingOp = 0;
                        }else if(lines[i].trim().equals("aristas")){
                            readingOp = 1;                            
                        }else if( readingOp == 0){
                            Vertex ver = new Vertex(lines[i]);
                            vl.insertarNodo(ver);
                        }else if(readingOp==1){
                            String[] arista = lines[i].split(",");
                            //agrega aristas tal cual como salen en el txt para crear el grafo (pero las aristas solo estan vinculadas en una direccion)
                            Edge aris = new Edge(vl.buscar(arista[1]));
                            aris.setLength(Double.parseDouble(arista[2]));
                            vl.buscarVertex(arista[0]).addAdjacent(aris);
                            
                            //agregando aristas de forma inversa para que sea un grafo no dirigido 
                            Edge aris2 = new Edge(vl.buscar(arista[0]));
                            aris2.setLength(Double.parseDouble(arista[2]));
                            vl.buscarVertex(arista[1]).addAdjacent(aris2);
                            
                        }
                    }
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No ha importado ningun archivo");
        }
    setSubido(true);    
    return vl;   
    }
    
    //funcion para imprimir el grafo (todos los nodos con sus adjacentes y distancias) por consola
    public String imprimir(){
        String info = "";
        String aristas = "";
        info += "ciudad\n";
        String ciudades=""; 
        
        if (this.vertices!=null) {
            Vertex auxV = (Vertex) vertices.getpFirst();
            while(auxV!=null){
                Edge auxE = (Edge) auxV.getAdjacent().getpFirst();
                
                while(auxE!=null){
                    
                    if (!ciudades.contains((String) auxE.getDest().getData())) {
                        String infoArista = auxV.getData() + "," + auxE.getDest().getData()+ "," + String.valueOf(auxE.getLength());
                        aristas += infoArista + "\n";   
                    }
                    auxE = (Edge) auxE.getpNext();  
                }
                ciudades+= (String) auxV.getData() + " ";
                
                info += (String) auxV.getData() + "\n";
                auxV = (Vertex) auxV.getpNext();
            }           
        }
        
        info += "aristas\n";
        info += aristas;
        return info;
    }
    
    //Funcion para a~nadir un vertex (despues de que primero haya sido importado el archivo TXT)
    public void addVertex(String ciudad, String aristas){
        Vertex ver = new Vertex(ciudad);
        if(this.vertices!=null){
            this.vertices.insertarNodo(ver);
            String[] lines = aristas.split("\n");
            for(int i=0; i < lines.length ;i++){
                String[] arista = lines[i].split(",");
                //agrega aristas tal cual como salen en el txt para crear el grafo (pero las aristas solo estan vinculadas en una direccion)
                Edge aris = new Edge(this.vertices.buscar(arista[1]));
                aris.setLength(Double.parseDouble(arista[2]));
                this.vertices.buscarVertex(arista[0]).addAdjacent(aris);

                //agregando aristas de forma inversa para que sea un grafo no dirigido 
                Edge aris2 = new Edge(this.vertices.buscar(arista[0]));
                aris2.setLength(Double.parseDouble(arista[2]));
                this.vertices.buscarVertex(arista[1]).addAdjacent(aris2); 
            }
        }else{
            JOptionPane.showMessageDialog(null, "Antes de agregar ciudades debe importar un archivo");
        }
    }
    
    //Funcion para escribir todo los cambios y guardar en otro archivo TXT
    public void write_txt(){
        String info = "";
        String path = "test/info.txt";
        info=imprimir();
        
        try{
            File file = new File(path);
            PrintWriter pw = new PrintWriter(file);
            pw.print(info);
            pw.close(); 
            JOptionPane.showMessageDialog(null, "El archivo ha sido guardado de forma exitosa");
        }catch (Exception e){
            
        }
                
    }
    
    
    //Funcion para elminar un vertice del grafo
    public void deleteVertex(Nodo x){
        Vertex aux= (Vertex) vertices.getpFirst();
        while(aux != null){
            aux.deleteEdge(x); 
            aux =(Vertex) aux.getpNext();
        }
        vertices.deleteNodo(x);
        
    }
    
    public void updateFeromones(double rho){
        Vertex aux= (Vertex) vertices.getpFirst();
        while(aux != null){
            aux.getAdjacent().actualizarFeromonas(rho);
            aux =(Vertex) aux.getpNext();
        }
        
    }
    
}
