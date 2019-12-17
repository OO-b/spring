package DI_Annotation_01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;

public class MonitorViewer {
	
	private Recorder recorder;

	public Recorder getRecorder() {
		return recorder;
	}

	@Autowired //By type(타입을 기반으로) : IOC컨테이너 안에서 recorder라는 타입을 찾아서 있으면 자동으로 주소를 injection(주입)
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
	}
	
}
