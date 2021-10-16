#include <bits/stdc++.h>
#include <conio.h>

using namespace std;

struct Node{
	int data;

	struct Node *left;
	struct Node* right;

	Node(int data){
		this->data = data;
		left = NULL;
		right = NULL;
	}
};

Node* newNode(int data){
	Node* node = new Node(data);
	return node;
}


verticalOrderTraversal(Node *node){


}



int main(){

	struct Node* root = newNode(1);
	root->left =  newNode(2);
	root->right = newNode(3);
	root->left->left = newNode(4);
	root->left->right = newNode(5);
	root->right->left = newNode(6);
	root->right->right = newNode(7);
	root->right->left->right = newNode(8);
    root->right->right->right = newNode(9);

	verticalOrderTraversal(root);

	getch();
	return 1;
	
}
