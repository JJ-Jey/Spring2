package com.green.nowon.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

	//web socket 활용
	//TCP: 신뢰성 있음, 느림(UDP에 비해)
	//모든 웹브라우저에서 지원하지 않음: socket js를 통해 문제 해결 가능
	//STOMP 라이브러리로 구성: publish(발행)-subscribe(구독)

  @MessageMapping("/hello")
  @SendTo("/topic/greetings")
  public Greeting greeting(HelloMessage message) throws Exception {
    Thread.sleep(1000); // simulated delay
    return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
  }

}
