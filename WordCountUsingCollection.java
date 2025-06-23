package com.app;

import java.io.FileNotFoundException;

public class WordCountUsingCollection {

	public static void main(String[] args) throws FileNotFoundException{
		
		String filePath = "https://raw.githubusercontent.com/nilofarshaikh12/WordCountAssignment/master/InputFile.txt";

	       WordCountHelper counter = new WordCountHelper();
	       counter.countFromFile(filePath);
	}
}