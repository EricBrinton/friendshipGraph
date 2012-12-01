package apps;

import structures.Graph;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

	
	
	public class Friends{
		
		

			
		
	static Scanner stdin = new Scanner(System.in);
	

		
		static int getOption() {
			System.out.println("\tChoose action: ");
			System.out.println("1) Subgraph");
			System.out.println("2) Shortest path");
			System.out.println("3) Connected islands (cliques)");
			System.out.println("4) Connectors (Friends who keep friends together)");
			System.out.println("5) quit");
			char response = stdin.next().charAt(0);
			while (response !='1' && response !='2' && response != '3' && response != '4' && response != '5'){
				System.out.print("\tYou must enter 1, 2, 3, 4, or 5 => ");
				response = stdin.next().charAt(0);
			}
			return response;
		}
		
		/**
		 * @param args
		 */
		public static void main(String[] args) throws IOException{
			 //TODO Auto-generated method stub
			System.out.print("Enter graph file name => ");
			Graph graph = new Graph(stdin.next());
			String graphFile = stdin.next();

			
			int option;
			while ((option=getOption())!=5){
				
				if(option=='1'){//subgraph
					
					
					
				} 
				else 
					if(option=='2') {//shortestPath
					
						
						
						
					} else
						if(option=='3'){//cliques
	
							
							
					}else 
						if(option=='4') {//connectors
	
							
						}else 
							if (option=='5') {//quit
				
								System.exit(0);
							}
			
			}
		}
	/*	
		public String getGraph() {
			StringBuilder sb = new StringBuilder();
			getHTML(root, sb);
			return sb.toString();
		}
		private void getHTML(TagNode root, StringBuilder sb) {
			for (TagNode ptr=root; ptr != null;ptr=ptr.sibling) {
				if (ptr.firstChild == null) {
					sb.append(ptr.tag);
					sb.append("\n");
				} else {
					sb.append("<");
					sb.append(ptr.tag);
					sb.append(">\n");
					getHTML(ptr.firstChild, sb);
					sb.append("</");
					sb.append(ptr.tag);
					sb.append(">\n");	
				}
			}
		}*/
	}