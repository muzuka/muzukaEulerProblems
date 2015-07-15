
#include <fstream>
#include <stdio.h>
#include <stdlib.h>
#include <string>

using namespace std;

const int SIZE = 80;

int matrix[SIZE][SIZE];
int memoMatrix[SIZE][SIZE];

// splits the string "target" into the "parts" array by the "delim" characters
// note: must know the size of "parts" you will need before calculation
//                 otherwise provide a bigger than necessary array for parts
void splitString(char* parts[], char* target, const char* delim) {
	char* tok;
	tok = std::strtok(target, delim);
	int i = 0;
	while(tok != NULL) {
		parts[i] = tok;
		tok = strtok(NULL, delim);
		i++;
	}
}

void printMatrix(int m[], int size) {
	printf("[");
	for (int i = 0; i < size; i++) {
		printf("%d ", m[i]);
	}
	printf("]\n");
}

void fillMemoMatrix() {
  for(int i = 0; i < SIZE; i++) {
    for(int j = 0; j < SIZE; j++) {
      if(i == 0 && j == 0) {
		  memoMatrix[i][j] = matrix[i][j];
      }
      else if(i == 0) {
		  memoMatrix[i][j] = matrix[i][j] + memoMatrix[i][j-1];
      }
      else if(j == 0) {
		  memoMatrix[i][j] = matrix[i][j] + memoMatrix[i-1][j];
      }
      else {
		  int top = memoMatrix[i-1][j];
		  int left = memoMatrix[i][j-1];
		  if(top > left) {
			  memoMatrix[i][j] = left + matrix[i][j];
		  }
		  else {
			  memoMatrix[i][j] = top + matrix[i][j];
		  }
      }
    }
  }
}

int main(int argc, char* argv[]) {
  
  char* temp[SIZE];

  // fill array
  string line;
  ifstream in;
  in.open("matrix.txt");
  
  if(!in.is_open()) {
    printf("open() failed!\n");
    in.close();
    exit(1);
  }

  int i = 0;
  while(getline(in, line)) {
    splitString(temp, (char*)line.c_str(), ",");
    for(int j = 0; j < SIZE; j++) {
      matrix[i][j] = atoi(temp[j]);
    }
	i++;
  }
  
  fillMemoMatrix();
  printf("%d\n", memoMatrix[SIZE-1][SIZE-1]);
  
  return 0;
}
