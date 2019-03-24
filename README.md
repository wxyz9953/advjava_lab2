main函数在Main.java文件内

使用方法：

* 需要传入参数文件名。

* output.txt将生成在src同级文件output内。

* 实例化一个读取策略类，如：

  ```java
  Readable r = new FileInputStreamRead();
  //Readable r = new BufferedInputStreamRead();
  //Readable r = new BufferedReaderRead();
  //Readable r = new InputStreamReaderRead();
  ```

* 实例化CountWords类，需要传入参数：被读取文件路径，产生文件路径以及读取的策略。

* 调用writeResult()方法，即可在output文件夹内生成结果文件。

  ```java
  CountWords cw = new CountWords(inputPath, outputPath, r);
  cw.writeResult();
  ```

  