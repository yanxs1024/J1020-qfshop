package com.qf.utils;

import org.apache.commons.mail.HtmlEmail;

public class EmailUtils {
    public static void sendRegisterSuccess(String to, String activeCode) {
        try {
            // 创建一个email消息
            HtmlEmail email = new HtmlEmail();

            // 设置邮箱服务器
            email.setHostName("smtp.qq.com");

            // 设置编码集
            email.setCharset("utf-8");

            // 设置发件人的授权信息
            email.setAuthentication("792179997", "gvjkwdpjzhnxbeeh");

            // 设置发件人
            email.setFrom("792179997@qq.com", "千锋商城官方");

            // 设置收件人
            email.addTo(to, "");

            // 设置邮件主题
            email.setSubject("千锋商城激活邮件，请勿回复");

            // 设置消息体
            email.setHtmlMsg("<a href='http://localhost:8080/J2002_1012_qfshop_war_exploded/active_user?code="+activeCode+"'>点击链接激活您的帐号</a>");

            // 发送邮件
            email.send();
        } catch (Exception e) {

        }
    }
}
