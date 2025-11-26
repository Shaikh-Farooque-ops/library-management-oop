package com.library.library;

import com.library.exceptions.BookNotAvailableException;
import com.library.models.Item;
import com.library.users.Member;

public class Library {

	private Item[] items;
	private Member[] members;
	
	private int itemCount;
	private int memberCount;

	public Library() {
		items = new Item[10];
		members = new Member[10];
		itemCount = 0;
		memberCount = 0;
	}

	// Added the item
	public void addItem(Item item)
	{
		if(itemCount < items.length)
		{
			item.markAsAvailable();
			items[itemCount] = item;
			itemCount++;
			System.out.println("Item " + item.getTitle() + " added successfully");
		}
		
		else
			System.out.println("Library is full, cannot add more items.");
	}
	
	// Register the member
	public void registerMember(Member member)
	{
		if(memberCount < members.length)
		{
			members[memberCount] = member;
			memberCount++;
			System.out.println("Member Registered successfully");
		}
		
		else
		{			
			System.out.println("Member capacity full. Cannot register more members.");
		}
	}
	
	// find the item by Id 
	public Item findByItemId(int itemId)
	{
		for(int i=0; i<itemCount;i++)
		{
			if(items[i].getId() == itemId)
			{
				return items[i];
			}
		}
		return null;
	}
	
	// Helper method: Member by Id 
	public Member findByMemberId(int memberId)
	{
		for(int i=0; i<memberCount;i++)
		{
			if(members[i].getMemberId() == memberId)
			{
				return members[i];
			}
		}
		return null;
	}
	
	// issue Item : borrow a book
	public void issueItem(int itemId, int memberId) throws BookNotAvailableException 
	{
		// Find item
		Item item = findByItemId(itemId);
		if(item == null)
		{
			System.out.println("Item not found.");
			return;
		}
		
		// Find Member
		Member member = findByMemberId(memberId);
		if(member == null)
		{
			System.out.println("Member not found.");
			return;
		}
		
		// check if item available
		if(!item.isAvailable())
		{
			throw new BookNotAvailableException("Item " + item.getTitle() +  "  is not available.");
		}
		
		// Issue item
		member.borrowItem(item);
		System.out.println("Item " + item.getTitle() + " issued successfully by " + member.getName());
	}
	
	// return item
	public void returnItem(int itemId, int memberId)
	{
		// Find item
		Item item = findByItemId(itemId);
		if(item == null)
		{
			System.out.println("Item not found.");
			return;
		}
		
		// Find Member
		Member member = findByMemberId(memberId);
		if(member == null)
		{
			System.out.println("Member not found.");
			return;
		}
		
		// Check if item is already available
		if(item.isAvailable())
		{
			System.out.println("Item is already available. Cannot return");
			return;
		}
		
		// return item
		member.returnItem(item);
		System.out.println("Item " + item.getTitle() + " returned successfully by " + member.getName());
	}
	
	// Print all items in the library
	public void showAllItems()
	{
		if(itemCount == 0)
		{
			System.out.println("No items in the library.");
			return;
		}
		
		System.out.println("============ ALL LIBRARY ITEMS ============");
		for(int i=0; i<itemCount;i++)
		{
			System.out.println(items[i]);
		}
	}
	
	// show available items
	public void showAvailableItems()
	{
		boolean found = false;
		
		System.out.println("============ AVAILABLE ITEMS ============");
		for(int i=0; i<itemCount; i++)
		{
			if(items[i].isAvailable())
			{
				System.out.println(items[i]);
				found = true;
			}
		}
		
		if(found == false)
		{
			System.out.println("No items are currently available.");
		}
	}
}
