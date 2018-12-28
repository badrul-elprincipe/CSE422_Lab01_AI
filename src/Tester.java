/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;
/**
 *
 * @author user
 */
public class Tester {
    static String[]city;
    static Edge[]e1;
    static int [][] a;
    static int n1;
    static int n2;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try
        {
           FileReader f=new FileReader("bidivfgf.txt");
           BufferedReader br=new BufferedReader(f);
           String s=br.readLine();
           StringTokenizer st=new StringTokenizer(s," ");
           int v=Integer.parseInt(st.nextToken()); //number of cities
           int e=Integer.parseInt(st.nextToken()); //number of edges
           
           
           String start=br.readLine(); //start destination
           String dest=br.readLine();  //final destination
           
           System.out.println("Start: "+start);
           System.out.println("Destination: "+dest);
           city=new String[v];
           for(int i=0;i<v;i++)
           {
               city[i]=br.readLine().toString();
               System.out.println(city[i]);
           }
           
            e1=new Edge[e];
            for (int i = 0; i < e; i++) 
            {
                s=br.readLine();
                st= new StringTokenizer(s,",");
                e1[i]=new Edge(st.nextToken().toString(),st.nextToken().toString());
                System.out.println(e1[i].s1+ " "+ e1[i].s2);
            }
            
            //adjacency matrix
            a=new int[v][v];
            for (int i = 0; i < v; i++) {
                String compare=city[i];
                for (int j = 0; j < e; j++) {
                    if(e1[j].s1.equals(compare))
                    {
                        Index(i,e1[j].s2);
                    }
                    if(e1[j].s2.equals(compare))
                    {
                        Index(i,e1[j].s1);
                    }
                }
            }
           
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    System.out.print(a[i][j]+" ");
                }
                System.out.println();
                
            }
            
            n1=0;
            n2=0;
            for (int i = 0; i < v; i++) {
                if(city[i].equals(start)){
                    n1=n1+i;
                }
                if(city[i].equals(dest))
                {
                    n2=n2+i;
                }
            }
            System.out.println(n1);
            System.out.println(n2);
            BFS bfs=new BFS();
            bfs.visit(city,a, n1, n2);
           
           
           
           
//           for(int i=0;i<v;i++) //printing adjacency matrix
//           {
//               
//               for(int j=0;j<v;j++)
//               {
//                   System.out.print(a[i][j]+" ");
//                  
//               }
//               System.out.println();
//           }
//           
//           
//           b.visit(a,0,8);

        

           

        }
        catch(IOException e)
        {
            System.out.println("File not found");
        }
        
    }
    public static void Index(int x,String s4)
    {
        for (int i = 0; i < city.length; i++) {
            if(city[i].equals(s4))
            {
                a[x][i]=1;
            }
        }
    }
    
}
