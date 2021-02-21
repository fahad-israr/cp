// C++ implementation of the approach 
#include<bits/stdc++.h> 
using namespace std; 

// Function to return the minimum 
// number of operations required 
int minOperations(string str, int n) 
{ 

	// To store the indices of the last uppercase 
	// and the first lowercase character 
	int i, u = -1, l = -1; 

	// Find the last uppercase character 
	for (i = n - 1; i >= 0; i--) 
	{ 
		if (isupper(str[i])) 
		{ 
			u = i; 
			break; 
		} 
	} 

	// Find the first lowercase character 
	for (i = 0; i < n; i++) 
	{ 
		if (islower(str[i])) 
		{ 
			l = i; 
			break; 
		} 
	} 

	// If all the characters are either 
	// uppercase or lowercase 
	if (u == -1 || l == -1) 
		return 0; 

	// Count of uppercase characters that appear 
	// after the first lowercase character 
	int countUpper = 0; 
	for (i = l; i < n; i++) 
	{ 
		if (isupper(str[i])) 
		{ 
			countUpper++; 
		} 
	} 

	// Count of lowercase characters that appear 
	// before the last uppercase character 
	int countLower = 0; 
	for (i = 0; i < u; i++) 
	{ 
		if (islower(str[i])) 
		{ 
			countLower++; 
		} 
	} 

	// Return the minimum operations required 
	return min(countLower, countUpper); 
} 

// Driver Code 
int main() 
{ 
	string str = "geEksFOrGEekS"; 
	int n = str.length(); 
	cout << minOperations(str, n) << endl; 
} 

// This code is contributed by 
// Surendra_Gangwar 
