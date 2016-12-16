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

	public BigInteger getPrivKey() {
		return privKey;
	}

	public BigInteger getPubKey() {
		return pubKey;
	}

	public BigInteger getN() {
		return n;
	}

	public BigInteger getCoefficient() {
		return coefficient;
	}

	public BigInteger getExponent1() {
		return exponent1;
	}

	public BigInteger getExponent2() {
		return exponent2;
	}

	public BigInteger getP() {
		return p;
	}

	public BigInteger getQ() {
		return q;
	}
}
