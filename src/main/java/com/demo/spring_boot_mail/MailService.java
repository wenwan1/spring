package com.demo.spring_boot_mail;

import com.demo.util.Result;

public interface MailService {

    /**
     *发送纯文本邮件
     * @param toAddr 发送给谁
     * @param title 标题
     * @param content 内容
     */
    public Result sendTextMail(String toAddr, String title, String content);

    /**
     * 发送html格式邮件
     * @param toAddr
     * @param title
     * @param content
     */
    public Result sendHtmlMail(String toAddr,String title,String content);

    /**
     * 发送带有附件的邮件
     * @param toAddr
     * @param title
     * @param content
     * @param filePath
     */
    public Result sendAttachmentsMail(String toAddr, String title, String content, String filePath);
}
