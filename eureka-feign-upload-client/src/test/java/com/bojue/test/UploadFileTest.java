package com.bojue.test;

import com.bojue.consumer.Application;
import com.bojue.consumer.client.UploadServer;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UploadFileTest {

    @Autowired
    private UploadServer uploadServer;

    @Test
    @SneakyThrows
    public void upload(){
        File file = new File("H:\\test\\springcloud\\test.txt");
        DiskFileItem item = (DiskFileItem) new DiskFileItemFactory().createItem("file", MediaType.TEXT_PLAIN_VALUE, true, "test.txt");

        try(InputStream inputStream = new FileInputStream(file);OutputStream ops = item.getOutputStream()){
            IOUtils.copy(inputStream,ops);
        }catch (Exception e){
            throw new IllegalArgumentException("invalid file:"+e,e);
        }
        MultipartFile multipartFile = new CommonsMultipartFile(item);
        log.info(uploadServer.uploadFile(multipartFile));
        System.out.println("测试结束");
    }
}
