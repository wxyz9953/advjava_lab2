package cn.edu.tju.wxy;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		String fileName = args[0];
		String prePath = System.getProperty("user.dir") + File.separator;

		String path = prePath + "data" + File.separator + fileName;
		String outputPath = prePath + "output" + File.separator + "output.txt";

		Readable r = new FileInputStreamRead();
		//Readable r = new BufferedInputStreamRead();
		//Readable r = new BufferedReaderRead();
		//Readable r = new InputStreamReaderRead();
		CountWords cw = new CountWords(path, outputPath, r);
		cw.writeResult();
	}
}
