package main;

import java.util.Base64;

import javax.xml.bind.DatatypeConverter;

public class Main {

	public static void main(String[] args) {

		RSA rsa = new RSA(
				"139721121696950524826588106850589277149201407609721772094240512732263435522747938311240453050931930261483801083660740974606647762343797901776568952627044034430252415109426271529273025919247232149498325412099418785867055970264559033471714066901728022294156913563009971882292507967574638004022912842160046962763",
				"141482624370070397331659016840167171669762175617573550670131965177212458081250216130985545188965601581445995499595853199665045326236858265192627970970480636850683227427420000655754305398076045013588894161738893242561531526805416653594689480170103763171879023351810966896841177322118521251310975456956247827719",
				"65537");

		BERTLV bertlv = new BERTLV();
		String N = bertlv.encode(rsa.getN().toString());
		String pub = bertlv.encode(rsa.getPubKey().toString());
		String priv = bertlv.encode(rsa.getPrivKey().toString());
		String p = bertlv.encode(rsa.getP().toString());
		String q = bertlv.encode(rsa.getQ().toString());
		String exp1 = bertlv.encode(rsa.getExponent1().toString());
		String exp2 = bertlv.encode(rsa.getExponent2().toString());
		String coefficient = bertlv.encode(rsa.getCoefficient().toString());

		String result = "020100" + N + pub + priv + p + q + exp1 + exp2 + coefficient;
		int length = result.length() / 2;

		String finalResult = "3082" + String.format("%04X", length) + result;
		String encoded = Base64.getEncoder().encodeToString((DatatypeConverter.parseHexBinary(finalResult)));
		System.out.println(encoded);
	}
	
	

}
