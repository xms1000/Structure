package com.xms.structure.tree;

/**
 * Created by xms on 2017/8/19.
 */

public class AVLTree<T extends Comparable<T>> {
    @SuppressWarnings("hiding")
    class AVLTreeNode<T extends Comparable<T>> {
        T key;
        int height;
        AVLTreeNode<T> left;
        AVLTreeNode<T> right;

        public AVLTreeNode(T key, AVLTreeNode<T> left, AVLTreeNode<T> right) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }

    private AVLTreeNode<T> mRoot;

    public AVLTree() {
        mRoot = null;
    }

    private int height(AVLTreeNode<T> tree) {
        if (tree != null)
            return tree.height;
        return 0;
    }

    public int height() {
        return height(mRoot);
    }

    private AVLTreeNode<T> leftLeftRotation(AVLTreeNode<T> k) {
        AVLTreeNode<T> k1;

        k1 = k.left;
        k.left = k1.right;
        k1.right = k;

        k.height = Math.max(height(k.left), height(k.right)) + 1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;

        return k1;
    }

    private AVLTreeNode<T> rightRightRotation(AVLTreeNode<T> k) {
        AVLTreeNode<T> k1;

        k1 = k.right;
        k.right = k1.left;
        k1.left = k;

        k.height = Math.max(height(k.left), height(k.right)) + 1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;

        return k1;
    }

    private AVLTreeNode<T> leftRightRotation(AVLTreeNode<T> k) {
        k.left = rightRightRotation(k.left);
        return leftLeftRotation(k);
    }

    private AVLTreeNode<T> rightLeftRotation(AVLTreeNode<T> k) {
        k.right = leftLeftRotation(k.right);
        return rightRightRotation(k);
    }

    private AVLTreeNode<T> insert(AVLTreeNode<T> tree, T key) {
        if (tree == null) {
            tree = new AVLTreeNode<T>(key, null, null);
        } else {
            int cmp = key.compareTo(tree.key);
            if (cmp < 0) {
                tree.left = insert(tree.left, key);
                if (height(tree.left) - height(tree.right) == 2) {
                    if (key.compareTo(tree.left.key) < 0) {
                        tree = leftLeftRotation(tree);
                    } else {
                        tree = leftRightRotation(tree);
                    }
                }
            } else if (cmp > 0) {
                tree.right = insert(tree.right, key);
                if (height(tree.right) - height(tree.left) == 2) {
                    if (key.compareTo(tree.right.key) < 0) {
                        tree = rightLeftRotation(tree);
                    } else {
                        tree = rightRightRotation(tree);
                    }
                }

            } else {
                throw new RuntimeException("Can not insert instance node!");
            }
        }
        tree.height = Math.max(height(tree.left), height(tree.right)) + 1;
        return tree;
    }

    public AVLTreeNode<T> add(T key) {
        mRoot = insert(mRoot, key);
        return mRoot;
    }

    private AVLTreeNode<T> minimum(AVLTreeNode<T> tree) {
        if (tree == null)
            return null;

        while (tree.left != null)
            tree = tree.left;
        return tree;
    }

    public T minimum() {
        AVLTreeNode<T> p = minimum(mRoot);
        if (p != null)
            return p.key;

        return null;
    }

    private AVLTreeNode<T> maximum(AVLTreeNode<T> tree) {
        if (tree == null)
            return null;

        while (tree.right != null)
            tree = tree.right;
        return tree;
    }

    public T maximum() {
        AVLTreeNode<T> p = maximum(mRoot);
        if (p != null)
            return p.key;

        return null;
    }

    private AVLTreeNode<T> remove(AVLTreeNode<T> tree, AVLTreeNode<T> z) {
        if (tree == null || z == null)
            return null;
        int cmp = z.key.compareTo(tree.key);
        if (cmp < 0) {
            tree.left = remove(tree.left, z);
            if (height(tree.right) - height(tree.left) == 2) {
                AVLTreeNode<T> r = tree.right;
                if (height(r.left) < height(r.right)) {
                    tree = rightRightRotation(tree);
                } else {
                    tree = rightLeftRotation(tree);
                }
            }
        } else if (cmp > 0) {
            tree.right = remove(tree.right, z);
            if (height(tree.left) - height(tree.right) == 2) {
                AVLTreeNode<T> l = tree.left;
                if (height(l.left) < height(l.right)) {
                    tree = leftRightRotation(tree);
                } else {
                    tree = leftLeftRotation(tree);
                }
            }
        } else {
            if ((tree.left != null) && (tree.right != null)) {
                if (height(tree.left) > height(tree.right)) {
                    AVLTreeNode<T> max = maximum(tree.left);
                    tree.key = max.key;
                    tree.left = remove(tree.left, max);
                } else {
                    AVLTreeNode<T> min = minimum(tree.right);
                    tree.key = min.key;
                    tree.right = remove(tree.right, min);
                }
            } else {
                tree = (tree.left != null) ? tree.left : tree.right;
            }
        }
        if (tree != null) {
            tree.height = Math.max(height(tree.left), height(tree.right)) + 1;
        }
        return tree;
    }

    public void remove(T key) {
        AVLTreeNode<T> z;
        if ((z = search(key)) != null) {
            remove(mRoot, z);
        }
    }

    private AVLTreeNode<T> search(AVLTreeNode<T> x, T key) {
        if (x == null)
            return x;

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return search(x.left, key);
        else if (cmp > 0)
            return search(x.right, key);
        else
            return x;
    }

    public AVLTreeNode<T> search(T key) {
        return search(mRoot, key);
    }

    private void destroy(AVLTreeNode<T> tree) {
        if (tree == null)
            return;

        if (tree.left != null)
            destroy(tree.left);
        if (tree.right != null)
            destroy(tree.right);
        tree = null;
    }

    public void destroy() {
        destroy(mRoot);
    }
}
