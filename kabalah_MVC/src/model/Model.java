package model;

import java.util.LinkedList;
import java.util.List;

public class Model {

	public static String alefato[] = new String[27];
	public static int valor[] = new int[27];
	public static String nombreLetra[] = new String[20];
	public static List<String> conjunto = new LinkedList<String>();

	StringBuilder sb = new StringBuilder();

	public Model() {

		alefato[0] = "\u05D0";
		valor[0] = 1;

		alefato[1] = "\u05D1";
		valor[1] = 2;

		alefato[2] = "\u05D2";
		valor[2] = 3;

		alefato[3] = "\u05D3";
		valor[3] = 4;

		alefato[4] = "\u05D4";
		valor[4] = 5;

		alefato[5] = "\u05D5";
		valor[5] = 6;

		alefato[6] = "\u05D6";
		valor[6] = 7;

		alefato[7] = "\u05D7";
		valor[7] = 8;

		alefato[8] = "\u05D8";
		valor[8] = 9;

		alefato[9] = "\u05D9";
		valor[9] = 10;

		alefato[10] = "\u05DA";
		valor[10] = 500;

		alefato[11] = "\u05DB";
		valor[11] = 20;

		alefato[12] = "\u05DC";
		valor[12] = 30;

		alefato[13] = "\u05DD";
		valor[13] = 600;

		alefato[14] = "\u05DE";
		valor[14] = 40;

		alefato[15] = "\u05DF";
		valor[15] = 700;

		alefato[16] = "\u05E0";
		valor[16] = 50;

		alefato[17] = "\u05E1";
		valor[17] = 60;

		alefato[18] = "\u05E2";
		valor[18] = 70;

		alefato[19] = "\u05E3";
		valor[19] = 800;

		alefato[20] = "\u05E4";
		valor[20] = 80;

		alefato[21] = "\u05E5";
		valor[21] = 900;

		alefato[22] = "\u05E6";
		valor[22] = 90;

		alefato[23] = "\u05E7";
		valor[23] = 100;

		alefato[24] = "\u05E8";
		valor[24] = 200;

		alefato[25] = "\u05E9";
		valor[25] = 300;

		alefato[26] = "\u05EA";
		valor[26] = 400;

		Model.conjunto.clear();

	}

	public static int getValor(String text) {

		for (int i = 0; i < 27; i++) {
			if (alefato[i] == text)
				return valor[i];
		}

		return 0;
	}

	public StringBuilder permuta(String a) {

		if (conjunto.size() == 1) {
			sb.append(a + conjunto.get(0));
			sb.append("\n");
			//System.out.println(a + conjunto.get(0));

		}

		for (int i = 0; i < conjunto.size(); i++) {

			String b = conjunto.remove(i);
			permuta(a + b);
			conjunto.add(i, b);
		}
		return sb;
	}

	public void addConjunto(String s) {
		conjunto.add(s);
	}

	public void cleanConjunto() {
		conjunto.clear();
	}

	public void clearSb() {
		this.sb = new StringBuilder();
		
	}
	
	public List<String> getConjunto(){
		return this.conjunto;
		
	}

}
