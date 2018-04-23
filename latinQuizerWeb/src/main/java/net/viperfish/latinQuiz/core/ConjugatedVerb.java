package net.viperfish.latinQuiz.core;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.tuple.MutableTriple;

public final class ConjugatedVerb {
	private String conjugated;
	private List<MutableTriple<String, List<String>, String>> interProduct;

	public ConjugatedVerb() {
		interProduct = new LinkedList<>();
	}

	public ConjugatedVerb(String conjugated, List<MutableTriple<String, List<String>, String>> interProduct) {
		super();
		this.conjugated = conjugated;
		this.interProduct = interProduct;
	}

	public ConjugatedVerb(String conjugated) {
		this();
		this.conjugated = conjugated;
	}

	public ConjugatedVerb(ConjugatedVerb src) {
		this.conjugated = src.conjugated;
		this.interProduct = new LinkedList<>(src.interProduct);
	}

	public String getConjugated() {
		return conjugated;
	}

	public void setConjugated(String conjugated) {
		this.conjugated = conjugated;
	}

	public List<MutableTriple<String, List<String>, String>> getInterProduct() {
		return interProduct;
	}

	public void setInterProduct(List<MutableTriple<String, List<String>, String>> interProduct) {
		this.interProduct = interProduct;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conjugated == null) ? 0 : conjugated.hashCode());
		result = prime * result + ((interProduct == null) ? 0 : interProduct.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConjugatedVerb other = (ConjugatedVerb) obj;
		if (conjugated == null) {
			if (other.conjugated != null)
				return false;
		} else if (!conjugated.equals(other.conjugated))
			return false;
		if (interProduct == null) {
			if (other.interProduct != null)
				return false;
		} else if (!interProduct.equals(other.interProduct))
			return false;
		return true;
	}

}
