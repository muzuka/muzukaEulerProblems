
#include <iostream>
#include <stdlib.h>
#include <sstream>
#include <string>
#include <math.h>

using namespace std;

int sum(int l[]);
bool isPrime(int p);
bool isTrunctable(int t);
bool isLeftTrunctable(int t);
bool isRightTrunctable(int t);
int removeRight(int r);
int removeLeft(int l);


// main function
int main(int argc, char* argv[]) {

  cout << "This program solves Euler problem 37." << endl << 
    "Please choose an action:" << endl << 
    "Test 1: RemoveRight" << endl << 
    "Test 2: RemoveLeft" << endl << 
    "Test 3: isPrime" << endl << 
    "Test 4: isRightTrunctable" << endl <<
    "Test 5: isLeftTrunctable" << endl <<
    "Test 6: isTrunctable" << endl << 
    "Test 7: Find sum of trunctable numbers." << endl;

  int choice;
  cin >> choice;

  int truncts[11];
  int trunctsFound = 0;
  int count = 23;

  switch(choice) {

  case 1:
    cout << "Please enter a number" << endl;
    cin >> choice;
    cout << removeRight(choice) << endl;
    break;

  case 2:
    cout << "Please enter a number" << endl;
    cin >> choice;
    cout << removeLeft(choice) << endl;
    break;

  case 3:
    cout << "Please enter a number" << endl;
    cin >> choice;
    if (isPrime(choice)) {
      cout << "true" << endl;
    }
    else {
      cout << "false" << endl;
    }
    break;

  case 4:
    cout << "Please enter a number" << endl;
    cin >> choice;
    if (isRightTrunctable(choice)) {
      cout << "true" << endl;
    }
    else {
      cout << "false" << endl;
    }
    break;

  case 5:
    cout << "Please enter a number" << endl;
    cin >> choice;
    if (isLeftTrunctable(choice)) {
      cout << "true" << endl;
    }
    else {
      cout << "false" << endl;
    }
    break;

  case 6:
    cout << "Please enter a number" << endl;
    cin >> choice;
    if (isTrunctable(choice)) {
      cout << "true" << endl;
    }
    else {
      cout << "false" << endl;
    }
    break;

  case 7:
    while (trunctsFound < 11) {
      if (isTrunctable(count)) {
	truncts[trunctsFound] = count;
	trunctsFound++;
      }
      count++;
    }
    cout << "Sum of all trunctable numbers is " << sum(truncts) << "." << endl;
    break;
  default:
    cout << "Not a valid choice" << endl;
    break;
  }

  return 0;
}

int sum(int l[]) {
  int sum = 0;
  for (int i = 0; i < 11; i++) {
    sum += l[i];
  }
  return sum;
}

bool isPrime(int p) {
  if (p <= 1) {
    return false;
  }
  else if (p == 2) {
    return true;
  }
  else {
    for (int i = 2; i < p; i++) {
      if (p % i == 0) {
	return false;
      }
    }
    return true;
  }
}

bool isTrunctable(int t) {
  if (t == 2 || t == 3 || t == 5 || t == 7) {
    return false;
  }
  else {
    return (isRightTrunctable(t) && isLeftTrunctable(t));
  }
}

bool isRightTrunctable(int t) {
  if (t == 2 || t == 3 || t == 5 || t == 7) {
    return true;
  }
  else if (!isPrime(t)) {
    return false;
  }
  else {
    return isRightTrunctable(removeRight(t));
  }
}

bool isLeftTrunctable(int t) {
  if (t == 2 || t == 3 || t == 5 || t == 7) {
    return true;
  }
  else if (!isPrime(t)) {
    return false;
  }
  else {
    return isLeftTrunctable(removeLeft(t));
  }
}

int removeRight(int r) {
  ostringstream result;
  string stringResult;

  result << r;
  stringResult = result.str();
  
  return atoi(stringResult.substr(0, stringResult.length()-1).c_str());
}

int removeLeft(int l) {
  ostringstream result;
  string stringResult;

  result << l;
  stringResult = result.str();

  return atoi(stringResult.substr(1).c_str());
}
