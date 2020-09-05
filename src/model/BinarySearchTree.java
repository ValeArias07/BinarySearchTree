package model;

public class BinarySearchTree <K extends Comparable<K>, T>{
	
	private BSTNode<K,T> root;
	private int weight;
	private int height;
	
	public BinarySearchTree(){
		root=null;
	}
	
	private void addRecursive(BSTNode<K,T> current, K key, T value) {
		if(current!=null) {
			if(current.getKey().compareTo(key) < 0) {
				
				if(current.getRightNode()!=null) {
					 addRecursive(current.getRightNode(), key, value);
				}else {
					current.setRightNode(new BSTNode <K,T> (value, key));
					height(current, "R");
					weight++;
				}
			}else {
				if(current.getLeftNode()!=null) {
				    addRecursive(current.getLeftNode(), key, value); 
				}else {
					current.setLeftNode(new BSTNode <K,T> (value ,key));
					height(current, "L");
					weight++;

				}
			}
		}
	}
	
	public void add(K key, T value) {
		if(root!=null) 
			addRecursive(root, key, value);
		else 
			root= new BSTNode <K,T>(value, key);
			weight++;
	}
	
	public boolean update(K currentKey, K newKey) {
		boolean updated=false;
		BSTNode<K,T> found=search(currentKey);
		if(found!=null) {
			found.setKey(newKey);
			return true;
		}
		return updated;
	}
	
	public BSTNode<K,T> search(K key) {
		BSTNode<K, T> current = root;

		while (current != null && !current.getKey().equals(key)) {
			if (key.compareTo(current.getKey()) < 0) {
				current = current.getLeftNode();
			} else {
				current = current.getRightNode();
			}
		}
		return current;
	}

	public BSTNode<K,T> delete(K key){
		BSTNode<K,T>found=search(key);
		BSTNode<K,T> aux=null;
		
		if(found!=null) {
			aux=found;
			if(found.getLeftNode()==null && found.getRightNode()==null) {
				found=null;
			}else if(found.getLeftNode()!=null && found.getRightNode()!=null) {
				
				BSTNode<K,T> smallest=smallest(found);
				if(smallest.getRightNode()==null) {
					found=smallest;
				}else {
					BSTNode<K,T> biggest= bigest(found);
					if(biggest.getLeftNode()==null) {
						found=biggest;
					}
				}
				
			}else if (found.getLeftNode()!=null){
				found=found.getLeftNode();
			}else {
				found=found.getRightNode();
			}
		}
		return aux;
	}
	
	public BSTNode<K,T> bigest(BSTNode<K,T> current){
		
		if(current.getRightNode()!=null) {
			bigest(current.getRightNode());
		}
		return current;
	} 
	
	public BSTNode<K,T> smallest(BSTNode<K,T> current){
		
		if(current.getLeftNode()!=null) {
			smallest(current.getLeftNode());
		}
		return current;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void height(BSTNode<K,T> current, String position) {
		if(position.equals("R")) {
			if(current.getLeftNode()==null) {
				height++;
			}
		}else {
			if(current.getRightNode()==null) {
				height++;
			}
		}
	}
	
	public String inOrder(BSTNode<K,T> current, String txt) {
		if(current!=null) {
			inOrder(current.getLeftNode(), txt);
			txt+=" "+ current.getKey();
			inOrder(current.getRightNode(), txt);
		}
		return txt;
	}
	
	public String preOrder(BSTNode<K,T> current, String txt) {
		if(current!=null) {
			txt+=" "+ current.getKey();
			inOrder(current.getLeftNode(), txt);
			inOrder(current.getRightNode(), txt);
		}
		return txt;
	}
	
	public String postOrder(BSTNode<K,T> current, String txt) {
		if(current!=null) {
			inOrder(current.getLeftNode(), txt);
			inOrder(current.getRightNode(), txt);
			txt+=" "+ current.getKey();
		}
		return txt;
	}
		
}
