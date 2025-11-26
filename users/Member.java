package com.library.users;

import com.library.models.Item;

public class Member {

	private int memberId;
	private String name;
	private String email;
	private Item[] borrowedItems;
	private int borrowedCount;
	
	public Member(int memberId, String name, String email) {
		super();
		this.memberId = memberId;
		this.name = name;
		this.email = email;
		this.borrowedItems = new Item[5];
		this.borrowedCount = 0;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Item[] getBorrowedItems() {
		return borrowedItems;
	}

	public void setBorrowedItems(Item[] borrowedItems) {
		this.borrowedItems = borrowedItems;
	}

	public void borrowItem(Item item)
	{
		if(borrowedCount < borrowedItems.length)
		{
			borrowedItems[borrowedCount] = item;
			borrowedCount++;
			item.markAsUnavailable();
		}
		
		else
			System.out.println("Cannot borrow more items");
	}
	
	public void returnItem(Item item)
	{
		boolean found = false;
		
		for(int i=0; i<borrowedCount;i++)
		{
			if(borrowedItems[i] == item)
			{
				// Mark item as available
				item.markAsAvailable();
				
				// Shift left 
				for(int j=i;j<borrowedCount-1;j++)
				{
					borrowedItems[j] = borrowedItems[j+1];
				}
				borrowedCount--;
				borrowedItems[borrowedCount] = null;
				found = true;
				break;
			}
		}
		
		if(found)
		{
			System.out.println("Item \"" + item.getTitle() + "\" returned successfully by " + getName());
		}
		
		else
			System.out.println("Item not found in borrowed list");
		
	}
	
	public void viewBorrowedItems()
	{
		if(borrowedCount == 0)
		{
			System.out.println("No items borrowed.");
			return;
		}
		
		System.out.println("Borrowed Items:");
		
		for(int i=0; i<borrowedCount;i++)
		{
			System.out.println(borrowedItems[i].getTitle());
		}
		
	}
}
