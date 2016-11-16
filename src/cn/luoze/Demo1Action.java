package cn.luoze;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import java.io.File;
import java.util.UUID;

/**
 * Created by luo ze on 2016/11/16.
 */
public class Demo1Action extends ActionSupport {
    private File file;
    private String fileContentType;
    private String fileFileName;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String execute() throws Exception {

        System.out.println(file);
        //----------------------------
        //1 获得res文件夹的路径
        String dirPath = ServletActionContext.getServletContext().getRealPath("/res");
        System.out.println(dirPath);
        //2 创建目标文件
       String fileName = UUID.randomUUID().toString();



        File target = new File(dirPath+"/"+fileFileName);
        //3 将file拷贝到目标文件中
        file.renameTo(target);
        ////FileUtils.copyFile(file,target);
        //----------------------------------
        System.out.println("上传文件的Mime类型:"+fileContentType);
        System.out.println("上传文件的文件名称:"+fileFileName);
        return SUCCESS;
    }

    @Test
    public void test1(){
       String name="0141121965—罗泽.doc" ;



    }
}
