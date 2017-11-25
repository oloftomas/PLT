int main () {
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

  while(i < x) {
  	printInt(i);
  	i++;
  }

}

int test() {
	int i = 5;
	int j = 10;

	return i+j;
}