package project05a;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import project05a.binarytree.Node;

public class twobinary {
	binarytree a=new binarytree();
	int count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		twobinary q=new twobinary();
		q.start();
	}
	public void start() {
		try {
			Scanner files=new Scanner(new File("shuffled_dict.txt"));
			String w=files.nextLine();
			String word=w.split("\\(")[0];
			word=w.substring(0,word.length()-1);
			String c=w.split("\\)")[0];
			c=w.substring(word.length()+2,c.length());
			String meaning=w.substring(word.length()+3+c.length());
			a.insert(new Node(word,c,meaning));
			count++;
			while(files.hasNextLine()) {
				w=files.nextLine();
				word=w.split("\\(")[0];
				word=w.substring(0,word.length()-1);
				c=w.split("\\)")[0];
				c=w.substring(word.length()+2,c.length());
				meaning=w.substring(word.length()+3+c.length());
				a.insert(new Node(word,c,meaning));
				count++;
			}
			files.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true) {
			Scanner kb =new Scanner(System.in);
			String comma=kb.next();
			if(comma.equals("size")) {
				System.out.println(count);
			}
			else if(comma.equals("find"))
			{
				String word=kb.next();
				Node find=a.serch(new Node (word,null,null));
				if(find==null)
				{
					System.out.println("Not found");
				}
				else
					System.out.println(find.ex);
			}
			else if(comma.equals("add"))
			{
				System.out.print("word: ");
				String word=kb.next();
				System.out.print("class: ");
				kb.nextLine();
				String c=kb.nextLine();
				System.out.print("meaning: ");
				String meaning=kb.next();
				a.insert(new Node(word,c,meaning));
				count++;
			}
			else if(comma.equals("delete"))
			{
				String word=kb.next();
				Node find=a.delete(new Node(word,null,null));
				if(find==null)
				{
					System.out.println("Not found");
				}
				else {
					System.out.println("Deleted successfully");
				}
			}
			else if(comma.equals("deleteall"))
			{
				int num=0;
				comma=kb.next();
				try {
					Scanner files=new Scanner(new File(comma));
					String word=files.next();
					Node find=a.delete(new Node(word,null,null));
					num++;
					while(files.hasNext()) {
						word=files.next();
						find=a.delete(new Node(word,null,null));
						num++;
					}
					System.out.println(num+" words were deleted successfully.");
					files.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(comma.equals("exit"))
			{
				System.exit(0);
				kb.close();
			}
		}
		
	}

}
