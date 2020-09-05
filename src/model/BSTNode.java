package model;

public class BSTNode <K extends Comparable<K>, T> {
	
	private T value;
	private K key;
	private BSTNode<K,T> rightNode;
	private BSTNode<K,T> leftNode;

	
	public BSTNode (T value, K key) {
		this.value = value;
		this.key = key;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public BSTNode<K, T> getRightNode() {
		return rightNode;
	}

	public void setRightNode(BSTNode<K, T> rightNode) {
		this.rightNode = rightNode;
	}

	public BSTNode<K, T> getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(BSTNode<K, T> leftNode) {
		this.leftNode = leftNode;
	}	
}
