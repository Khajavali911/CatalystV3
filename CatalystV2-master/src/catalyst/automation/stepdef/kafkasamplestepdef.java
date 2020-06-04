package catalyst.automation.stepdef;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.aventstack.extentreports.GherkinKeyword;

import catalyst.automation.utility.ConsumerCreator;
import catalyst.automation.utility.IKafkaConstants;
import catalyst.automation.utility.ProducerCreator;
import cucumber.api.java.en.Given;



public class kafkasamplestepdef {
	
	@Given("I want to send some message to Kafka broker")
	public void i_want_to_send_some_message_to_Kafka_broker() throws InterruptedException, ExecutionException {
		Producer<Long, String> producer = ProducerCreator.createProducer();
        for (int index = 0; index < IKafkaConstants.MESSAGE_COUNT; index++) {
            ProducerRecord<Long, String> record = new ProducerRecord<Long, String>(IKafkaConstants.TOPIC_NAME,
            "This is record " + index);
           
            RecordMetadata metadata = producer.send(record).get();
            
                        System.out.println("Record sent with key " + index + " to partition " + metadata.partition()
                        + " with offset " + metadata.offset());
        }
                 
    }
        
    @Given("I want to consume message from Kafka broker")
    public void consumeMessgaeFromBroker() throws InterruptedException, ExecutionException {
        	Consumer<Long, String> consumer = ConsumerCreator.createConsumer();
            int noMessageFound = 0;
            while (true) {
              ConsumerRecords<Long, String> consumerRecords = consumer.poll(1000);
              // 1000 is the time in milliseconds consumer will wait if no record is found at broker.
              if (consumerRecords.count() == 0) {
                  noMessageFound++;
                  if (noMessageFound > IKafkaConstants.MAX_NO_MESSAGE_FOUND_COUNT)
                    // If no message found count is reached to threshold exit loop.  
                    break;
                  else
                      continue;
              }
              //print each record. 
              consumerRecords.forEach(record -> {
                  System.out.println("Record Key " + record.key());
                  System.out.println("Record value " + record.value());
                  System.out.println("Record partition " + record.partition());
                  System.out.println("Record offset " + record.offset());
               });
              // commits the offset of record to broker. 
               consumer.commitAsync();
        }
	/*	Properties props = new Properties();
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
        
            String msg = "Hello from Khajavali ";
            producer.send(new ProducerRecord<String, String>("test 1", msg));
          
        } catch (Exception e) {
          e.printStackTrace();

        } finally {
          producer.close();
        };
        */
	}
	 	 
}
