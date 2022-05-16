#include "stack.h"
#include <stdlib.h>
#include <stdio.h>

int main( void) {

    int a,b,c=0;

    printf("Vuota? %d\n", is_empty());

    push(2);
    print_stack();

    push(10);
    print_stack();

    printf("Top: %d\n",top());
    print_stack();

    printf("Vuota? %d\n", is_empty());

    //make_empty();

    a=pop();
    printf("Pop: %d\n", a);
    print_stack();

    pop();
    print_stack();

    return 0;

  }
