package com.library.utils;

import java.util.Scanner;

public class InputHelper {
	
	private static final Scanner sc = new Scanner(System.in);

	public static String readString(String message)
	{
		System.out.print(message);
		return sc.nextLine();
	}
	
	public static int readInt(String message)
	{
		System.out.print(message);
		
		while(true)
		{
			try
			{
				return Integer.parseInt(sc.nextLine());
			}
			catch(NumberFormatException  e)
			{
				System.out.print("Invalid number. Try again: ");
			}
		}
	}
}
