package org.example;

import java.io.*;

public class Utils {

    //    读取文件
    private static String readFile(String path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();
            return content.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("读取失败");
        return null;
    }

//    保存文件

    public static void writeFile(String saveContent) {
        String fileName = "saveAllTestResult.txt";  // 文件名
        try {
            FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(saveContent);  // 写入测试结果
            bw.close();  // 关闭BufferedWriter
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void review(String beginPath,String testPath) {
//        查重

        //读取文件
        String article1 = readFile(beginPath);
        String article2 = readFile(testPath);
        SimHash hash1 = new SimHash(article1, 64);
        SimHash hash2 = new SimHash(article2, 64);
        double similarVal = hash1.getSemblance(hash2);
        String result = String.format("%.2f", similarVal);//文本相似度精确到小数点后两位

        String saveContent = "海明距离：" + hash1.hammingDistance(hash2) + "    查重率：" + result + "\n";
        //打印需要的信息
        System.out.print(saveContent);
        writeFile(saveContent); // 保存
    }

}
