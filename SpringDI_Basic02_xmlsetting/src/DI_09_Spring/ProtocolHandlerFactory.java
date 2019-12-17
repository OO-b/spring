package DI_09_Spring;

import java.util.Map;

public class ProtocolHandlerFactory {
	//Map(key,value) - value 값에 Interface 들어옴 
	private Map<String,ProtocolHandler> handlers;
	
	public void setHandlers(Map<String,ProtocolHandler> handlers) {
		this.handlers = handlers;
		System.out.println("setter 주입 성공 :" + this.handlers);
	}
	
}

