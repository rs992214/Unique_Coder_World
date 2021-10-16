using namespace std;

#define NULL 0

class BinaryTreeNode{
	public:
		int val;
		BinaryTreeNode *left,*right;


		BinaryTreeNode(int val){
			this->val = val;
			left = NULL;
			right = NULL;
		}

		~BinaryTreeNode(){
			delete left;
			delete right;
		}
};