package org.lingyv.JDK.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lingyv on 2016/12/9.
 * I/O流的典型使用方式
 */
public class YvReader {

    /**
     * 缓冲输入文件
     * 将文件内容保存在List<String>对象中
     * <p>
     * BufferedReader能为字符输入流提供缓冲区，可以提高许多IO处理的速度。你可以一次读取一大块的数据，而不需要每次从网络或者磁盘中一次读取一个字节。特别是在访问大量磁盘数据时，缓冲通常会让IO快上许多。
     * BufferedReader和BufferedInputStream的主要区别在于，BufferedReader操作字符，而BufferedInputStream操作原始字节。
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    public static List<String> fileReader(String filePath) throws IOException {
        File file = new File(filePath);
        List<String> fileContent = new ArrayList<String>();
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String lineContent = null;
                //读取文件的每一行，并添加到List容器中
                while ((lineContent = reader.readLine()) != null) {
                    //加上换行符(读的过程中换行符会被去除掉)
                    //fileContent.add(lineContent+"\n");
                    fileContent.add(lineContent);
                }
            }
        } else {
            throw new IOException("文件 " + filePath + " 不存在");
        }

        return fileContent;
    }

    public static void main(String[] args) throws IOException {
        List<String> files = fileReader("D:\\Panasonic_SCM\\20 需求分析\\EDI\\PIDSCN系统EDI样本文件_160720\\OB-DATA_016021_160328.dat");
        for (String file : files) {
            System.out.println(file);
            System.out.println(file.length());
        }
    }
}
