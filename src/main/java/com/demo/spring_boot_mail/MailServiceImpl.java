package com.demo.spring_boot_mail;


import com.demo.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class MailServiceImpl implements MailService {

    private static final Logger logger= LoggerFactory.getLogger(MailService.class);

    @Autowired
    JavaMailSender javaMailSender;

    @Value(value = "${spring.mail.username}")
    private String from;

    @Override
    public Result sendTextMail(String toAddr, String title, String content) {

        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setTo(toAddr);
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setText(content);
        simpleMailMessage.setSubject(title);
        try {
            javaMailSender.send(simpleMailMessage);
            logger.info("邮箱已发送");
            return new Result(true,"发送邮件成功");
        }catch (Exception e){
            logger.error("MailServiceImpl[sendTextMail] error",e);
            return new Result(false,"发送邮箱失败");
        }
    }

    @Override
    public Result sendHtmlMail(String toAddr, String title, String content) {

        //html邮件对象
        MimeMessage message = javaMailSender.createMimeMessage();
        try{
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setText(content,true);
            helper.setFrom(from);
            helper.setTo(toAddr);
            helper.setSubject(title);
            javaMailSender.send(message);
            logger.info("邮箱已发送");
            return new Result(true,"发送邮件成功");
        }catch (Exception e){
            logger.error("MailServiceImpl[sendHtmlMail] error",e);
            return new Result(false,"发送邮箱失败");
        }

    }

    @Override
    public Result sendAttachmentsMail(String toAddr, String title, String content, String filePath) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(toAddr);
            helper.setSubject(title);
            helper.setText(content, true);
            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);
            //helper.addAttachment("test"+fileName, file);
            javaMailSender.send(message);
            logger.info("带附件的邮件已经发送。");
            return new Result(true,"发送邮件成功");
        } catch (Exception e) {
            logger.error("MailServiceImpl[sendHtmlMail] error",e);
            return new Result(false,"发送邮箱失败");
        }
    }
}
