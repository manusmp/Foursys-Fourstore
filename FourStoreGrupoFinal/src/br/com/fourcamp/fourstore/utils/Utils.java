package br.com.fourcamp.fourstore.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
	public static String validateCPF(String cpf) {

		String regex = "\\b([0-9]{3})\\.([0-9]{3})\\.([0-9]{3})\\-([0-9]{2})";

		String return1 = "";
		Pattern padrao = Pattern.compile(regex);

		Matcher match = padrao.matcher(cpf);
		if(!match.find()) {
			return1 = "Por favor digite um CPF de acordo com o padrão solicitado! ";
			} else {
			return1 = "CPF: " + cpf + " \nDevidamente correto!";
			}
			return return1;
	}
}