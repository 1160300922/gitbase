package application;

import java.io.FileNotFoundException;

import helper.ParseCommandHelper;

public class MovieGraphApp {
	public static void main(String args[]) throws FileNotFoundException
	{
		System.out.println("Here is moviegraph");
		ParseCommandHelper parse = new ParseCommandHelper();
		parse.OpenFile();
		System.out.println("completed!");
	}
}
