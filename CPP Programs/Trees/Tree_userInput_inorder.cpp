#include <iostream>
#include <conio.h>
#include "BinaryTreeClass.h"




BinaryTreeNode* takeInput(){
	int data;
	cin>>data;

	if(data == -1){
		return NULL;
	}
	
	BinaryTreeNode* node = new BinaryTreeNode(data);
	BinaryTreeNode* leftChild = takeInput();
	BinaryTreeNode* rightChild = takeInput();

	node->left = leftChild;
	node->right = rightChild;

	return node;
}

void PrintTree(BinaryTreeNode *node){

	if(node == NULL) return;

	cout<<node->val<<" ";
	PrintTree(node->left);
	PrintTree(node->right);
}



int main(){

	//inorder 
	BinaryTreeNode* root = takeInput();

	//inorder
	PrintTree(root);

	getch();
	return 0;
}
