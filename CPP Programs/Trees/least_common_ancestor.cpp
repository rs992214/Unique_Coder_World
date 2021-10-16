//https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
//this one works in  BST ,not in unordered binary tree.
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

int LCA(Node* node,int n1,int n2){

	if(node == NULL) return 0;

	if( node->val > n1 && node->val > n2 ){
		return LCA(node->left,n1,n2);
	}
	else if( node->val < n1 && node->val < n2 ){
		return LCA(node->right,n1,n2);
	}
	
	return node->val;

}


int main(){
	
	Node *root = newNode(20);
    root->left = newNode(8);
    root->right = newNode(22);
    root->left->left = newNode(4);
    root->left->right = newNode(12);
    root->left->right->left = newNode(10);
    root->left->right->right = newNode(14);
 
    int n1 = 10, n2 = 14;

	cout<<LCA(root,n1,n2);

	getch();
	return 0;
}
