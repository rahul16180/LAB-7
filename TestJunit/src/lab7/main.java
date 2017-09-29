//RAHUL SAINI
//2016180
package lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

 class music implements Serializable
	{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		String name,singer;
		int duration;
		
		music(String name, String singer, int duration)
		{
			this.name=name;
			this.singer=singer;
			this.duration=duration;
			
		}
		
		public String toString()
		{
			return(this.name +","+ this.singer +","+ this.duration);
		}
	}

public class main {
	
	 static void add(ArrayList<music> playlist,String n,String s,int d)
	{
		        			
		playlist.add(new music(n,s,d));
		System.out.println(playlist.size());
	}

	static void delete(ArrayList<music> playlist, String del)
	{
		int k=1;
		while(k<=playlist.size())
		{   
			
			if(playlist.get(k-1).name.equals(del))
			{
				playlist.remove(k-1);
				System.out.println(playlist.size());
				break;
			} 
			
			if(k==playlist.size()-1)
			{
				System.out.println("Song Not Found");
				break;
			}
			
			k++;
		}
	}
	
	static void search(ArrayList<music> playlist, String search)
	{
		int i=0;
		while(i<playlist.size())
		{   
			
			if(playlist.get(i).name.equals(search))
			{
				System.out.println(playlist.get(i).name + "  " + playlist.get(i).singer + "  " + playlist.get(i).duration);
				break;
			} 
			
			if(i==playlist.size()-1)
			{
				System.out.println("Song Not Found");
				break;
			}
			
			i++;
		}
	}
	
	static void show(ArrayList<music> playlist)
	{
		int l=0;
		while(l<playlist.size())
		{
			System.out.println("Name:"+playlist.get(l).name + "  Singer:" + playlist.get(l).singer + "  Duration:" + playlist.get(l).duration);
			l++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String filename=in.nextLine();
		File f = new File("./src/" + filename + ".txt");
		@SuppressWarnings("resource")
		Scanner infile = new Scanner(f);
		
		FileOutputStream fout=new FileOutputStream(filename);  
		@SuppressWarnings("resource")
		ObjectOutputStream out=new ObjectOutputStream(fout);
		
		boolean exit=true;
		
		ArrayList<music> playlist = new ArrayList<music>();
		
		  out.writeObject(playlist);  
		  out.flush();  
		
		String data;
		
		try {
		while(infile.hasNext()) 
		{ 
			data=infile.nextLine();
			String[] dataarray=data.split(",");
			String name=dataarray[0];
			String singer=dataarray[1];
			int duration=Integer.parseInt(dataarray[2]);
			playlist.add(new music(name,singer,duration));
		}
		}
		catch(Exception e)
		{
			System.out.println("Empty");
		}
		
		
		
		System.out.println("No Of Songs : " + playlist.size());
			
		
        while(exit)
        {
        	System.out.println("MENU");
        	System.out.println("1.Add");
        	System.out.println("2.Delete");
        	System.out.println("3.Search");
        	System.out.println("4.Show");
        	System.out.println("5.Exit");
        	
        	int choice=in.nextInt();
        	switch(choice)
        	{
        		case 1: 
        			String n=in.next();
        			String s=in.next();
        			int d = in.nextInt();
        			add(playlist,n,s,d);
        			break;
        			
        		case 2:
        			System.out.println("Enter The Song To Be Deleted");
        			String del=in.next();
        			delete(playlist,del);
        			break;
        			
        			
        		case 3:
        			System.out.println("Enter The Song To Be Searched");
        			String search=in.next();
        			search(playlist,search);
        			break;
        			
        		case 4:
        			show(playlist);
        			break;
        			
        		case 5:
        			PrintWriter w = new PrintWriter("./src/" + filename + ".txt", "UTF-8");
        			int j=0;
        			while(j<playlist.size())
        			{
        				w.println(playlist.get(j));
        				j++;
        			}
        			w.close();
        			exit=false;
        			break;
        			
        		
        		
    		}
        	 
        	
        }

	}

}
