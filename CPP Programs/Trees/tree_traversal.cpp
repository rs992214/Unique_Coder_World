#include <conio.h>

#include <iostream>
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


void postOrderTraversal(struct Node* node){
	if(node->left != NULL){
		postOrderTraversal(node->left); }
	
	

	if(node->right != NULL){	
		postOrderTraversal(node->right); }

	cout<<node->data<<" ";
}

void preOrderTraversal(struct Node* node){

	cout<<node->data<<" ";
	
	if(node->left != NULL){
		preOrderTraversal(node->left); }

	if(node->right != NULL){	
		preOrderTraversal(node->right); }

}

void inOrderTraversal(struct Node* node){

	
	if(node->left != NULL){
		inOrderTraversal(node->left); }
	
	cout<<node->data<<" ";

	if(node->right != NULL){	
		inOrderTraversal(node->right); }
}


int treeSize(Node* node){
	
	if(node == NULL) return 0;

	
	return treeSize(node->left) + 1 + treeSize(node->right) ;
}


int treeDepth(Node* node){
	if(node == NULL) return 0;

	return 1+max(treeDepth(node->left),treeDepth(node->right));
}

void deleteTree(Node* node){

	if(node == NULL) return ;

	deleteTree(node->left);
	deleteTree(node->right);

	delete node ;
}

void mirrorTree(Node* node){

	if(node == NULL ) return ;

	

	mirrorTree(node->left);
	mirrorTree(node->right);

	Node* temp = newNode(0);
	temp = node->left;
	node->left = node->right;
	node->right = temp;

}

int main(){


	struct Node* root = newNode(1);
	root->left = newNode(2);
	root->right = newNode(3);
	root->left->left = newNode(4);
	root->left->right = newNode(5);
	root->left->right->left = newNode(6);

	cout<<"preOrderTraversal\n";
	preOrderTraversal(root);
	cout<<"\n";

	cout<<"inOrderTraversal\n";
	inOrderTraversal(root);
	cout<<"\n";

	cout<<"postOrderTraversal"<<"\n";
	postOrderTraversal(root);
	cout<<"\n";

	cout<<"size of tree is :"<<treeSize(root)<<"\n";
	cout<<"max height/depth of tree is : "<<treeDepth(root)<<"\n";


	cout<<"mirror Tree : \n";
	mirrorTree(root);

	cout<<"preOrderTraversal\n";
	preOrderTraversal(root);
	cout<<"\n";

	cout<<"deleting the tree \n";
	deleteTree(root);
	
	getch();
	return 0;
}