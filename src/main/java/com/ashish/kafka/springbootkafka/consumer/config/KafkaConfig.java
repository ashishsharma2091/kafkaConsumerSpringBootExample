package com.ashish.kafka.springbootkafka.consumer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.ashish.kafka.springbootkafka.consumer.model.CarOptions;

@EnableKafka
@Configuration
public class KafkaConfig {

	/**
	 * for string type messages
	 * @return
	 */
	@Bean
	public	ConsumerFactory<String, String> getConsumerFactory(){
		Map<String,Object> config=new HashMap<String, Object>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		return new DefaultKafkaConsumerFactory<String, String>(config);
		
			}
	@Bean
	public  ConcurrentKafkaListenerContainerFactory<String, String> getKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory=new ConcurrentKafkaListenerContainerFactory<String, String>();
		factory.setConsumerFactory(getConsumerFactory());
		return factory;
			}
	/**
	 * for object type data to be consumed
	 * @return
	 */
	@Bean
	public	ConsumerFactory<String, CarOptions> getConsumerFactoryForObject(){
		Map<String,Object> config=new HashMap<String, Object>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_json");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		return new DefaultKafkaConsumerFactory<String, CarOptions>(config,new StringDeserializer()
				,new JsonDeserializer<>(CarOptions.class) );
		//, new StringDeserializer(),new JsonDeserializer<>(CarOptions.class)
			}
	/**
	 * for object type data to be consumed
	 * @return
	 */
	@Bean
	public  ConcurrentKafkaListenerContainerFactory<String, CarOptions> getKafkaListenerContainerFactoryForObject() {
		ConcurrentKafkaListenerContainerFactory<String, CarOptions> factory=new ConcurrentKafkaListenerContainerFactory<String, CarOptions>();
		factory.setConsumerFactory(getConsumerFactoryForObject());
		return factory;
			}
	
	
	
	
	
	
	
	/*
	 * @Bean public KafkaTemplate<String, CarOptions> kafkaTemplate(){ return new
	 * KafkaTemplate<String, CarOptions>(producerFactory()); }
	 */}
