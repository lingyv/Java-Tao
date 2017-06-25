package org.lingyv.JDK.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by lingyv on 2016/12/9.
 * File 既能代表一个特定文件的名称，又能代表一个目录下的一组文件的名称
 * FIle类可以让你访问底层文件系统，通过File类，你可以做到以下几点:
 * 检测文件是否存在
 * 读取文件长度
 * 重命名或移动文件
 * 删除文件
 * 检测某个路径是文件还是目录
 * 读取目录中的文件列表
 * <p>
 * 请注意：File只能访问文件以及文件系统的元数据。如果你想读写文件内容，需要使用FileInputStream、FileOutputStream或者RandomAccessFile。如果你正在使用Java NIO，并且想使用完整的NIO解决方案，你会使用到java.nio.FileChannel(否则你也可以使用File)。
 */
public class YvFile {

    /**
     * 检测文件或目录是否存在
     *
     * @param file
     * @return
     */
    public static boolean isExist(final File file) {
        return file.exists();
    }

    /**
     * 判断File对象指向的是文件还是目录
     * 返回值是true时，File指向的是目录，否则指向的是文件
     *
     * @param file
     * @return
     */
    public static boolean isDirectory(final File file) {
        return file.isDirectory();
    }

    /**
     * 根据pathname创建单一文件夹,如果父文件夹不存在则报错
     *
     * @param file
     * @return
     */
    public static boolean createDirectory(final File file) {
        return file.mkdir();
    }

    /**
     * 根据pathname创建文件夹，如果父文件夹不存在，则会创建父文件夹。
     * 注意：如果最终创建失败，有可能会成功创建一些父文件夹
     *
     * @param file
     * @return
     */
    public static boolean createsDirectory(final File file) {
        return file.mkdirs();
    }

    /**
     * 删除一个文件或者目录。
     * 注意：如果file指向一个目录，则必须保证目录为空
     *
     * @param file
     * @return
     */
    public static boolean deleteFile(final File file) {
        return file.delete();
    }

    /**
     * 获取文件长度
     *
     * @param file
     * @return
     */
    public static long length(final File file) {
        return file.length();
    }

    /**
     * 重命名或移动
     *
     * @param file
     * @param newFile
     * @return
     */
    public static boolean move(final File file, final File newFile) {
        return file.renameTo(newFile);
    }

    /**
     * 目录列表器
     * 查看一个File对象包含的全部列表
     */
    public static void dirList(final File path) {
        String[] dirList = path.list();
        //排序
        Arrays.sort(dirList, String.CASE_INSENSITIVE_ORDER);
        for (String dir : dirList) {
            System.out.println(dir);
        }
    }

    /**
     * 目录查看器
     * 使用正则表达式查看一个File对象包含的符合条件的列表
     *
     * @param regex
     */
    public static void filterDirList(final File path, final String regex) {
        //获取匹配正则表达式的目录列表
        String[] filterDirList = path.list(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);

            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
        Arrays.sort(filterDirList, String.CASE_INSENSITIVE_ORDER);
        for (String dir : filterDirList) {
            System.out.println(dir);
        }
    }

    public static void main(String[] args) {
        final File path = new File(".");
        //dirList();
        filterDirList(path, ".*.xml");
    }

}
