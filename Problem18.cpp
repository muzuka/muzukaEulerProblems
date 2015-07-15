
#include <stdio.h>
#include <stdlib.h>
#include <fstream>
#include <map>
#include <math.h>
#include <string>
#include <cstring>

std::map<int, std::map<int, int> > tree;    // contains tree
std::map<int, std::map<int, int> > sumTree; // memoizes summations

// splits the string "target" into the "parts" array by the "delim" characters
// note: must know the size of "parts" you will need before calculation
//		 otherwise provide a bigger than necessary array for parts
 void splitString(char * parts[], char * target, const char * delim) {
	 char * tok;
	 tok = std::strtok(target, delim);
	 int i = 0;
	 while(tok != NULL) {
		 parts[i] = tok;
		 tok = strtok(NULL, delim);
		 i++;
	 }
 }
 
 // finds maximum value of all values in a map
 // Assumes map is behaving like a vector;
 /*int max(std::vector<int> m) {
	 int max = m[0];
	 for(int i = 0; (unsigned int)i < m.size(); i++) {
		 if(m[i] > max)
			max = m[i];
	 }
	 return max;
 }*/
 
 // finds maximum value of a integer array
 /*int max(int m[], int size) {
	 int max = m[0];
	 for(int i = 1; i < size; i++) {
		 if(m[i] > max)
			max = m[i];
	 }
	 return max;
 }*/
 
int greedy() {
	int sum = tree[0][0];
	int place = 0;
	for(int i = 1; (unsigned int)i < tree.size(); i++) {
		if(tree[i][place] > tree[i][place+1]) {
			sum += tree[i][place];
		}
		else if(tree[i][place] < tree[i][place+1]) {
			sum += tree[i][place+1];
			place += 1;
		}
		else {
			if(tree[i+1][place] < tree[i+1][place+2]) {
				place += 1;
			}
		}
	}
	return sum;
}

// assumes tree has been filled
void fillSumTree() {
	unsigned int sumHeight = tree.size() - 2;
	
	for(int i = 0; (unsigned int)i < tree.size(); i++) {
		sumTree[tree.size()-1][i] = tree[tree.size() - 1][i];
	}
	
	for(int i = sumHeight; i >= 0; i--) {
		for(int j = 0; (unsigned int)j < tree[sumHeight].size(); j++) {
			sumTree[sumHeight][j] = tree[sumHeight][j] + fmax(sumTree[sumHeight+1][j], sumTree[sumHeight+1][j+1]);
			//printf("%d ", sumTree[sumHeight][j]);
		}
		//printf("\n");
		sumHeight -= 1;
	}
}

int maxRoute(int row, int place) {
	if ((unsigned int)row + 1 == tree.size()) {
		return tree[row][place];
	}
	else {
		int r1 = tree[row][place] + maxRoute(row+1, place);
		int r2 = tree[row][place] + maxRoute(row+1, place+1);

		return fmax(r1, r2);
	}
}

int main(int argc, char* argv[]) {

	std::string line;
	char* numbers[150];
	tree.clear();
	std::ifstream in;
	in.open("big.txt");

	if(!in.is_open()) {
		printf("open() failed\n");
		in.close();
		exit(1);
	}

	int i = 0;
	while(getline(in, line)) {
		printf("%s\n", line.c_str());
		splitString(numbers, (char*)line.c_str(), " ");
		tree[i] = std::map<int, int>();
		sumTree[i] = std::map<int, int>();
		for(int j = 0; j < i+1; j++) {
			tree[i][j] = atoi(numbers[j]);
			sumTree[i][j] = 0;
		}
		i++;
	}
	
	fillSumTree();
	printf("%d\n", sumTree[0][0]);

	return 0;
}
