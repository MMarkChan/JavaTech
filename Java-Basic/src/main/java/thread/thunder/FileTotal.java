package thread.thunder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileTotal {

    public static void ReadSubdirectory(File dir){
        if(dir.isDirectory()){
            // 取得目录内的所有文件列表
            File[] subFile=dir.listFiles();
            // 遍历文件列表
            for(int i=0;i<subFile.length;i++){
                if(subFile[i].isDirectory()){
                    // 如果是目录则递归调用
                    ReadSubdirectory(subFile[i]);
                }else{
                    // 如果不是目录则处理文件
                    ReadSubFile(subFile[i]);
                }
            }
        }
    }
    public static void ReadSubFile(File file){
        int numCount=0;
        int letterCount=0;
        int spaceCount=0;
        int lineCount=0;
        int temp=0;
        try {

            /**
             * 计算数字个数、字母个数、空格数
             */
            FileInputStream input=new FileInputStream(file);
            while((temp=input.read())!=-1){ // 每次读取一个字节
                if(temp>=48&&temp<=57){
                    // 数字[0-9]对应的ASCII整数值为[48-57]
                    numCount++;
                }else
                if((temp>=65&&temp<=90)||(temp>97&&temp<122)){
                    // 小写字母[a-z]对应的ASCII整数值为[97-122],大写字母[A-Z]对应的ASCII整数值为[65-90]
                    letterCount++;
                }else if(temp==32){
                    // 空格对应的ASCII整数值为32
                    spaceCount++;
                }
            }

            /**
             * 计算行数
             */
            BufferedReader buffer=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while(buffer.readLine()!=null){
                lineCount++;
            }
            System.out.println("文件路径："+file.getAbsolutePath());
            System.out.println("数字个数:"+numCount);
            System.out.println("字母个数:"+letterCount);
            System.out.println("空格个数:"+spaceCount);
            System.out.println("行数数:"+lineCount);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ReadSubdirectory(new File("F:/kuaipan"));
    }
}