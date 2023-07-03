# GameOfLife
a little text based game of life simulator i made in about an hour for fun.

HOW TO USE:
simply running the program with 'java GameOfLife' will initialize it with a 5x5 space of a Glider for 8 generations.

if you would like to do something different, you can use command-line arguments to change the program slightly.

the first argument is the number of rows, the second the number of columns, and the third is a the number of generations. If these are used (and all 3 MUST be used otherwise the Glider will be used), then a random grid of live and dead cells with the dimensions specified will be simulated for the duration specified.

the fourth and fifth arguments are the appearance of live and dead cells. if not specified, the default of '@' and '\*' are used. some terminals won't like you using certain characters like @ and \*, so look out for that.

the sixth argument is the number of time, in milliseconds, waited between displaying each generation. by default this is 1000, but the program will run basically instantly, so if you set it to 0 then all of your generations will appear at once.
