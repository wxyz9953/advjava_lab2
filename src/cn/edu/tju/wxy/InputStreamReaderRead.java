package cn.edu.tju.wxy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderRead implements Readable {

	@Override
	public String readFile(String path) {
		File file = new File(path);
		String src = "";
		InputStreamReader ir = null;
		try {
			ir = new InputStreamReader(new FileInputStream(file), "Unicode");
			Long len = file.length();
			byte[] data = new byte[len.intValue()];
			int tmp = 0;
			int end = 0;
			while ((tmp = ir.read()) != -1) {
				//对读取数据进行初步过滤
				if (Character.isLetter((char) tmp) || (char) tmp == ' ' || (char) tmp == '\n'
						|| Character.isDigit((char) tmp)) {
					data[end++] = (byte) tmp;
				}
			}
			src = new String(data, 0, end);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.exit(0);
		} finally {
			if (ir != null) {
				try {
					ir.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return src;
	}

}
