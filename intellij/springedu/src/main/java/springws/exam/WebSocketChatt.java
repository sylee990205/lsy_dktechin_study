package springws.exam;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Service;

@Service
@ServerEndpoint(value="/chatt")
public class WebSocketChatt {
	private static Set<Session> clientSet = 
						Collections.synchronizedSet(new HashSet<Session>());
	@OnOpen
	public void onOpen(Session s) {
		if(!clientSet.contains(s)) {
			clientSet.add(s);
			System.out.println("[세션 오픈] " + s);
		}else {
			System.out.println("이미 연결된 세션임!!!");
		}
	}
	
	@OnMessage
	public void onMessage(String msg, Session session) throws Exception{
		System.out.println("[수신 메시지] " + msg);
		for(Session s : clientSet) {
			System.out.println("[송신 메시지] " + msg);
			s.getBasicRemote().sendText(msg);
		}		
	}
	
	@OnClose
	public void onClose(Session s) {
		System.out.println("[세션 종료] " + s);
		clientSet.remove(s);
	}
}
