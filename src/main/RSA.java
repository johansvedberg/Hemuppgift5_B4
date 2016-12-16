package main;

import java.math.BigInteger;

public class RSA {
	private BigInteger privKey;
	private BigInteger p, q;
	private BigInteger pubKey;
	private BigInteger coefficient;
	private BigInteger n;
	private BigInteger exponent1, exponent2;

	public RSA(String pString, String qString, String eString) {
		p = new BigInteger(pString);
		q = new BigInteger(qString);
		pubKey = new BigInteger(eString);

		n = p.multiply(q);
		coefficient = q.modInverse(p);	

		BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

		privKey = pubKey.modInverse(m);
		exponent1 = privKey.mod(p.subtract(BigInteger.ONE));
		exponent2 = privKey.mod(q.subtract(BigInteger.ONE));

	}

	public String getPrivKey() {
		return privKey.toString();
	}

	public String getPubKey() {
		return pubKey.toString();
	}

	public String getN() {
		return n.toString();
	}

	public String getCoefficient() {
		return coefficient.toString();
	}

	public String getExponent1() {
		return exponent1.toString();
	}

	public String getExponent2() {
		return exponent2.toString();
	}

	public String getP() {
		return p.toString();
	}

	public String getQ() {
		return q.toString();
	}
}
