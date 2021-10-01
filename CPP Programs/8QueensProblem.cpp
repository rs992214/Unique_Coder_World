***8 Queens Problem using Backtracking***

#include <bits/stdc++.h>

using namespace std;

int board[8][8]; // you can pick any matrix size you want
                 
bool isPossible(int n,int row,int col){  // check whether 
                      // placing queen possible or not

// Same Column
  for(int i=row-1;i>=0;i--){
    if(board[i][col] == 1){
      return false;
    }
  }
  
//Upper Left Diagonal
  for(int i=row-1,j=col-1;i>=0 && j>=0 ; i--,j--){
    if(board[i][j] ==1){
      return false;
    }
  }

  // Upper Right Diagonal
  for(int i=row-1,j=col+1;i>=0 && j<n ; i--,j++){
    if(board[i][j] == 1){
      return false;
    }
  }

  return true;
}
void nQueenHelper(int n,int row){
  if(row==n){
    // We have reached some solution.
    // Print the board matrix
    // return

    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
        cout << board[i][j] << " ";
      }
    }
    cout<<endl;
    return;

  }

  // Place at all possible positions and move to smaller problem
  for(int j=0;j<n;j++){

    if(isPossible(n,row,j)){  // if no attack, proceed
      board[row][j] = 1;      // mark row, column with 1
      nQueenHelper(n,row+1);  // call function to continue 
                              // further
    }
    
     board[row][j] = 0;      // unmark to backtrack
  }
  return;

}
void placeNQueens(int n){

  memset(board,0,8*8*sizeof(int)); // allocate 8*8 memory 
                                     // and initialize all 
                                     // cells with zeroes

  nQueenHelper(n,0);     // call the backtracking function 
                         // and print solutions
}

int main(){
    
    int n;
    cin>>n; // could use a default 8 as well
    
    placeNQueens(n);
    return 0;
}
