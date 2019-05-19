package com.lisi.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOUtil {
	
	 
    /**
     * 单字节，不带缓冲进行文件拷贝
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFileByByte(File srcFile,File destFile)throws IOException{
        if(!srcFile.exists()){
            throw new IllegalArgumentException("文件:"+srcFile+"不存在");
        }
        if(!srcFile.isFile()){
            throw new IllegalArgumentException(srcFile+"不是文件");
        }
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(destFile);
        int c ;
        while((c = in.read())!=-1){
            out.write(c);
            out.flush();
        }
        in.close();
        out.close();
    }
	
	  /**
     * 文件流拷贝，字节批量读取
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFile(File srcFile,File destFile)throws IOException{
        if(!srcFile.exists()){
            throw new IllegalArgumentException("文件:"+srcFile+"不存在");
        }
        if(!srcFile.isFile()){
            throw new IllegalArgumentException(srcFile+"不是文件");
        }
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(destFile);
        //一次读取多少字节
        byte[] buf = new byte[2*1024];
        int b ;
        while((b = in.read(buf,0,buf.length))!=-1){
            out.write(buf,0,b);
            out.flush();//最好加上
        }
        in.close();
        out.close();
        
    }
	
    
   /**
    * 进行文件的拷贝，利用带缓冲的字节流
    * @Title: copyFileByBuffer 
    * @Description: TODO
    * @param srcFile
    * @param destFile
    * @throws IOException
    * @return: void
    */
    public static void copyFileByBuffer(File srcFile,File destFile)throws IOException{
        if(!srcFile.exists()){
            throw new IllegalArgumentException("文件:"+srcFile+"不存在");
        }
        if(!srcFile.isFile()){
            throw new IllegalArgumentException(srcFile+"不是文件");
        }
        BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(destFile));
        int c ;
        while((c = bis.read())!=-1){
            bos.write(c);
            bos.flush();//刷新缓冲区
        }
        bis.close();
        bos.close();
    }
  

	 /**
	  * 字符流读取文件,写入文件
	  * @Title: readFile 
	  * @Description: TODO
	  * @param srcFile 源文件	
	  * @param destFile 目标文件
	  * @return: void
	  */
    public static void readFile(File srcFile,File destFile){
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileInputStream = new FileInputStream(srcFile);
            inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            fileWriter = new FileWriter(destFile);
            bufferedWriter = new BufferedWriter(fileWriter);
            String data = null;
            while ((data = bufferedReader.readLine()) != null){
                bufferedWriter.write(data);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    
}
