#include <signal.h>

int main(int argc, char *argv[])
{
	kill((int)(argv[1]-'0'),SIGINT);
	getchar();
	return(0);
}
