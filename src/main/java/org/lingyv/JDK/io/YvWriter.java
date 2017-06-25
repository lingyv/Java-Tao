package org.lingyv.JDK.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lingyv on 2016/12/9.
 */
public class YvWriter {

    /**
     * 将数据写入文件
     * 如果文件不存在，则创建文件
     * 如果文件存在且有内容，则会删掉原有内容再写入
     *
     * @param dirPath
     * @param fileName
     * @param fileContent
     * @return
     * @throws IOException
     */
    public static boolean fileWriter(String dirPath, String fileName, List<String> fileContent) throws IOException {
        return writer(dirPath, fileName, fileContent, false);
    }

    /**
     * 将数据追加写入文件
     * 如果文件不存在，则创建文件
     *
     * @param dirPath
     * @param fileName
     * @param fileContent
     * @throws IOException
     */
    public static boolean fileAppend(String dirPath, String fileName, List<String> fileContent) throws IOException {
        return writer(dirPath, fileName, fileContent, true);
    }

    /**
     * 将数据写入文件
     * 如果文件不存在，则创建文件
     * @param dirPath
     * @param fileName
     * @param fileContent
     * @param append  --> 是否保留原文件内容
     * @return
     * @throws IOException
     */
    private static boolean writer(String dirPath, String fileName, List<String> fileContent, boolean append) throws IOException {
        boolean result = false;
        if (createDir(dirPath)) {
            String filePath = dirPath + "/" + fileName;
            try (FileWriter fileWriter = new FileWriter(filePath,append);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                 PrintWriter writer = new PrintWriter(bufferedWriter)) {
                if (fileContent != null && !fileContent.isEmpty()) {
                    for (String content : fileContent) {
                        writer.println(content);
                    }
                    result = true;
                } else {
                    throw new IOException("没有要写入的内容");
                }
            }
        } else {
            throw new IOException("文件夹" + dirPath + "不存在");
        }

        return result;
    }

    private static boolean createDir(String dirPath) {
        boolean success = true;
        File file = new File(dirPath);
        if (!file.exists()) {
            success = file.mkdirs();
        }
        return success;
    }

    public static void main(String[] args) throws IOException {
        List<String> content = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            content.add(""+i);
        }

        fileAppend("D:\\conf\\abc","vim快捷键.java",content);
    }
}
