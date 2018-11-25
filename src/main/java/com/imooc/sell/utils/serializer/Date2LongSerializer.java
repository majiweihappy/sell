package com.imooc.sell.utils.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * Created by majiwei
 * 2018/10/21 0021 20:03
 */
public class Date2LongSerializer extends JsonSerializer<Date>
{
    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException
    {
        //序列化生成json时将date时间戳/1000
        jsonGenerator.writeNumber(date.getTime() / 1000);
    }
}
