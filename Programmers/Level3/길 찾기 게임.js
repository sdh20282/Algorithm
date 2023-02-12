class BinaryTree {
    constructor([value, x]) {
        this.value = value;
        this.x = x;
        this.left = null;
        this.right = null;
    }

    insert([value, x]) {
        x <= this.x
            ? !!this.left
                ? this.left.insert([value, x])
                : this.left = new BinaryTree([value, x])
            : !!this.right
                ? this.right.insert([value, x])
                : this.right = new BinaryTree([value, x]);
    }

    getPreorder(binaryTree) {
        const array = [];

        binaryTree.preorder(binaryTree, array);

        return array;
    }

    preorder(binaryTree, array) {
        if (binaryTree != null) {
            array.push(binaryTree.value);
            binaryTree.preorder(binaryTree.left, array);
            binaryTree.preorder(binaryTree.right, array);
        }
    }

    getPostorder(binaryTree) {
        const array = [];

        binaryTree.postorder(binaryTree, array);

        return array;
    }

    postorder(binaryTree, array) {
        if (binaryTree != null) {
            binaryTree.postorder(binaryTree.left, array);
            binaryTree.postorder(binaryTree.right, array);
            array.push(binaryTree.value);
        }
    }
}

function solution(nodeinfo) {
    nodeinfo = nodeinfo.map((node, index) => [ index + 1, node[0], node[1] ]).sort((a, b) => b[2] - a[2]);

    const binaryTree = new BinaryTree(nodeinfo[0]);

    for (let index = 1; index < nodeinfo.length; index++) {
        binaryTree.insert(nodeinfo[index]);
    }

    return [binaryTree.getPreorder(binaryTree), binaryTree.getPostorder(binaryTree)];
}
