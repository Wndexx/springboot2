package com.wndex.boot.converter;

import com.wndex.boot.bean.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.util.List;

/**
 * 自定义 HttpMessageConverter
 *
 * @author wndexx 2022-09-24 9:49
 */
public class WndexMessageConverter implements HttpMessageConverter<Person> {
    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return clazz.isAssignableFrom(Person.class);
    }

    /**
     * application/x-wndex
     *
     * @return 支持的媒体类型
     */
    @Override
    public List<MediaType> getSupportedMediaTypes() {
        // 自定义的媒体类型
        return MediaType.parseMediaTypes("application/x-wndex;charset=utf-8");
    }

    @Override
    public Person read(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void write(Person person, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String data = person.getUserName() + ";" + person.getAge() + ";" + person.getBirth() + ";" + person.getPet();
        outputMessage.getHeaders().setContentType(MediaType.parseMediaType("text/plain;charset=utf-8"));
        outputMessage.getBody().write(data.getBytes());
    }
}
