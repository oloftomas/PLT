int main () {

  int i = 0;
  retInt(++i);

  printInt(i);

  //retInt(tst = tst + 1, tst2);

  //printInt(tst);

/*
  int i = 0;
  int x = 5;

  int y = 5 + i*i-x+i;

  printInt(y);

  printInt(x);

  double d = 2.0;
  double e = 3.5;

  double z = e+d*1.5;

  printDouble(z);

  //double input = readDouble();

  //printDouble(input);

  int funCall = test();
  printInt(funCall);

  funCall = 666;

  printInt(funCall);

  while(i < x) {
  	printInt(i);
  	i++;
  }

  double b = 2.1;
  double c = 2.1;

  bool bc = (b == c);
  
  if (bc) {
  	printInt(123);
  } else {
  	printInt(321);
  }

*/
}

int retInt(int i) {
	return i;
}

int test() {
	int i = 5;
	int j = 10;

	return i+j;
}