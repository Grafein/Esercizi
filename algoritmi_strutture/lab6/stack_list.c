#include <stdlib.h>
#include <stdio.h>

struct node {

      int d;
      struct node *next;
};

struct node *list;


void make_empty ( void ) {

    list=NULL;
    //empty()
    printf("Pila svuotata\n");
}

int is_empty ( void ) {

    if (list==NULL)
    return 1;

  return 0;
}

 int top ( void ) {

    if (list==NULL) {
        printf("Impossibile eseguire top da pila vuota\n");
    }else{
        return (list)->d;
    }
  return 0;
 }

int pop ( void ) {

    struct node *first= list;

    if (list==NULL){
        printf("Impossibile eseguire pop su pila vuota\n");
        exit(EXIT_FAILURE);
    }else{
        list=list->next;
        return first->d;

    }
}


void push ( int n ) {

    struct node *new_node=malloc(sizeof(struct node));

    if (new_node==NULL) {
      exit(EXIT_FAILURE);
    }

    new_node->d=n;
    new_node->next=list;

    list=new_node;

}


 void print_stack ( void ){


      struct node *i=list;

      if (list==NULL) {
          printf("Pila vuota\n");
      }else{

        while(i!=NULL) {

            printf("%d ", i->d);
            i=i->next;
        }
    printf("\n");

  }
}
