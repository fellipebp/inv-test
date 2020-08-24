package com.example.test.modifiedsource.firstitem;

import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageHandler {


    private static MessageHandler instance = null;
    
    private ResourceBundle resourceBundle;
 
    private MessageHandler() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("message");
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
        resourceBundle = new MessageSourceResourceBundle(messageSource, LocaleContextHolder.getLocale());
    }
 
    public static MessageHandler getInstance() {
        if (instance == null) {
            synchronized (MessageHandler.class) {
                if (instance == null) {
                    instance = new MessageHandler();
                }
            }
        }
        return instance;
    }
 
    public String getMessage(String key) {
        return resourceBundle.getString(key);
    }
 
    public String getMessage(String key, Object... params) {
        return MessageFormat.format(getMessage(key), params);
    }
    
}