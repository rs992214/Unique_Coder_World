#include <bits/stdc++.h>
using namespace std;

bool detect_cycle(int node, vector<int> adj[], vector<bool> &vis, int parent)
{
    vis[node] = true;

    for (auto x : adj[node])
    {
        if (!vis[x])
        {
            if (detect_cycle(x, adj, vis, node))
                return true;
        }
        else if (parent != x)
            return true;
    }
    return false;
}

// Function to detect cycle in an undirected graph.
bool isCycle(int v, vector<int> adj[])
{

    vector<bool> vis(v, 0);

    for (int i = 0; i < v; i++)
    {
        if (!vis[i])
        {
            if (detect_cycle(i, adj, vis, -1))
                return true;
        }
    }
    return false;
}

int main()
{
    int n, e;
    cout << "Enter no. of vertices : ";
    cin >> n;
    cout << "Enter no. of edges : ";
    cin >> e;
    vector<int> adj[n];
    int u, v;
    
    for(int i = 0; i < e; i++)
    {
        cout << "Enter edge " << i + 1 << endl;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    if(isCycle(n, adj))
        cout << "Cycle is Present!";
    else 
        cout << "Cycle is not present!";
    return 0;
}
