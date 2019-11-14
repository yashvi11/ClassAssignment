import java.util.*;

class BinarySearchTree{
	class Node {
		int data;
		Node left, right;
		Node(int data) {
			this.data = data;
			right = left = null;
		}
	}
	Node root;
	BinarySearchTree() {
		root = null;
	}
	void insert(int data) {
		root = insertInTree(root,data);
	}
	Node insertInTree(Node root , int data)
    {
        if(root == null) {
            root = new Node(data);
            return root;
        }
        if(data < root.data) {
           root.left = insertInTree(root.left, data);
        }
        else {
            root.right = insertInTree(root.right, data);
        }
        return root;
    }
    int height() {
        int a ;
        a = calHeight(root);
        return a;
    }
    int calHeight(Node root)
    {
        if(root == null) {
            return 0;
        }
        else {
            int l = calHeight(root.left);
            int r = calHeight(root.right);
            if(l>r) {
                return l+1;
            }
            else {
                return r+1;
            }
        }
    }
    void preorder() {
        printPreOrder(root);
        System.out.println();
    }
    void printPreOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
    void postorder() {
        printPostOrder(root);
        System.out.println();
    }
    void printPostOrder(Node root) {
        if(root == null) {
            return;
        }
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.data + " ");
    }
    void inorder() {
        printInOrder(root);
        System.out.println();
    }
    void printInOrder(Node root) {
        if(root == null) {
            return;
        }
        else {
            printInOrder(root.left);
            System.out.print(root.data + " ");
            printInOrder(root.right);
        }
    }
    void finalDisplay()
    {
        int h = height();
        for(int i = h ; i>=1 ; i--) {
            printdisplay(root,i);
        }
    }
    void printdisplay(Node root , int level)
    {
        if(root == null) {
            return;
        }
        if(level == 1) {
            System.out.print(root.data+" ");
        }
        else if(level>1) {
        	printdisplay(root.right, level-1);
            printdisplay(root.left, level-1);
        }
    }

}
public class Assignment {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		BinarySearchTree tree = new BinarySearchTree();
        System.out.println("Enter the number of nodes");
        int num = sc.nextInt();
        System.out.println("Enter nodes");
        for(int i =0 ; i<num ; i++) {
            tree.insert(sc.nextInt());
        }
        System.out.println("Inorder ");
        tree.inorder();
        System.out.println("postorder ");
        tree.postorder();
        System.out.println("Pre order ");
        tree.preorder();
        System.out.println("Display final");
        tree.finalDisplay();
	}
}