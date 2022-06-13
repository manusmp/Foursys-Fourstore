package src.br.com.foursys.fourcamp.fourstore.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
	public static boolean validateCPF(String cpf) {

		String regex = "\\b([0-9]{3})\\.([0-9]{3})\\.([0-9]{3})\\-([0-9]{2})";

		boolean return1 = false;
		Pattern padrao = Pattern.compile(regex);

		Matcher match = padrao.matcher(cpf);
		if(!match.find()) {
			return1 = false;
			} else {
			return1 = true;
			}
			return return1;
	}
	public static boolean validateCard(String card) {

		String regex = "\\b([0-9]{4})\\.([0-9]{4})\\.([0-9]{4})\\.([0-9]{4})";

		boolean return1 = false;
		Pattern padrao = Pattern.compile(regex);

		Matcher match = padrao.matcher(card);
		if(!match.find()) {
			return1 = false;
			} else {
			return1 = true;
			}
			return return1;
	}


	public static boolean validateTelephone(String tel) {

		String regex = "(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})";
		

		boolean return1 = false;
		Pattern padrao = Pattern.compile(regex);

		Matcher match = padrao.matcher(tel);
		if (!match.find()) {
			return1 = false;
		} else {
			return1 = true;
		}
		return return1;
	}
}
