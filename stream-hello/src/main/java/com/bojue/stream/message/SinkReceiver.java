package com.bojue.stream.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class SinkReceiver {

  protected Logger logger = LoggerFactory.getLogger(SinkReceiver.class);

  @StreamListener(Sink.INPUT)
  public void receiver(Object payload){
    logger.info("收到消息："+payload);
  }
}
