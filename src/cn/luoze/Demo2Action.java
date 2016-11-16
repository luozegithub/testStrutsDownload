package cn.luoze;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by luo ze on 2016/11/16.
 */
public class Demo2Action extends ActionSupport{

    public String getFilename() {
        try {
            return URLEncoder.encode("而我.zip", "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }

    }



    public InputStream getZip(){
        ServletContext sc = ServletActionContext.getServletContext();
         InputStream in=sc.getResourceAsStream("/WEB-INF/真.zip");
        return in;
    }
    public String execute(){
        return SUCCESS;
    }
}
