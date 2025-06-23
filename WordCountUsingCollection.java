package com.app;

import java.io.FileNotFoundException;

public class WordCountUsingCollection {

	public static void main(String[] args) throws FileNotFoundException{
		
		 String filePath = "https://raw.githubusercontent.com/nilofarshaikh12/WordCount_Assignment1/develop/src/com/app/InputFile.txt";

	       WordCountHelper counter = new WordCountHelper();
	       counter.countFromFile(filePath);
	}
}