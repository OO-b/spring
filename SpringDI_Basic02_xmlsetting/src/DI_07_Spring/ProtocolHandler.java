package DI_07_Spring;

import java.util.List;

public class ProtocolHandler {
	
	private List<MyFilter> filters;

	public List<MyFilter> getFilters() {
		return filters;
	}

	public void setFilters(List<MyFilter> filters) {
		this.filters = filters;
	}
	
	
	//검증하는 함수 (필터가 몇개의 필터를 가지고 있는지 확인하기 위해서)
	public int filter_length() {
		return this.filters.size();
	}
}
