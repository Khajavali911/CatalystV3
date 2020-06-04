/*package catalyst.automation.utility;

import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaUtility {
	public static void consume() {
		Properties props = new Properties();
	    props.put("bootstrap.servers", "127.0.0.1:9092");
	    props.put("group.id", "group-1");
	    props.put("enable.auto.commit", "true");
	    props.put("auto.commit.interval.ms", "1000");
	    props.put("auto.offset.reset", "earliest");
	    props.put("session.timeout.ms", "30000");
	    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

	    @SuppressWarnings("resource")
		KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(props);
	    kafkaConsumer.subscribe(Arrays.asList("test"));
	    while (true) {
	      ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
	      for (ConsumerRecord<String, String> record : records) {
	        System.out.println("Partition: " + record.partition() + " Offset: " + record.offset()
	            + " Value: " + record.value() + " ThreadID: " + Thread.currentThread().getId());
	        @SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
	        scanner.nextLine();
	      }
	    }
	}
	public static void produce() {
	 	Properties props = new Properties();
	    props.put("bootstrap.servers", "127.0.0.1:9092");
	    props.put("acks", "all");
	    props.put("retries", 0);
	    props.put("batch.size", 16384);
	    props.put("linger.ms", 1);
	    props.put("buffer.memory", 33554432);
	    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	    Producer<String, String> producer = null;
	    try {
	      producer = new KafkaProducer<>(props);
	      for (int i = 0; i < 100; i++) {
	        String msg = "Message " + i;
	        producer.send(new ProducerRecord<String, String>("test", msg));
	        System.out.println("Sent:" + msg);
	      }
	    } catch (Exception e) {
	      e.printStackTrace();

	    } finally {
	      producer.close();
	    }
	}


}
*/