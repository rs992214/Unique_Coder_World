#include<bits/stdc++.h>
using namespace std;
void swap(int &a,int&b)
{
    int temp = a;
    a=b;
    b=temp;
}

void merge(vector<int> &v,int start , int mid, int end)
{
    vector<int> a,b;
    int i=0,j=0,k=start;
    for(i = start ; i<=mid;i++)
    {
        a.push_back(v[i]);
    }
    for(i = mid+1 ; i<=end;i++)
    {
        b.push_back(v[i]);
    }
    i=0,j=0;
    while(i<a.size() && j<b.size())
    {
        if(a[i]<b[j])
        {
            v[k]  = a[i];
            k++;
            i++;
        }
        else{
            v[k] = b[j];
            j++;
            k++;
        }
    }
    while(i<a.size())
    {
        v[k] = a[i];
        i++;
        k++;
    }
     while(j<b.size())
    {
        v[k] = b[j];
        j++;
        k++;
    }
}
void mergesort(vector<int> &v , int start , int end)
{
    if(start<end)
    {
           int mid = (start + end) / 2;
           mergesort(v, start , mid);
           mergesort(v, mid+1, end);
           merge(v, start , mid, end);
    }
}
void selectionsort(vector<int> &v)
{
    bool flag=true;
    for(int i=0 ; (i<v.size()) && flag ; i++)
    {
        int min = v[i] ;
        int index=i;
        flag =false;
        for(int j=i + 1;j<v.size() ; j++)
        {
            if(v[j] < min)
            {
                min = v[j];
                index=j;
                flag = true;
            }
        }
         swap(v[i] , v[index]);
         
    }
}

void insert(int val , vector<int> &v)
{
    int i=0;
    while( i <v.size() && v[i]<val )
    i++;
    int temp = v[i];
    v[i] = val;
    v.push_back(temp);
}
void insertionsort(vector<int> &v)
{
    vector<int> a;
    a.push_back(v[0]);
    for(int i=1;i<v.size() ; i++)
    {
        int val = v[i];
        insert(val,a);
    }

    v=a;
}
void bubblesort(vector<int> &v)
{
    bool flag = true;
    while(flag)
    {
        flag= false;
        for(int i=0;i<v.size()-1;i++)
        {
            if(v[i]>v[i+1])
            {
                swap(v[i],v[i+1]);
                flag = true;
            }
        }
    }
}
void display(vector<int> v)
{
 for(int i=0;i<v.size();i++)
    {
        cout<<v[i]<<" ";
    }
    cout<<endl;
}
int main()
{
    int n;
    cin>>n;
    vector<int> a(n);
    for(int i=0;i<n;i++)
    {
        cin>>a[i];
    }
    // bubblesort(a);
    // selectionsort(a);
    // insertionsort(a);
    mergesort(a , 0 ,a.size()-1);
    display(a);
   return 0;
}