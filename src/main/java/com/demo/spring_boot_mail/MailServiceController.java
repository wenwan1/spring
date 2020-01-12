package com.demo.spring_boot_mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailServiceController {
    @Autowired
    MailServiceImpl mailServiceImpl;

    @RequestMapping("/mail/sendTextMail")
    public void sendTextMail(){
        String toAddr="1582847253@qq.com";
        String title="来自刘帅的邮件";
        String content="你好啊，小伙子，很高兴认识你";
        mailServiceImpl.sendTextMail(toAddr,title,content);
    }

    @RequestMapping("/mail/sendHtmlMail")
    public void sendHtmlMail(){
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        String toAddr="1582847253@qq.com";
        String title="来自刘帅的邮件";
        mailServiceImpl.sendHtmlMail(toAddr,title,content);
    }

    @RequestMapping("/mail/sendAttachFileMail")
    public void sendAttachFileMail(){
        String toAddr="1074286810@qq.com";
        String title="这是来自刘帅通过spring boot发送的邮件";
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封含有图片的html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        String file="C:\\Users\\liush\\Desktop\\1-161006161113.jpg";
        mailServiceImpl.sendAttachmentsMail(toAddr,title,content,file);
    }

}
