package DI_Annotation_03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Qualifier;

public class MonitorViewer {
	
	private Recorder recorder;

	public Recorder getRecorder() {
		return recorder;
	}

	//annotation이 옵션을 가질 수 있다
	//@Autowired(required = true) //기본설정(무조건 injection)
	@Autowired(required = false) //기본설정(무조건 injection)
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
		System.out.println("setter주입 성공" + recorder);
	}
	

	}
