
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Portatil
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        List<Project> projects = new ArrayList();
        List<String> dependencies = new ArrayList();
        
        projects.add(new Project("a"));
        projects.add(new Project("b"));
        projects.add(new Project("c"));
        projects.add(new Project("d"));
        projects.add(new Project("e"));
        projects.add(new Project("f"));
        
        dependencies.add("a");
        dependencies.add("d");
        dependencies.add("f");
        dependencies.add("b");
        dependencies.add("b");
        dependencies.add("d");
        dependencies.add("f");
        dependencies.add("a");
        dependencies.add("d");
        dependencies.add("c");
        
        
        List<String> result = createGraph(projects,dependencies);
        
        System.out.println("Build sequence: ");
        
        printList(result);
        
    }

    public static List createGraph(List<Project> projects, List<String> dependencies) {
        Graph grafo = new Graph();

        //First we add each project to the graph
        for (int i = 0; i < projects.size(); i++) {
            grafo.getOrCreateNode(projects.get(i).getName());
        }

         //Now we add dependencies to each of the projects

        for (int i = 0; i < dependencies.size(); i++) {
            String origin = dependencies.get(i);
            i++;
            String destination = dependencies.get(i);

            //We remove it from the list to know which can be considered the root of the graph
            projects.remove(new Project(destination));

            //We add it to the graph
            grafo.addEdge(origin, destination);

        }

        List result = new ArrayList();

        boolean isLoop = false;

        //To store all the nodes to explore solutions
        Queue<String> cola = new LinkedList();

        //If there is more than 1 project than can become root
        if (projects.size() > 1) {
            int i = 0;
            while (i < projects.size()-1) {
                String destination = projects.get(i).getName();
                i++;
                String origin= projects.get(i).getName();
                grafo.addEdge(origin, destination);
                result.add(origin);
                result.add(destination);
                cola.add(origin);
                cola.add(destination);
            }

        } else if (projects.size() == 1) // If there is only one possibility for root
        {
            result.add(projects.get(0).getName());

            cola.add(projects.get(0).getName());
        }

        //If there is one possible root, we craft the solution
        if (!result.isEmpty()) {
            //While there are more children to look through or there are no more loops
            while (!cola.isEmpty() && !isLoop) {
                
                Project current = grafo.getOrCreateNode(cola.remove());
                
                //We get the children of the current node and prepare the solution and the next nodes
                List<Project> children = current.getChildren();

                //We go through each of the children
                for (Project child : children) {
                    //If the child is not in the solution alrady
                    if (!result.contains(child.getName())) { 
                        result.add(child.getName());
                        cola.add(child.getName());
                    }
                    else if(isThereLoop(grafo,result,child)) //If there is a loop
                    {
                        isLoop = true;
                    }
                    
                }
            }

        }

        return result;

    }
    
    public static boolean isThereLoop(Graph grafo, List<String> lista, Project child)
    {
        int i=0;
        boolean result=false;
        
        while(i<lista.size())
        {
            Project current = grafo.getOrCreateNode(lista.get(i));
            
            //If both a a reference to each other
            
            if(current.containsNeighbor(child.getName()) && child.containsNeighbor(current.getName()))
            {
                result=true;
            }
            
            i++;
            
        }
        
        return result;
    }
    
    public static void printList(List<String> lista)
    {
        lista.forEach((current) -> {
            System.out.print(current+" ");
        });
    }

}
