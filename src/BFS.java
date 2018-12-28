/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author user
 */
public class BFS {
    

    public void visit(String[]s6,int a1[][], int start, int dest) {
        ArrayList a2 = new ArrayList();
        ArrayList a3 = new ArrayList();
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        int vertex = a1.length - 1;
        ArrayList collision=new ArrayList();
        ArrayList cl=new ArrayList();
        ArrayList fcl=new ArrayList();
        ArrayList fclout=new ArrayList();
        int [] parentfor=new int[vertex+1];
        int [] parentback=new int[vertex+1];
        int index;

        int[] visited1 = new int[vertex + 1];
        int[] visited2 = new int[vertex + 1];
        int i;
        int b;

        visited1[start] = 1;
        visited2[dest] = 1;
        //System.out.print("BFS: ");
//        for(int j=start;j<=dest;j++)
//        {
//            q1.add(j);
//        }
        
//        for(int j=dest;j>=start;j--)
//        {
//            q2.add(j);
//        }
        q1.add(start);
        //System.out.println("q1: " + q1);
        q2.add(dest);
        //System.out.println("q2: " + q2);
        int swap = 0;

        //int match1=-1, match2=-1;
        //boolean Break = false;

        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (swap == 0) {
                b = q1.remove();
                collision.add(s6[b]);
                //System.out.println(collision);
                i = 0;
                for (int j = 0; j < collision.size(); j++) {
                    for (int k = 0; k < cl.size(); k++) {
                        if(collision.get(j).equals(cl.get(k)))
                        {
                            //System.out.println("Forward : "+ collision.get(j));
                            fcl.add(collision.get(j));
                            fclout.add("Forward : "+ collision.get(j));
                            break;
                        }
                    }
                }

                //System.out.print(s6[b] + "-> ");

                while (i <= vertex) {
                    
                    
                    if (a1[b][i] == 1 && visited1[i] == 0) 
                    {
                        q1.add(i);
                        parentfor[i]=b;
                        //System.out.print(parentfor[i]+" ");
                        visited1[i] = 1;
                        a2.add(s6[i]);
                    }
                    i++;
                }
                swap = 1;

            } else if (swap == 1) {

                b = q2.remove();
                cl.add(s6[b]);
                //System.out.println(cl);
                i = 0;
                
                for (int j = 0; j < cl.size(); j++) {
                    for (int k = 0; k < collision.size(); k++) {
                        if(cl.get(j).equals(collision.get(k)))
                        {
                            //System.out.println("Backward : "+ cl.get(j));
                            fcl.add(cl.get(j));
                            fclout.add("Forward : "+ cl.get(j));
                            break;
                        }
                    }
                }
                

                //System.out.print(s6[b] + "-> ");
                while (i <= vertex) {
                    
                    
                    if (a1[b][i] == 1 && visited2[i] == 0) 
                    {
                        q2.add(i);
                        parentback[i]=b;
                        //System.out.print(parentback[i]+" ");
                        visited2[i] = 1;
                        a3.add(s6[i]);
                    }
                    i++;
                }
                swap = 0;

            }

//            for (int k = 0; k < a2.size(); k++) {
//                for (int l = 0; l < a3.size(); l++) {
//                    if (a2.get(k) == a3.get(l)) {
//                        match1 = (int) a2.get(k);
//                        match2 = (int) a3.get(l);
//                        Break = true;
//                    }
//
////                    if (Break) {
////                        break;
////                    }
//                }
////                if (Break) {
////                    break;
////                }
//            }

//            if (Break) {
//                System.out.println(match1);
//                System.out.println(match2);
//                //break;
//            }

        }
//        System.out.println();
//        System.out.print(a2 + " ");
//        System.out.println();
//        System.out.print(a3 + " ");
//        System.out.println();
        System.out.println(fcl.get(0));
        System.out.println(fclout.get(0));
        index=0;
        for (int j = 0; j < s6.length; j++) {
            if(fcl.get(0).equals(s6[j])){
                index=index+j;
            }
        }
        int count=0;
        //System.out.println(index);
        //System.out.println(parentfor[index]);
        //System.out.println(parentback[index]);
        System.out.print("Route: "+s6[start]+" --> ");
       
        if(parentfor[index]!=start)
        {
            System.out.print(s6[parentfor[index]]+" --> ");
            parentfor[index]=parentfor[parentfor[index]];
            count=count+1;
        }
        if(parentback[index]!=dest)
        {
            System.out.print(s6[parentback[index]]+" --> ");
            parentback[index]=parentback[parentback[index]];
            count=count+1;
        }
        else
        {
            System.out.print(s6[index]+" --> "+s6[dest]);
            count=count+1;
        }
        System.out.println();
        System.out.println("Length: "+count);
          


    }

}
