package cn.edu.tju.wxy;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class CountWords {
	private Readable read;
	private String readPath;
	private String writePath;

	public CountWords(String readPath, String writePath, Readable read) {
		this.readPath = readPath;
		this.writePath = writePath;
		this.read = read;
	}

	public void writeResult() {

		String src = this.read.readFile(readPath);
		//过滤数据
		src = src.trim();
		src = src.replaceAll("\\p{P}", "");
		String pattern = "\\s";

		String[] split = src.split(pattern);

		// 排序
		Map<String, Integer> map = new TreeMap<>();
		for (int i = 0; i < split.length; i++) {
			String key = split[i];
			key = key.toLowerCase();
			if (key.equals("")) {// 去除诡异的""的情况
				continue;
			}
			int count = map.containsKey(key) ? map.get(key) + 1 : 1;
			map.put(key, count);
		}
		
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>();
		list.addAll(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue() - o1.getValue();
			}
		});

		OutputStream out = null;
		try {
			File output = new File(writePath);
			out = new FileOutputStream(output);
			// 创建文件
			if (!output.exists()) {
				output.createNewFile();
			}

			// 写入文件
			Iterator<Entry<String, Integer>> it = list.iterator();
			while (it.hasNext()) {
				Entry<String, Integer> temp = it.next();
				String str = temp.getKey() + "   " + temp.getValue() + "\r\n";
				byte outData[] = str.getBytes();

				for (int x = 0; x < outData.length; x++) {
					out.write(outData[x]);
				}
			}

			System.out.println("成功");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
