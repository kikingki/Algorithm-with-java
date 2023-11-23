import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        char value;
        Node left;
        Node right;

        Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    static Node root = new Node('A', null, null);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char value = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(root,value,left,right);
        }

        // 전위순회
        preOrder(root);
        System.out.println();

        // 중위순회
        inOrder(root);
        System.out.println();

        // 후위순회
        postOrder(root);
        System.out.println();
    }

    // 재귀로 노드 삽입
    private static void insertNode(Node currentNode, char nodeValue, char left, char right) {
        // 현재 노드의 값과, 삽입할 노드가 일치하는지 확인
        if (currentNode.value == nodeValue) {
            currentNode.left = (left == '.' ? null : new Node(left,null,null));
            currentNode.right = (right == '.' ? null : new Node(right,null,null));
        }
        // 일치하지 않으면 왼쪽 혹은 오른쪽 서브트리를 재귀적으로 검색
        else {
            if(currentNode.left != null) insertNode(currentNode.left, nodeValue, left, right);
            if(currentNode.right != null) insertNode(currentNode.right, nodeValue, left, right);
        }
    }

    private static void preOrder(Node head) {
        System.out.print(head.value);
        if(head.left != null) preOrder(head.left);
        if(head.right != null) preOrder(head.right);
    }

    private static void inOrder(Node head) {
        if(head.left != null) inOrder(head.left);
        System.out.print(head.value);
        if(head.right != null) inOrder(head.right);
    }

    private static void postOrder(Node head) {
        if(head.left != null) postOrder(head.left);
        if(head.right != null) postOrder(head.right);
        System.out.print(head.value);
    }
}
