package ma.fsdm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChiffreRomain {
	ArrayList<String> chiffresRomains;
	public ChiffreRomain(){
		chiffresRomains = new ArrayList<String>();
		chiffresRomains.add("I");chiffresRomains.add("V");
		chiffresRomains.add("X");chiffresRomains.add("L");
		chiffresRomains.add("C");chiffresRomains.add("D");chiffresRomains.add("M");
	}
	public String calculer(int chiffreArabe) {
		String ch = "";
		int unites, dixaines, centaines;
		centaines = chiffreArabe / 100;
		dixaines = chiffreArabe % 100;
		unites = dixaines % 10;
		dixaines = dixaines / 10;
		ch += puissanceDixArabeToRomain(centaines, 2);
		ch += puissanceDixArabeToRomain(dixaines, 1);
		ch += puissanceDixArabeToRomain(unites, 0);
		return ch;
	}
	public String puissanceDixArabeToRomain(int chiffreArabe, int puissance) {
		String ch = "";
		switch (puissance) {
		case 0:
			ch+=unitesToRomain(chiffreArabe);
			break;
		case 1:
			ch+=dixainesToRomain(chiffreArabe*10);
			break;
		case 2:
			 ch+=centainesToRomain(chiffreArabe*100);
				break;

		default:
			ch+="";
		}
		return ch;
	}
	public String unitesToRomain(int unites) {
		int temp;
		int nbre = unites;
		String ch = "";
		temp = unites / 5;
		unites = unites % 5;
		
		if ( unites == 4) {
			ch += chiffresRomains.get(0);
				if ( nbre > 5 ) 
					ch += chiffresRomains.get(2);
				else 
					ch += chiffresRomains.get(1);
		}
		else {
			if ( temp == 1) ch += chiffresRomains.get(1);
			for (int i = 0; i < unites; i++) 
				ch += chiffresRomains.get(0);
		}
		return ch;
	}

	public String dixainesToRomain(int dixaines) {

		int temp;
		int nbre = dixaines;
		String ch = "";
		temp = dixaines / 50;
		dixaines = dixaines % 50;
		if ( dixaines/10 == 4) {
			ch += chiffresRomains.get(2);
				if ( nbre < 50 )
					ch += chiffresRomains.get(3);
				else
					ch += chiffresRomains.get(4);
		}
		else {
			if ( temp == 1) ch += chiffresRomains.get(3);
			for (int i = 0; i < dixaines/10; i++) 
				ch += chiffresRomains.get(2);
		}
		return ch;
	}

	public String centainesToRomain(int centaines) {
		int mille, cinqCents, cents;
		int nbre = centaines % 1000;
		int compteurDeSymboles;
		String ch = "";
		mille = centaines / 1000;
		cinqCents = centaines % 1000;
		cents = cinqCents % 500;
		cinqCents = cinqCents / 500;
		
			for (int i = 0; i < mille%1000; i++) {
				ch += chiffresRomains.get(6);
			}
			if ( (cinqCents == 1) && (cents/100 != 4))	ch += chiffresRomains.get(5);
			

			if( cents/100 != 4)
				for (int i = 0; i < cents/100; i++) 
					ch += chiffresRomains.get(4);
			else {
				ch += chiffresRomains.get(4);
				if (nbre < 500)
					ch += chiffresRomains.get(5);
				else
					ch += chiffresRomains.get(6);
			}
		return ch;
	}
	
	
}
