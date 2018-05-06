package application;

import java.io.FileNotFoundException;

import helper.ParseCommandHelper;

public class SocialNetworkApp {
	public static void main(String args[]) throws FileNotFoundException
	{
		System.out.println("Here is socialnetwork");
		ParseCommandHelper parse = new ParseCommandHelper();
		parse.OpenFile();
		System.out.println("completed!");
	}
}
