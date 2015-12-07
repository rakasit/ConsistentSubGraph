package com.B503;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DAG

{
   Map<Integer, Set<Integer>> parent=new HashMap <Integer, Set<Integer>> ();
   Map<Integer, Set<Integer>> children=new HashMap <Integer, Set<Integer>> ();
   
   void addParent(Integer node, Integer par)
   {
	  Set<Integer>tempParent=parent.get(node);
	  if(tempParent==null)
		  tempParent=new HashSet<Integer>();
	  tempParent.add(par);
	  parent.put(node,tempParent );
   }
   
   void addChildren(Integer node, Integer child )
   {
	      Set<Integer>tempChild=children.get(node);
	      if(tempChild==null)
			  tempChild=new HashSet<Integer>();
	      tempChild.add(child);
		  children.put(node,tempChild );
		  
   }
   
   Set<Integer> getParents(Integer node)
   {
	   
	   return parent.get(node);
   }
   Set<Integer> getChildren(Integer node)
   {
	   
	   return children.get(node);
   }
   
   void PrintAdjacencyList()
   {
	   for(Integer i:parent.keySet()){
		   System.out.print("node :="+ i+"parents :="+getParents(i)+"children :="+getChildren(i));
		   System.out.println();
	   }
   }
   
   public static void main(String args[])
   {
	   DAG graph=new DAG();
	   //01
	   graph.addParent(Integer.valueOf(1),null);
	   graph.addChildren(null,1);
	   //12
	   graph.addParent(Integer.valueOf(2),Integer.valueOf(1));
	   graph.addChildren(Integer.valueOf(1), Integer.valueOf(2));
	   //13
	   graph.addParent(Integer.valueOf(3),Integer.valueOf(1));
	   graph.addChildren(Integer.valueOf(1), Integer.valueOf(3));
	   //1,14
	   graph.addParent(Integer.valueOf(14),Integer.valueOf(1));
	   graph.addChildren(Integer.valueOf(1), Integer.valueOf(14));
	   //
	   graph.addParent(Integer.valueOf(14),Integer.valueOf(1));
	   graph.addChildren(Integer.valueOf(1), Integer.valueOf(14));
	   //2,4
	   graph.addParent(Integer.valueOf(4),Integer.valueOf(2));
	   graph.addChildren(Integer.valueOf(2), Integer.valueOf(4));
	   //2,5
	   graph.addParent(Integer.valueOf(5),Integer.valueOf(2));
	   graph.addChildren(Integer.valueOf(2), Integer.valueOf(5));
	   //4,6
	   graph.addParent(Integer.valueOf(6),Integer.valueOf(4));
	   graph.addChildren(Integer.valueOf(4), Integer.valueOf(6));
	   //5,6
	   graph.addParent(Integer.valueOf(6),Integer.valueOf(5));
	   graph.addChildren(Integer.valueOf(5), Integer.valueOf(6));
	   //3,8
	   graph.addParent(Integer.valueOf(8),Integer.valueOf(3));
	   graph.addChildren(Integer.valueOf(3), Integer.valueOf(8));
	   
	   graph.PrintAdjacencyList();
   }
   
}
