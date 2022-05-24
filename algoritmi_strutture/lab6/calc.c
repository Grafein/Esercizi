
#include <stdio.h>
#include <stdlib.h>

#include "stack.h"


int main(void) {

    make_empty();

    char token[10];
    int res=0;

     
        
while(scanf("%s", token)!=EOF) {  

    
       

    if(token[0]>='0' && token[0]<='9') {
    int num=atoi(token);

    push(num);
        
    }else{

    int a=pop(); 
    int b=pop(); 

    switch(token[0]) {

        case('+'): res=b+a; break;
        case('-'): res=b-a; break;
        case('*'): res=b*a;  break;
        case('/'): res=b/a;  break;

    }    

    push(res);
    
    }
}

    printf("%d\n",res);

    return 0;
}
            
