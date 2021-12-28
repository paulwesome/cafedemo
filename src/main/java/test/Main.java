package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jmsintegration/jmsIntSubscribeContext.xml");
        context.start();
        System.out.println("Please type something and hit return");
    }

@Test
    public void testSendJmsMessage() throws Exception {
        System.out.println("=============================================");
        JmsMessageBean bean = new JmsMessageBean();
        bean.setAge(23);
        bean.setBirthday(new Date());
        bean.setManbers(Arrays.asList("123", "234", "345"));
        bean.setName("Jms");
        publisher.sendMessage(bean);
    }
		
	}

}
