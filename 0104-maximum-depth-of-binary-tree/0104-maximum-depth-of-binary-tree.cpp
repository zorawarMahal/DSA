/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int maxDepth(TreeNode* root) {
        return maxD(root);
    }

    int maxD(TreeNode* root) {
        if (root == NULL) return 0;
        int leftsum = maxD(root->left);
        int rightsum = maxD(root->right);
        return max(leftsum, rightsum) + 1;
    }
};