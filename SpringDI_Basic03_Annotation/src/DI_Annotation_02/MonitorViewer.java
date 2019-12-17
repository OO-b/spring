package DI_Annotation_02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Qualifier;

public class MonitorViewer {
	
	private Recorder recorder;

	public Recorder getRecorder() {
		return recorder;
	}

	@Autowired //By type(타입을 기반으로) : IOC컨테이너 안에서 recorder라는 타입을 찾아서 있으면 자동으로 주소를 injection(주입)
	@Qualifier("recorder_1")   //<qualifier value="recorder_1"></qualifier>
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
		System.out.println("setter주입 성공");
	}
	
	//일반 함수 
	@Autowired
	@Qualifier("recorder_2")
	public void Gmethod(Recorder rec) {
		System.out.println("Gmethod(rec) : " + rec);
	}
}
