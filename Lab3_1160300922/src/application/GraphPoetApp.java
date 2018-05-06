package application;

import java.io.FileNotFoundException;

import helper.ParseCommandHelper;

public class GraphPoetApp {
	public static void main(String args[]) throws FileNotFoundException
	{
		System.out.println("Here is graphpoet");
		ParseCommandHelper parse = new ParseCommandHelper();
		parse.OpenFile();
		System.out.println("completed!");
	}
}
