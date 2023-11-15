package com.mms.demo.service;

public interface MailService {
    public void sendSimpleMail(String from, String to, String subject, String text);
}
