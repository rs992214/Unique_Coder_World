#include <iostream>
#include <conio.h>
#include "BinaryTreeClass.h"
#include <queue>

BinaryTreeNode* takeInput(){

	int data;
	cin>>data;

	if(data == -1){
		return NULL;
	}

	BinaryTreeNode* root = new BinaryTreeNode(data);

	queue<BinaryTreeNode*> pendingNodes;

	pendingNodes.push(root);
	
	while(pendingNodes.empty() == false){

		BinaryTreeNode *node = pendingNodes.front();
		pendingNodes.pop();
		int x;
		cin>>x;
		if(x != -1) 
		{ BinaryTreeNode* leftChild = new BinaryTreeNode(x);
			 node->left = leftChild;
			 pendingNodes.push(leftChild); 
		}

		cin>>x;
		if(x != -1) 
		{ BinaryTreeNode* rightChild = new BinaryTreeNode(x);
			 node->right = rightChild;
			 pendingNodes.push(rightChild); 
		}


	}
	

	return root;
}


void PrintTree(BinaryTreeNode *node){

	if(node == NULL){
		return ;
	}

	queue<BinaryTreeNode*> pendingNodes;

	pendingNodes.push(node);

	while(pendingNodes.empty() == false){

		BinaryTreeNode* node = pendingNodes.front();
		cout<<node->val<<" ";
		pendingNodes.pop();

		if(node->left != NULL){
			pendingNodes.push(node->left);
		}

		if(node->right != NULL){
			pendingNodes.push(node->right);
		}
	}


}



int main(){

	//levelorder
	// BinaryTreeNode* root = new BinaryTreeNode(1);
	// root->left = new BinaryTreeNode(2);
	// root->right = new BinaryTreeNode(2);
	// root->left->left = new BinaryTreeNode(3);
	// root->left->right = new BinaryTreeNode(3);
	// root->right->left = new BinaryTreeNode(3);
	// root->right->right = new BinaryTreeNode(3);

	BinaryTreeNode* root = takeInput();


	//levelorder
	PrintTree(root);

	getch();
	return 0;
}
