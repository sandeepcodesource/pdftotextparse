package com.bst.parsepdfss;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class App {

	public static void main(String[] args) throws IOException {
		
		File file = new File("anurag dec 21.pdf");
		PDFParser parser =new PDFParser(new org.apache.pdfbox.io.RandomAccessFile(file, "r"));
		parser.parse();
		COSDocument cosdoc = parser.getDocument();
		PDDocument pddoc = new PDDocument(cosdoc);		
		PDFTextStripper str = new PDFTextStripper();
		String data = str.getText(pddoc);
		String s[]=data.split("\n");
		for(int i=0;i<s.length;i++)
			if(s[i].indexOf(":")>=0 && s[i].indexOf('.')<0&& Character.isDigit(s[i].charAt(0))==false)
			System.out.println(s[i]);		 
	}
}