//in order travsersal in BST will give sorted array.
 

#include <conio.h>
#include<bits/stdc++.h>

using namespace std;


struct Node {
	int data;
	struct Node *left,*right;

	Node(int data){
		this->data = data;
		left = right = NULL;
	}
};

Node* newNode(int data){
	Node* node = new Node(data);
	return node;
}

void inOrderTraversal(struct Node* node){

	
	if(node->left != NULL){
		inOrderTraversal(node->left); }
	
	cout<<node->data<<" ";

	if(node->right != NULL){	
		inOrderTraversal(node->right); }
}

int main(){
	
	struct Node* root = newNode(4);
	root->left = newNode(2);
	root->right = newNode(5);
	root->left->left = newNode(1);
	root->left->right = newNode(3);
	root->left->right->left = newNode(5);

	cout<<"inOrderTraversal\n";
	inOrderTraversal(root);
	cout<<"\n";

	getch();
	return 0;
}