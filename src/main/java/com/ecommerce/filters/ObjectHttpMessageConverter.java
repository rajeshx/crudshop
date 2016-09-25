package com.ecommerce.filters;
/**
@author rajesh
 */
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <p>Converts HTTP requests with bodies that are application/x-www-form-urlencoded or multipart/form-data to an Object
 * annotated with {@link org.springframework.web.bind.annotation.RequestBody} in the the handler method.
 * reference
 * @author Jesse Swidler
 */
public class ObjectHttpMessageConverter implements HttpMessageConverter<Object> {

    private final FormHttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final LinkedMultiValueMap<String, String> LINKED_MULTI_VALUE_MAP = new LinkedMultiValueMap<String, String>();
    private static final Class<? extends MultiValueMap<String, ?>> LINKED_MULTI_VALUE_MAP_CLASS
            = (Class<? extends MultiValueMap<String, ?>>) LINKED_MULTI_VALUE_MAP.getClass();

    public boolean canRead(Class clazz, MediaType mediaType) {
        return objectMapper.canSerialize(clazz) && formHttpMessageConverter.canRead(MultiValueMap.class, mediaType);
    }

    public boolean canWrite(Class clazz, MediaType mediaType) {
        return false;
    }

     
    public List<MediaType> getSupportedMediaTypes() {
        return formHttpMessageConverter.getSupportedMediaTypes();
    }

     
    public Object read(Class clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        Map<String, String> input = formHttpMessageConverter.read(LINKED_MULTI_VALUE_MAP_CLASS, inputMessage).toSingleValueMap();
        return objectMapper.convertValue(input, clazz);
    }

     
    public void write(Object o, MediaType contentType, HttpOutputMessage outputMessage) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("");
    }
}