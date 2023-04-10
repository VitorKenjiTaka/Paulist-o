package model;

public class jogo {

	int codTimeA;
	int codTimeB;
	int golsA;
	int golsB;
	String data;
	
	public int getCodTimeA() {
		return codTimeA;
	}
	public void setCodTimeA(int codTimeA) {
		this.codTimeA = codTimeA;
	}
	public int getCodTimeB() {
		return codTimeB;
	}
	public void setCodTimeB(int codTimeB) {
		this.codTimeB = codTimeB;
	}
	public int getGolsA() {
		return golsA;
	}
	public void setGolsA(int golsA) {
		this.golsA = golsA;
	}
	public int getGolsB() {
		return golsB;
	}
	public void setGolsB(int golsB) {
		this.golsB = golsB;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "jogo [codTimeA=" + codTimeA + ", codTimeB=" + codTimeB + ", golsA=" + golsA + ", golsB=" + golsB
				+ ", data=" + data + "]";
	}
}
