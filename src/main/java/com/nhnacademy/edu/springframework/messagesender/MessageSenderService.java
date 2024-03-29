package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.messagesender.annotation.SMS2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageSenderService {

    @Autowired
    private MessageSender messageSender;
    //private List<MessageSender> messageSenders;

    //@Value("${from}")
    private String name;

    //@Autowired
    /*public MessageSenderService(MessageSender messageSender) {
        System.out.println("------ Constructor Injection ------");
        this.messageSender = messageSender;
    }*/

    //@Autowired(required = true)
    /*public MessageSenderService(List<MessageSender> messageSenders) {
        this.messageSenders = messageSenders;
    }*/

    //@Autowired
    public MessageSenderService(@SMS2("smsMessageSender") MessageSender messageSender) {
        this.messageSender = messageSender;
        this.name = name;
    }

    public MessageSenderService() {

    }


    /*public MessageSenderService(@SMS(selectSendType = SelectSendType.SMS_) MessageSender messageSender) {
        this.messageSender = messageSender;
    }*/

    /*public MessageSenderService(@Qualifier("smsMessageSender") MessageSender messageSender) {
        this.messageSender = messageSender;
    }*/

    /*public MessageSenderService() {
        System.out.println("---------- Default Constructor Injection ----------");
    }*/

    /*@Autowired  // setter injection
    @Required
    public void setSmsMessageSender(MessageSender messageSender) {
        System.out.println("setMessageSender invoked!");
        this.messageSender = messageSender;
    }*/

    public void setMessageSender(MessageSender messageSender) {
        System.out.println("set by setMessageSender");
        this.messageSender = messageSender;
    }

    public void messageSend() {
        System.out.println("From : " + name);
        messageSender.sendMessage(new User("random@naver.com", "010-0000-0000"), "test 메시지1");

        //messageSenders.get(0).sendMessage(new User("random1@naver.com", "010-0000-0000"), "test 메시지1");
        //messageSenders.get(1).sendMessage(new User("random2@naver.com", "010-1000-0000"), "test 메시지2");
    }

    public boolean doMessageSend() {
        boolean rtn = messageSender.sendMessage(new User("testingTest@gmail.com", "010-1233-2832"), "테스트위한 계정");
        System.out.println("return from messageSender " + rtn);
        return rtn;

    }

}
