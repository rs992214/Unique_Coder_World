#include<conio.h>
#include<bits/stdc++.h>

using namespace std;

struct Node{
	int val;
	struct Node *left,*right;

	Node(int val){
		this->val = val;
		left = right = NULL;
	}
};



Node* newNode(int val){

	Node* node = new Node(val);
	node->left = NULL;
	node->right = NULL;
	return node;
}


void flatten(Node* node){

	if(node == NULL || (node->left == NULL && node->right == NULL)) return;
	
	if(node->left != NULL){

		

		flatten(node->left);
		Node* temp = node->right;
		node->right = node->left;
		node->left = NULL;

		Node* t = node->right;

		while(t->right != NULL){
			t = t->right;
		}

		t->right = temp;
		

	}
	
	flatten(node->right);

}

void traverse(Node *node){
	if(node == NULL) return;

	
	traverse(node->left);
	cout<<node->val<<" ";
	traverse(node->right);
}

int main(){

	struct Node* root = newNode(1);
	root->left = newNode(2);
	root->right = newNode(5);
	root->left->left = newNode(3);
	root->left->right = newNode(4);
	root->right->right= newNode(6);
		// traverse(root);
	flatten(root);
	traverse(root);
	getch();
	return 0;
}