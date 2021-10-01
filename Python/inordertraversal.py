class node:
    def __init__(self,key) :
        self.right=None
        self.left=None
        self.key=key
def Inorder(root): 
    if root: 
        Inorder(root.left) 
        print(root.key,end=" ")
        Inorder(root.right) 
root=node(30)
root.left=node(20)
root.right=node(40)
root.left.left=node(15)
root.left.right=node(25)       
Inorder(root)
print()
