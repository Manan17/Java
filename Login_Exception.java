import java.util.*;

class PasswordFormatException extends Exception

{
	PasswordFormatException(String s)
	{
		super(s);
	}
}


class TestCustomException
{
	Scanner sc= new Scanner(System.in);
	String name,upass,confirm;
	char[] pass;
	int plen=0,spl=0,up=0,low=0,digits=0;

	public void accept()
	{
		
		System.out.println("Enter name");
		name=sc.next();
		System.out.println("Enter password of exactly 8 characters = ");
		upass=sc.next();
			
		try
		{
			validate(upass);
			
			System.out.println("Confirm Password = ");
			confirm=sc.next();	
			
			if(upass.equals(confirm))
			{
				System.out.println("Password match ");
			}	
			else
			{
				System.out.println("password does not match");
			}
		}
		catch(Exception m)
		{
			System.out.println("Exception Occured : "+m);
		}
				
		
	
				


	}

	 void validate(String data)throws PasswordFormatException
	{
		pass=data.toCharArray();
		

		if(pass.length==8)
		{	
			if(pass[0]>='A' && pass[0]<='Z' || pass[0]>='a' && pass[0]<='z')
			{	
				for(plen=0;plen<8;plen++)
				{
		
					if(pass[plen]=='@' || pass[plen]=='_')
					{
						spl++;
					}
				
					if(pass[plen]>='A' && pass[plen]<='Z')	
					{
						up++;
					}									
					if(pass[plen]>='a' && pass[plen]<='z')	
					{
						low++;
					}		
					if(pass[plen]>='0' && pass[plen]<='9')
					{
						digits++;
					}
				}
			}
			else
			{
				throw new PasswordFormatException("First character has to be an alaphabet:");
			}

			if(spl<1 || up<1 || low < 1 || digits <1)
			{
				String error = "\n\tEnter atleast one uppercase\n";
				error+="\n\tEnter atleast one lowercase\n";
				error=error+"\n\tEnter atleast one digit\n";
				error=error+"\n\tEnter special character(@ | _)";

				throw new PasswordFormatException(error);
			}	
		}	
		else
		{
			throw new PasswordFormatException("Enter 8 characters only");
		
		}
		
	}	
	
    	
	public static void main(String a[])
	{
		TestCustomException obj=new TestCustomException();
		obj.accept();
		
		
	}
}