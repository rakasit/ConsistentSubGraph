package com.B503;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/*We WIll do it*/

public class DAG {


	private Map<Integer,List<Integer>> nodes = new HashMap<Integer,List<Integer>>();
	private static Map<Map<Integer,Set<Integer>>,Set<Integer>> n = new HashMap<Map<Integer,Set<Integer>>,Set<Integer>>();
	private static Stack s1=new Stack();
	static int child=-1,parent=-1;

	public String toString () {
		StringBuffer s = new StringBuffer();
		for (Integer v: nodes.keySet()) s.append("\n    " + v + " -> " + nodes.get(v));
		return s.toString();                
	}


	public void add (Integer vertex) {
		if (nodes.containsKey(vertex)) return;
		nodes.put(vertex, new ArrayList<Integer>());
	}


	public boolean contains (Integer vertex) {
		return nodes.containsKey(vertex);
	}


	public void add (Integer from, Integer to) {
		this.add(from); this.add(to);
		nodes.get(from).add(to);
	}


	public void remove (Integer from, Integer to) {
		if (!(this.contains(from) && this.contains(to)))
			throw new IllegalArgumentException("Nonexistent vertex");
		nodes.get(from).remove(to);
	}


	public static void main (String[] args) throws IOException {

		DAG graph = new DAG();

		// final Scanner in = new Scanner(new File(args[0]));
		//final PrintWriter pr = new PrintWriter(new FileWriter(new File(args[1])));
		//in.nextLine();
		/*while (in.hasNextLine()) {
			final String line = in.nextLine();
			final String[] parts = line.split("");*/
		Map<Integer,Set<Integer>> m1=new HashMap<Integer,Set<Integer>>();

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		graph.add(0,1);
		System.out.println("keys"+n.keySet());

		if(n.keySet().isEmpty())
		{	

			m1.put((Integer)0,new HashSet());
			Set<Integer> l=new HashSet();
			l.add(Integer.valueOf(1));
			n.put(m1,l);

			//adding parent for the child
			m1=new HashMap<Integer,Set<Integer>>();
			m1.put((Integer)1,new HashSet());
			l=new HashSet();
			l.add(Integer.valueOf(0));
			m1.put((Integer)1,l);
			n.put(m1,new HashSet());



		}
		System.out.println(n);
		// if(n.keySet().isEmpty())
		//  System.out.println("yes");
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		graph.add(0,2);
		if(n.keySet().isEmpty())
		{

		}
		else
		{
			for(Map<Integer,Set<Integer>>m2:n.keySet())
			{
				if(m2.containsKey((Integer)0))
				{
					Set l;
					l=m2.get((Integer)0);
					Map<Integer,Set<Integer>>m3=new HashMap<Integer,Set<Integer>>();
					m3.put((Integer)0, l);
					Set l1;
					l1=n.get(m3);
					l1.add((Integer)2);
					n.put(m3, l1);
					child=0;
					// System.out.println(n);
				}
				if(m2.containsKey((Integer)2))
				{
					Set l;
					l=m2.get((Integer)2);
					l.add((Integer)0);
					m2.put((Integer)2,l);
					l=n.get(m2);
					parent=0;
					n.put(m2,l);


				}
			}

			if(child==-1 && parent==-1)
			{
				m1.put((Integer)0,new HashSet());
				Set<Integer> l=new HashSet();
				l.add(Integer.valueOf(2));
				n.put(m1,l);

				//adding parent for the child
				m1=new HashMap<Integer,Set<Integer>>();
				m1.put((Integer)2,new HashSet());
				l=new HashSet();
				l.add(Integer.valueOf(0));
				m1.put((Integer)2,l);
				n.put(m1,new HashSet());	  
			}
			if(child==-1 && parent==0)
			{
				m1.put((Integer)0,new HashSet());
				Set<Integer> l=new HashSet();
				l.add(Integer.valueOf(2));
				n.put(m1,l);  
			}
			if(child==0 && parent==-1)
			{
				Set<Integer> l=new HashSet();
				m1=new HashMap<Integer,Set<Integer>>();
				m1.put((Integer)2,new HashSet());
				l=new HashSet();
				l.add(Integer.valueOf(0));
				m1.put((Integer)2,l);
				n.put(m1,new HashSet());
			}

			System.out.println(n);





		}


		//	  .................................................................................................................................
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		graph.add(0,6);


		for(Map<Integer,Set<Integer>>m2:n.keySet())
		{
			if(m2.containsKey((Integer)0))
			{
				Set l;
				l=m2.get((Integer)0);
				Map<Integer,Set<Integer>>m3=new HashMap<Integer,Set<Integer>>();
				m3.put((Integer)0, l);
				Set l1;
				l1=n.get(m3);
				l1.add((Integer)6);
				n.put(m3, l1);
				child=0;
				// System.out.println(n);
			}
			if(m2.containsKey((Integer)6))
			{
				Set l;
				l=m2.get((Integer)6);
				l.add((Integer)0);
				m2.put((Integer)6,l);
				l=n.get(m2);
				parent=0;
				n.put(m2,l);


			}
		}

		if(child==-1 && parent==-1)
		{
			m1.put((Integer)0,new HashSet());
			Set<Integer> l=new HashSet();
			l.add(Integer.valueOf(6));
			n.put(m1,l);

			//adding parent for the child
			m1=new HashMap<Integer,Set<Integer>>();
			m1.put((Integer)6,new HashSet());
			l=new HashSet();
			l.add(Integer.valueOf(0));
			m1.put((Integer)6,l);
			n.put(m1,new HashSet());	  
		}
		if(child==-1 && parent==0)
		{
			m1.put((Integer)0,new HashSet());
			Set<Integer> l=new HashSet();
			l.add(Integer.valueOf(6));
			n.put(m1,l);  
		}
		if(child==0 && parent==-1)
		{
			Set<Integer> l=new HashSet();
			m1=new HashMap<Integer,Set<Integer>>();
			m1.put((Integer)6,new HashSet());
			l=new HashSet();
			l.add(Integer.valueOf(0));
			m1.put((Integer)6,l);
			n.put(m1,new HashSet());
		}

		System.out.println(n);



		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


		graph.add(1,3);

		for(Map<Integer,Set<Integer>>m2:n.keySet())
		{
			if(m2.containsKey((Integer)1))
			{
				Set l;
				l=m2.get((Integer)1);
				Map<Integer,Set<Integer>>m3=new HashMap<Integer,Set<Integer>>();
				m3.put((Integer)1, l);
				Set l1;
				l1=n.get(m3);
				l1.add((Integer)3);
				n.put(m3, l1);
				child=0;
				// System.out.println(n);
			}
			if(m2.containsKey((Integer)3))
			{
				Set l;
				l=m2.get((Integer)3);
				l.add((Integer)1);
				m2.put((Integer)1,l);
				l=n.get(m2);
				parent=0;
				n.put(m2,l);


			}
		}

		if(child==-1 && parent==-1)
		{
			m1.put((Integer)1,new HashSet());
			Set<Integer> l=new HashSet();
			l.add(Integer.valueOf(3));
			n.put(m1,l);

			//adding parent for the child
			m1=new HashMap<Integer,Set<Integer>>();
			m1.put((Integer)3,new HashSet());
			l=new HashSet();
			l.add(Integer.valueOf(1));
			m1.put((Integer)3,l);
			n.put(m1,new HashSet());	  
		}
		if(child==-1 && parent==0)
		{
			m1.put((Integer)1,new HashSet());
			Set<Integer> l=new HashSet();
			l.add(Integer.valueOf(3));
			n.put(m1,l);  
		}
		if(child==0 && parent==-1)
		{
			Set<Integer> l=new HashSet();
			m1=new HashMap<Integer,Set<Integer>>();
			m1.put((Integer)3,new HashSet());
			l=new HashSet();
			l.add(Integer.valueOf(1));
			m1.put((Integer)3,l);
			n.put(m1,new HashSet());
		}

		System.out.println(n);


		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





		graph.add(3,4);


		for(Map<Integer,Set<Integer>>m2:n.keySet())
		{
			if(m2.containsKey((Integer)3))
			{
				Set l;
				l=m2.get((Integer)3);
				Map<Integer,Set<Integer>>m3=new HashMap<Integer,Set<Integer>>();
				m3.put((Integer)3, l);
				Set l1;
				l1=n.get(m3);
				l1.add((Integer)4);
				n.put(m3, l1);
				child=0;
				// System.out.println(n);
			}
			if(m2.containsKey((Integer)4))
			{
				Set l;
				l=m2.get((Integer)4);
				l.add((Integer)3);
				m2.put((Integer)3,l);
				l=n.get(m2);
				parent=0;
				n.put(m2,l);


			}
		}

		if(child==-1 && parent==-1)
		{
			m1.put((Integer)3,new HashSet());
			Set<Integer> l=new HashSet();
			l.add(Integer.valueOf(4));
			n.put(m1,l);

			//adding parent for the child
			m1=new HashMap<Integer,Set<Integer>>();
			m1.put((Integer)4,new HashSet());
			l=new HashSet();
			l.add(Integer.valueOf(3));
			m1.put((Integer)4,l);
			n.put(m1,new HashSet());	  
		}
		if(child==-1 && parent==0)
		{
			m1.put((Integer)3,new HashSet());
			Set<Integer> l=new HashSet();
			l.add(Integer.valueOf(4));
			n.put(m1,l);  
		}
		if(child==0 && parent==-1)
		{
			Set<Integer> l=new HashSet();
			m1=new HashMap<Integer,Set<Integer>>();
			m1.put((Integer)4,new HashSet());
			l=new HashSet();
			l.add(Integer.valueOf(3));
			m1.put((Integer)4,l);
			n.put(m1,new HashSet());
		}

		System.out.println(n);
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// graph.add(3,5);
		graph.add(6,5);



		for(Map<Integer,Set<Integer>>m2:n.keySet())
		{
			if(m2.containsKey((Integer)6))
			{
				Set l;
				l=m2.get((Integer)6);
				Map<Integer,Set<Integer>>m3=new HashMap<Integer,Set<Integer>>();
				m3.put((Integer)6, l);
				Set l1;
				l1=n.get(m3);
				l1.add((Integer)5);
				n.put(m3, l1);
				child=0;
				// System.out.println(n);
			}
			if(m2.containsKey((Integer)5))
			{
				Set l;
				l=m2.get((Integer)5);
				l.add((Integer)6);
				m2.put((Integer)6,l);
				l=n.get(m2);
				parent=0;
				n.put(m2,l);


			}
		}

		if(child==-1 && parent==-1)
		{
			m1.put((Integer)6,new HashSet());
			Set<Integer> l=new HashSet();
			l.add(Integer.valueOf(5));
			n.put(m1,l);

			//adding parent for the child
			m1=new HashMap<Integer,Set<Integer>>();
			m1.put((Integer)5,new HashSet());
			l=new HashSet();
			l.add(Integer.valueOf(6));
			m1.put((Integer)5,l);
			n.put(m1,new HashSet());	  
		}
		if(child==-1 && parent==0)
		{
			m1.put((Integer)6,new HashSet());
			Set<Integer> l=new HashSet();
			l.add(Integer.valueOf(5));
			n.put(m1,l);  
		}
		if(child==0 && parent==-1)
		{
			Set<Integer> l=new HashSet();
			m1=new HashMap<Integer,Set<Integer>>();
			m1.put((Integer)5,new HashSet());
			l=new HashSet();
			l.add(Integer.valueOf(6));
			m1.put((Integer)5,l);
			n.put(m1,new HashSet());
		}

		System.out.println(n);
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		graph.add(2,3);


		for(Map<Integer,Set<Integer>>m2:n.keySet())
		{
			System.out.println("in for");
			System.out.println(m2);
			if(m2.containsKey((Integer)2))
			{
				Set l;
				l=m2.get((Integer)2);
				Map<Integer,Set<Integer>>m3=new HashMap<Integer,Set<Integer>>();
				m3.put((Integer)2, l);
				Set l1;
				l1=n.get(m3);
				l1.add((Integer)3);
				n.put(m3, l1);
				child=0;
				System.out.println("first if "+ n);
			}
			if(m2.containsKey((Integer)3))
			{
				Set l;
				l=m2.get((Integer)3);
				System.out.println("scnd if 1"+n);
				l.add((Integer)2);
				System.out.println("scnd if 2"+n);
				m2.put((Integer)3,l);
				// System.out.println("scnd if 3"+n);
				//l=n.get(m2);
				//System.out.println("value of l"+l);
				parent=0;
				//System.out.println("scnd if 5"+n);
				//n.put(m2,l);

				System.out.println("scnd if"+n);
			}
		}

		if(child==-1 && parent==-1)
		{
			m1.put((Integer)2,new HashSet());
			Set<Integer> l=new HashSet();
			l.add(Integer.valueOf(3));
			n.put(m1,l);

			//adding parent for the child
			m1=new HashMap<Integer,Set<Integer>>();
			m1.put((Integer)3,new HashSet());
			l=new HashSet();
			l.add(Integer.valueOf(2));
			m1.put((Integer)3,l);
			n.put(m1,new HashSet());	
			System.out.println("c -1 p =-1 "+n);
		}
		if(child==-1 && parent==0)
		{
			m1.put((Integer)2,new HashSet());
			Set<Integer> l=new HashSet();
			l.add(Integer.valueOf(3));
			n.put(m1,l);  
			System.out.println("c -1 p 0" +n);
		}
		if(child==0 && parent==-1)
		{
			Set<Integer> l=new HashSet();
			m1=new HashMap<Integer,Set<Integer>>();
			m1.put((Integer)3,new HashSet());
			l=new HashSet();
			l.add(Integer.valueOf(2));
			m1.put((Integer)3,l);
			n.put(m1,new HashSet());
			System.out.println("c 0 p -1 "+n);
		}

		System.out.println(n);
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		graph.add(7,4);

		System.out.println("adding 7,4");
		child=-1;
		parent =-1;

		for(Map<Integer,Set<Integer>>m2:n.keySet())
		{
			System.out.println("in for");
			System.out.println(m2);
			if(m2.containsKey((Integer)7))
			{
				Set l;
				l=m2.get((Integer)7);
				Map<Integer,Set<Integer>>m3=new HashMap<Integer,Set<Integer>>();
				m3.put((Integer)7, l);
				Set l1;
				l1=n.get(m3);
				l1.add((Integer)4);
				n.put(m3, l1);
				child=0;
				System.out.println("first if "+ n);
			}
			if(m2.containsKey((Integer)4))
			{
				Set l;
				l=m2.get((Integer)4);
				System.out.println("scnd if 1"+n);
				l.add((Integer)7);
				System.out.println("scnd if 2"+n);
				m2.put((Integer)4,l);
				// System.out.println("scnd if 3"+n);
				//l=n.get(m2);
				//System.out.println("value of l"+l);
				parent=0;
				//System.out.println("scnd if 5"+n);
				//n.put(m2,l);

				System.out.println("scnd if"+n);
			}
		}

		if(child==-1 && parent==-1)
		{
			m1=new HashMap<Integer,Set<Integer>>();
			m1.put((Integer)7,new HashSet());
			Set<Integer> l=new HashSet();
			l.add(Integer.valueOf(4));
			n.put(m1,l);

			//adding parent for the child
			m1=new HashMap<Integer,Set<Integer>>();
			m1.put((Integer)4,new HashSet());
			l=new HashSet();
			l.add(Integer.valueOf(7));
			m1.put((Integer)4,l);
			n.put(m1,new HashSet());	
			System.out.println("c -1 p =-1 "+n);
		}
		if(child==-1 && parent==0)
		{
			m1=new HashMap<Integer,Set<Integer>>();
			m1.put((Integer)7,new HashSet());
			Set<Integer> l=new HashSet();
			l.add(Integer.valueOf(4));
			n.put(m1,l);  
			System.out.println("c -1 p 0" +n);
		}
		if(child==0 && parent==-1)
		{
			Set<Integer> l=new HashSet();
			m1=new HashMap<Integer,Set<Integer>>();
			m1.put((Integer)4,new HashSet());
			l=new HashSet();
			l.add(Integer.valueOf(7));
			m1.put((Integer)4,l);
			n.put(m1,new HashSet());
			System.out.println("c 0 p -1 "+n);
		}

		System.out.println(n);


		//}

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		graph.add(6,4);
		child=-1;
		parent =-1;

		for(Map<Integer,Set<Integer>>m2:n.keySet())
		{
			System.out.println("in for");
			System.out.println(m2);
			if(m2.containsKey((Integer)6))
			{
				Set l;
				l=m2.get((Integer)6);
				Map<Integer,Set<Integer>>m3=new HashMap<Integer,Set<Integer>>();
				m3.put((Integer)6, l);
				Set l1;
				l1=n.get(m3);
				l1.add((Integer)4);
				n.put(m3, l1);
				child=0;
				System.out.println("first if "+ n);
			}
			if(m2.containsKey((Integer)4))
			{
				Set l;
				l=m2.get((Integer)4);
				System.out.println("scnd if 1"+n);
				l.add((Integer)6);
				System.out.println("scnd if 2"+n);
				m2.put((Integer)4,l);
				// System.out.println("scnd if 3"+n);
				//l=n.get(m2);
				//System.out.println("value of l"+l);
				parent=0;
				//System.out.println("scnd if 5"+n);
				//n.put(m2,l);

				System.out.println("scnd if"+n);
			}
		}

		if(child==-1 && parent==-1)
		{
			m1=new HashMap<Integer,Set<Integer>>();
			m1.put((Integer)6,new HashSet());
			Set<Integer> l=new HashSet();
			l.add(Integer.valueOf(4));
			n.put(m1,l);

			//adding parent for the child
			m1=new HashMap<Integer,Set<Integer>>();
			m1.put((Integer)4,new HashSet());
			l=new HashSet();
			l.add(Integer.valueOf(6));
			m1.put((Integer)4,l);
			n.put(m1,new HashSet());	
			System.out.println("c -1 p =-1 "+n);
		}
		if(child==-1 && parent==0)
		{
			m1=new HashMap<Integer,Set<Integer>>();
			m1.put((Integer)6,new HashSet());
			Set<Integer> l=new HashSet();
			l.add(Integer.valueOf(4));
			n.put(m1,l);  
			System.out.println("c -1 p 0" +n);
		}
		if(child==0 && parent==-1)
		{
			Set<Integer> l=new HashSet();
			m1=new HashMap<Integer,Set<Integer>>();
			m1.put((Integer)4,new HashSet());
			l=new HashSet();
			l.add(Integer.valueOf(6));
			m1.put((Integer)4,l);
			n.put(m1,new HashSet());
			System.out.println("c 0 p -1 "+n);
		}

		System.out.println(n);
		
		//Traversing the subgraphs of the saved graph
		Set<Integer>l=new HashSet<Integer>();
		for(Map<Integer,Set<Integer>>m2:n.keySet())
		{
			//System.out.println(m2);
			for(Integer i:m2.keySet())
			{
				//System.out.println("The key"+i);
				Set<Integer>st =m2.get(i);
				 l.add(i);
				for(Integer j:st)
				{
					        System.out.println(i);
					       
			        		s1.push(j);
			        		
			        		
				}
				
				while(!s1.isEmpty())
        		{
        			
        			Integer k=(Integer)s1.pop();
        			l.add(k);
        			for(Map<Integer,Set<Integer>>m3:n.keySet()){
        				if(m3.containsKey(k))
        				{
        					Set<Integer>st1 =m3.get(k);
        					
        					for(Integer m:st1)
        					{
        						        System.out.println(i);
        						       
        				        		s1.push(m);
        				        		
        				        		
        					}
        					break;
        					
        				}
        			}
        			
        		}
				
				System.out.println("The subgraph"+l);
				
			}
			
		
		}

		System.out.println("The current graph: " + graph);
		// pr.println(graph);

	}
}
