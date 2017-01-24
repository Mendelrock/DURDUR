/*
La fonction strsignal() disponible en tant qu'extension GNU
(il faut donc utiliser la constante symbolique _GNU_SOURCE a la compilation) dans <string.h>.
Cette fonction renvoie un pointeur sur une chaine de caracteres allouee statiquement
donc susceptible d'etre ecrasee a chaque appel) et contenant un libelle descriptif du signal.
-----
Il existe une table globale de chaines de caracteres contenant les libelles des signaux :
char * sys_siglist[numero_signal].
*/

#define GNU SOURCE
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <string.h>

int main (void)
{
  int i;
  fprintf(stderr, "strsignal( ) :\n\n");
  for(i=1; i<NSIG; ++i)
	printf("%s \n",strsignal(i));
  fprintf(stderr, "\n sys_siglist[] : \n\n");
  for(i=1; i<NSIG; ++i)
	printf("%s \n",sys_siglist[i]);
  return (0);
}
