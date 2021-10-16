//https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
//this one works in unordered binary tree.

#include <conio.h>
#include<bits/stdc++.h>

using namespace std;


struct Node {
	int val;
	struct Node *left,*right;

	Node(int data){
		this->val = data;
		left = right = NULL;
	}
};

Node* newNode(int data){
	Node* node = new Node(data);
	return node;
}

Node* findLCA(Node* root,int n1,int n2){

	if (root == NULL) return NULL;
 
   
    if (root->val == n1 || root->val == n2)
        return root;
 
    // Look for keys in left and right subtrees
    Node *left_lca  = findLCA(root->left, n1, n2);
    Node *right_lca = findLCA(root->right, n1, n2);
 
    // If both of the above calls return Non-NULL, then one key
    // is present in once subtree and other is present in other,
    // So this node is the LCA
    if (left_lca && right_lca)  return root;
 
    // Otherwise check if left subtree or right subtree is LCA
    return (left_lca != NULL)? left_lca: right_lca;

}


int main(){
	
	 Node * root = newNode(1);
    root->left = newNode(2);
    root->right = newNode(3);
    root->left->left = newNode(4);
    root->left->right = newNode(5);
    root->right->left = newNode(6);
    root->right->right = newNode(7);
 
    int n1 = 10, n2 = 14;

	cout << "LCA(4, 5) = " << findLCA(root, 4, 5)->key;

	getch();
	return 0;
}
