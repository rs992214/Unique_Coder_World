#include<bits/stdc++.h>
using namespace std;

int main(){
    //n is even
    int n;
    cin>>n;
    vector<int> arr(n);
    for(int i = 0; i<n; ++i){
        cin>>arr[i];
    }
    vector<int> second(n/2);
    for(int i = 0; i<n/2; ++i){
        second[i] = arr[i];
    }
    for(int i = n/2; i<n; ++i){
        second[i - n/2] += 1000*arr[i];
    }
    for(int i = 0; i<n; ++i){
        if(i < n/2)
        cout<<second[i]%1000<<" ";
        else
        cout<<second[i - n/2]/1000<<" ";
    }
    cout<<endl;
}
