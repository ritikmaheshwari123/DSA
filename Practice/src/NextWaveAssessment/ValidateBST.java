package NextWaveAssessment;

public class ValidateBST {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.right.left = new Node(12);
        root.right.right = new Node(20);
        root.right.right.right = new Node(25);

        System.out.println(validBST(root)); // true
    }

    public static boolean validBST(Node root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValid(Node node, long min, long max) {
        if (node == null) {
            return true; // Empty tree is valid BST
        }

        // Rule violation check
        if (node.sweetness <= min || node.sweetness >= max) {
            return false;
        }

        // Recursively validate left and right subtrees
        return isValid(node.left, min, node.sweetness)
                && isValid(node.right, node.sweetness, max);
    }
}
