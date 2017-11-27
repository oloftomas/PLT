int main ()
{
  int sum = 0 ;
  int num = 0 ;
  int x ;
  while ((x = readInt()) != 0) {
    sum = sum + x ;
    num++ ;
  }
  printInt(sum/num) ;

}

