package cn.edu.tju.wxy;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputStreamRead implements Readable{

	@Override
	public String readFile(String path) {
		String src = null;
		BufferedInputStream bin = null;
		try {
			File file = new File(path);
			bin = new BufferedInputStream(new FileInputStream(file));
			Long len = file.length();
			byte[] data = new byte[len.intValue()];
			int tmp = 0;
			int end = 0;
			while ((tmp = bin.read()) != -1) {
				data[end++] = (byte) tmp;
			}
			src = new String(data, 0, end, "Unicode");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		} catch(IOException e){
			System.out.println(e.getMessage());
			System.exit(0);
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			
			if (bin != null) {
				try {
					bin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return src;
	}

}
