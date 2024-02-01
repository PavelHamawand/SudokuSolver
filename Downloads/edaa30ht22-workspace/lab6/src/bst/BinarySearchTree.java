package bst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinarySearchTree<E extends Comparable<? super E>> {
	BinaryNode<E> root; // Används också i BSTVisaulizer
	int size; // Används också i BSTVisaulizer
	private ArrayList<E> list;
	private final Comparator<? super E> comparator;

	/**
	 * Constructs an empty binary search tree.
	 */
	public BinarySearchTree() {
		this.list = new ArrayList<>();
		comparator = (right, left) -> (right.compareTo(left));
		this.root = null;
		this.size = 0;
	}

	/**
	 * Constructs an empty binary search tree, sorted according to the specified
	 * comparator.
	 */
	public BinarySearchTree(Comparator<E> comparator) {
		this.comparator = comparator;
	    this.root = null;
		this.size = 0;
	}

	public static void main(String[] args) {
		BSTVisualizer visualizer = new BSTVisualizer("test", 400, 400);
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.add(1);
		tree.add(3);
		tree.add(5);
		tree.add(7);
		tree.add(9);
		tree.add(7);
		tree.add(11);
		tree.add(13);
		//tree.rebuild();
		visualizer.drawTree(tree);
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 *
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		int temp = size;
		root = recursive(root, x);
		return temp < size;
	}

	private BinaryNode<E> recursive(BinaryNode<E> node, E x) {
		if (node == null) {
			size++;
			return new BinaryNode<>(x);
		}
		if (x.compareTo(node.element) < 0) {
			node.left = recursive(node.left, x);
		} else if (x.compareTo(node.element) > 0) {
			node.right = recursive(node.right, x);
		} 
		return node;
	}

	/**
	 * Computes the height of tree.
	 *
	 * @return the height of the tree
	 */
	public int height() {
		return height(this.root);
	} 

	private int height(BinaryNode<E> node) {
		if (node == null)
			return 0;
		else {
			return 1 + Math.max(height(node.left), height(node.right));
		}
	}

	/**
	 * Returns the number of elements in this tree.
	 *
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
	}

	/**
	 * Removes all of the elements from this list.
	 */
	public void clear() {
		root = null;
		size = 0;
	}

	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		printTree(root);
	}

	private void printTree(BinaryNode<E> root) {
		if (root != null) {
			printTree(root.left);
			System.out.println(root.element);
			printTree(root.right);
		}
	}

	/**
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		toArray(root, list);
		root = buildTree(list, 0, list.size() - 1);
	}

	/*
	 * Adds all elements from the tree rooted at 'root' in inorder to the list
	 * sorted.
	 */
	private void toArray(BinaryNode<E> root, List<E> sorted) {
		if (root != null) {
			toArray(root.left, list);
			list.add(root.element);
			toArray(root.right, list);
		}
	}

	/*
	 * Builds a complete tree from the elements from position first to last in the
	 * list sorted. Elements in the list a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(ArrayList<E> sorted, int first, int last) {
		if (first > last) return null;

		int mid = (first + last) / 2;

		BinaryNode<E> temp = new BinaryNode<>(sorted.get(mid));

		temp.left = buildTree(sorted, first, mid - 1);
		temp.right = buildTree(sorted, mid + 1, last);

		return temp;
	}

	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}
	}

}
