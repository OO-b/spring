package DI_Annotation_04;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Qualifier;

public class MonitorViewer {
	
	private Recorder recorder;

	public Recorder getRecorder() {
		return recorder;
	}


	@Resource(name="yy")  //같은 타입이 여러개 있다 하더라도 name으로 하나를 선택 할 수 있음
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
		System.out.println("setter주입 성공" + recorder);
	}
	

	}
