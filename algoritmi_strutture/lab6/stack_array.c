
  #include <stdlib.h>
  #include <stdio.h>

  #define N 10

  int stack[N];
  int itop=-1;

  void make_empty ( void ){

      itop=-1;
      printf("Pila svuotata\n");

  }

  int is_empty ( void ) {

      if (itop==-1) {
          return 1;
      }
      return 0;
  }

  int top ( void ){

      if (itop==-1) {
          printf("Impossiible eseguire top su pila vuota\n");
      }

      return stack[itop];
  }


  int pop ( void ){

      if (itop==-1) {
        printf("Impossibile eseguire pop su pila vuota\n");
        exit(EXIT_FAILURE);
      }

      itop--;
      return stack[itop+1];
  }

  void push ( int n ) {

      if (itop>=N) {
        printf("Impossibile eseguire push su pila piena\n");
        exit(EXIT_FAILURE);
      }else{

      itop++;
      stack[itop]=n;

      }
  }

  void print_stack ( void ){

        int i=itop;

        if (i==-1) {
          
          printf("Pila vuota\n");
          
        }else{

          while((i)!=-1) {
              printf("%d ",stack[i]);
              i--;
          }

        printf("\n");

      }
  }
