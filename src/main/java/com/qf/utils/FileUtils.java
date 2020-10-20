package com.qf.utils;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@WebListener
public class FileUtils implements ServletContextListener {
    private static ServletContext application;

    public static String getExtName(String filename) {
        String[] split = filename.split("\\.");

        if (split.length == 1) {
            return "";
        } else {
            int spiltlength = split.length;
            return "." + split[spiltlength - 1];
        }
    }

    public static String storage(Part part) throws IOException {
        // 文件存储的目录(相对路径)
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String format = simpleDateFormat.format(date);

        String extName = FileUtils.getExtName(part.getSubmittedFileName());
        String filename = UUID.randomUUID().toString() + extName;
        String relativePath = "prodimg/" + format;

        //将相对路径转换成绝对路径
        String realPath = application.getRealPath(relativePath);

        File file = new File(realPath);
        file.mkdirs();

        FileOutputStream fis = new FileOutputStream(realPath+ "/" + filename);
        IOUtils.copy(part.getInputStream(),fis);
        fis.close();
        return relativePath + "/" + filename;

    }
    @Override
    public void contextInitialized(ServletContextEvent event) {
        application = event.getServletContext();
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
    }
}
