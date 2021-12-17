package univpm.esame.ProgettoOOP.filter;

public class FilterSize {
	private int param;
	public FilterSize(int param) {
		this.param=param;
	}
	public boolean filterGrater(int size) {
		return size>=this.param;
	}
	public boolean filterLower(int size) {
		return size<this.param;
	}
}
