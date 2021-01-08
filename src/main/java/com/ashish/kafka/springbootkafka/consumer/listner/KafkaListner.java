package com.ashish.kafka.springbootkafka.consumer.listner;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ashish.kafka.springbootkafka.consumer.model.CarOptions;

@Service
public class KafkaListner {

	@KafkaListener(topics="sampleTopic",groupId="group_id")
	public void consume(String message) {
	System.out.println("got this message : "+message);
	}	
	
	@KafkaListener(topics="sampleTopic_json1",groupId="group_json", containerFactory = "getKafkaListenerContainerFactoryForObject")
	public void consumeJson(CarOptions carOptions) {
	System.out.println("got this Json message is : "+carOptions);
	}
}
