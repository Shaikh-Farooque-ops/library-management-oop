package com.library;

import com.library.exceptions.BookNotAvailableException;
import com.library.library.Library;
import com.library.models.Book;
import com.library.users.Member;
import com.library.utils.InputHelper;

public class Main {

	public static void main(String[] args) {	

		Library library = new Library();
		library.addItem(new Book(1, "Core Java", "James Gosling", true, 250, "Programming"));
		library.addItem(new Book(2, "Advance Java", "Rod Johnson", true, 300, "Technology"));
		library.addItem(new Book(3, "Spring Boot", "Grady Booch", true, 200, "Education"));
		
		System.out.println();
		
	    library.registerMember(new Member(101, "Farry", "farry@gmail.com"));
	    library.registerMember(new Member(102, "Ayesha", "ayesha@gmail.com"));
	    library.registerMember(new Member(103, "Rahul", "rahul123@gmail.com"));
	    
	    while(true)
	    {
	    	System.out.println("\n======== LIBRARY MENU ========");
	    	System.out.println("1. Issue Item");
            System.out.println("2. Return Item");
            System.out.println("3. Show All Items");
            System.out.println("4. Show Available Items");
            System.out.println("5. Exit");
            System.out.println("===============================");
            
            int choice = InputHelper.readInt("Enter your choice: ");
            
            switch(choice)
            {
            	case 1:
            		int issueItemId = InputHelper.readInt("Enter Item ID to issue: ");
            		int issueMemberId = InputHelper.readInt("Enter Member ID: ");
            		
            		try
            		{
            			library.issueItem(issueItemId, issueMemberId);
            		}
            		catch(BookNotAvailableException e)
            		{
            			 System.out.println(e.getMessage());
            		}
            		break;
            		
            	case 2:
            		 int returnItemId = InputHelper.readInt("Enter Item ID to return: ");
                     int returnMemberId = InputHelper.readInt("Enter Member ID: ");
                     library.returnItem(returnItemId, returnMemberId);
                     break;
                     
            	 case 3:
                     library.showAllItems();
                     break;

                 case 4:
                     library.showAvailableItems();
                     break;
                     
                 case 5:
                     System.out.println("Exiting... Goodbye!");
                     System.exit(0);
                     
                 default:
                     System.out.println("Invalid choice. Please try again.");
            		
            }
	    }
	    
	}

}
