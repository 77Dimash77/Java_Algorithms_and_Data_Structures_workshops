public class SM3and4DZ {
    private static class RedBlackTree {
        private Node root;

        private static class Node {
            int value;
            Node left;
            Node right;
            boolean isRed;
            int blackCount;

            Node(int value) {
                this.value = value;
                this.isRed = true;
                this.blackCount = 1;
            }
        }

        public void push(int value) {
            root = pushNode(root, value);
            root.isRed = false;
        }

        private Node pushNode(Node node, int value) {
            if (node == null) {
                return new Node(value);
            }

            if (value < node.value) {
                node.left = pushNode(node.left, value);
                node.blackCount++;
            } else if (value > node.value) {
                node.right = pushNode(node.right, value);
            } else {
                return node;
            }

            if (isRed(node.right) && !isRed(node.left)) {
                node = rotateLeft(node);
            }
            if (isRed(node.left) && isRed(node.left.left)) {
                node = rotateRight(node);
            }
            if (isRed(node.left) && isRed(node.right)) {
                flipColors(node);
            }

            if (isRed(node.right) && isRed(node.right.left)) {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
                flipColors(node);
            }

            return node;
        }

        private boolean isRed(Node node) {
            if (node == null) {
                return false;
            }
            return node.isRed;
        }

        private Node rotateLeft(Node node) {
            Node newRoot = node.right;
            node.right = newRoot.left;
            newRoot.left = node;
            newRoot.isRed = node.isRed;
            node.isRed = true;
            return newRoot;
        }

        private Node rotateRight(Node node) {
            Node newRoot = node.left;
            node.left = newRoot.right;
            newRoot.right = node;
            newRoot.isRed = node.isRed;
            node.isRed = true;
            return newRoot;
        }

        private void flipColors(Node node) {
            node.isRed = true;
            node.left.isRed = false;
            node.right.isRed = false;
        }
    }

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        tree.push(10);
        tree.push(5);
        tree.push(15);
        tree.push(3);
        tree.push(8);
        tree.push(12);
        tree.push(18);
    }
}