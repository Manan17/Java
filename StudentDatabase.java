import java.util.*;
import java.io.*;
class Example
{
	int roll_no;
	String add,name;
	Scanner sc = new Scanner(System.in);
		 
	public void accept()
	{
		System.out.println("Enter Roll no = ");
		roll_no = sc.nextInt();
		System.out.println("Enter name = ");
		name = sc.next();
		System.out.println("Enter address = ");
		add = sc.next();
	}
	public void file()
	{
		try
		{						
			FileWriter fw = new FileWriter("E:\\user.txt",true);
			fw.write(roll_no+";"+name+";"+add+".");
			fw.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void show()
	{
		try
		{
			FileReader fr = new FileReader("E:\\user.txt");
			BufferedReader br = new BufferedReader(fr);
			String data;
			data = br.readLine();
			data = data.replace(";","\t");
			data = data.replace(".","\n");
			System.out.print(data);
			fr.close();
			br.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}	
		
	void search()
	{
		String rollno;		
		try
		{
			System.out.println("Enter rollno to search = ");
			rollno = sc.next();
			FileReader fr = new FileReader("E:\\user.txt");
			BufferedReader br = new BufferedReader(fr);
			String data = br.readLine();
			String[] str = data.split("\\.");
			
			for(int i=0;i<str.length;i++)
			{
				String[] str1 = str[i].split(";");
				if(rollno.equals(str1[0]))
				{
					String newdata = str[i].replace(";","\t");
					System.out.println(newdata);
				}
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}		
	void delete()
	{
		try
		{		
			File f1= new File("E:\\user.txt");
			File f2= new File("E:\\deleted.txt");
			FileReader fr=new FileReader("E:\\user.txt");
			BufferedReader br=new BufferedReader(fr);
			FileWriter fw2=new FileWriter("E:\\deleted.txt");
			String roll;
			System.out.println("Enter a RollNo. to Delete: ");
			roll=sc.next();
			String str=br.readLine();
			String[] arr1=str.split("\\.");
			
			for(int i=0;i<arr1.length;i++)
			{
				String[] arr2=arr1[i].split(";");
				if(roll.equals(arr2[0]))
				{
				}
				else
				{
					fw2.write(arr1[i]+".");					
				}
			}
			fr.close();
			fw2.close();											
			f1.delete();
			f2.renameTo(f1);		
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void update()
	{
		try
		{
			File f1= new File("E:\\user.txt");
			File f2= new File("E:\\deleted.txt");
			FileReader fr=new FileReader("E:\\user.txt");
			BufferedReader br=new BufferedReader(fr);
			FileWriter fw2=new FileWriter("E:\\deleted.txt");
			String roll;
			System.out.println("Enter a RollNo. to Update: ");
			roll=sc.next();

			String str=br.readLine();
			String[] arr1=str.split("\\.");			
			
			for(int i=0;i<arr1.length;i++)
			{
				String[] arr2=arr1[i].split(";");

				if(roll.equals(arr2[0]))
				{
					System.out.println("Enter a Name to Update: ");
					String name = sc.next();
					System.out.println("Enter a Address to Update: ");
					String add = sc.next();
					fw2.write(roll+";"+name+";"+add+".");
					
				}
				else
				{
					fw2.write(arr1[i]+".");
				}
			}
			fr.close();
			fw2.close();											
			f1.delete();
			f2.renameTo(f1);			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
			
	public static void main(String args[])
	{
		
		int choice=1;
		Scanner sc = new Scanner(System.in);
		System.out.println("WELCOME TO STUDENT DATABASE");
		Example obj = new Example();
		while(choice!=6)
		{
			System.out.println("\nMENU \n 1:ADD \n 2:UPDATE  \n 3:SEARCH\n 4:DELETE  \n 5:SHOW \n 6:EXIT \nEnter your choice = ");
			choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:
					obj.accept();
					obj.file();
					break;
				case 2:
					obj.update();
					break;
				case 3:
					obj.search();
					break;	
				case 4:
					obj.delete();
					break;		
				case 5:
					obj.show();
					break;
				case 6:
					break;
				default:
					System.out.println("Enter valid number");
					break;
			}
		
		}		
	}
}
			
					