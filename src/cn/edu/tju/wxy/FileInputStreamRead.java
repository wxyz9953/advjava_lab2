package cn.edu.tju.wxy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamRead implements Readable {

	@Override
	public String readFile(String path) {
		InputStream in = null;
		String src = null;
		try {
			File file = new File(path);
			in = new FileInputStream(file);
			Long len = file.length();
			byte[] data = new byte[len.intValue()];
			int tmp = 0;
			int end = 0;
			while ((tmp = in.read()) != -1) {
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
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return src;
	}

}
