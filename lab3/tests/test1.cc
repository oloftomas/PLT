int main() {
	int x = 2;
	printInt(foo(x));
	return x;
}

int foo(int i) {
	return --i;
}
