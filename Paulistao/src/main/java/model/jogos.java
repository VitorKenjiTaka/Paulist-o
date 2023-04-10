package model;

public class jogos {
	String TimeA;
	String TimeB;
	String dta;
	public String getTimeA() {
		return TimeA;
	}
	public void setTimeA(String timeA) {
		TimeA = timeA;
	}
	public String getTimeB() {
		return TimeB;
	}
	public void setTimeB(String timeB) {
		TimeB = timeB;
	}
	public String getDta() {
		return dta;
	}
	public void setDta(String dta) {
		this.dta = dta;
	}
	@Override
	public String toString() {
		return "jogos [TimeA=" + TimeA + ", TimeB=" + TimeB + ", dta=" + dta + "]";
	}
}
