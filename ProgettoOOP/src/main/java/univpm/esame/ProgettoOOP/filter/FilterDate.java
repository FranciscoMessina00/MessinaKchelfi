package univpm.esame.ProgettoOOP.filter;

import java.sql.Timestamp;

public class FilterDate {
	private Timestamp param;
	public FilterDate(Timestamp param) {
		this.param=param;
	}
	public boolean filterGrater(Timestamp date) {
		return date.after(param);
	}
	public boolean filterLower(Timestamp date) {
		return date.before(param);
	}
}
