


#include <conio.h>
#include<bits/stdc++.h>

using namespace std;


struct BinaryTreeNode{
	int val;
	BinaryTreeNode *left,*right;

	BinaryTreeNode(int val){
		this->val = val;
		left = right = NULL;
	}
};

BinaryTreeNode* newNode(int val){

	BinaryTreeNode* node = new BinaryTreeNode(val);
	return node;
}

int leaf_node(BinaryTreeNode* node){
	
	

	if(node == NULL){
	 return 0;
	}
	else if(node->left == NULL && node->right == NULL){
		return 1;
	}

	return leaf_node(node->left) + leaf_node(node->right); 
}


int main(){
		
	struct BinaryTreeNode* root = newNode(1);
	root->left = newNode(2);
	root->right = newNode(2);
	root->left->left = newNode(3);
	root->left->right = newNode(3);

	cout<<leaf_node(root);
	getch();
	return 0;
}